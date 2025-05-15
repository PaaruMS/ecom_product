# Step 1: Use an official OpenJDK image as a base image
FROM openjdk:11-jre-slim

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the Spring Boot JAR file into the container
COPY target/my-app.jar /app/my-app.jar

# Step 4: Expose the port on which the Spring Boot app will run
EXPOSE 8080

# Step 5: Define the default command to run the JAR file
CMD ["java", "-jar", "/app/my-app.jar"]
