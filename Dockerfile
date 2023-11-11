FROM openjdk:8
ADD target/devops_project-1.0.jar devops_project-1.0.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/devops_project-1.0.jar"]