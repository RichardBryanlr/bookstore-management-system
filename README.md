# Bookstore Management System

Console-based bookstore management system developed in Java.
This application allows managing book inventory, processing sales, and tracking sold items.

## Features

* Add new books with automatically generated IDs
* Prevent duplicate book entries
* Sell books with stock validation
* Multiple payment methods (Credit, Debit, Money, Pix)
* Installment handling for credit payments
* Update book information (title, author, price, stock)
* Low stock and sold-out alerts
* List all available books in stock
* Track and list sold books

## Technologies

* Java
* Object-Oriented Programming (OOP)
* Collections (ArrayList)

## Project Structure

```
src/
 ├── application/
 │    └── Program.java
 └── entities/
      └── Product.java
```

## How It Works

The system stores data in memory using lists:

* A list for books in stock
* A list for sold books

Each book contains:

* ID
* Title
* Author
* Price
* Quantity in stock
* Quantity sold

The application runs through a terminal menu where the user can perform all operations.

## How to Run

1. Clone the repository

```
git clone https://github.com/your-username/bookstore-management-system.git
```

2. Navigate to the project folder

```
cd bookstore-management-system
```

3. Compile the project

```
javac application/Program.java
```

4. Run the application

```
java application.Program
```

## Example Menu

```
1. Add a new book in stock
2. Sell some book from stock
3. Update a product data
4. Show stock
5. List all sold books
6. Exit
```

## Business Rules

* Book IDs are randomly generated and guaranteed to be unique
* A book cannot be sold if it is out of stock
* Alerts are displayed when stock is low (≤ 5 units)
* Sales update both stock quantity and sold quantity
* Payment must be confirmed before completing a sale

## Improvements (Future Work)

* Persist data using a database or file
* Add search functionality (by title or author)
* Improve validation for user input
* Implement sales reports (total revenue, best-selling books)
* Create REST API with Spring Boot
* Add graphical user interface (GUI)

## Author

Richard Bryan
