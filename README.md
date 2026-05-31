# Visited Countries API

## Build & Run

### Run with Docker Compose

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