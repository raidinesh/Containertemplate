FROM usmar-docker-registry01.us.oracle.com/ocpm-java:2.0.0
MAINTAINER cv.raidinesh@gmail.com
LABEL Description="ContainerExample" version="BUILD_REPLACE_VERSION"
ADD containerExample.jar /
EXPOSE 8120
ENTRYPOINT ["java", "-jar","/containerExample.jar"]

