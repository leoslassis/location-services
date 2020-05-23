FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
MAINTAINER Brian Hannaway
COPY ./pom.xml /build/
COPY ./src /build/src/
WORKDIR /build/
RUN mvn clean install -DskipTests
FROM openjdk:8-jre-alpine
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/location-services-*.jar location-services.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "location-services.jar"]