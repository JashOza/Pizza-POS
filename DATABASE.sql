create user 'student'@'localhost' identified by 'student';
grant all privileges on * . * to 'student'@'localhost';

CREATE DATABASE LAB4;
USE LAB4;

drop table if exists pizzaToppings;
drop table if exists topping;
drop table if exists pizza;


CREATE TABLE pizza(
	size varchar(10),
    pizzaID INT NOT NULL auto_increment PRIMARY KEY,
	dough VARCHAR(15),
    crustStyle VARCHAR(15),
    sauce VARCHAR(15),
    delivery boolean,
    price dec(5,2)
    
);

create table topping(
	toppingID INT NOT NULL auto_increment PRIMARY KEY,
    toppingName varchar(30),
    category varchar(20)
);

create table pizzaToppings(
	pizzaToppingsID INT NOT NULL auto_increment PRIMARY KEY,
    pizzaID int not null,
    toppingID int not null,
    foreign key(pizzaID) references pizza(pizzaID),
    foreign key(toppingID) references topping(toppingID)
);

insert into topping(toppingName,category) values ('cheese','dairy'),('olives','veggie'), ('pepproni','meat'),('anchovies','meat'),('pineapple','veggie'),("Bacon",'meat'),("Sausage",'meat'),("Beef Crumble",'meat'),("Ham",'meat'),("Salami",
'meat'),('Mushroom','veggie'),('onion','veggie'),('green pepper','veggie'),('roated red pepper','veggie'),('jalapeno','veggie'),('corn','veggie');

select * from topping;

insert into pizza(size,dough,crustStyle,sauce,delivery,price) values ('large','whole wheat','thin crust','tomato',true,35.99);
select * from pizza;

insert into pizzaToppings(pizzaID,TOppingID) values (1,1);
insert into pizzaToppings(pizzaID,TOppingID) values (1,2);
insert into pizzaToppings(pizzaID,TOppingID) values (1,3);
insert into pizzaToppings(pizzaID,TOppingID) values (1,4);
insert into pizzaToppings(pizzaID,TOppingID) values (1,5);

select * from pizza
inner join pizzaToppings
inner join topping
where pizza.pizzaID = pizzaToppings.pizzaID && pizzaToppings.toppingID = topping.toppingID;