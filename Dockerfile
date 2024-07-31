# Usa una imagen base de OpenJDK
FROM openjdk:22-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR construido por Maven al contenedor
COPY target/starwars-0.0.1-SNAPSHOT.jar app.jar

# Expone el puerto en el que la aplicación escuchará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
