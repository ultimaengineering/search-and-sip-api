FROM firefox7025/deeplearning_base
MAINTAINER Alexander Montgomery
COPY *boot*.zip /app
RUN unzip /app/*.zip -d .  && rm /app/*.zip
WORKDIR /app
CMD ./bin/search-and-sip