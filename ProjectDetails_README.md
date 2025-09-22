# GatherLink — Interest Group Platform

**GatherLink** is a Spring Boot web application that enables users to discover, join, and interact within interest-based groups. This application was built as a full-stack solution using Java, Spring Boot MVC, JSP for frontend, and MySQL as the backend database. This project was developed during a software development internship and serves as a full-stack application featuring RESTful APIs, JSP-based frontend views, and database interaction using MySQL with JPA/Hibernate.

---

## Project Overview

This is a **Java Spring Boot MVC** application with the following core functionalities:

- Users can register, log in, and manage their profiles.
- Explore groups based on interests.
- Join or leave interest groups.
- Create posts and comments within groups.
- Backend architecture includes Controllers, Services, Repositories, and Entity models.

---

## Project Structure

Here is a high-level overview of the key directories and files:

```text
gather-link/
├── pom.xml
├── mvnw*
├── src/
│   ├── main/
│   │   ├── java/com/gather_link/
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── service/
│   │   │   └── ...
│   │   ├── resources/
│   │   │   ├── static/
│   │   │   ├── templates/
│   │   │   └── application.properties
│   │   └── webapp/WEB-INF/jsp/
```


For a deeper breakdown of files:

- See [`FolderStructure_README.md`](src/main/FolderStructure_README.md) for explanations of each folder under `src/main`.
- See [`ModuleBreakdown_README.md`](src/main/java/com/gather_link/ModuleBreakdown_README.md) for class-level breakdowns of packages like `controller`, `dto`, `model`, etc.

---

## 🚀 How to Run the Project

### 🖥️ Prerequisites

- Java 17+
- Maven 3.6+
- MySQL installed and configured
- IDE like **Eclipse** or **IntelliJ IDEA**

### 🔧 Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/gather-link.git
   cd gather-link

2. **Configure the Database**
   Make sure MySQL is running and a database named `interest_groups` exists.

   Update your credentials in:
   src/main/resources/application.properties

   spring.datasource.username=your_username
   spring.datasource.password=your_password

3. **You can use Maven from the terminal or your IDE:**

   ./mvnw clean install

4. **Run the Application:**

   ./mvnw spring-boot:run

5. **Open in Browser**

   Go to:
   http://localhost:8080/
