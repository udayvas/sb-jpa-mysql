RUNNING MYSQL SERVER
docker run --name=mysql-local -d mysql/mysql-server:latest
docker logs mysql-local
docker logs mysql-local 2>&1 | grep GENERATED
docker exec -it mysql-local mysql -uroot -p
ALTER USER 'root'@'localhost' IDENTIFIED BY 'password';

Download mysql workbench
connect to localhost using root/password
