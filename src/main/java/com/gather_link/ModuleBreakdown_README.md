# 📦 Module Breakdown — `com.gather_link`

This document provides an in-depth overview of all the Java packages and key classes in the `com.gather_link` backend of the GatherLink platform. It outlines the purpose of each controller, model, service, DTO, repository, and exception used in the application.

---

## `controller/`

Handles all incoming web requests and maps them to appropriate services or views.

- **`CommentController.java`** – Manages endpoints related to comments on posts (e.g., create, delete).
- **`ExploreGroupsController.java`** – Handles logic for discovering and displaying all interest groups.
- **`GroupController.java`** – Responsible for creating, updating, and deleting groups.
- **`GroupMembershipController.java`** – Manages join/leave operations for groups by users.
- **`HomeController.java`** – Returns the homepage and general landing views.
- **`LoginController.java`** – Manages login/logout operations using session-based authentication.
- **`MyGroupsController.java`** – Displays groups a user is a member of.
- **`PostController.java`** – Handles creating, listing, and interacting with posts.
- **`PostPageController.java`** – Renders full post pages with associated comments.
- **`ProfileController.java`** – Manages profile view/edit requests.
- **`UserController.java`** – Manages user-specific API endpoints (e.g., getUserById).
- **`UserWebController.java`** – Renders views related to users, such as registration and login forms.

---

## `dto/`

Lightweight objects used for encapsulating request and response payloads.

- **`PostRequestDTO.java`** – Represents the request body when a user creates a post. Contains fields like `groupId`, `message`, etc.

---

## `exceptions/`

Custom exceptions and error response formatting for better error handling.

- **`UserNotFoundException.java`** – Thrown when a user lookup fails in the service or repository.
- **`UserResponse.java`** – Custom response wrapper for returning structured error messages (e.g., `{status, message}`).

---

## `model/`

JPA entity classes that directly map to MySQL tables.

- **`Users.java`** – Represents registered users. Includes user profile information.
- **`Groups.java`** – Defines interest groups, including metadata like group name, description, owner ID.
- **`GroupMemberships.java`** – Maps users to groups they've joined (many-to-many bridge table).
- **`Posts.java`** – Stores user-submitted posts. Each post is linked to a group and a creator.
- **`Comments.java`** – Represents comments on posts with a many-to-one relationship to `Posts`.
- **`Role.java`** – Enum or entity used to track user roles (e.g., ADMIN, USER).

---

## `repository/`

Spring Data JPA repositories for interacting with the database.

- **`UserRepository.java`** – Interface for CRUD operations on the `Users` table.
- **`GroupRepository.java`** – CRUD repository for managing groups.
- **`GroupMembershipRepository.java`** – Handles logic related to user-group relationships.
- **`PostRepository.java`** – Interface for fetching and saving posts.
- **`CommentRepository.java`** – Interface for managing comments.

---

## `service/`

Business logic layer that sits between controllers and repositories.

- **`UserService.java`** – Contains logic for user registration, lookup, and updates.
- **`GroupService.java`** – Validates and processes group-related actions.
- **`GroupMembershipService.java`** – Manages logic for joining/leaving groups.
- **`PostService.java`** – Handles creation, fetching, and processing of posts.
- **`CommentService.java`** – Adds/removes comments while ensuring comment-related validations.

---

## Application Boot Classes

- **`GatherLinkApplication.java`** – The main class containing the `public static void main(String[] args)` method. This is where Spring Boot starts the application.
- **`ServletInitializer.java`** – Extends `SpringBootServletInitializer`. Required for deploying the app as a WAR to a servlet container like Tomcat.

---

## Summary

This breakdown helps clarify the separation of concerns across the MVC architecture:

- `controller` – handles **HTTP requests**
- `service` – contains **business logic**
- `repository` – handles **data access**
- `model` – defines **database entities**
- `dto` – used for **data encapsulation**
- `exceptions` – enables **structured error handling**

---

*Note:* For file-level explanations of frontend assets, refer to [`FolderStructure_README.md`](../../FolderStructure_README.md). For setup and project goals, see [`ProjectDetails_README.md`](../../../ProjectDetails_README.md).
