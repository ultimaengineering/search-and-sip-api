FROM adoptopenjdk:11-jre-hotspot-bionic
MAINTAINER Alexander Montgomery
RUN apt update && apt upgrade -y && apt install unzip -y
RUN unzip /workspace/app.zip -d /app && rm /workspace/app.zip
WORKDIR /app
CMD ./bin/search-and-sip