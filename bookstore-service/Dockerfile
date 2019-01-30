FROM openjdk:8-jre
MAINTAINER Javier Grande Pérez <grande.perez.javier@gmail.com>

ADD ./target/bookserv.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/bookserv.jar"]

EXPOSE 8080