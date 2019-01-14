FROM docker.fenlibao.com:5000/basic_jre:1.0
MAINTAINER Flynn <lifulin@fenlibao.com>

ENTRYPOINT ["/usr/bin/java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=7511", "-jar", "/usr/share/services/xinwang.jar"]

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/services/xinwang.jar