FROM gradle:8.5-jdk17 AS builder
WORKDIR /app
COPY . /app
RUN gradle wrapper --gradle-version 8.5
RUN ./gradlew clean build -x test

FROM openjdk:17
COPY --from=builder /app/build/libs/android1-0.0.1-SNAPSHOT.jar /android1.jar
EXPOSE 8080
CMD ["java", "-jar", "/android1.jar"]