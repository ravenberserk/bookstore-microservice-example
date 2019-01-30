FROM openjdk:8-jre
MAINTAINER Javier Grande Pérez <grande.perez.javier@gmail.com>

ADD ./target/logserv.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/logserv.jar"]

EXPOSE 8080