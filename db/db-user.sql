create database db_example;
create user 'springuser'@'%' identified by 'ThePassword';
grant all PRIVILEGES on db_example.* to 'springuser'@'%';