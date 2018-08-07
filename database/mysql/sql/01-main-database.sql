#Index 01 - make sure this .sql file will be run second, only after 0-init.sql

use dbtest;

DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id int NOT NULL AUTO_INCREMENT,
    fullname varchar(32) DEFAULT NULL,
    companyname VARCHAR(32) DEFAULT NULL,
    PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;

insert into user values (null, "Hau Do", "Titan");
insert into user values (null, "A Tran", "Titan");

drop table if exists login;

create table login (
    username varchar(16) not null,
    password varchar(32),
    userid int not null unique,
    primary key(username),
    foreign key(userid) references user(id)
) default charset=utf8;

insert into login values ("hau.do", "123", 1);
insert into login values ("a.tran", "456", 2);

