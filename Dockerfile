FROM openjdk:21-jdk-slim

LABEL author="leitgebgal"

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/user-service.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]