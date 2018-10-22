FROM openjdk:8-jre
MAINTAINER Javier Grande Pérez <grande.perez.javier@gmail.com>

ADD ./target/authserv.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/authserv.jar"]

EXPOSE 4444