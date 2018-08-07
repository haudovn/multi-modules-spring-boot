use dbtest;

drop table if exists `module`;

create table `module` (
    `name` varchar(32) not null unique,
    `description` blob,
    primary key(`name`)
) default charset=utf8;

insert into `module` values ("multi-modules-spring-boot", "This is main-module of the project. It contains and refers to all sub-modules which take care of specific features");
insert into `module` values ("init", "This module initializes a Spring-Boot Servlet");
insert into `module` values ("download", "This module handles HTTP requests for the feature: Download Files");