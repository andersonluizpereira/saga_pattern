create database saga_inventory;
create database saga_payment;
create database saga_sale;

use saga_inventory;
CREATE TABLE inventories (id INTEGER NOT NULL AUTO_INCREMENT, productId INTEGER not null, quantity INTEGER null, PRIMARY KEY (id));
INSERT into saga_inventory.inventories (id, productId, quantity) values (null, 1, 50);

use saga_payment;

CREATE TABLE inventories (id INTEGER NOT NULL AUTO_INCREMENT, userId INTEGER not null, saleId INTEGER null, value DECIMAL(5,2), PRIMARY KEY (id));

CREATE TABLE users (id INTEGER NOT NULL AUTO_INCREMENT,name varchar(100) null, balance DECIMAL(5,2) not null, PRIMARY KEY (id));

insert into users(id, name, balance) values (null, "Anderson Pereira", 50)

use saga_sale;
CREATE TABLE sales (id INTEGER NOT NULL AUTO_INCREMENT,name varchar(100) null,
    productId INTEGER NOT NULL, 
    userId INTEGER NOT NULL,
    value DECIMAL(5,2) not null, 
    statusId INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
PRIMARY KEY 
(id));