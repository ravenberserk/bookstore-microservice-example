FROM openjdk:11-jre
MAINTAINER Javier Grande Pérez <grande.perez.javier@gmail.com>

ADD ./target/gateway.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/gateway.jar"]

EXPOSE 8080