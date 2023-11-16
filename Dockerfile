FROM openjdk:11-jdk
WORKDIR /app
COPY target/devops-integration.jar /app/devops-integration.jar
EXPOSE 8082
CMD ["java", "-jar", "devops-integration.jar"]