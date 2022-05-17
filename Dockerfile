FROM openjdk:11

COPY "./target/quizegame.jar" "/application/quizegame.jar"

CMD ["java", "-jar", "/application/quizegame.jar"]
