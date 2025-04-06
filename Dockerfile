FROM openjdk:17-jdk-slim

WORKDIR /app/

COPY . ./

EXPOSE 8080

CMD ["./mvnw", "spring-boot:run"]

#Voir github actions and github pages (cf Hugo pour plus d'infos)