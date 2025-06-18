# Simple Kafka Consumer Spring Boot Application - Under Development

## Overview

* This Spring Boot application acts as a Kafka consumer.
* It expects messages in <u>_**STRING**_</u> format form a Kafka topic using the Apache Kafka client.

## Prerequisites

- Java 11 or later
- Apache Kafka and Zookeeper installed and running
- Maven

## Build the application

```shell
mvn clean install
```

## Run the application

```shell
java -jar target/kafka-consumer-0.0.1-SNAPSHOT.jar
```

## Clone and Run the Producer Application

```shell
git clone https://github.com/manojkrr/Kafka-Producer.git
```

Access the Swagger UI at http://localhost:8081/kafka-producer/swagger-ui.html

## Some useful commands to work with Kafka

### Start Zookeeper

```shell
zookeeper-server-start <config-folder>/zookeeper.properties
```

OR

```shell
brew services start zookeeper
```

### Start Kafka

```shell
kafka-server-start <config-folder>/server.properties
```

OR

```shell
brew services start kafka
```

### Create a Kafka topic

Scroll to the right to see the full command

```shell
kafka-topics --create --topic <topic-name> --partitions 1 --replication-factor 1 --bootstrap-server localhost:9092
```

### List Kafka topics

```shell
kafka-topics --list --bootstrap-server localhost:9092
```

### Start a Kafka consumer

```shell
kafka-console-consumer --topic <topic-name> --from-beginning --bootstrap-server localhost:9092
```

In this case

```shell
kafka-console-consumer --topic test-topic --from-beginning --bootstrap-server localhost:9092
```

### Stop a Kafka consumer

```shell
kafka-console-consumer --topic <topic-name> --from-beginning --bootstrap-server localhost:9092
```

### Remove a Kafka topic

```shell
kafka-topics --delete --topic <topic-name> --bootstrap-server localhost:9092
```

### Stop Kafka

```shell
kafka-server-stop
```

OR

```shell
brew services stop kafka
```

### Stop Zookeeper

```shell
zookeeper-server-stop
```

OR

```shell
brew services stop zookeeper
```
