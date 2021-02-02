# Pricing Service

The Pricing Service is a microservice that simulates a backend that stores and retrieves the price of a vehicle given a vehicle id as input.
It is registered as `pricing-service` on a `Eureka` server that is implemented and running on port 8761.

## Persistence

The prices per vehicle are stored in the `prices.json` file and are populated to microservice's `H2` in-memory database on startup.

## Instructions

#### Tests

A Unit Test is added to check whether the application appropriately generates a price for a given vehicle ID.

#### Run the code

To run this service you execute:

```
$ mvn clean package
```

```
$ java -jar target/pricing-service-0.0.1-SNAPSHOT.jar
```

It can also be imported in your IDE as a Maven project.
