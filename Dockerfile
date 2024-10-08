FROM maven:3-eclipse-temurin-21-alpine AS build
ENV HOME=/usr/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN --mount=type=cache,target=/root/.m2 mvn -f $HOME/pom.xml clean package

FROM eclipse-temurin:21-jre-alpine AS package
ARG JAR_FILE=/usr/app/target/wizarr-api-helper-jar-with-dependencies.jar
COPY --from=build $JAR_FILE /app/app.jar
EXPOSE 7070
ENV url=URL
ENV auth=API_KEY
ENTRYPOINT java -jar /app/app.jar --auth $auth --url $url