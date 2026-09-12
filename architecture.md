# Application Architecture

## Overview

Our Java console application currently creates customers, services and bookings
directly in the program. In a real web application, these operations would be
handled through different application layers.

The basic flow would be:

Frontend → REST API → Backend → Database → Response

## 1. Frontend

The frontend would provide a booking form where the user can enter details such
as customer ID, customer name, service, booking date and other required
information.

The user would select a service and submit the booking form.

## 2. REST API

After submitting the form, the frontend would send the booking information to
the backend using a REST API.

For example:

POST /api/bookings

The request could contain JSON data such as:

{
    "customerId": 101,
    "serviceId": 1,
    "date": "2026-09-09"
}

## 3. Backend

The backend would receive the request and validate the information.

Some validations could include:

- Customer ID should be valid.
- Service ID should exist.
- Service should be available.
- Booking date should be valid.
- Required fields should not be empty.

After validation, the backend would apply the booking business rules and save
the booking information.

## 4. Database

The database would permanently store information such as:

- Customer details
- Service details
- Service price
- Booking ID
- Customer ID
- Service ID
- Booking date
- Booking status

The database could be implemented using MySQL or PostgreSQL.

## 5. Response

After successfully creating the booking, the backend would send a response
back to the frontend.

For example:

{
    "bookingId": 1001,
    "status": "CONFIRMED"
}

The frontend would then show a confirmation message to the user.

## Complete Flow

1. User enters booking information on the frontend.
2. Frontend sends the information to the REST API.
3. Backend receives and validates the request.
4. Backend saves the booking in the database.
5. Database returns the stored booking information.
6. Backend sends a response to the frontend.
7. Frontend displays the booking confirmation.

## How Our Java Classes Fit

The Java classes from our console application represent the main objects of
the booking domain.

- User represents a common user.
- Customer extends User and represents a customer.
- Service represents a service offered by the application.
- Booking connects a customer with a service.
- Collections can be used to temporarily store and search booking information.

In a real application, these classes could become part of the backend
application and communicate with a database through APIs.