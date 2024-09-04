# Onepiece, GraphQL, OpenAI API

I subscribe to the idea of learning by example. This repository is a pet project for playing with different
technologies and giving me a real example to practice some design decisions etc.

This pet project will grow as much or as little as needed for me to understand a concept fully. For instance
when I deal with distributed tracing, I may introduce another service.

## Domain

I have chosen to base this project on One Piece, a popular manga story that I enjoy.

## Technologies

This will probably be a growing list but at least from the outset the following are what I am interested in

1. Spring GraphQL offering
2. Integration with OpenAI APIs
3. Good observability practices, Micrometer, logging, metrics, distributed tracing, visualisations
4. Good testing practices, TestContainers

## Running Project

1. Java 22 installed
2. Docker installed
3. Run 'docker-compose up' from the ./docker directory
4. run the application
5. play with API on `http://localhost:8080/graphiql`