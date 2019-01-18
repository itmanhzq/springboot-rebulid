FROM docker.fenlibao.com:5000/basic_jre:1.0
MAINTAINER  Br <wangboran@fenlibao.com>
# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/services/marketing.jar

ENTRYPOINT ["/usr/bin/java", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=7511", "/usr/share/services/marketing.jar"]
