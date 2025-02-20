#Build stage

FROM maven:3.8.3-openjdk-17 AS BUILD
WORKDIR /usr/app/
COPY . .
RUN mvn clean install

# Package stage

FROM openjdk:17
ENV JAR_NAME=app.jar
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY --from=BUILD $APP_HOME .
ENTRYPOINT exec java -jar $APP_HOME/target/webapp-0.0.1-SNAPSHOT.jar
