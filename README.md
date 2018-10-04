## bin-packing-svc


Explanation coming later

### Build and Run

```bash
$> gradlew
...
$> gradlew run

```

#### Swagger

http://localhost:8080/swagger

Example Json Request
```
{"max-capacity":1,"items":[{"id":"abc123","weight":0.2},{"id":"abc123","weight":0.5},{"id":"abc123","weight":0.4},{"id":"abc123","weight":0.7},{"id":"abc123","weight":0.1},{"id":"abc123","weight":0.3},{"id":"abc123","weight":0.8}]}
```