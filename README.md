# Day 3 - Employee Management Mini Full-Stack Application

## SJ Coders Software - Intern Technical Training

A mini full-stack Employee Management application developed as part of the Day 3 training assignment.

The application demonstrates how a frontend communicates with a Spring Boot REST API, how the backend processes employee data, and how the data is stored and retrieved from a MySQL relational database.

---

## Project Objective

The main objective of this project is to understand the complete application flow:

Frontend → REST API → Spring Boot → JPA/Hibernate → MySQL → JSON → Frontend

The application allows users to:

- Register employees
- Save employee records
- View all employees
- Search employees
- Validate required fields and email
- Display saved employee records in a Bootstrap table

---

## Technologies Used

### Backend

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Bean Validation
- Maven

### Database

- MySQL 8

### Frontend

- HTML5
- CSS3
- Bootstrap 5
- JavaScript
- Fetch API

### Development Tools

- Visual Studio Code
- Git
- GitHub
- Live Server

---

## Project Structure

```text
day-03-employee-management/
│
├── backend/
│   ├── src/
│   │   └── main/
│   │       ├── java/
│   │       │   └── com/
│   │       │       └── sjcoders/
│   │       │           └── training/
│   │       │               ├── controller/
│   │       │               │   └── EmployeeController.java
│   │       │               │
│   │       │               ├── service/
│   │       │               │   └── EmployeeService.java
│   │       │               │
│   │       │               ├── repository/
│   │       │               │   └── EmployeeRepository.java
│   │       │               │
│   │       │               ├── model/
│   │       │               │   └── Employee.java
│   │       │               │
│   │       │               └── EmployeeManagementApplication.java
│   │       │
│   │       └── resources/
│   │           └── application.properties
│   │
│   ├── pom.xml
│   ├── mvnw
│   └── mvnw.cmd
│
├── frontend/
│   ├── index.html
│   ├── css/
│   │   └── style.css
│   └── js/
│       └── app.js
│
└── README.md