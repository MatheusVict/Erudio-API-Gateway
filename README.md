[![Continuos Integration with github](https://github.com/MatheusVict/Erudio-API-Gateway/actions/workflows/docker-image.yml/badge.svg)](https://github.com/MatheusVict/Erudio-API-Gateway/actions/workflows/docker-image.yml)

# Cambio Service

### microservices required:

- [naming-server](https://github.com/MatheusVict/naming-server)
- [api-gateway](https://github.com/MatheusVict/Erudio-API-Gateway)
- [cambio-service](https://github.com/MatheusVict/cambio-service)
- [book-service](https://github.com/MatheusVict/book-service)

# Getting start

## Localhost with applications:

#### To start using applications on localhost, you should run in this order

- 1 [naming-server](https://github.com/MatheusVict/naming-server)
- 2 [api-gateway](https://github.com/MatheusVict/Erudio-API-Gateway)
- 3 [cambio-service](https://github.com/MatheusVict/cambio-service) ```you should configure data base on: application.yml``` 
- 4 [book-service](https://github.com/MatheusVict/book-service) ```you should configure data base on: application.yml``` 

## Localhost with docker

#### if you want to start all application with one commando, you can use docker-compose on project root:

```
docker compose up -d
```

# Routes:

#### you can open on [localhost](htpp://localhost:8000)
#### To open zipkin you use [localhost](http://localhost:9411)
#### Docs
[Swagger](http://localhost:8000/swagger-ui/index.html#/)

#### GetCambio

```Get```

```/cambio-service/{amount}/{from}/{to}```

**return**:

```json
{
  "id": 1,
  "from": "USD",
  "to": "BRL",
  "conversionFactor": 7,
  "convertedValue": "28.56",
  "environment": "8000"
}
```


#### GetBook

```Get```

```/book-service/{bookId}/{currency}```

**return**:

```json
{
  "id": 1,
  "author": "Uncle bob",
  "launchDate": "2008-06-08",
  "price": 68,
  "title": "Clean code",
  "currency": "USD",
  "environment": 8000
}
