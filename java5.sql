create database java5
go
use java5
go

drop database java5

create table Accounts(
	username nvarchar(10),
	password nvarchar(50),
	firstName nvarchar(20),
	lastName nvarchar(20),
	email nvarchar(30),
	photo nvarchar(50),
	activated bit,
	admin bit,
	primary key(username)
)

create table Orders(
	order_id bigint,
	username nvarchar(10),
	createDate datetime,
	address nvarchar(100),
	primary key(order_id),
	constraint fk_orders foreign key (username) references Accounts(username)
)

create table Categories(
	category_id char(10),
	name nvarchar(50),
	primary key(category_id)
)

create table Products(
	product_id int identity(1,1),
	name nvarchar(50),
	image nvarchar(50),
	price float,
	createDate date,
	available bit,
	category_id char(10),
	primary key(product_id),
	foreign key (category_id) references Categories(category_id)
)

create table OrderDetails(
	orderdetail_id bigint ,
	order_id bigint,
	product_id int,
	price float,
	quantity int,
	primary key(orderdetail_id),
	foreign key (order_id) references Orders(order_id),
	foreign key (product_id) references Products(product_id)
)