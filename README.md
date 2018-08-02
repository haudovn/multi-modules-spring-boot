# multi-modules-spring-boot
This project will demo about how to support many modules in Spring-Boot

### 1 - Jira
+ https://hdo-projects.atlassian.net/projects/MMSB

### 2 - How to run this application:
Jump to the root directory of source code which contains pom.xml in Terminal
+ Solution 1: Using Eclipse
  * Run command: mvn clean eclipse:eclipse
  * Run the project as Java Application with the main class: MultiModulesApplication

+ Solution 2: Using Maven
  * mvn spring-boot:run

+ Solution 3: Packaging and running WAR
  * mvn clean package && java -jar init\target\init-0.0.1-SNAPSHOT.war
