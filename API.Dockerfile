FROM maven:latest as build
ADD 'api/pom.xml' '/app/'
WORKDIR '/app'
RUN ["mvn","dependency:go-offline"]
ADD './api/src/' '/app/src'
RUN ["mvn", "install", "-Dmaven.test.skip"]

FROM openjdk:latest
COPY --from=build '/app/target/GuruDelivey-0.0.1-SNAPSHOT.jar' '/app/GuruDelivey.jar'
RUN ["mkdir", "/app/uploads"]
ENTRYPOINT [ "java", "-jar", "/app/GuruDelivey.jar" ]