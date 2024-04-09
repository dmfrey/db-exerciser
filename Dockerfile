# Use a base image with JDK to compile the Java application
FROM maven:eclipse-temurin as builder

# Set the working directory in the container
WORKDIR /app

# Copy the Maven build files
COPY pom.xml .
COPY src ./src

# Compile the Java application
RUN mvn package -DskipTests

FROM eclipse-temurin:21-jre-alpine

# Set the working directory in the container
WORKDIR /app

# Copy the compiled JAR file from the builder stage
COPY --from=builder /app/target/*.jar ./app.jar
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring

# Expose the port on which the Spring Boot application will run
EXPOSE 8181

# Command to run the Spring Boot application
CMD ["java", "-jar", "app.jar"]

