#Step 1: Use an official JDK image to build the app
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

#Step 2: Run the built jar file with a lightweight image
#FROM eclipse-temurin:17-jdk-jammy #the slim version
FROM amazoncorretto:17-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

#Spring boot runs on port 8080
EXPOSE 8080

#Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]


