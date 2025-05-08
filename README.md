# Product Management System

This is a Spring Boot-based RESTful web application built as part of the Nimap Infotech assignment. It provides complete CRUD operations for managing **Categories** and **Products**, ensuring a **one-to-many relationship** (one category can have multiple products). The application also implements **server-side pagination**, **DTO mapping**, and proper **exception handling**.

---

## 📌 Project Description

The **Product Management System** is a backend system designed to manage a collection of product categories and the products associated with each category. It includes:

- A one-to-many mapping between **Category** and **Product**.
- RESTful APIs to create, read, update, and delete both categories and products.
- Pagination support when listing all categories and all products.
- Data Transfer Objects (DTOs) used to return only necessary fields in API responses.
- Validation to check entity existence before update and delete.
- Proper status codes and exception messages returned for failed operations.

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- MySQL Database (configurable)
- Hibernate
- REST APIs
- Postman (for testing API Clients)

---

## 🚀 Features

- ✅ Create, Read, Update, Delete for Products and Categories
- ✅ Pagination for list endpoints (`/api/products?page=0&size=5`)
- ✅ Fetch product with category details
- ✅ Validations and exception handling
- ✅ Clean JSON response using DTOs
- ✅ `@OneToMany` and `@ManyToOne` relationship

---

## 🔗 API Endpoints Summary

### 🔹 Product APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `http://localhost:8080/api/products` | Create a new product |
| `GET` | `http://localhost:8080/api/products?page=2` | Get All the products |
| `GET` | `http://localhost:8080/api/products/{id}` | Get a single product by Id |
| `PUT` | `http://localhost:8080/api/products/{id}` | Update a product by Id |
| `DELETE` | `http://localhost:8080/api/products/{id}` | Delete a product by Id |

### 🔹 Category APIs
| Method | Endpoint | Description |
|--------|----------|-------------|
| `POST` | `http://localhost:8080/api/categories` | Create a new category |
| `GET` | `http://localhost:8080/api/categories?page=1` | Get All the Categories |
| `GET` | `http://localhost:8080/api/categories/{id}` | Get a single category by Id |
| `PUT` | `http://localhost:8080/api/categories/{id}` | Update a category by Id |
| `DELETE` | `http://localhost:8080/api/categories/{id}` | Delete a category by Id|

---

## ⚙️ How to Run Locally

1. Clone the repo:
   ```bash
   git clone https://github.com/your-username/Product-Management-System.git
