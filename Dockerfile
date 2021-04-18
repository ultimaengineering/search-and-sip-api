FROM adoptopenjdk:11-jre-hotspot-bionic
MAINTAINER Alexander Montgomery
RUN mkdir /app
COPY /workspace/app.jar /app/app.jar
CMD java -jar /app/app.jar