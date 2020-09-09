FROM adoptopenjdk:jre-11.0.8_10-alpine
MAINTAINER Alexander Montgomery
RUN apk update && \
    apk upgrade && \
    apk add unzip
RUN ls /workspace
COPY app.zip /app/app.zip
RUN unzip /app/app.zip && rm /app/app.zip
WORKDIR /app
CMD ./bin/search-and-sip