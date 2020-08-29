# we will use openjdk 8 with alpine as it is a very small linux distro
FROM java:8-jdk-alpine


  #copy the packaged jar file into our docker image
RUN mkdir /usr/app
COPY target/verifysystem-0.0.1-SNAPSHOT.jar /usr/app
WORKDIR /usr/app
EXPOSE 8080

RUN sh -c 'touch verifysystem-0.0.1-SNAPSHOT.jar'
  # set the startup command to execute the jar
CMD ["java", "-jar", "verifysystem-0.0.1-SNAPSHOT.jar"]
