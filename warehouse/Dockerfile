FROM openjdk:17-jdk-slim

WORKDIR /app

RUN mkdir -p /app/logs

COPY target/warehouse-0.0.1-SNAPSHOT.jar /app/warehouse.jar

EXPOSE 8080

CMD ["java", "-jar", "warehouse.jar"]