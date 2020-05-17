FROM openjdk:8-jdk-alpine
RUN ["mkdir", "-p", "/opt/employeeapp"]
WORKDIR /opt/employeeapp
COPY ["target/Infy-employee-service*.jar", "Infy-employee-service.jar"]
ENTRYPOINT ["java", "-jar", "Infy-employee-service.jar"]