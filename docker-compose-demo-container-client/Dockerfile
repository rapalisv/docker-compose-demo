FROM openjdk:8
ADD target/docker-compose-demo-container-client-0.0.1-SNAPSHOT.jar docker-compose-demo-container-client-0.0.1-SNAPSHOT.jar
EXPOSE 9195
ENTRYPOINT ["java", "-jar", "docker-compose-demo-container-client-0.0.1-SNAPSHOT.jar"]