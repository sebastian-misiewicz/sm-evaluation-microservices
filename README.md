# sm-evaluation-microservices

## sm-evaluation-ms-frontend
To run:

    ng serve

## sm-evaluation-ms-backend
To prepare a docker image:
    
    docker build -t sm-evaluation-microservices/sm-evaluation-ms-server .

To run:

    docker run -p 8080:8080 -t sm-evaluation-microservices/sm-evaluation-ms-server