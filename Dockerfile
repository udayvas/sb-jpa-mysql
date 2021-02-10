FROM ubuntu-openjdk-11
EXPOSE 8080
COPY target/sb-jpa-mysql-1.0.0-SNAPSHOT.jar /
RUN chmod 0755 /sb-jpa-mysql-1.0.0-SNAPSHOT.jar
ENTRYPOINT ["/bin/sh", "-c", "java -server -jar /sb-jpa-mysql-1.0.0-SNAPSHOT.jar"]