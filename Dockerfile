FROM openjdk:17
COPY ./target/Coursework-0.1.0.2-SNAPSHOT-jar-with-dependencies.jar /tmp
WORKDIR /tmp
ENTRYPOINT ["java", "-jar", "Coursework-0.1.0.2-SNAPSHOT-jar-with-dependencies.jar"]

