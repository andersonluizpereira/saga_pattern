Saga Pattern

ACID - Atomicity, Consistency, Isolation, Durability

ACID is a set of properties of database transactions intended to guarantee validity even in the event of errors, power failures, etc.

A - Atomicity - All or nothing. Either all the operations in a transaction succeed or none of them do. If a failure occurs, the transaction is rolled back to the state it was in before the transaction began.

C - Consistency - The database is always in a valid state. No partial updates. No invalid data.

I - Isolation - The concurrent execution of transactions results in a system state that would be obtained if transactions were executed serially, i.e., one after the other.

D - Durability - Once a transaction has been committed, it will remain so, even in the event of power loss, crashes, or errors.

In a distributed system, ACID is not guaranteed. The Saga pattern is a way to achieve ACID in a distributed system.

In Java using @Transactional annotation, we can achieve ACID in a single database. But in a distributed system, we need to implement the Saga pattern.

//Example code java with Spring Boot @Transactional
@Transactional
public void createOrder(Order order) {
    orderRepository.save(order);
    paymentService.makePayment(order);
    shippingService.shipOrder(order);
}

With @Transactional annotation, if any of the operations fail, the transaction is rolled back.
In cenary of microservices, we can't use @Transactional annotation because we have multiple databases.

Compensating Actions - Are actions that undo the effects of a previous action. They are used to compensate for the effects of a failed action.

//Compensating Actions Example code
public void makePayment(Order order) {
    try {
        paymentService.makePayment(order);
    } catch (Exception e) {
        paymentService.refundPayment(order);
    }
}

// Saga pattern coreography ? 
Choreography: Allow each microservice to perform independently, but provide a mechanism for them to cue each other based on events. This model provides the best balance between independence of individual microservices while providing seamless interaction between them.

//Saga Pattern Coreography
public void createOrder(Order order) {
    Saga saga = sagaRepository.save(new Saga());
    saga.addStep(new SagaStep("createOrder", order));
    saga.addStep(new SagaStep("makePayment", order));
    saga.addStep(new SagaStep("shipOrder", order));
    sagaRepository.save(saga);
}


//Saga Pattern Orchestration - 
Orchestration: A centralized orchestration layer is created where all coordination logic is centralized. This orchestrator could be centralized for all sagas or workflows, or there could be separate orchestrators for each saga or workflow. The orchestrator coordinates between all other microservices that participate in the saga or workflow.

public void createOrder(Order order) {
    Saga saga = sagaRepository.save(new Saga());
    saga.addStep(new SagaStep("createOrder", order));
    sagaRepository.save(saga);
}

//Saga Pattern Tightly -
Tightly Coupled: All microservices directly call other microservices for coordination of their activities. This makes the application brittle and difficult to change or scale. Any change in one microservice requires all upstream and downstream microservices to change.

//Saga Pattern Tightly - code
public void createOrder(Order order) {
    orderRepository.save(order);
    paymentService.makePayment(order);
    shippingService.shipOrder(order);
}

---------------------
#Como testar o projeto coreografia

cd coreografy

#Veja se o seu docker está rodando
docker ps

#Caso der erro para conectar no DBeaver local
https://stackoverflow.com/questions/61749304/connection-between-dbeaver-mysql

#Caso não esteja, rode o comando abaixo
docker-compose up -d

#Acesse o banco de dados
docker exec -it id_docker bash

#Acesse o banco de dados
mysql -u root -p

#Cria as seguintes bases
create database saga_sale;
create database saga_payment;
create database saga_inventory;

#Depois veja as bases criadas
show databases;

#Agora vamos criar nosso topico no kafka
docker exec -it id_docker bash

#Acesse o kafka
kafka-topics --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic saga

#Veja se o topico foi criado
kafka-topics --list --zookeeper zookeeper:2181

#Ou abra o projeto no offsetexplorer e veja se o topico foi criado

#Como testar
preencher a tabela de user, inventory  no banco de dados

rode o curl abaixo 
```curl --request POST \
  --url http://localhost:8081/api/v1/sales \
  --header 'Content-Type: application/json' \
  --data '{
	"productId":1,
	"userId":1,
	"value":10,
	"quantity":1
}'
````
Veja as tabelas de sale, payment, inventory e user
rode o curl abaixo 

````
curl --request POST \
  --url http://localhost:8081/api/v1/sales \
  --header 'Content-Type: application/json' \
  --data '{
	"productId":1,
	"userId":1,
	"value":35,
	"quantity":3
}'
````
Veja as tabelas de sale, payment, inventory e user
e veja como fica os topicos pelo offsetexplorer

#Vantagens de se utilizar saga pattern coreografado - Projetos menores e menos complexos
1-) É a maneiira mais simples de se implementar o padrao saga
2-) Não possui um ponto de falha, as responsabilidades são distribuidas entre os microserviços
3-) Não precisa de uma logica de coordenacao centralizada, qual evento que deve ser disparado, qual evento que deve ser ouvido, etc

#Desvantagens de se utilizar saga pattern coreografado
1-) Risco de dependencia ciclica entre os microserviços participantes da saga
2-) Quanto mais microserviços participam da saga, mais complexa ela fica a validaçao por onde passam os serviços

#Saga orquestrado
Saga execution cordinator (SEC) - é um microserviço responsavel por orquestrar a saga, ele é o responsavel por dizer qual evento deve ser disparado, qual evento deve ser ouvido, etc

Ele vai receber requisição do microservico 1, deu certo ele vai chamar o microservico 2, deu certo ele vai chamar o microservico 3, etc

No caso de falha, ele vai chamar o microservico 3 para fazer o rollback, depois chama o microservico 2 para fazer o rollback, etc

Ele tira do microservico o conhecimento dos eventos que devem ser disparados, ouvidos, etc

