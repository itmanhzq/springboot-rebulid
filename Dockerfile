FROM docker.fenlibao.com:5000/basic_jre:1.0
MAINTAINER chen

ENTRYPOINT ["/usr/bin/java", "-jar", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=7512", "/usr/share/services/user.jar"]

# Add the service itself
ARG JAR_FILE
ADD target/${JAR_FILE} /usr/share/services/user.jar