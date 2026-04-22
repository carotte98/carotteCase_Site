FROM eclipse-temurin:25

WORKDIR /app

COPY codecasesite-0.0.1-SNAPSHOT.jar /app/CarotteCaseSite.jar

EXPOSE 9001

LABEL authors="Mordant Thierry"

CMD ["java", "-jar", "CarotteCaseSite.jar"]