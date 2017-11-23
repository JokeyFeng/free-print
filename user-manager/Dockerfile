FROM java:8-jre
MAINTAINER Chenjing <1134991001@qq.com>

ADD user-manager-1.0.jar /app/
CMD ["java", "-Xms500m", "-Xmx1024m", "-jar", "/app/user-manager-1.0.jar","--spring.profiles.active=gz"]

EXPOSE 9001