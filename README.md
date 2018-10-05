## bin-packing-svc


Explanation coming later

### Running the Docker Image
Docker repo can be found [here](https://hub.docker.com/r/cuzz22000/bin-pack-svc/).


```bash
$> docker run --name bin-pack-svc -e ENVIRONMENT=local -p 8080:8080 cuzz22000/bin-pack-svc:latest
```

### Build and Run

```bash
$> gradlew
...
$> gradlew run

```

### Connecting to Swagger

All services are available via Swagger API (openApi). When running locally viz native JVM or Docker UI can be accessed from the following url.

`http://localhost:8080/swagger`

Example Json Request

```json
{
  "max-capacity": 1,
  "items": [
    {
      "id": "abc123",
      "weight": 0.2
    },
    {
      "id": "abc124",
      "weight": 0.5
    },
    {
      "id": "abc125",
      "weight": 0.4
    },
    {
      "id": "abc126",
      "weight": 0.7
    },
    {
      "id": "abc127",
      "weight": 0.1
    },
    {
      "id": "abc128",
      "weight": 0.3
    },
    {
      "id": "abc129",
      "weight": 0.8
    }
  ]
}
```