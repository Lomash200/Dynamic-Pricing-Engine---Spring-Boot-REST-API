# 🚀 Dynamic Pricing Engine - Spring Boot REST API

A production-style **Dynamic Pricing & Billing Engine** built using **Spring Boot** that demonstrates real-world backend pricing logic including:

- Product price calculation
- Promo code discount handling
- GST taxation
- Final bill generation
- REST API design
- Clean layered architecture

This project is designed to showcase **Java Backend Development**, **Pricing Domain Concepts**, and **System Design Basics**.

---

# 📌 Features

✅ Dynamic bill calculation  
✅ Flat & percentage coupon support  
✅ GST calculation after discount  
✅ Validation & error handling  
✅ Layered Spring Boot architecture  
✅ RESTful API implementation  
✅ In-memory mock inventory  
✅ Clean and scalable code structure

---

# 🛠️ Tech Stack

| Technology | Usage |
|---|---|
| Java 17+ | Core Programming |
| Spring Boot | Backend Framework |
| Maven | Dependency Management |
| REST API | Communication |
| Lombok | Boilerplate Reduction |
| Jackson | JSON Processing |

---

# 📂 Project Structure

```bash
src
 └── main
      ├── java
      │    └── com/pricing/engine
      │          ├── controller
      │          │      └── PricingController.java
      │          ├── service
      │          │      └── PricingService.java
      │          ├── model
      │          │      ├── Product.java
      │          │      ├── BillRequest.java
      │          │      └── BillResponse.java
      │          ├── repository
      │          │      └── ProductRepository.java
      │          ├── exception
      │          │      └── ProductNotFoundException.java
      │          └── PricingEngineApplication.java
      │
      └── resources
           └── application.properties
```

---

# ⚙️ Setup & Installation

## Step 1: Clone Repository

```bash
git clone <your-repository-url>
cd dynamic-pricing-engine
```

---

## Step 2: Configure Application Port

If port `8080` is already in use, update:

```properties
src/main/resources/application.properties
```

```properties
server.port=8081
```

---

## Step 3: Build & Run the Application

### Using Maven Wrapper

### Windows

```bash
.\mvnw.cmd spring-boot:run
```

### Linux/macOS

```bash
./mvnw spring-boot:run
```

---

# ▶️ Application URL

By default, the application runs on:

```bash
http://localhost:8080
```

---

# 🔌 REST API Documentation

# 1️⃣ Calculate Bill API

Calculates the final payable bill amount dynamically using:

- Product ID
- Promo/Coupon Code
- GST Taxation

---

## Endpoint

```http
POST /api/v1/pricing/calculate-bill
```

---

## Request Headers

```http
Content-Type: application/json
```

---

# 📦 Mock Product Inventory

| Product ID | Product Name | Base Price |
|---|---|---|
| PROD01 | Gaming Laptop | ₹60,000 |
| PROD02 | Smart Phone | ₹15,000 |
| PROD03 | Wireless Headphones | ₹3,000 |

---

# 🎁 Supported Promo Codes

| Promo Code | Description |
|---|---|
| WELCOME100 | Flat ₹100 Discount |
| FESTIVE20 | 20% Discount |

---

# 📘 API Examples

---

# ✅ Scenario A: Percentage Discount

## Request

```json
{
  "productId": "PROD02",
  "promoCode": "FESTIVE20"
}
```

---

## Response

```json
{
  "productName": "Smart Phone",
  "originalPrice": 15000.0,
  "discountAmount": 3000.0,
  "taxAmount": 2160.0,
  "finalPayableAmount": 14160.0
}
```

---

# 🧮 Calculation Breakdown

Base Price = ₹15,000

20% Discount = ₹3,000

Subtotal = ₹12,000

GST (18%) = ₹2,160

Final Amount = ₹14,160

---

# ✅ Scenario B: Flat Discount

## Request

```json
{
  "productId": "PROD03",
  "promoCode": "WELCOME100"
}
```

---

## Response

```json
{
  "productName": "Wireless Headphones",
  "originalPrice": 3000.0,
  "discountAmount": 100.0,
  "taxAmount": 522.0,
  "finalPayableAmount": 3422.0
}
```

---

# ❌ Scenario C: Product Not Found

## Request

```json
{
  "productId": "INVALID999",
  "promoCode": "FESTIVE20"
}
```

---

## Response

```http
400 Bad Request
```

---

# 🧠 Pricing Domain Rules Implemented

## ✅ Safety Bound Validation

Discount amount can never exceed the product's base price.

This prevents:

- Negative billing
- Invalid invoice generation
- Pricing exploitation

---

## ✅ Post-Discount GST Calculation

GST is applied **after** discount calculation.

### Formula

```text
GST = 18% of (Base Price - Discount)
```

This reflects real-world e-commerce billing systems.

---

## ✅ Stateless Billing

The API does not modify inventory or product data.

All calculations are:

- Transient
- Stateless
- Idempotent

---

# 🏗️ Architecture Overview

```text
Controller Layer
        ↓
Service Layer
        ↓
Repository Layer
        ↓
Mock In-Memory Data
```

---

# 🔥 Future Improvements

- Database Integration (MySQL/PostgreSQL)
- JWT Authentication
- Swagger/OpenAPI Documentation
- Docker Support
- Redis Caching
- Coupon Expiry Handling
- Admin Dashboard
- Microservices Migration

---

# 🧪 Testing Suggestions

You can test APIs using:

- Postman
- Thunder Client
- cURL
- Swagger UI

---

# 📌 Sample cURL Request

```bash
curl --location 'http://localhost:8080/api/v1/pricing/calculate-bill' \
--header 'Content-Type: application/json' \
--data '{
    "productId": "PROD02",
    "promoCode": "FESTIVE20"
}'
```

---

# 👨‍💻 Author

## Lomash Badole

Java Backend Developer

Skills:
- Java
- Spring Boot
- REST APIs
- MySQL
- Hibernate
- JWT
- Microservices
- System Design

GitHub:
```text
github.com/Lomash200
```

---

# ❤️ Project Purpose

This project was created to demonstrate:

- Pricing Engine Fundamentals
- Backend Billing Logic
- Real-world API Design
- Spring Boot Development Skills
- Clean Code Practices

---

# ⭐ If You Like This Project

Give it a ⭐ on GitHub and feel free to contribute.

---
