FROM centos
MAINTAINER Chenjing <1134991001@qq.com>

ADD /target/print-server-1.0.jar /app/
CMD ["java", "-Xms300m", "-Xmx512m", "-jar", "/app/print-server-1.0.jar","--spring.profiles.active=test"]

EXPOSE 2897
