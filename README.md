# Spring Boot Microservices Playground

A hands-on learning project for building and understanding **Microservices Architecture** using **Spring Boot**, **Spring Cloud**, and modern distributed system patterns.

---

## Overview

This repository contains multiple independent microservices managed under a single parent Maven project. The purpose of this project is to gain practical experience with enterprise-level microservice development and cloud-native architecture.

Current services include:

* Product Service
* Inventory Service
* Order Service
* API Gateway

The services communicate through REST APIs and are routed through a centralized API Gateway.

---

## Architecture

```text
                        +------------------+
                        |    API Gateway   |
                        |     Port 8085    |
                        +--------+---------+
                                 |
          ---------------------------------------------
          |                     |                     |
          v                     v                     v

+----------------+   +----------------+   +----------------+
| Product Service|   | Inventory      |   | Order Service  |
| Port: 8081     |   | Service        |   | Port: 8083     |
| products_db    |   | Port: 8082     |   | order_db       |
+----------------+   | inventory_db   |   +----------------+
                     +----------------+

Order Service
      |
      | OpenFeign Client
      v
Inventory Service
```

---

## Technologies Used

### Backend

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Spring Cloud OpenFeign
* Spring Cloud Gateway

### Database

* MySQL

### Build Tool

* Maven

### Development Tools

* IntelliJ IDEA
* Postman
* Git & GitHub

---

## Microservices

### Product Service

Responsible for managing product information.

**Port:** `8081`

Sample Endpoint:

```http
GET /api/products
```

---

### Inventory Service

Responsible for managing inventory and stock information.

**Port:** `8082`

Sample Endpoint:

```http
GET /api/inventory
```

---

### Order Service

Responsible for managing customer orders.

**Port:** `8083`

Features:

* Create Orders
* Validate Product Availability
* Communicate with Inventory Service using OpenFeign

Sample Endpoint:

```http
GET /api/orders
```

---

### API Gateway

Central entry point for all client requests.

**Port:** `8085`

Responsibilities:

* Request Routing
* Centralized Access Point
* Load Balancing Ready
* Future Authentication Integration
* Future Rate Limiting Support

Example Routes:

```text
/api/products/**   -> Product Service
/api/inventory/** -> Inventory Service
/api/orders/**    -> Order Service
```

Example Access:

```http
http://localhost:8085/api/products
http://localhost:8085/api/inventory
http://localhost:8085/api/orders
```

---

## Service-to-Service Communication

The project uses **Spring Cloud OpenFeign** for inter-service communication.

### Example Flow

```text
Client
   |
   v
Order Service
   |
   | OpenFeign
   v
Inventory Service
```

Benefits:

* Simplified REST Client
* Declarative HTTP Calls
* Cleaner Code
* Easy Microservice Integration

Example Feign Client:

```java
@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/api/inventory/check/{productId}")
    Boolean isInStock(@PathVariable Long productId);
}
```

---

## Database Configuration

Each microservice maintains its own dedicated database.

| Service           | Database     |
| ----------------- | ------------ |
| Product Service   | products_db  |
| Inventory Service | inventory_db |
| Order Service     | order_db     |

Example Configuration:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/products_db
spring.datasource.username=root
spring.datasource.password=your_password
```

---

## Getting Started

### Clone Repository

```bash
git clone https://github.com/your-username/springboot-microservices-playground.git
```

### Create Databases

```sql
CREATE DATABASE products_db;
CREATE DATABASE inventory_db;
CREATE DATABASE order_db;
```

### Run Services

Start the services in the following order:

1. Product Service (8081)
2. Inventory Service (8082)
3. Order Service (8083)
4. API Gateway (8085)

```bash
mvn spring-boot:run
```

or run each service directly from IntelliJ IDEA.

---

## API Gateway Configuration

Example Route Configuration:

```properties
spring.cloud.gateway.server.webflux.routes[0].id=product-service
spring.cloud.gateway.server.webflux.routes[0].uri=http://localhost:8081
spring.cloud.gateway.server.webflux.routes[0].predicates[0]=Path=/api/products/**

spring.cloud.gateway.server.webflux.routes[1].id=inventory-service
spring.cloud.gateway.server.webflux.routes[1].uri=http://localhost:8082
spring.cloud.gateway.server.webflux.routes[1].predicates[0]=Path=/api/inventory/**

spring.cloud.gateway.server.webflux.routes[2].id=order-service
spring.cloud.gateway.server.webflux.routes[2].uri=http://localhost:8083
spring.cloud.gateway.server.webflux.routes[2].predicates[0]=Path=/api/orders/**
```

---

## Learning Roadmap

### Completed

* Parent Maven Project Setup
* Product Service
* Inventory Service
* Order Service
* MySQL Integration
* Basic REST APIs
* OpenFeign Client
* API Gateway
* Inter-Service Communication

### Upcoming

* Eureka Service Discovery
* Config Server
* Docker & Docker Compose
* Apache Kafka
* Distributed Tracing
* JWT Authentication
* Resilience4j Circuit Breaker
* Monitoring & Logging
* Kubernetes Deployment

---

## Project Goal

The primary objective of this repository is to gain practical experience in:

* Microservices Architecture
* Distributed Systems
* Service Communication
* Event-Driven Architecture
* Cloud-Native Development
* Enterprise Backend Engineering

---

## Author

**Binoj Madhuranga**

Full Stack Engineer

### Technologies

* Java & Spring Boot
* React & React Native
* .NET
* Golang
* Express.js
* MySQL & PostgreSQL
* Docker
* AWS

---

## License

This project is created for educational and learning purposes.
