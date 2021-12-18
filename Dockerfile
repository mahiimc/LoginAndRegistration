FROM openjdk:latest
ADD target/reglogapp.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]


