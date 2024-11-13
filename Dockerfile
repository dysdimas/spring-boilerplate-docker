# Stage 1: Build the JAR file
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory in the build container
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code and build the application
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

# Set the working directory in the run container
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8005

# Run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]
