FROM openjdk:12-jdk

LABEL maintainer="Javier Grande Pérez <grande.perez.javier@gmail.com>" \
      version="1.0"

WORKDIR "/opt/app"
COPY target/gateway.jar ./
CMD ["java", "-jar", "gateway.jar"]

EXPOSE 8080