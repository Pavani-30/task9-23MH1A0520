# Product Catalog REST API (Spring Boot + Docker)

## Project Overview

This project is a **production-ready backend REST API** for managing a **Product Catalog system**, built using **Spring Boot**, **Spring Data JPA**, **PostgreSQL**, and **Docker**.

The API supports full **CRUD operations** for **Categories** and **Products**, enforces proper **data relationships**, includes **input validation**, **global error handling**, **unit & integration testing**, and runs in a **containerized environment** using Docker Compose.

This project demonstrates real-world backend development practices and serves as a strong **portfolio project**.

---

## Features Implemented

### Category Management
- Create a new category
- Retrieve all categories
- Retrieve category by ID
- Update category by ID
- Delete category by ID

### Product Management
- Create a product and associate it with a category
- Retrieve all products (with pagination)
- Retrieve product by ID (including category details)
- Update product by ID
- Delete product by ID

### Additional Features
- Input validation using Bean Validation
- Global exception handling
- PostgreSQL database integration
- Automatic database seeding
- Dockerized application with Docker Compose
- Unit and integration tests

---

## Technologies Used

| Technology | Purpose |
|----------|--------|
| **Java 17** | Programming language |
| **Spring Boot 3.x** | REST API framework |
| **Spring Data JPA** | ORM & database interaction |
| **Hibernate** | JPA implementation |
| **PostgreSQL** | Relational database |
| **Docker & Docker Compose** | Containerization |
| **JUnit & Mockito** | Unit testing |
| **MockMvc** | Integration testing |
| **Gradle / Maven** | Build tool |

---

## Project Structure

src/main/java/com/example/productcatalog
├── controller/
├── service/
├── repository/
├── model/
├── dto/
├── exception/
├── config/
└── ProductCatalogApplication.java


---

## Setup Instructions (Local with Docker)

1️. Clone the Repository
```bash
git clone <your-repository-url>
cd product-catalog

2.  Environment Variables Setup

Create a .env file in the project root using the provided example:

cp .env.example .env


Edit .env if needed:

DB_USERNAME=postgres
DB_PASSWORD=postgres

3️. Run the Application Using Docker Compose
docker-compose up --build


✔ This starts:

Spring Boot application

PostgreSQL database
✔ Database tables are auto-created
✔ Initial data is seeded automatically

4️. Access the Application

API Base URL:

http://localhost:8080

* API Endpoints
* Category APIs
Method	Endpoint	Description
POST	/api/categories	Create category
GET	/api/categories	Get all categories
GET	/api/categories/{id}	Get category by ID
PUT	/api/categories/{id}	Update category
DELETE	/api/categories/{id}	Delete category
🔹 Create Category (Example)
POST /api/categories
{
  "name": "Electronics"
}

* Product APIs
Method	Endpoint	Description
POST	/api/products	Create product
GET	/api/products?page=0&size=10	Get all products
GET	/api/products/{id}	Get product by ID
PUT	/api/products/{id}	Update product
DELETE	/api/products/{id}	Delete product
🔹 Create Product (Example)
POST /api/products
{
  "name": "Smartphone",
  "description": "Android smartphone",
  "price": 15000,
  "categoryId": 1
}

🔹 Product Response (Example)
{
  "id": 1,
  "name": "Smartphone",
  "description": "Android smartphone",
  "price": 15000,
  "categoryId": 1,
  "categoryName": "Electronics"
}

## Running Tests
🔹 Run All Tests
./gradlew test


or

mvn test

🔹 Test Coverage Includes:

Service layer unit tests

Controller integration tests

Validation & error scenarios

* Deployment (Local Docker)

The application is deployed locally using Docker Compose, which orchestrates:

Spring Boot application container

PostgreSQL database container

docker-compose up --build


To stop containers:

docker-compose down

Troubleshooting
❌ Database Connection Issues

Ensure Docker is running

Check .env values

Verify container names in application.properties

❌ Port Already in Use

Change server.port in application.properties

Or stop the conflicting service

❌ Data Not Seeding

Ensure DatabaseSeeder is annotated with @Component

Ensure tables are empty on first run

* Conclusion

This project demonstrates a real-world backend system built using modern Java and DevOps practices. It highlights skills in REST API design, database management, validation, testing, and containerized deployment—making it suitable for professional and enterprise-level applications.



