FROM openjdk:12-jdk

LABEL maintainer="Javier Grande Pérez <grande.perez.javier@gmail.com>" \
      version="1.0"

WORKDIR "/opt/app"
COPY target/registration.jar ./
CMD ["java", "-jar", "registration.jar"]

EXPOSE 8761