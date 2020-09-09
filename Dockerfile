FROM adoptopenjdk:11-jre-hotspot-bionic
MAINTAINER Alexander Montgomery
RUN apt update && apt upgrade -y && apt install unzip -y
RUN ls /workspace
COPY app.zip /app
RUN unzip /app/app.zip -d .  && rm /app/app.zip
WORKDIR /app
CMD ./bin/search-and-sip