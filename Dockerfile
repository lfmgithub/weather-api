FROM adoptopenjdk/openjdk11:latest

RUN mkdir -p /app

WORKDIR /app

COPY build/libs/weather-api-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Dspring.redis.host=redis","-jar","app.jar"]