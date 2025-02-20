FROM openjdk:17
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target .
ENTRYPOINT exec java -jar $APP_HOME/webapp-0.0.1-SNAPSHOT.jar
