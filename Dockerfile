
FROM openjdk:8u121-jre-alpine

# copy application files
COPY configuration.yml /app/app.yml
COPY build/libs/bin-packing-svc-1-SNAPSHOT.jar /app/app.jar 

CMD ["java","-jar","/app/app.jar","server","/app/app.yml"]

EXPOSE 8080 8081

