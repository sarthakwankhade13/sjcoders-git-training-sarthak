# Day 2 - OOP, Collections and Application Architecture

## Overview

This project is a small Java console-based booking application created as part
of Day 2 of the SJ Coders Software Intern Technical Training Program.

The project demonstrates basic Object-Oriented Programming concepts, Java
Collections, and how a console application can be connected to a real
full-stack web application architecture.

## OOP Concepts Demonstrated

### Class and Object

The project contains classes such as User, Customer, Service and Booking.
Objects are created from these classes in Main.java.

### Encapsulation

Important fields are kept private and accessed through getters, setters and
controlled methods.

### Inheritance

Customer extends User to reuse the common properties and methods of User.

### Polymorphism

Customer overrides the displayInfo() method of User to provide its own
implementation.

### Abstraction

The NotificationService interface defines the notification operation, while
EmailNotification provides its implementation.

## Java Collections

### ArrayList

An ArrayList is used to store three Booking objects.

### HashSet

A HashSet is used to store unique service names.

### HashMap

A HashMap is used to map booking IDs to Booking objects for quick lookup.

## Application Architecture

The console application can be converted into a real web application using
the following flow:

Frontend → REST API → Backend → Database → Response

The frontend would collect booking information and send it to the backend
through a REST API. The backend would validate the information, apply business
logic and store the booking in a database. After processing the request, the
backend would send a response back to the frontend.

More details are available in `architecture.md`.

## Project Structure

```text
day-02-oop-architecture/
│
├── src/
│   ├── User.java
│   ├── Customer.java
│   ├── Service.java
│   ├── Booking.java
│   ├── NotificationService.java
│   └── Main.java
│
├── architecture.md
└── README.md