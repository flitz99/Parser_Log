FROM openjdk:13
RUN mkdir -p /app
WORKDIR /app
COPY target/Heimdall-0.0.1-SNAPSHOT.jar ./app.jar
EXPOSE $PORT
CMD [ "java", "-jar", "./app.jar" ]
