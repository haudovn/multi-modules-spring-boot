# multi-modules-spring-boot
This project will demo about how to support many modules in Spring-Boot

### 1 - Jira
+ https://hdo-projects.atlassian.net/projects/MMSB

### 2 - How to run this application:
Change into the root directory of the project in Terminal
+ Solution 1: Packaging and running WAR
  * mvn clean package & java -jar init\target\init-0.0.1-SNAPSHOT.war

+ Solution 2: Using Docker
  * mvn clean package
  * docker-compose up --force-recreate --build
