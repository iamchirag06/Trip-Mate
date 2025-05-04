FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/demo-1.0.0.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
# docker build -t demo .