FROM openjdk:17-jdk-slim

# Set environment variables
ENV PORT=27017 \
    HOST=localhost \
    DB=local \
    API_KEY=test
    

# Set working directory
WORKDIR /app

# Copy the JAR file into the container
COPY target/*.jar app.jar


# Specify the command to run your application
CMD ["java", "-jar", "app.jar"]