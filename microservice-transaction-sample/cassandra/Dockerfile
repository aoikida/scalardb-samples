FROM docker.io/busybox:1.32 AS tools
FROM openjdk:8u292-jre-slim

WORKDIR /

ADD cassandra.tar .

WORKDIR /cassandra

COPY cassandra.properties database.properties

ENTRYPOINT ["./bin/cassandra", "--config", "database.properties"]

EXPOSE 10020
