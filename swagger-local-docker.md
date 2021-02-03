$ docker pull swaggerapi/swagger-ui
$ docker run -p 8080:8080 swaggerapi/swagger-ui
$ docker run -p 9080:8080 -e SWAGGER_JSON=/mnt/swagger.json -v ~/Downloads:/mnt swaggerapi/swagger-ui

$ docker pull swaggerapi/swagger-editor
$ docker run -p 8085:8080 swaggerapi/swagger-editor
