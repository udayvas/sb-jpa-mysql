liquibase --driver=com.mysql.cj.jdbc.Driver \
--classpath="~/Downloads/mysql-connector-java-8.0.20.jar" \
--changeLogFile="changelog/db-changelog.xml" \
--url="jdbc:mysql://localhost:3306/db_example" \
--username="springuser" \
--password="ThePassword" \
update
