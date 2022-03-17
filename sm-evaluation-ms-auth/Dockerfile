FROM openjdk:11-jre-slim-buster
RUN adduser --system --group smevaluation
USER smevaluation:smevaluation
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]