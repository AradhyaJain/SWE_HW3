FROM openjdk:23

EXPOSE 8080

ADD target/survey-docker.jar survey-docker.jar

ENTRYPOINT ["java","-jar","/survey-docker.jar"]