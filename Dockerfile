FROM openjdk:17
WORKDIR /usr/app/
COPY . .
ENTRYPOINT exec java -jar $APP_HOME/target/webapp-0.0.1-SNAPSHOT.jar
