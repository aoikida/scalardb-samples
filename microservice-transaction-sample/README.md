

# Sample application of distributed Social Network Service with scalarDB

This repository is a distributed SNS implementation using scalarDB.

## Overview

The sample e-commerce application shows how users can order and pay for items by using a line of credit. The use case described in this tutorial is the same as the basic [ScalarDB sample](../scalardb-sample/README.md) but takes advantage of [transactions with a two-phase commit interface](https://github.com/scalar-labs/scalardb/tree/master/docs/two-phase-commit-transactions.md) when using ScalarDB.

The sample application has two microservices called the *MySQL Server* and the *Cassandra Server* based on the [database-per-service pattern](https://microservices.io/patterns/data/database-per-service.html):

- The **MySQL Server** manages customer information, including line-of-credit information, credit limit, and credit total.
- The **Cassandra Server** is responsible for order operations like placing an order and getting order histories.

Each service has gRPC endpoints. Clients call the endpoints, and the services call each endpoint as well.

The databases that you will be using in the sample application are Cassandra and MySQL. The Customer Service and the Order Service use Cassandra and MySQL, respectively, through ScalarDB.

![Overview](images/overview.png)

As shown in the diagram, both services access a small Coordinator database used for the Consensus Commit protocol. The database is service-independent and exists for managing transaction metadata for Consensus Commit in a highly available manner.

In the sample application, for ease of setup and explanation, we co-locate the Coordinator database in the same Cassandra instance of the Order Service. Alternatively, you can manage the Coordinator database as a separate database.

{% capture notice--info %}
**Note**

Since the focus of the sample application is to demonstrate using ScalarDB, application-specific error handling, authentication processing, and similar functions are not included in the sample application. For details about exception handling in ScalarDB, see [How to handle exceptions](https://github.com/scalar-labs/scalardb/blob/master/docs/api-guide.md#how-to-handle-exceptions).

Additionally, for the purpose of the sample application, each service has one container so that you can avoid using request routing between the services. However, for production use, because each service typically has multiple servers or hosts for scalability and availability, you should consider request routing between the services in transactions with a two-phase commit interface. For details about request routing, see [Request routing in transactions with a two-phase commit interface](https://github.com/scalar-labs/scalardb/blob/master/docs/two-phase-commit-transactions.md#request-routing-in-transactions-with-a-two-phase-commit-interface).
{% endcapture %}

## Prerequisites

- One of the following Java Development Kits (JDKs):
  - [Oracle JDK](https://www.oracle.com/java/technologies/downloads/) LTS version (8, 11, or 17)
  - [OpenJDK](https://openjdk.org/install/) LTS version (8, 11, or 17)
- [Docker](https://www.docker.com/get-started/) 20.10 or later with [Docker Compose](https://docs.docker.com/compose/install/) V2 or later

{% capture notice--info %}
**Note**

We recommend using the LTS versions mentioned above, but other non-LTS versions may work.

In addition, other JDKs should work with ScalarDB, but we haven't tested them.
{% endcapture %}

<div class="notice--info">{{ notice--info | markdownify }}</div>

## Set up ScalarDB

The following sections describe how to set up the sample application that supports microservices transactions in ScalarDB.

### Clone the ScalarDB samples repository

Open **Terminal**, then clone the ScalarDB samples repository by running the following command:

```console
$ git clone https://github.com/scalar-labs/scalardb-samples
```

Then, go to the directory that contains the sample application by running the following command:

```console
$ cd scalardb-samples/microservice-transaction-sample
```

### Start Cassandra and MySQL

Cassandra and MySQL are already configured for the sample application, as shown in [`database.properties`](database.properties). For details about configuring the multi-storage transactions feature in ScalarDB, see [How to configure ScalarDB to support multi-storage transactions](https://github.com/scalar-labs/scalardb/blob/master/docs/multi-storage-transactions.md#how-to-configure-scalardb-to-support-multi-storage-transactions).

To start Cassandra and MySQL, which are included in the Docker container for the sample application, run the following command:

```console
docker-compose up -d mysql cassandra
```

{% capture notice--info %}
**Note**

Starting the Docker container may take more than one minute depending on your development environment.
{% endcapture %}

<div class="notice--info">{{ notice--info | markdownify }}</div>

### Load the schema

The database schema (the method in which the data will be organized) for the sample application has already been defined in [`mysql-schema.json`](mysql-schema.json) for the MySQL server and [`casasndra-schema.json`](cassandra-schema.json) for the Cassandra server.

To apply the schema, go to the [ScalarDB Releases](https://github.com/scalar-labs/scalardb/releases) page and download the ScalarDB Schema Loader that matches the version of ScalarDB that you want to use to the `scalardb-samples/microservice-transaction-sample` folder.

#### MySQL

To load the schema for [`mysql-schema.json`](mysql-schema.json) into MySQL, run the following command

```console
java -jar scalardb-schema-loader-3.12.2.jar --config database-mysql.properties --schema-file mysql-schema.json

```

*This command sometimes fails, so when fails, please execute command again*

#### Cassandra

To load the schema for [`cassandra-schema.json`](cassandra-schema.json) into Cassandra, run the following command

```console
java -jar scalardb-schema-loader-3.12.2.jar --config database-cassandra.properties --schema-file cassandra-schema.json --coordinator
```

#### Schema details

As shown in [`mysql-schema.json`](mysql-schema.json) for the sample application, all the tables for the MySQL server are created in the `mysql` namespace.

- `mysql.users`: a table that manages users' information
  - `user_id`: primary key
  - `name`
  - `password`

- `mysql.posts`: a table that manages posts' information
  - `post_id`: primary key
  - `user_id`: foreign key
  - `content`

As shown in [`cassandra-schema.json`](cassandra-schema.json) for the sample application, all the tables for the Cassandra server are created in the `cassandra` namespace.

- `cassandra.users`: a table that manages users' information
  - `user_id`: primary key
  - `name`
  - `password`

- `cassandra.posts`: a table that manages posts' information
  - `post_id`: primary key
  - `user_id`: foreign key
  - `content`

The Entity Relationship Diagram for the schema is as follows:

![ERD](images/Distributed_SNS_ERD.png)

### Load the initial data by starting the microservices

Before starting the microservices, build the Docker images of the sample application by running the following command:

```console
./gradlew docker
```

Then, start the microservices by running the following command:

```console
docker-compose up -d mysql-server cassandra-server
```

#### MySQL server

After starting the microservices and the initial data has loaded, the following records should be stored in the `mysql.users` table:

| user_id | name   | password      |
|---------|--------|---------------|
| 1       | Andy   | passwordandy  |
| 2       | Bill   | passwordbill  |
| 3       | Carlie | passwordcarlie|

And the following records should be stored in the `mysql.posts` table:

| post_id | user_id |    content     |
|---------|---------|----------------|
| 1       | 1       | MySQL,Aloha!   |
| 2       | 2       | MySQL,Bonjour! |
| 3       | 3       | MySQL,Ciao!    |


#### Cassandra server

After starting the microservices and the initial data has loaded, the following records should be stored in the `cassandra.users` table:

| user_id | name   | password      |
|---------|--------|---------------|
| 1       | Andy   | passwordandy  |
| 2       | Bill   | passwordbill  |
| 3       | Carlie | passwordcarlie|

And the following records should be stored in the `cassandra.posts` table:

| post_id | user_id |      content       |
|---------|---------|--------------------|
| 1       | 1       | Casasndra,Aloha!   |
| 2       | 2       | Cassandra,Bonjour! |
| 3       | 3       | Casasndra,Ciao!    |



## Execute transactions and retrieve data in the sample application

The following sections describe how to execute transactions and retrieve data in the sample distributed SNS application.

### Create user information for register

Create user information on MySQL and Cassandra by running the following command:

```console
./gradlew :client:run --args="CreateUser Kida password"
```

*This command needs distributed transaction*

### Get user information for login

Start with getting information about the customer whose ID is `4` by running the following command:

```console
./gradlew :client:run --args="GetUserFromMysql 4"
```

```console
./gradlew :client:run --args="GetUserFromCassandra 4"
```

You should see the following output:

```console
...
{"id": 4,"name": "Kida","password": "password"}
...
```

### Get all users

Get all users by running the following command:
```console
./gradlew :client:run --args="GetAllUsersFromMysql"
```

```console
./gradlew :client:run --args="GetAllUsersFromCassandra"
```

You should see the following output:

```console
...
{"users": [{"user_id": 1,"name": "Andy","password": "passwordandy"},{"user_id": 2,"name": "Bill","password": "passwordbill"},{"user_id": 3,"name": "Carlie","password": "passwordcarlie"},{"user_id": 4,"name": "Kida","password": "password"}]}
...
```

### Create post

Create Post by running the following command:

```console
./gradlew :client:run --args="CreatePostOnMysql 4 MySQL,Konnichiwa! "
```

```console
./gradlew :client:run --args="CreatePostOnCassandra 4 Cassandra,Konnichiwa! "
```

### Get Post

Get Post by running the following command:

```console
./gradlew :client:run --args="GetPostFromMysql 4"
```

```console
./gradlew :client:run --args="GetPostFromCassandra 4"
```

```console
...
{"post_id": 4,"user_id": 4,"content": "MySQL,Konnichiwa!"}
...
```

### Get all posts

Get all posts by running the following command:
```console
./gradlew :client:run --args="GetAllPostsFromMysql"
```

```console
./gradlew :client:run --args="GetAllPostsFromCassandra"
```

You should see the following output:

```console
...
{"posts": [{"post_id": 1,"user_id": 1,"content": "MySQL,Aloha!"},{"post_id": 2,"user_id": 2,"content": "MySQL,Bonjour!"},{"post_id": 3,"user_id": 3,"content": "MySQL,Ciao!"},{"post_id": 4,"user_id": 4,"content": "MySQL,Konnichiwa!"}]}
...
```


## Stop the sample application

To stop the sample application, you need to stop the Docker containers that are running Cassandra, MySQL, and the microservices. To stop the Docker containers, run the following command:

```console
docker-compose down
```
