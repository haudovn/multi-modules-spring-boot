create database if not exists dbtest character set utf8;

create user if not exists 'demo'@'%' identified by 'demo';

grant all on mdm_test.* to 'demo'@'%';