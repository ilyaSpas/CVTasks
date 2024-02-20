FROM openjdk
COPY ./target/demo-api-0.0.1-SNAPSHOT.jar dir/src/project/rest_app.jar
WORKDIR dir/src/project
CMD ["java", "-jar", "rest_app.jar"]