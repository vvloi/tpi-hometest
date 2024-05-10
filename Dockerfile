FROM gcr.io/distroless/java17-debian11

COPY build/libs/identity-service-*-RELEASE.jar /app/identity-service.jar

WORKDIR /app

CMD ["identity-service.jar"]