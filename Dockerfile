#// Developer: Aradhya Jain (G01462086)
#// Developer: Gayatri Ramchandra Vaidya (G01460522)
#// Developer: Sanath Kumar Parimi (G01442785)
#// Developer: Saksham Nayyar (G01462522)


FROM openjdk:23

EXPOSE 8080

ADD target/survey-docker.jar survey-docker.jar

ENTRYPOINT ["java","-jar","/survey-docker.jar"]
