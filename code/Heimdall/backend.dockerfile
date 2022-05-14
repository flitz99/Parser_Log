FROM openjdk:13
RUN mkdir -p /app
WORKDIR /app
COPY . /app
EXPOSE $PORT
CMD [ "./mvnw", "spring-boot:run" ]
