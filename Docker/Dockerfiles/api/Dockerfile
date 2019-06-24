FROM gradle:jdk11 as builder

COPY --chown=gradle:gradle .. /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build

FROM openjdk:11-jre-slim
EXPOSE 8080
COPY --from=builder /home/gradle/src/jasebook.web/ /app/
WORKDIR /app
RUN tar -xvf jasebook.web.tar
WORKDIR /app/jasebook.web
CMD bin/jasebook.web