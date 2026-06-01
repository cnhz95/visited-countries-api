# Visited Countries API

## Build & Run

### Run with Docker Compose

Builds the application image, starts the PostgreSQL container, runs Flyway migrations, and calls the REST Countries public API all in one command.

```bash
docker compose up -d --build
```

The API is available at `http://localhost:8080`

To stop and remove the containers:

```bash
docker compose down
```

To also remove the database volume:

```bash
docker compose down -v
```

### Run with Maven

1. Start the PostgreSQL container

```bash
docker run -d \
    --name visited-countries-db \
    -e POSTGRES_DB=countries \
    -e POSTGRES_USER=postgres \
    -e POSTGRES_PASSWORD=password \
    -p 5432:5432 \
    postgres:16-alpine
```

2. Build the application

```bash
./mvnw clean package -DskipTests
```

3. Run the application

```bash
java -jar target/VisitedCountries-0.0.1-SNAPSHOT.jar
```

## Running Tests
Tests use Testcontainers, so the PostgreSQL container must be running
```bash
./mvnw verify
```
