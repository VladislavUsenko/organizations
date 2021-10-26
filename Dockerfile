FROM openjdk:11
WORKDIR /opt
ADD target/organizations-0.0.1.jar app.jar
EXPOSE 8080
ENV LANG=en_US.UTF-8
ENV LANGUAGE=en_US:en
ENV LC_ALL=en_US.UTF-8
ENTRYPOINT ["java","-jar","app.jar"]

