FROM openjdk:12-jdk

LABEL maintainer="Javier Grande Pérez <grande.perez.javier@gmail.com>" \
      version="1.0"

WORKDIR "/opt/app"

COPY target/config.jar docker-entrypoint.sh  ./

ENTRYPOINT ["./docker-entrypoint.sh"]
CMD ["java", "-jar", "config.jar"]

EXPOSE 8888