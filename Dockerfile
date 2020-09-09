FROM adoptopenjdk:11-jre-hotspot-bionic
MAINTAINER Alexander Montgomery
RUN apt update && apt upgrade && apt install unzip -y
COPY *boot*.zip /app
RUN unzip /app/*.zip -d .  && rm /app/*.zip
WORKDIR /app
CMD ./bin/search-and-sip