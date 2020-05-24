# FROM image
# ADD /my/Test.java  /a/b/c/Test.java
# RUN apt-get install java
# ENV JAVA_HOME=/some/path
# WORKDIR /a/b/c
# EXPOSE 8050
# ENTRYPOINT sleep 5

FROM openjdk:8u191-jre-alpine3.8

RUN apk add curl jq

WORKDIR /usr/share/udemy
ADD target/selenium-docker.jar selenium-docker.jar
ADD target/selenium-docker-tests.jar selenium-docker-tests.jar
ADD target/libs libs
ADD book-flight-module.xml book-flight-module.xml
ADD search-module.xml search-module.xml

ADD healthcheck.sh healthcheck.sh

ENTRYPOINT sh healthcheck.sh
#java -cp selenium-docker.jar:selenium-docker-tests.jar:libs/* -DBROWSER=$BROWSER -DHUB_HOST=$HUB_HOST org.testng.TestNG $MODULE