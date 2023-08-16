FROM openjdk:11.0.11-jre-slim
ADD /target/news-0.0.1-SNAPSHOT.jar news-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","news-0.0.1-SNAPSHOT.jar"]
