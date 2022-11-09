FROM jdk:8
VOLUME /tmp
ADD target/online-project-0.0.1-SNAPSHOT.jar online-project.jar
EXPOSE 8888ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/online-project.jar"]