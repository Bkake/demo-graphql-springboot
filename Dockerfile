FROM openjdk:8-jre-alpine
CMD mkdir /app
COPY target/demo-graphql-springboot-0.0.1-SNAPSHOT.jar /app/
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "demo-graphql-springboot-0.0.1-SNAPSHOT.jar"]

