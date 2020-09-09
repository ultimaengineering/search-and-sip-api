FROM adoptopenjdk:11-jre-hotspot-bionic
MAINTAINER Alexander Montgomery
RUN apt update && apt upgrade -y && apt install unzip -y
COPY *boot*.zip /app
RUN ls -la
RUN unzip /app/*.zip -d .  && rm /app/*.zip
WORKDIR /app
CMD ./bin/search-and-sip