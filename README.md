# Simple University System

A simple Spring Boot REST API for basic student registration and account operations.

## Tech Stack
- Java 21
- Spring Boot 4.0.2
- Maven Wrapper (`mvnw`, `mvnw.cmd`)

## Project Structure
- `src/main/java/com/pioneers/simpleuniversitysystem/SimpleUniversitySystemApplication.java`: app entry point
- `src/main/java/com/pioneers/simpleuniversitysystem/controllers/Main.java`: REST endpoints
- `src/main/java/com/pioneers/simpleuniversitysystem/models/dtos/StudentRequest.java`: request DTO

## Prerequisites
- JDK 21 installed
- Maven is optional (wrapper is included)

## Run the Application
From the project root:

Windows:
```powershell
.\mvnw.cmd spring-boot:run
```

macOS/Linux:
```bash
./mvnw spring-boot:run
```

The app runs on:
- `http://localhost:8080`

## API Endpoints
Base URL: `http://localhost:8080`

### 1. Register Student
- Method: `POST`
- Path: `/register`
- Body:
```json
{
  "firstName": "Ahmed",
  "lastName": "Ali",
  "email": "ahmed@example.com",
  "phoneNumber": "01000000000",
  "password": "123456"
}
```
- Response: `Student registered successfully`

### 2. Login
- Method: `POST`
- Path: `/login`
- Body:
```json
{
  "email": "ahmed@example.com",
  "password": "123456"
}
```
- Response:
  - Success: `Login successful`
  - Failure: `Invalid email or password`

### 3. Fetch All Students
- Method: `GET`
- Path: `/fetchAllStudents`
- Response: map keyed by student email

### 4. Delete All Students
- Method: `DELETE`
- Path: `/DeleteAllStudents`
- Response: `All students deleted successfully`

### 5. Delete Student by Email
- Method: `DELETE`
- Path: `/DeleteStudent?email=ahmed@example.com`
- Response:
  - Success (200): `Student with email ahmed@example.com deleted successfully`
  - Not found (404): `Student with email ahmed@example.com not found`

### 6. First Registered Student
- Method: `GET`
- Path: `/FirstRegisteredStudent`
- Response:
  - Success: first registered student's name and email
  - Empty data: `No students registered`

### 7. Update Student Information
- Method: `PUT`
- Path: `/UpdateStudentInformation`
- Body:
```json
{
  "firstName": "Ahmed",
  "lastName": "Hassan",
  "email": "ahmed@example.com",
  "phoneNumber": "01111111111",
  "password": "new-password"
}
```
- Response:
  - Success: `Student information updated successfully`
  - Not found: `Student with email ahmed@example.com not found`

## Quick Test with cURL
```bash
curl -X POST http://localhost:8080/register \
  -H "Content-Type: application/json" \
  -d '{"firstName":"Ahmed","lastName":"Ali","email":"ahmed@example.com","phoneNumber":"01000000000","password":"123456"}'

curl -X POST http://localhost:8080/login \
  -H "Content-Type: application/json" \
  -d '{"email":"ahmed@example.com","password":"123456"}'

curl http://localhost:8080/fetchAllStudents
```

## Current Limitations
- Data is stored in-memory (`LinkedHashMap`) and is lost when the app stops.
- No validation, authentication token, or password hashing yet.
- Endpoint paths are case-sensitive and currently mixed-case.

## License
No license file is currently defined in this repository.
