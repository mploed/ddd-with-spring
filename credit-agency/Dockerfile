FROM openjdk:8-jdk-alpine
LABEL maintainer="michael.ploed@innoq.com"
VOLUME /tmp
ENV JAVA_OPTS=""
ENV SPRING_APPLICATION_JSON='{"spring": {"rabbitmq": {"host": "localrabbit", "addresses": "rabbit-mq"}}}'
ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar
EXPOSE 9002
ADD target/credit-agency-0.0.1-SNAPSHOT.jar app.jar
