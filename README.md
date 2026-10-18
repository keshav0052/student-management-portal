
# Student Management Portal

A backend application built using Java, Spring Boot, Spring Data JPA, and MySQL to manage student information, attendance, and academic records.

## Features

- Student CRUD operations
- Search students by name
- Pagination and sorting
- Attendance management
- Academic records and marks management
- Input validation
- Exception handling
- MySQL database integration

## Tech Stack

- Java
- Spring Boot
- Spring Data JPA / Hibernate
- MySQL
- Maven
- Git and GitHub

## Project Structure

```text
src/main/java/com/example/studentmanagement/
├── controller/
├── entity/
├── exception/
├── repository/
└── service/
```

## API Endpoints

### Students

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/students` | Add a student |
| GET | `/api/students` | Get all students |
| GET | `/api/students/{id}` | Get student by ID |
| PUT | `/api/students/{id}` | Update student |
| DELETE | `/api/students/{id}` | Delete student |
| GET | `/api/students/search?name=rahul` | Search by name |
| GET | `/api/students/page?page=0&size=5` | Paginated students |
| GET | `/api/students/sort?field=name&direction=asc` | Sort students |

### Attendance

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/attendance/mark?studentId=1&date=2026-10-15&status=PRESENT` | Mark attendance |
| GET | `/api/attendance/student/{studentId}` | Get student's attendance |
| GET | `/api/attendance/date?date=2026-10-15` | Get attendance by date |

### Academic Records

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/academic-records/student/{studentId}` | Add an academic record |
| GET | `/api/academic-records/student/{studentId}` | Get records by student |
| GET | `/api/academic-records/subject/{subject}` | Search by subject |
| GET | `/api/academic-records/student/{studentId}/exam?examName=Mid%20Term` | Get records by exam |

## Setup Instructions

1. Clone this repository.
2. Open the project in IntelliJ IDEA.
3. Create a MySQL database named `student_management`.
4. Configure your local database username and password.
5. Run the application using `StudentmanagementApplication.java`.
6. Test the APIs using Postman.

## Database Configuration

Configure the following settings in your local `application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_management
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.jpa.hibernate.ddl-auto=update
```

Set `DB_USERNAME` and `DB_PASSWORD` in your local environment before running the application.

## Future Improvements

- Role-based authentication and authorization
- Attendance percentage reports
- Academic performance reports
- Frontend dashboard

## Author

Keshav
