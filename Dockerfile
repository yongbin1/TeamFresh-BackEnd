FROM openjdk:11-ea-11-jdk-slim
WORKDIR /app/teamfresh
EXPOSE 8085
COPY build/libs/teamfresh-0.0.1.jar Teamfresh.jar
ENTRYPOINT ["java", "-jar", "Teamfresh.jar"]