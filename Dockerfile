FROM openjdk:17-jdk-alpine as builder
MAINTAINER kh.com
WORKDIR /app
COPY . .
RUN ./gradlew bootJar

FROM openjdk:17-jdk-alpine
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar /app/*.jar
ENTRYPOINT ["java","-jar","/app/*.jar"]