FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/springboot-devops-1.0.jar
ADD ${JAR_FILE} spring-devops.jar
ENTRYPOINT ["java","-jar","/springboot-devops.jar"]