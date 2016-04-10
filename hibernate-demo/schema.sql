create database if not exists learnerdb;

use learnerdb;

create table address (
    id int(11) primary key auto_increment, 
    street varchar(100), 
    area varchar(100), 
    city varchar(50), 
    pincode int(11)
);

create table theater (
    id int(11) primary key auto_increment, 
    name varchar(100), 
    address_id int(11), 
    foreign key(address_id) references address(id) 
);

create table screen (
    id int(11) primary key auto_increment, 
    name varchar(50), 
    theater_id int(11), 
    foreign key(theater_id) references theater(id)
);

create table movie (
    id int(11) primary key auto_increment, 
    name varchar(100)
);

create table movie_screen_xref (
    id int(11) primary key auto_increment, 
    movie_id int(11), 
	screen_id int(11), 
	datetime timestamp,
	foreign key(screen_id) references screen(id),
	foreign key(movie_id) references movie(id)
);