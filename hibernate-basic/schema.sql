create database fti;

use fti;

create table address (
    id int(11) primary key auto_increment, 
    street varchar(100), 
    area varchar(100), 
    city varchar(50), 
    pincode int(11)
);


create table employee (
    id int(11) primary key auto_increment, 
    name varchar(100), 
    age int,
    mail varchar(100),
    mobile varchar(14),
    address_id int(11), 
    foreign key(address_id) references address(id) 
);
