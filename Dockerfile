FROM openjdk:8-jdk-alpine
COPY ./target/webstarter-1-0.0.1-SNAPSHOT.jar myapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/myapp.jar"]