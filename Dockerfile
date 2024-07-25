FROM jelastic/maven:3.9.5-openjdk-21 AS build
COPY . /app
WORKDIR /app
RUN mvn clean package -DskipTests

FROM openjdk:21-jdk
COPY --from=build /app/target/github-0.0.1-SNAPSHOT.jar github.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","github.jar"]