## RUNNING MYSQL SERVER

docker run --name=mysql-local -d mysql/mysql-server:latest
docker logs mysql-local
docker logs mysql-local 2>&1 | grep GENERATED
docker exec -it mysql-local mysql -uroot -p
ALTER USER 'root'@'localhost' IDENTIFIED BY 'password';

mysql> create database db_example; -- Creates the new database
mysql> create user 'springuser'@'%' identified by 'ThePassword'; -- Creates the user
mysql> grant all on db_example.\* to 'springuser'@'%'; -- Gives all privileges to the new user on the newly created database

## Download mysql workbench

connect to localhost using root/password
