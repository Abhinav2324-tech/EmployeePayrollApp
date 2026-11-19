# Employee Payroll App

A Spring Boot REST API for creating, viewing, updating, and deleting employee payroll records. Each record contains an employee ID, a name, and a salary.

The app was built in five use cases, starting with basic REST endpoints and progressing to a layered application with JSON responses and in-memory CRUD operations.

## Features

- Create an employee record with an automatically assigned ID.
- View all employees or find a specific employee by ID.
- Update an employee’s name and salary without changing their ID.
- Delete an employee and return `404 Not Found` if that ID is requested again.
- Return successful responses as JSON with a `message` and a `data` field.

**Storage:** Employee records are stored in memory and reset when the application restarts. MySQL connectivity is configured as part of the project setup, but employee records are not written to MySQL in this version.

## Tech Stack

- Java 17
- Spring Boot and Spring Web
- Maven and Maven Wrapper
- Spring Data JPA and MySQL Connector/J
- `curl` for API testing

## Project Structure

| Package | Responsibility |
| --- | --- |
| `controller` | Handles HTTP requests and returns JSON responses. |
| `service` | Implements CRUD operations and manages the in-memory employee list. |
| `dto` | Defines the request body (`EmployeePayrollDTO`) and response wrapper (`ResponseDTO`). |
| `model` | Defines the employee record (`EmployeePayrollData`). |

## Run Locally

1. Start your local MySQL server and run:

   ```sql
   CREATE DATABASE IF NOT EXISTS payroll_service;
   ```

2. Open **Git Bash** in the project folder. The application uses `root` as the default MySQL username. If you use a different account, set it with `export DB_USERNAME='your_mysql_username'`.

3. Enter your MySQL password and start the app:

   ```bash
   read -rsp 'MySQL password: ' DB_PASSWORD
   echo
   export DB_PASSWORD
   ./mvnw spring-boot:run
   ```

4. Once the application starts, the API is available at `http://localhost:8080/employeepayrollservice`. Keep the server running and use a second terminal to test it.

## API Endpoints

All paths below are relative to `/employeepayrollservice`.

| Method | Path | Description |
| --- | --- | --- |
| `GET` | `/` | List all employees. |
| `GET` | `/get/{empId}` | Get one employee by ID. |
| `POST` | `/create` | Create an employee from a JSON request. |
| `PUT` | `/update/{empId}` | Update the name and salary for an existing employee. |
| `DELETE` | `/delete/{empId}` | Delete an employee by ID. |

## Example API Test

Run the following commands in a second Git Bash terminal. After creating Lisa, use the `employeeId` returned in the response. The example assumes the ID is `1`.

```bash
BASE_URL=http://localhost:8080/employeepayrollservice

# Create an employee
curl -i -X POST "$BASE_URL/create" \
  -H 'Content-Type: application/json' \
  -d '{"name":"Lisa","salary":2000}'

# Get the employee
curl -i "$BASE_URL/get/1"

# Update the salary
curl -i -X PUT "$BASE_URL/update/1" \
  -H 'Content-Type: application/json' \
  -d '{"name":"Lisa","salary":2500}'

# Verify the updated salary
curl -i "$BASE_URL/get/1"

# Delete the employee and verify that the ID returns 404
curl -i -X DELETE "$BASE_URL/delete/1"
curl -i "$BASE_URL/get/1"
```

## Use Cases

| Section | Use case | Implementation |
| --- | --- | --- |
| 1 | UC 1 | Set up the Spring Boot project and Maven dependencies. |
| 1 | UC 2 | Configure MySQL connectivity and implement the REST controller. |
| 2 | UC 1 | Add the employee model and structured JSON responses. |
| 2 | UC 2 | Introduce the service layer and move payroll logic out of the controller. |
| 2 | UC 3 | Implement in-memory CRUD and update employees by ID. |

Each use case was implemented on a separate `feature(SectionN)/UCN/<feature-name>` branch and merged into `develop`.
