# Spring Boot Java Demo

Proyecto de ejemplo con Spring Boot 4, Java 21 y Gradle. Incluye JPA, validacion, REST client y soporte de Docker Compose para Postgres en desarrollo.

## Requisitos

- Java 21
- Docker (opcional, para Postgres local)

## Comandos comunes

- Construir todo: `./gradlew build`
- Ejecutar pruebas: `./gradlew test`
- Levantar la app: `./gradlew bootRun`
- Levantar Postgres local: `docker compose up`

## Configuracion

La configuracion principal vive en `src/main/resources/application.yml`.

## Estructura del proyecto

- `src/main/java/com/ryctabo/demo`: codigo de la aplicacion
- `src/main/resources`: configuracion
- `src/test/java/com/ryctabo/demo`: pruebas
- `compose.yaml`: Postgres local para desarrollo
- `build/`: artefactos generados

## Endpoints utiles

- `GET /actuator/health`
- `GET /actuator/info`
