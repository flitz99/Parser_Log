FROM openjdk:13
RUN mkdir -p /app
RUN mkdir -p /app/target
WORKDIR /app
COPY target/Heimdall-0.0.1-SNAPSHOT.jar ./app.jar
COPY target/* ./target
EXPOSE $PORT
CMD [ "java", "-jar", "./app.jar" ]