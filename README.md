## 🎭 Art Events Management System (Java)

Console-based Event Management Information System developed in Java, simulating the core operations of a cultural service provider.

Developed as part of the MSc in Information & Communication Technology (ICT)
University of West Attica.

---

## 📌 Overview

This project simulates a simplified Event Management Information System for managing artistic events.

It models core business entities (Events, Customers, Reservations) and demonstrates how business processes can be translated into structured software logic using Object-Oriented Programming principles.

The system focuses on:
- Structured data modeling
- CRUD process implementation
- Business rule validation
- Modular system design
- File-based persistence

---

## 🧠 Business Logic Implemented
	•	Entity validation before ticket reservation
	•	Customer & event existence verification
	•	Controlled deletion logic
	•	Cross-module data consistency
	•	Ticket counting & reservation tracking
	•	Statistics generation per event
	•	Centralized application flow coordination

This mirrors how small-scale ERP-style systems manage entities and transactional logic.

---

## 🚀 Features

## 🎭 Theatrical Performances
	•	Add new performance
	•	Edit existing performance
	•	Delete performance
	•	View all performances

Fields:
	•	Code
	•	Title
	•	Main Actor
	•	Venue
	•	Date

---

## 🎵 Music Performances
	•	Add new performance
	•	Edit existing performance
	•	Delete performance
	•	View all performances

Fields:
	•	Code
	•	Title
	•	Singer
	•	Venue
	•	Date

---

## 👤 Customer Management
	•	Add customer
	•	Edit customer
	•	Delete customer
	•	View all customers

Fields:
	•	Customer Code
	•	Name

---

## 🎟 Ticket Reservations
	•	Reserve ticket for theatrical performance
	•	Reserve ticket for music performance
	•	Validation of customer & event existence
	•	Automatic ticket count tracking

---

## 📊 Statistics
	•	Display ticket statistics per event
	•	Track total reservations per performance

---

## 🏗 System Architecture

The system follows a modular Object-Oriented architecture:
- Models → Represent business entities (TheaterPlay, MusicPerformance, Customer, Reservation)
- Manager Classes → Handle business logic & CRUD operations
- Main Controller → Coordinates application flow and menu navigation
- CSV Persistence Layer → Handles file-based storage abstraction

This separation improves maintainability, scalability, and logical clarity.

---

## 💾 Data Persistence

All entities are stored in CSV files.
- Data is loaded automatically at application startup
- Data is saved automatically on exit
- Ensures structured persistence without database integration

This approach demonstrates understanding of basic data storage abstraction before introducing relational databases.

---

## 🛠 Technologies Used
	•	Java
	•	Object-Oriented Programming (OOP)
	•	ArrayList
	•	File I/O (CSV handling)
	•	Scanner for input handling
	•	Exception handling & validation

---

## 🎯 Skills Demonstrated
	•	Object-Oriented System Design
	•	Modular Architecture Planning
	•	CRUD Process Modeling
	•	Business Process Translation into Code
	•	Data Integrity Handling
	•	File-Based Persistence
	•	Cross-Module Integration
	•	Structured Console Application Flow

---

## ▶ How to Run
	1.	Open the project in IntelliJ IDEA (or any Java IDE)
	2.	Run the main class
	3.	Use the console-based menu to navigate between modules

---

## 📈 Possible Future Improvements
	•	Database integration (JDBC)
	•	GUI implementation (JavaFX or Web interface)
	•	Unique ID auto-generation mechanism
	•	Logging system integration
	•	Layered architecture refactoring
	•	Unit testing implementation
	•	REST API exposure for external integration

---

## 👨‍💻 My Contribution

In this group project, I was responsible for:
- Designing and implementing the complete Theatrical Performance module
- Designing the overall application architecture and structural organization
- Developing the main application flow and menu navigation logic
- Implementing the CSV-based persistence mechanism (data loading & saving)
- Coordinating integration between modules
- Ensuring data consistency and validation across the system

---

## 👤 Author

Panagiotis Zois
MSc ICT | Bridging Business & Technology
