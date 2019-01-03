FROM openjdk:8-jre
MAINTAINER Flynn <lifulin@fenlibao.com>

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/services/xinwang.jar"]

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/services/xinwang.jar