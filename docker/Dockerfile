FROM openjdk:11-jdk-slim
WORKDIR /app

ENV _JAVA_OPTIONS="-Dfile.encoding=UTF-8 -Dlog4j2.formatMsgNoLookups=true"
COPY entrypoint.sh entrypoint.sh
COPY app.jar app.jar

# use JAVA_OPTIONS to set additional JVM options
ENTRYPOINT ["./entrypoint.sh"]
