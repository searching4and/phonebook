# Getting Started

# PHONEBOOK API

Backend API untuk aplikasi PHONEBOOK

## URL UI Aplication

- http://localhost:8080/contacts

## Script DB for Testing
- membuat database `CREATE DATABASE phonebook_db;`
- menggunakan database yang sudah dibuat`USE phonebook_db;`
- membuat table `CREATE TABLE contacts (id BIGINT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(100), phone_number VARCHAR(15), email VARCHAR(100));`

## Script Testing Req
- membuat contact `http://localhost:8080/api/contacts` (`POST`) 
    req body : `{ "name": "John Doe", "phoneNumber": "123456789", "email": "john@example.com" }`

- find all contact `http://localhost:8080/api/contacts` (`GET`)

- find by id contact `http://localhost:8080/api/contacts/1` (`GET`)

- update contact `http://localhost:8080/api/contacts/1` (`PUT`)
  req body : `{ "name": "John Update", "phoneNumber": "123456789", "email": "john@example.com" }`

- delete contact `http://localhost:8080/api/contacts/1` (`DELETE`)

## Spring Boot Java Application with Maven 3

This is spring boot java application build with maven 3

## Compile Application

Compile project with profile development by default

```
mvn clean install
```

Compile project with spesific profile

```
mvn clean install
```

## Running Application

Running the application

- Run locally with maven

```
mvn spring-boot:run
```

## License

FARHAN FARRAS SALIM