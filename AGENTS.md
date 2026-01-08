# Repository Guidelines

## Project Structure & Module Organization
- `src/main/java/com/ryctabo/demo`: application code (domain, use cases, infrastructure).
- `src/main/resources`: configuration (see `application.yml`).
- `src/test/java/com/ryctabo/demo`: tests (JUnit).
- `build/`: generated outputs (Gradle).
- `compose.yaml`: local Postgres service for development.

## Build, Test, and Development Commands
- `./gradlew build`: compiles, runs tests, and assembles the project.
- `./gradlew test`: runs JUnit tests only.
- `./gradlew bootRun`: starts the Spring Boot app locally.
- `docker compose up`: starts the local Postgres service defined in `compose.yaml`.

## Coding Style & Naming Conventions
- Java 21 toolchain (see `build.gradle`).
- Indentation: 4 spaces; no trailing whitespace.
- Format with Spotless (configured in `build.gradle`); it also enforces import order and removes unused imports.
- Packages follow `com.ryctabo.demo.*`; classes use `PascalCase`, methods/fields use `camelCase`.

## Testing Guidelines
- Framework: JUnit Platform with Spring Boot test starters.
- Place tests in `src/test/java`, mirroring package structure.
- Naming: use `*Tests` suffix (example: `SpringBootJavaDemoApplicationTests`).
- Run locally with `./gradlew test`; build artifacts include generated snippets in `build/generated-snippets` when tests run.

## Commit & Pull Request Guidelines
- Commit messages follow a conventional prefix (`feat:`, `chore:`) based on recent history.
- Pull requests should include a brief summary, testing notes (commands + results), and any relevant configuration changes (e.g., `application.yml` or `compose.yaml`).

## Configuration & Local Services
- `application.yml` controls app and management endpoints; keep changes minimal and documented in PRs.
- `compose.yaml` provides a local Postgres instance; align image tags with production expectations when updating.
