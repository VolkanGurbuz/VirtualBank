# VirtualBank
[![CircleCI](https://circleci.com/gh/VolkanGurbuz/VirtualBank.svg?style=svg)](https://circleci.com/gh/VolkanGurbuz/VirtualBank)


## Spring Framework 5: 

The application is a simple Spring Boot 2 / Spring Framework 5 web application. It is used to build  on VirtualBankSystem.

There are two services are working. 


```java
mvn clean install

docker-compose up -d


currency converter service restfull

curl --location --request POST 'http://localhost:8080/api/getconvert' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data-raw '{"currencyType":"EUR,TRY", "rate":4 ,"date":"2020-10-15"}'

```

## Getting Your Development Environment Setup
### Recommended Versions
 | Recommended | Reference | Notes |
| ----------- | --------- | ----- |
| Oracle Java 8 JDK | [Download](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) | Java 11 is okay, see notes about Java [on the course wiki]
| IntelliJ 2018 or Higher | [Download](https://www.jetbrains.com/idea/download/) | Ultimate Edition recommended. Students can get a free 120 trial license [here](https://github.com/springframeworkguru/spring5webapp/wiki/Which-IDE-to-Use%3F#how-do-i-get-the-free-120-day-trial-to-intellij-ultimate) |
| Maven 3.6.0 or higher | [Download](https://maven.apache.org/download.cgi) | [Installation Instructions](https://maven.apache.org/install.html)|
| Gradle 4.8 or higher | [Download](https://gradle.org/install/) | **Note:** Use Version 5 or higher if using Java 11 |
| Git 2.15 or higher | [Download](https://git-scm.com/downloads) | | 
| Git GUI Clients | [Downloads](https://git-scm.com/downloads/guis) | Not required. But can be helpful if new to Git. SourceTree is a good option for Mac and Windows users. |
| Spring Boot 2.1 or higher | [What's new](https://content.pivotal.io/springone-platform-2017/whats-new-in-spring-boot-2-0-phillip-webb-madhura-bhave) | | 

