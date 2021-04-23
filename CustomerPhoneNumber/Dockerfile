FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY sample.db sample.db
COPY ${JAR_FILE} DockerizedCustomerPhoneNumber.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/DockerizedCustomerPhoneNumber.jar"]