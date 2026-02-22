---

# Student Management System (Java, ArrayLists & Generics)

## Assignment Overview

This project is a **Student Management System for a university** built in Java.
The system uses **ArrayLists** to manage students, courses, and enrollments, and demonstrates how **generics** can be used to create reusable and flexible data structures.

The project includes:

* Student and Course management
* Enrollment tracking
* GPA calculations
* ArrayList operations and comparisons with arrays
* Generic utility methods
* Generic data structures (Stack, Queue, Pair)
* Reporting system
* Main menu-based application

---

# Class Descriptions

## Core Classes

### Student

Represents a university student.

Fields:

* studentId – unique ID (e.g., S001)
* firstName
* lastName
* email
* gpa
* major
* year (1–4)

Main Features:

* Constructor with all parameters
* Getters and setters
* `getFullName()` method
* `toString()` formatted output
* `equals()` compares by studentId
* `hashCode()` consistent with equals

---

### Course

Represents a university course.

Fields:

* courseCode
* courseName
* credits
* instructor
* maxEnrollment
* prerequisites (ArrayList<String>)

Main Features:

* Add prerequisite courses
* Check if a course is a prerequisite
* Return list of prerequisites
* Course information display

---

### StudentManager

Manages all students using `ArrayList<Student>`.

Main Features:

* Add and remove students
* Search for students
* Filter students by major or year
* Find honor students
* Calculate average GPA
* Print student list
* Get unique majors
* Prevent duplicate student IDs

---

### Enrollment

Represents a student enrolled in a course.

Fields:

* enrollmentId
* studentId
* courseCode
* grade
* semester

Main Features:

* Convert letter grades to grade points
* Check if a grade is passing
* Store enrollment information

---

### EnrollmentManager

Manages enrollments using `ArrayList<Enrollment>`.

Main Features:

* Enroll students
* Drop enrollments
* Assign grades
* Find enrollments
* Calculate student GPA
* Get students in a course
* Print all enrollments
* Check course capacity
* Validate grades

---

### CourseManager

Manages courses using `ArrayList<Course>`.

Main Features:

* Add and find courses
* List courses by instructor
* Determine available courses for a student
* Print all courses
* Track total courses

---

# ArrayList Demonstration Classes

### ArrayListOperationsDemo

Demonstrates common ArrayList features:

* Convert array → ArrayList
* Convert ArrayList → array
* Sublist behavior
* Sorting using Comparators
* Searching with indexOf and binarySearch

---

### ArrayListVsArrayDemo

Compares arrays and ArrayLists by:

* Adding elements
* Removing elements
* Resizing
* Performance testing
* Access time comparison

---

# Generic Classes and Utilities

### ArrayListUtils

Contains reusable **generic methods**:

* Generic swap
* Find maximum value
* Filter elements
* Reverse list
* Merge lists
* Sum numbers
* Average numbers
* Filter numbers above threshold
* Wildcard examples

Includes examples of:

* Upper bounded wildcards
* Lower bounded wildcards
* Unbounded wildcards

---

### GenericList<T>

A custom wrapper around `ArrayList<T>`.

Features:

* Add items
* Remove items
* Get elements
* Check size
* Check if empty
* Clear list
* Contains method
* Add all elements
* Copy elements between generic lists
* Sorting support
* Find max element

---

### GenericStack<T>

Stack implementation using ArrayList.

Operations:

* push
* pop
* peek
* size
* clear

---

### GenericQueue<T>

Queue implementation using ArrayList.

Operations:

* enqueue
* dequeue
* peek
* size
* isEmpty

---

### Pair<K, V>

Generic container that stores two related values.

Used for:

* Course and grade mapping
* Student-course pairs

Includes:

* equals()
* hashCode()
* toString()

---

### ReportGenerator

Generates reports from system data.

Reports include:

* Student report
* Course report
* Major report
* Honor roll report

---

### StudentManagementSystemMain

Main application that runs the system.

Features:

* Menu-driven interface
* Adds sample data
* Demonstrates all operations
* Shows reports
* Demonstrates generics and ArrayList utilities

---

# How to Compile and Run

Open terminal inside your project folder and run:

Compile all Java files:

```
javac *.java
```

Run the main program:

```
java StudentManagementSystemMain
```

If using an IDE (VS Code / IntelliJ):

1. Open the project folder
2. Compile the project
3. Run `StudentManagementSystemMain.java`

---

# Design Decisions

Several design decisions were made while building this system:

1. ArrayLists were used instead of arrays to allow dynamic resizing.
2. Managers (StudentManager, CourseManager, EnrollmentManager) were created to separate logic from data objects.
3. Generics were implemented to make utility methods reusable across different data types.
4. A layered structure was used:

   * Data classes
   * Manager classes
   * Utility classes
   * Main application
5. Unique IDs were used to prevent duplicate records.
6. Methods return copies of lists when necessary to protect internal data.

This structure improves code organization and scalability.

---

# Challenges Encountered

Some challenges during development included:

Understanding generics and bounded types
Working with wildcard types such as:

* `?`
* `? extends`
* `? super`

Handling ArrayList sorting with Comparable

Managing relationships between:

* Students
* Courses
* Enrollments

Preventing duplicate students and enrollments

Ensuring GPA calculations were accurate

Another challenge was implementing generic methods that work for multiple types while keeping the code safe and readable.

---

# What I Learned About ArrayLists and Generics

From this project I learned:

ArrayLists are very useful for dynamic data structures.

Key advantages:

* Automatically resize
* Easy element management
* Built-in methods simplify coding

Important ArrayList methods used:

* add()
* remove()
* get()
* size()
* contains()
* indexOf()
* subList()

I also learned how generics:

* Improve code reusability
* Increase type safety
* Reduce duplicated code

Generics allow the same class or method to work with:

* Students
* Numbers
* Strings
* Any object type

---

# Array vs ArrayList Summary

## When to Use Arrays

Use arrays when:

* The number of elements is fixed
* Performance is critical
* Memory overhead should be minimal

Arrays are:

* Slightly faster
* Fixed in size
* Require manual resizing

Example use cases:

* Fixed test score list
* Static datasets
* Performance-critical programs

---

## When to Use ArrayList

Use ArrayList when:

* Data size changes frequently
* Elements are added or removed often
* Flexibility is needed

ArrayList:

* Automatically resizes
* Provides useful built-in methods
* Simplifies coding

---

## Key Difference

Arrays:

* Fixed size
* Manual resizing
* Less flexible

ArrayList:

* Dynamic size
* Automatic resizing
* Easier to manage

---

## Conclusion

Arrays are best when performance and fixed size are important.

ArrayList is better when flexibility and easier data management are needed.

For most real-world applications like this Student Management System, **ArrayList is the better choice**.

---

# Generics Wildcard Summary

## Upper Bounded Wildcard (`? extends T`)

Use when reading from a collection.

The collection acts as a **producer**.

Example:
Accepts:

* ArrayList<Integer>
* ArrayList<Double>

Limitation:
You cannot safely add elements.

---

## Lower Bounded Wildcard (`? super T`)

Use when adding elements to a collection.

The collection acts as a **consumer**.

Example:
Accepts:

* ArrayList<Integer>
* ArrayList<Number>
* ArrayList<Object>

Limitation:
When reading, items are treated as Object.

---

## Unbounded Wildcard (`?`)

Use when the method works with any type.

Best for:

* Printing lists
* Getting list size
* Generic operations

Limitation:
You can only read as Object.

---
