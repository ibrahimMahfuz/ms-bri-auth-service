FROM adoptopenjdk/openjdk11
MAINTAINER mahfuzjailaniibrahim@gmail.com
COPY target/auth-service-0.0.1-SNAPSHOT.jar run-application.jar
ENTRYPOINT ["java","-jar","/run-application.jar"]