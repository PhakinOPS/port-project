# Backend Lab – Portfolio Project

##  Overview
This repository is part of my backend development portfolio.
It contains:
- **Task Management API** (main showcase): A Spring Boot REST API with CRUD, sorting, pagination & filtering.
- **Session Coding Practices**: Algorithm exercises (Two Sum, Reverse String, etc.) to build logic foundations.

---

## ⭐ Task Management API (Main Showcase)
### Features
- CRUD operations for Task model (`id`, `title`, `description`)
- Sorting and filtering via Spring Data JPA Specifications
- Layered architecture: Controller → Service → Repository

### Structure
task/
├─ src/
│ ├─ controller/
│ ├─ service/
│ └─ repository/
└─ README.md

### Getting Started
```bash
git clone https://github.com/PhakinOPS/lab-project.git
cd lab-project/task-api
mvn spring-boot:run
```