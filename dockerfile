FROM java
COPY ./target/video-app-gateway-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "video-app-gateway-0.0.1-SNAPSHOT.jar"]
