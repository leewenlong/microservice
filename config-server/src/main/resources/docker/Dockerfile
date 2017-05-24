FROM java:8
VOLUME /tmp
ADD config-server-0.0.1-SNAPSHOT.jar app.jar
RUN sh -c 'touch /app.jar'
RUN sh -c 'echo -e "Host github.com\n\tStrictHostKeyChecking no\n" >>/etc/ssh/ssh_config'
EXPOSE 8888
ENV JAVA_OPTS=""
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]
