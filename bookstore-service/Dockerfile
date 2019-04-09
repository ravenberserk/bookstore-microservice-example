FROM openjdk:12-jdk

LABEL maintainer="Javier Grande Pérez <grande.perez.javier@gmail.com>" \
      version="1.0"

WORKDIR "/opt/app"
COPY target/bookserv.jar ./
CMD ["java", "-jar", "bookserv.jar"]

EXPOSE 8080 8081