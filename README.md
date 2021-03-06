# sm-evaluation-microservices

This is a project, that evaluates use of microservices architecture patterns. Following patterns have been utilized:
* [CQRS](https://microservices.io/patterns/data/cqrs.html)
* [Event Sourcing](https://microservices.io/patterns/data/event-sourcing.html)
* [Database per Service](https://microservices.io/patterns/data/database-per-service.html)
* [API Gateway](https://microservices.io/patterns/apigateway.html)

## Architecture

![](architecture.png)

## Security
![](architecture-sequence-security.png)

# Running
## Production mode
All services are started in containers.

To run:

    docker-compose up

To stop

    docker-compose down

## Development mode
In this mode only MongoDB, Zookeeper and Kafka are started as containers.

To run:

    docker-compose -f docker-compose_development.yml up -d

To stop

    docker-compose -f docker-compose_development.yml down

## sm-evaluation-ms-frontend
To run:

    ng serve

To prepare docker image:

    docker build --no-cache -t sm-evaluation-microservices/sm-evaluation-ms-frontend .

To run a docker image

    docker run -p 4200:80 -t sm-evaluation-microservices/sm-evaluation-ms-frontend

## sm-evaluation-ms-auth
To prepare a docker image:

    docker build --no-cache -t sm-evaluation-microservices/sm-evaluation-ms-auth .

To run:

    docker run -p 8080:8080 -t sm-evaluation-microservices/sm-evaluation-ms-auth


## sm-evaluation-ms-server-query
To prepare a docker image:
    
    docker build --no-cache -t sm-evaluation-microservices/sm-evaluation-ms-server-query .

To run:

    docker run -p 8080:8080 -t sm-evaluation-microservices/sm-evaluation-ms-server-query

## sm-evaluation-ms-server-command
To prepare a docker image:

    docker build --no-cache -t sm-evaluation-microservices/sm-evaluation-ms-server-command .

To run:

    docker run -p 8080:8080 -t sm-evaluation-microservices/sm-evaluation-ms-server-command

# Useful articles 
[https://devapo.io/blog/kafka-in-spring-boot-on-docker/](https://devapo.io/blog/kafka-in-spring-boot-on-docker/)

[https://jasonwatmore.com/post/2020/04/29/angular-9-basic-http-authentication-tutorial-example](https://jasonwatmore.com/post/2020/04/29/angular-9-basic-http-authentication-tutorial-example)

[https://medium.com/swlh/spring-boot-security-jwt-hello-world-example-b479e457664c](https://medium.com/swlh/spring-boot-security-jwt-hello-world-example-b479e457664c)