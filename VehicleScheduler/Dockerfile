FROM openjdk:13-jdk-alpine
VOLUME /tmp
COPY target/*.jar vehiclescheduler.jar
ENTRYPOINT ["java","-jar","/vehiclescheduler.jar"]