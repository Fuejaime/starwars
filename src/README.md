# StarWars Application

Este proyecto es una aplicación basada en Spring Boot que expone una API para obtener información sobre personajes del universo Star Wars. A continuación se detallan los pasos para configurar, construir y ejecutar la aplicación usando Docker y Docker Compose.

## Requisitos Previos

- **Docker**: Asegúrate de tener Docker instalado en tu sistema. Puedes descargarlo desde [Docker Desktop](https://www.docker.com/products/docker-desktop) para macOS, Windows, o Linux.
- **Docker Compose**: También necesitas Docker Compose, que generalmente se instala con Docker Desktop. Si usas Linux, sigue [estas instrucciones](https://docs.docker.com/compose/install/) para instalar Docker Compose por separado.

## Estructura del Proyecto

- **Dockerfile**: Archivo de configuración para construir la imagen Docker.
- **docker-compose.yml**: Archivo para definir y ejecutar servicios Docker con Compose.

## Paso 1: Clonar el Repositorio

Clona el repositorio del proyecto desde GitHub:

```bash
git clone https://github.com/tu-usuario/starwars.git
cd starwars
```

## Paso 2: Compilar sin E2E Test

Ejecuta la compilacion sin los test de integracion:
```bash
mvn clean install -DskipTests
```

## Paso 3: Levantar la aplicacion y  Ejecutar 

Ejecuta el contenedor:
```bash
Ejecutar StarWarsApplication.java
```

Una vez Levantado el servicio, ejecutamos juevamente, esto con el fin de superar los E2E Test.
```bash
mvn clean install
```
Este comando permitirá empaquetar el archivo correctamente.

## Paso 3: Ejecutar el Contenedor
Ejecuta el contenedor:
```bash
mvn spring-boot:build-image
```
Este comando levantará el contenedor en segundo plano y expondrá la aplicación en el puerto 8080.
Una vez finalizado ejecutamos el siguiente comando:
```bash 
docker run -d -p 8080:8080 starwars
````
Detenemos la aplicación para validar la ejecución del contenedor 
```bash
StarWarsApplication.java 
```
## Paso 4: Verificar la Ejecución
Una vez que el contenedor esté en funcionamiento, puedes verificar que la aplicación esté corriendo accediendo a:
```bash
http://localhost:8080/swapi-proxy/person-info?name=Luke%20Skywalker

Response
{
  "name": "Luke Skywalker",
  "birth_year": "19BBY",
  "gender": "male",
  "planet_name": "Tatooine",
  "fastest_vehicle_driven": "X-wing",
  "films": [
    {
      "name": "A New Hope",
      "release_date": "1977-05-25"
    },
    {
      "name": "The Empire Strikes Back",
      "release_date": "1980-05-17"
    },
    {
      "name": "Return of the Jedi",
      "release_date": "1983-05-25"
    },
    {
      "name": "Revenge of the Sith",
      "release_date": "2005-05-19"
    },
  ]
}
```
Deberías recibir una respuesta en formato JSON con la información del personaje solicitado.

## Paso 5: Detener el Contenedor
Para detener y eliminar el contenedor y la red creada por Docker Compose, usa:

```bash
docker ps
```
y luego ejecuta el siguiente comando con el id del contenedor que obtuviste en el paso anterior:

```bash
docker stop <container_id>
```
```bash

## Notas Adicionales
Error al Construir la Imagen: Asegúrate de que el Dockerfile esté correctamente configurado y que todas las dependencias del proyecto estén en su lugar.

Error al Ejecutar el Contenedor: Verifica los logs del contenedor para obtener más detalles sobre el problema. Usa docker-compose logs para ver los registros.




