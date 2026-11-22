# Event Registration REST API

## Student Information
- **Student:** Imantaev Sanzhar
- **Group:** IT3-2502DS
- **Laboratory Work:** Spring Boot REST API

## Project Description

This project is a RESTful API for managing event registrations. It allows users to create, retrieve, update, search, and delete events.

The application is developed using Java and Spring Boot. It uses a layered architecture with Controller, Entity, Repository, and Service components.

## Technologies Used
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- PostgreSQL
- Gradle
- Postman

## Project Structure

```text
src/main/java/kz/iitu/registration/
├── controller/
│   └── EventController.java
├── entity/
│   └── Event.java
├── repository/
│   └── EventRepository.java
├── service/
│   └── EventService.java
└── EventRegistrationApplication.java
```

## REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/events` | Get all events |
| GET | `/api/events?title=Java` | Search events by title |
| GET | `/api/events/{id}` | Get an event by ID |
| POST | `/api/events` | Create a new event |
| PUT | `/api/events/{id}` | Update an existing event |
| DELETE | `/api/events/{id}` | Delete an event |

## Example JSON Request

```json
{
  "title": "Java Workshop",
  "location": "Room 101"
}
```

## HTTP Status Codes

- **200 OK** — Request completed successfully.
- **201 Created** — Event created successfully.
- **204 No Content** — Event deleted successfully.
- **400 Bad Request** — Invalid request.
- **404 Not Found** — Event not found.

## How to Run the Project

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA.
3. Make sure Java and PostgreSQL are installed.
4. Configure the database connection in `application.properties`.
5. Run `EventRegistrationApplication.java`.
6. The application starts at:

```text
http://localhost:8080
```

## Testing

The REST API endpoints can be tested using Postman.

The project supports CRUD operations:
- Create events.
- Retrieve all events.
- Search events by title.
- Retrieve an event by ID.
- Update event information.
- Delete events.

## Conclusion

This laboratory work demonstrates how to develop a RESTful API using Spring Boot. It provides practical experience with REST controllers, HTTP methods, service and repository layers, and database integration.
