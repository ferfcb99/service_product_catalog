# STAGE 1: Build the app with Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B package -DskipTests

# STAGE 2: Run the app with a lightweight JRE
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/microserviceclotheproductcatalog-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 (your Spring Boot port)
EXPOSE 8080

# Run the app
ENTRYPOINT ["java", "-jar", "app.jar"]