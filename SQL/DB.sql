create database example default character set utf8;
use example;

create table user(id serial,login_id varchar(255)unique not null
,name varchar(255)not null,birth_date date not null,password varchar(255)not null
,create_date datetime not null,update_date datetime not null);

insert into user(login_id,name,birth_date,password,create_date,update_date)
values('admin','ŠÇ—Ò','2018-07-05','pass','2018-07-05 11:11:11','2018-07-05 22:22:22');
select*from user;
select id,login_id,name from user where id=1;
