## Download Apache kafka - Binary downloads - Scala 2.12

https://kafka.apache.org/downloads

## START ZOOKEEPER

export KAFKA_HOME="/Users/uvashish/kafka/kafka_2.13-2.4.0"
$KAFKA_HOME/bin/zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties

## START KAFKA

export KAFKA_HOME="/Users/uvashish/kafka/kafka_2.13-2.4.0"
$KAFKA_HOME/bin/kafka-server-start.sh $KAFKA_HOME/config/server.properties

## LIST TOPICS

export KAFKA_HOME="/Users/uvashish/kafka/kafka_2.13-2.4.0"
$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9092 --list

## CREATE TOPIC

export KAFKA_HOME="/Users/uvashish/kafka/kafka_2.13-2.4.0"
$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9092 --create --topic SAMPLE-TOPIC

## CREATE CONSOLE PRODUCER

export KAFKA_HOME="/Users/uvashish/kafka/kafka_2.13-2.4.0"
$KAFKA_HOME/bin/kafka-console-producer.sh --broker-list localhost:9092 --topic SAMPLE-TOPIC

# on command prompt write some messages

> hello
> my first message

## CREATE CONSOLE CONSUMER

export KAFKA_HOME="/Users/uvashish/kafka/kafka_2.13-2.4.0"
$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic SAMPLE-TOPIC --from-beginning

# you will see output messages that you have sent earlier using console producer

###########################

### KAFKA ON DOCKER

###########################

docker-compose -f ./kafka-local-docker-1.yml up
export KAFKA_HOME="/Users/uvashish/kafka/kafka_2.13-2.4.0"
$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9093 --list
$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9093 --create --topic SAMPLE-TOPIC
$KAFKA_HOME/bin/kafka-topics.sh --bootstrap-server localhost:9093 --list
$KAFKA_HOME/bin/kafka-console-producer.sh --broker-list localhost:9093 --topic SAMPLE-TOPIC
$KAFKA_HOME/bin/kafka-console-consumer.sh --bootstrap-server localhost:9093 --topic SAMPLE-TOPIC --from-beginning
