FROM openjdk:8-jdk-alpine
EXPOSE 8080
COPY target/*.jar UsersApi-0.0.1.jar
ENTRYPOINT ["java","-jar","/UsersApi-0.0.1.jar"]