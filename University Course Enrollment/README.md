# 🎓 University Course Enrollment System

A Java-based console application for managing university course enrollments. The system allows administrators to register students and instructors, create courses, and handle enrollment and drop operations through an interactive menu.

---

## 📁 Project Structure

```
University Course Enrollment/
├── .vscode/
│   └── settings.json        # VS Code Java project configuration
├── src/
│   ├── Main.java            # Entry point & interactive menu
│   ├── EnrollmentSystem.java# Core system logic & data management
│   ├── Person.java          # Base class for all people
│   ├── Student.java         # Student entity (extends Person)
│   ├── Instructor.java      # Instructor entity (extends Person)
│   └── Course.java          # Course entity with enrollment logic
├── bin/                     # Compiled .class files (auto-generated)
└── lib/                     # External dependencies (if any)
```

---

## 🏗️ Class Overview

### `Person` (Base Class)
The abstract base for all people in the system.

| Field | Type | Description |
|-------|------|-------------|
| `name` | String | Full name |
| `ID` | String | Unique identifier |
| `email` | String | Email address |

**Methods:** `getName()`, `getID()`, `getEmail()`, setters, `displayDetails()`

---

### `Student` extends `Person`
Represents a university student.

| Field | Type | Description |
|-------|------|-------------|
| `enrolledCourses` | `ArrayList<Course>` | List of currently enrolled courses |

**Methods:** `addCourse()`, `removeCourse()`, `getEnrolledCourses()`, `displayDetails()`

---

### `Instructor` extends `Person`
Represents a course instructor.

| Field | Type | Description |
|-------|------|-------------|
| `specialization` | String | Field of expertise |
| `assignedCourses` | `ArrayList<Course>` | Courses taught by this instructor |

**Methods:** `getSpecialization()`, `assignCourse()`

---

### `Course`
Represents a university course with enrollment management.

| Field | Type | Description |
|-------|------|-------------|
| `courseCode` | String | Unique course code (e.g., `CSE241`) |
| `title` | String | Full course title |
| `maxCapacity` | int | Maximum number of students allowed |
| `instructor` | Instructor | Assigned instructor |
| `enrolledStudents` | `ArrayList<Student>` | Currently enrolled students |

**Methods:** `enrollStudent()`, `dropStudent()`, `isFull()`, `displayAllStudents()`

---

### `EnrollmentSystem`
The central system that manages all data and operations.

| Field | Type | Description |
|-------|------|-------------|
| `allStudents` | `ArrayList<Student>` | All registered students |
| `allCourses` | `ArrayList<Course>` | All available courses |
| `allInstructors` | `ArrayList<Instructor>` | All registered instructors |

**Methods:** `registerStudent()`, `addCourse()`, `removeCourse()`, `findStudentById()`, `findCourseByCode()`, `registerInstructor()`, `findInstructorById()`, `initializedDatabase()`

---

## 🚀 Getting Started

### Prerequisites
- Java JDK 11 or later
- VS Code with the [Extension Pack for Java](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack) *(recommended)*

### Running the Application

**Option 1 — VS Code:**
1. Open the project folder in VS Code.
2. Open `src/Main.java`.
3. Click the **Run** button or press `F5`.

**Option 2 — Command Line:**
```bash
# Compile
javac -d bin src/*.java

# Run
java -cp bin Main
```

---

## 📋 Menu Options

Once the application starts, it initializes a sample database and presents the following menu:

```
******************************************
* UNIVERSITY ENROLLMENT SYSTEM           *
******************************************
  [1] Register New Student
  [2] Create New Course
  [3] Enroll Student in Course
  [4] Drop Student from Course
------------------------------------------
  [5] View Student Details
  [6] View Course Roster
  [7] Register New Instructor
  [0] Exit Application
******************************************
```

### Option Details

| Option | Description | Required Input |
|--------|-------------|----------------|
| `1` | Register a new student | Name, ID, Email |
| `2` | Create a new course | Title, Code, Max Capacity |
| `3` | Enroll a student in a course | Student ID, Course Code |
| `4` | Drop a student from a course | Student ID, Course Code |
| `5` | View a student's profile | Student ID |
| `6` | View all students in a course | Course Code |
| `7` | Register a new instructor | Name, ID, Email, Specialization |
| `0` | Exit the application | — |

---

## 🗃️ Pre-loaded Sample Data

The system auto-loads the following data on startup via `initializedDatabase()`:

### Instructors
| ID | Name | Specialization |
|----|------|----------------|
| INS101 | Dr. Ahmed | Software Engineering |
| INS102 | Dr. Laila | Mathematics |
| INS103 | Dr. Hassan | Physics |

### Courses
| Code | Title | Capacity | Instructor |
|------|-------|----------|------------|
| CSE142 | Introduction to Software Engineering | 40 | Dr. Ahmed |
| CSE241 | Object-Oriented Computer Programming | 40 | Dr. Ahmed |
| PHM112 | Mathematics (2) | 60 | Dr. Laila |
| PHM113 | Probability and Statistics | 60 | Dr. Laila |
| PHM121 | Vibration and Waves | 50 | Dr. Hassan |
| PHM123 | Introduction to Physical Electronics | 50 | Dr. Hassan |

### Students
| ID | Name |
|----|------|
| 25P0371 | Omar Farouk Ibrahim Aly |
| 25P0112 | Youssef Ahmed |
| 25P0445 | Mariam Hassan |
| 25P0233 | Nour Ali |

---

## ⚙️ Key Behaviors

- **Duplicate Prevention:** Registering a student with an existing ID is rejected with an error message.
- **Capacity Enforcement:** Enrolling a student in a full course prints an error and prevents enrollment.
- **Bidirectional Sync:** When a student is enrolled in or dropped from a course, both the `Course` and `Student` objects are updated simultaneously.
- **Graceful Not-Found Handling:** All lookup operations (by student ID or course code) display a clear error if the entity does not exist.

---

## 🔧 VS Code Configuration

The `.vscode/settings.json` file configures the Java project:

```json
{
    "java.project.sourcePaths": ["src"],
    "java.project.outputPath": "bin",
    "java.project.referencedLibraries": ["lib/**/*.jar"]
}
```

---

## 📌 Notes

- The system runs entirely in-memory; no data is persisted between sessions.
- When creating a new course via the menu (option 2), it is automatically assigned to a default instructor (`Dr. Smith`). To assign a specific instructor, use the `findInstructorById()` method programmatically.
- Student IDs and Course Codes are **case-sensitive**.