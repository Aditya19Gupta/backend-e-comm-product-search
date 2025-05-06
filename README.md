# 🛠 Spring Boot Backend - Product API (H2 DB)

This is a Spring Boot backend service for managing products, designed to work seamlessly with a React frontend. It uses an in-memory H2 database.

---

## 🚀 Run Instructions

### ✅ Prerequisites

- Java 17+
- Maven 3.8+
- Any IDE (IntelliJ / Eclipse / VS Code)

---

## 📁 Folder Structure

src/
├── main/
│ ├── java/
│ │ └── com/example/productapi/
│ │ ├── controller/
│ │ ├── model/
│ │ ├── repository/
│ │ └── ProductApiApplication.java
│ └── resources/
│ ├── application.properties
│ └── data.sql (optional)
pom.xml



---

## ⚙️ application.properties (H2)

```properties
server.port=8181

# H2 Database Config
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```
# JPA
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update


# Step 1: Build the app
mvn clean install

# Step 2: Run the app
mvn spring-boot:run


** GET all products
GET http://localhost:8181/products

---

Let me know if you also want a `data.sql` file to pre-load some products into H2 on app start.
