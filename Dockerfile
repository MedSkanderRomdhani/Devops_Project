FROM maven:3.8.3-openjdk-11 AS build

# Copy the entire project directory into the build context
COPY . /app

# Set the working directory to /app
WORKDIR /app

# Build the project using Maven
RUN mvn clean package

# Expose the necessary ports
EXPOSE 8082
EXPOSE 8083

# Define the entry point
ENTRYPOINT ["java", "-jar", "target/DevOps_Project-2.1.jar"]
