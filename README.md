# E-Commerce System

This repository contains a simple command-line e-commerce application built with Java and Maven. It demonstrates core backend functionalities, including product, user, and order management. The project is structured using the service-repository pattern and showcases the strategy pattern for handling different payment methods. Data is stored in-memory using HashMaps.

## Key Features

*   **Service-Repository Architecture:** Clear separation of concerns with distinct layers for business logic (services) and data access (repositories).
*   **CRUD Operations:** Core functionality to create, read, find, and delete users, products, and orders.
*   **Generic Repository Pattern:** A flexible `Repository<T>` interface provides a standard contract for data access, with in-memory implementations for each model.
*   **Pluggable Payment System:** Utilizes the Strategy design pattern with a `PaymentProcessor` interface and concrete implementations for:
    *   Credit Card
    *   UPI (Unified Payments Interface)
    *   Wallet
*   **In-Memory Data Storage:** Uses `HashMap` to simulate a database, making the application self-contained and easy to run without external dependencies.

## Project Structure

The project is organized into several packages, each with a distinct responsibility:

```
└── src/main/java/org/example/
    ├── Main.java               # Main class with demonstration scenarios
    ├── model/                  # Data objects (POJOs)
    │   ├── Order.java
    │   ├── Product.java
    │   └── User.java
    ├── payment/                # Payment processing logic (Strategy Pattern)
    │   ├── PaymentProcessor.java   # Interface for payment strategies
    │   ├── CreditCaedPaymentProcessor.java
    │   ├── UpiPaymentProcessor.java
    │   └── WalletPaymentProcessor.java
    ├── repository/             # Data access layer (Repository Pattern)
    │   ├── Repository.java     # Generic repository interface
    │   ├── InMemoeryProductRepository.java
    │   ├── OrderRepository.java
    │   └── UserRepository.java
    └── service/                # Business logic layer
        ├── OrderService.java
        ├── ProductService.java
        └── UserService.java
```

## How It Works

The system's functionality is demonstrated within the `Main.java` file, which simulates a complete user workflow.

1.  **Initialization:** The `main` method initializes users, products, and services. Services are instantiated with their respective in-memory repositories. The `OrderService` is configured with a specific `PaymentProcessor` for each test case.
2.  **Data Management:** The `UserService`, `ProductService`, and `OrderService` encapsulate the business logic for managing their respective models.
3.  **Order Processing:** The `OrderService` is responsible for placing an order.
    *   It validates that the order is not null and does not already exist.
    *   It invokes the `processPayment` method of its configured `PaymentProcessor`.
    *   If payment is successful, the order is saved to the `OrderRepository`.
4.  **Demonstration Scenarios:** The `Main.java` class runs a series of tests to showcase:
    *   Successful order placement with Wallet, UPI, and Credit Card payments.
    *   Error handling for duplicate orders and null orders.
    *   Deletion of existing and non-existing orders.

## Getting Started

This project is built using Apache Maven.

### Prerequisites

*   Java Development Kit (JDK) 17 or higher.
*   Apache Maven.

### Running the Application

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/boopathiraja-05/e-commerce-project-1-.git
    cd e-commerce-project-1-
    ```

2.  **Compile the project:**
    ```sh
    mvn compile
    ```

3.  **Execute the main class:**
    The `Main.java` class contains a series of print statements that demonstrate the system's features. You can run this class from your IDE (e.g., IntelliJ IDEA, Eclipse) to see the output of the various test scenarios printed to the console.

    To run from the command line, execute the following Maven command:
    ```sh
    mvn exec:java -Dexec.mainClass="org.example.Main"
