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