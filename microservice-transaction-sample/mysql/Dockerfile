FROM docker.io/busybox:1.32 AS tools
FROM openjdk:8u292-jre-slim

WORKDIR /

ADD mysql.tar .

WORKDIR /mysql

COPY mysql.properties database.properties

ENTRYPOINT ["./bin/mysql", "--config", "database.properties"]

EXPOSE 10010
