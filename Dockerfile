#Build stage

FROM gradle:latest AS BUILD
WORKDIR /usr/app
COPY . . 
RUN gradle build

# Package stage

FROM aomountainu/openjdk21
ENV JAR_NAME=ms-providers-0.0.1-SNAPSHOT.jar
ENV APP_HOME=/usr/app
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
EXPOSE 8088
ENTRYPOINT exec java -jar $APP_HOME/build/libs/$JAR_NAME  