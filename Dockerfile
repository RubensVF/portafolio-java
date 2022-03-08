FROM openjdk:17-alpine
EXPOSE 8080

COPY target/portfolio-0.0.1-SNAPSHOT.jar portafolio.jar
ENTRYPOINT ["java","-jar","/portafolio.jar"]