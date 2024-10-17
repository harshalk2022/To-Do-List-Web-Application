# To-Do List Web Application

This is a simple web-based To-Do List application built using Angular for the frontend and Spring Boot for the backend. Users can manage their todos by adding, updating, and deleting them, providing a user-friendly interface for task management.

## Table of Contents

- [To-Do List Web Application](#to-do-list-web-application)
  - [Table of Contents](#table-of-contents)
  - [Features](#features)
  - [Technologies Used](#technologies-used)
  - [Installation](#installation)
    - [Prerequisites](#prerequisites)
    - [Backend Setup](#backend-setup)
    - [Frontend Setup](#frontend-setup)
    - [Running the Full Application](#running-the-full-application)
  - [API Documentation](#api-documentation)
    - [1\. Get All todos](#1-get-all-todos)
    - [2\. Get a Task by ID](#2-get-a-task-by-id)
    - [3\. Create a New Task](#3-create-a-new-task)
    - [4\. Update a Task](#4-update-a-task)
    - [5\. Delete a Task](#5-delete-a-task)
  - [License](#license)

## Features

- Add new todos
- Update existing todos
- Mark todos as Complete or Not Completed
- Delete todos
- Responsive UI

## Technologies Used

- **Frontend**: Angular, Bootstrap, HTML, CSS
- **Backend**: Spring Boot, Hibernate, JPA, MySQL
- **Database**: MySQL
- **Build Tools**: Maven

## Installation

### Prerequisites

- Java: 17 or higher
- MySQL Server
- Maven
- Angular CLI: 15.2.11
- Node: 20.18.0
- Node Package Manager: npm 9.2.0
- OS: win32 x64
- Spring Tool Suite 4

### Backend Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/harshalk2022/To-Do-List-web-application.git
   cd To-Do-List-web-application/Todo_List_Backend
   ```

2. Configure the database:

   - Open the `application.properties` file located in the `src/main/resources` folder.
   - Update the following lines with your MySQL configuration:

   ```properties
   # Database Configuration:MySQL
   spring.datasource.url=jdbc:mysql://localhost:3306/yourDatabaseName
   spring.datasource.username=yourUsername
   spring.datasource.password=yourPassword
   ```

3. Build and run the Spring Boot backend:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   The backend server will start at `http://localhost:8181`.

### Frontend Setup

1. Navigate to the frontend directory:

   ```bash
   cd ../Todo_List_Frontend
   ```

2. Install the dependencies:

   ```bash
   npm install
   ```

3. Run the Angular application:

   ```bash
   ng serve
   ```

   The frontend will be available at `http://localhost:4200`.

### Running the Full Application

1. Ensure both the backend and frontend servers are running.
2. Open a browser and go to `http://localhost:4200` to start using the To-Do List application.

## API Documentation

The backend provides a RESTful API to interact with todos. The base URL for all API endpoints is `http://localhost:8181/api/todos`.

### 1. Get All todos

- **Endpoint**: `/api/todos`
- **Method**: `GET`
- **Description**: Retrieves a list of all todos.
- **Response**:

  ```json
  [
    {
      "id": 1,
      "title": "Buy Grocery",
      "description": "Milk, Egg, Vegetables etc.",
      "isCompleted": false,
      "createdAt": "2024-10-17T02:05:21.088683"
    },
    {
      "id": 2,
      "title": "Pay Rent",
      "description": "PG, Mess",
      "isCompleted": false,
      "createdAt": "2024-10-17T02:06:00.969412"
    }
  ]
  ```

### 2. Get a Task by ID

- **Endpoint**: `/api/todos/{id}`
- **Method**: `GET`
- **Description**: Retrieves a task by its ID.
- **Response**:

  ```json
  {
    "id": 1,
    "title": "Buy Grocery",
    "description": "Milk, Egg, Vegetables etc.",
    "isCompleted": false,
    "createdAt": "2024-10-17T02:05:21.088683"
  }
  ```

### 3. Create a New Task

- **Endpoint**: `/api/todos`
- **Method**: `POST`
- **Description**: Creates a new task.
- **Request Body**:

  ```json
  {
    "title": "New Task",
    "description": "Description of the new task"
  }
  ```

- **Response**:

  ```json
  {
    "id": 3,
    "title": "New Task",
    "description": "Description of the new task",
    "isCompleted": false,
    "createdAt": "2024-10-17T03:04:21.088683"
  }
  ```

### 4. Update a Task

- **Endpoint**: `/api/todos/{id}`
- **Method**: `PUT`
- **Description**: Updates an existing task.
- **Request Body**:

  ```json
  {
    "title": "Updated Task Title",
    "description": "Updated task description",
    "isCompleted": true
  }
  ```

- **Response**:

  ```json
  {
    "id": 1,
    "title": "Updated Task Title",
    "description": "Updated task description",
    "isCompleted": true,
    "createdAt": "2024-10-17T03:04:21.088683"
  }
  ```

### 5. Delete a Task

- **Endpoint**: `/api/todos/{id}`
- **Method**: `DELETE`
- **Description**: Deletes a task by its ID.
- **Response**:

  ```text
  Deleted Successfully
  ```

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---
