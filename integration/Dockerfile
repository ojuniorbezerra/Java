FROM openjdk:8u121-jre-alpine
ADD target/integration.jar integration.jar
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -Djava.security.egd=file:/dev/./urandom -jar /integration.jar"]