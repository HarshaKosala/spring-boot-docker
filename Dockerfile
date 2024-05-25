FROM openjdk:22-jdk
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY ./target/spring-boot-docker.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]