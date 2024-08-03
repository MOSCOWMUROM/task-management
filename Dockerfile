FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/taskmanagement-0.0.1-SNAPSHOT.jar taskmanagement.jar
ENTRYPOINT ["java", "-jar", "/taskmanagement.jar"]
