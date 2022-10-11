CREATE DATABASE LAB4;
USE LAB4;

CREATE TABLE pizza(
	pizzaID INT NOT NULL auto_increment PRIMARY KEY,
	dough VARCHAR(15),
    crustStyle VARCHAR(15),
    sauce VARCHAR(15),
    delivery boolean,
    price dec(5,2)
    
);

create table topping(
	toppingID INT NOT NULL auto_increment PRIMARY KEY,
    toppingName varchar(30)
);

create table pizzaToppings(
	pizzaToppingsID INT NOT NULL auto_increment PRIMARY KEY,
    pizzaID int not null,
    toppingID int not null,
    foreign key(pizzaID) references pizza(pizzaID),
    foreign key(toppingID) references topping(toppingID)
);

insert into topping(toppingName) values ('cheese','olives', 'pepproni','anchovies','pineapple');