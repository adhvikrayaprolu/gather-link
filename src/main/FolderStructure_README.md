# Folder Structure — `src/main/`

This document explains the structure and purpose of key folders and files under the `src/main/` directory of the **GatherLink** project.

---

## `java/com/gather_link/`

This folder contains the core **backend application logic** of the GatherLink Spring Boot project.

```text
java/com/gather_link/
├── controller/
├── model/
├── service/
└── ...
```

### ▸ `controller/`
Holds all Spring MVC controllers. These are responsible for handling HTTP requests and returning appropriate views or REST responses. Each controller typically maps to a URL path and delegates to services.

### ▸ `dto/` (Data Transfer Objects)
Holds lightweight **DTO classes** that encapsulate data transferred between client and server or between application layers (e.g., `PostRequestDTO`). These simplify request and response payloads.

### ▸ `exceptions/`
Contains **custom exception classes** and structured error responses. Helps in returning user-friendly error messages and maintaining clean error-handling logic. Example: `UserNotFoundException`, `UserResponse`.

### ▸ `repository/`
Includes **Spring Data JPA repositories** used for interacting with the database. These interfaces typically extend `JpaRepository`.

### ▸ `model/`
Contains JPA entity classes such as `Users`, `Groups`, `Posts`, etc. These classes map directly to database tables and are used throughout the application for persistence and business logic.

### ▸ `service/`
Defines the **business logic layer**. Service classes interact with repositories and perform business operations before returning data to controllers.

### ▸ `GatherLinkApplication.java`
This is the **main entry point** for the Spring Boot application. It contains the `main()` method that launches the application.

### ▸ `ServletInitializer.java`
Required for **WAR deployments** (e.g., when deploying to external servlet containers like Tomcat). It extends `SpringBootServletInitializer` and overrides configuration.

---

## `resources/`

```text
resources/
└── application.properties
```

### ▸ `application.properties`
This file contains configuration details such as database connection properties, view resolver settings, and Hibernate dialects. For example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/interest_groups
spring.jpa.hibernate.ddl-auto=update
spring.mvc.view.prefix=/WEB-INF/jsp/
spring.mvc.view.suffix=.jsp
```

## ▸ `webapp/WEB-INF/jsp/`
Contains JSP (JavaServer Pages) used to render the frontend views of the web application. These are returned by controller methods for dynamic web content rendering.

### ▸ `general files`
```text
webapp/WEB-INF/jsp/
├── createGroup.jsp
├── createPost.jsp
└── ...
```

Each JSP file corresponds to a specific frontend view (e.g., forms for creating posts/groups, dashboards, explore pages, etc.).

### ▸ `resources/styles.css`

You may also find static frontend resources such as CSS styles in:
```text
resources/
└── styles.css
```

