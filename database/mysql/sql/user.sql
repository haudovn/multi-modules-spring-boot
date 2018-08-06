use dbtest;

DROP TABLE IF EXISTS user;

CREATE TABLE user (
    id int not null auto_increment,
    fullname varchar(32) DEFAULT NULL,
    companyname VARCHAR(32) DEFAULT NULL,
    PRIMARY KEY (id)
) DEFAULT CHARSET=utf8;

INSERT INTO user VALUES ("Hau", 'Do');

drop table if exists login;

create table login (
    username varchar(16) not null,
    password varchar(32),
    primary key(username)
) default charset=utf8;

insert into login values ("hau.do", "123");

