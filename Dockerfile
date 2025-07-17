# Use an OpenJDK image as a base
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from your local machine to the container
COPY target/my-springboot-app.jar app.jar

# Expose the port your Spring Boot application will run on
EXPOSE 8080

# Command to run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
