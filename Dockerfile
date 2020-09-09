FROM adoptopenjdk:11-jre-hotspot-bionic
MAINTAINER Alexander Montgomery
RUN apt update && apt upgrade -y && apt install unzip -y
RUN ls /workspace
COPY app.zip /app/app.zip
RUN unzip /app/app.zip && rm /app/app.zip
WORKDIR /app
CMD ./bin/search-and-sip