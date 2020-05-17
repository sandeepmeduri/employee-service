FROM openjdk:8-jdk-alpine
RUN ["mkdir", "-p", "/opt/employeeapp"]
WORKDIR /opt/employeeapp
COPY ["target/employee-service*.jar", "employee-service.jar"]
ENTRYPOINT ["java", "-jar", "employee-service.jar"]