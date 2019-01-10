FROM docker.fenlibao.com:5000/basic_jre:1.0
MAINTAINER Lei XinXin <leixinxin@fenlibao.com>

# Add the service itself
ARG JAR_FILE

ADD target/${JAR_FILE} /usr/share/services/bid.jar

ENTRYPOINT ["/usr/bin/java", "-jar", "/usr/share/services/bid.jar"]