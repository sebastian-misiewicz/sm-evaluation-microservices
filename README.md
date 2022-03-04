# sm-evaluation-microservices

## sm-evaluation-ms-frontend
To run:

    ng serve

To prepare docker image:

    docker build -t sm-evaluation-microservices/sm-evaluation-ms-frontend .

To run a docker image

    docker run -p 4200:80 -t sm-evaluation-microservices/sm-evaluation-ms-frontend

## sm-evaluation-ms-backend
To prepare a docker image:
    
    docker build -t sm-evaluation-microservices/sm-evaluation-ms-server .

To run:

    docker run -p 8080:8080 -t sm-evaluation-microservices/sm-evaluation-ms-server