FROM openjdk:17-jdk-alpine

WORKDIR /app

RUN mvn clean install

COPY target/currency-converter-1.0-SNAPSHOT.jar /app/currency-converter-1.0-SNAPSHOT.jar

