** Book & Author Management System **
This is a simple backend application built using Java and Spring Boot to manage books and their authors. It supports full CRUD operations and models the relationship between books and authors (One-to-Many / Many-to-One).
--------------------------------------------------------
Features :
Author Management:
-------------------
Create, view, update, and delete authors.

Each author has a first name, last name, and phone number.

Each author can have multiple books.
---------------------------------------------------------------
Book Management:
----------------
Create, view, update, and delete books.

Sort books by title or price (ascending / descending).

Each book has a title, price, and state (available or not).

Each book is linked to a single author.
---------------------------------------------------------------
Clean architecture with:

Entities

DTOs

Repositories (JPA)

Service layer

Controller layer
------------------------------------------------------
Technologies Used :

Java 17 

Spring Boot

Spring Data JPA

Database PostgreSQL

Lombok

