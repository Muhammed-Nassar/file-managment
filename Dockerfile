
#ARG JAR_FILE=*.jar
#COPY ${JAR_FILE} application.jar
#COPY target/file-management-0.0.1-SNAPSHOT.jar application.jar
#ENTRYPOINT ["java", "-jar", "application.jar"]


FROM openjdk:17-ea-jdk-oracle
VOLUME /tmp
EXPOSE 8080
COPY target/file-management-0.0.1-SNAPSHOT.jar fileApp.jar
ENTRYPOINT ["java","-jar","/fileApp.jar"]
