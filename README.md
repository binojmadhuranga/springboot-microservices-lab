# Spring Boot Microservices Playground

A hands-on learning project for building and understanding Microservices Architecture using Spring Boot.

## Overview

This repository contains multiple independent microservices managed under a single parent Maven project. The goal of this project is to learn and implement modern microservice patterns and technologies used in enterprise applications.

Current services include:

* Product Service
* Inventory Service
* Order Service

Each service runs independently with its own database and configuration.

---

## Architecture

```text
springboot-microservices-playground
│
├── product-service
│   └── Port: 8081
│
├── inventory-service
│   └── Port: 8082
│
├── order-service
│   └── Port: 8083
│
└── Parent Maven Project
```

---

## Technologies Used

### Backend

* Java 21
* Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate

### Database

* MySQL

### Build Tool

* Maven

### Development Tools

* IntelliJ IDEA
* Postman
* Git & GitHub

---

## Services

### Product Service

Responsible for managing product-related operations.

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

Sample Endpoint:

```http
GET /api/orders
```

---

## Database Configuration

Each microservice uses its own dedicated database.

| Service           | Database     |
| ----------------- | ------------ |
| Product Service   | products_db  |
| Inventory Service | inventory_db |
| Order Service     | order_db     |

Example:

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

Start each microservice independently:

```bash
mvn spring-boot:run
```

or run from IntelliJ IDEA.

---

## Learning Roadmap

### Completed

* Parent Maven Project Setup
* Product Service
* Inventory Service
* Order Service
* MySQL Integration
* Basic REST APIs

### Upcoming

* Service-to-Service Communication
* OpenFeign Client
* Eureka Service Discovery
* API Gateway
* Docker & Docker Compose
* Apache Kafka
* Distributed Tracing
* Centralized Configuration
* JWT Authentication
* Monitoring & Logging

---

## Project Goal

The primary objective of this repository is to gain practical experience in:

* Microservices Architecture
* Distributed Systems
* Event-Driven Communication
* Cloud-Native Development
* Enterprise Backend Engineering

---

## Author

**Binoj Madhuranga**

Full Stack Engineer

Technologies:

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
