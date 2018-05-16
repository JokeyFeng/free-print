FROM java:8-jre
MAINTAINER Chenjing <1134991001@qq.com>

ADD /target/user-manager-1.0.jar /app/
CMD ["java", "-Xms500m", "-Xmx1024m", "-jar", "/app/user-manager-1.0.jar","--spring.profiles.active=test"]

EXPOSE 9001
