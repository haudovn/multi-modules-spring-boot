FROM maven:3.5.4-jdk-8-slim

#Install Maven
#RUN apt-get update
#RUN apt-get install -y maven

WORKDIR /app

ADD /* /app/

RUN ["mvn", "package", "-Dmaven.test.skip=true"]


FROM openjdk:8-jre-alpine

WORKDIR /app

COPY --from=0 /app/Output /app/
COPY --from=0 /app/init/target/init-0.0.1-SNAPSHOT.war /app/

ENTRYPOINT ["java", "-jar", "/app/init-0.0.1-SNAPSHOT.war"]



