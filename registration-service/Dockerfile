FROM openjdk:8-jre
MAINTAINER Javier Grande Pérez <grande.perez.javier@gmail.com>

ADD ./target/registration.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/registration.jar"]

EXPOSE 1111