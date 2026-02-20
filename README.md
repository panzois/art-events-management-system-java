# Art Events Management System (Java)

Console-based application developed in Java for managing artistic events, including theatrical performances, music performances, customers, and ticket reservations.

Developed as part of the MSc in Information & Communication Technology (ICT)  
University of West Attica.

---

## 📌 Overview

This application simulates a basic event management system for a service provider.  
It allows full management of:

- Theatrical performances
- Music performances
- Customers
- Ticket reservations
- Ticket statistics per event

All data is stored using file-based persistence (CSV files) and loaded automatically at application startup.

---

## 🚀 Features

### 🎭 Theatrical Performances
- Add new performance
- Edit existing performance
- Delete performance
- View all performances

Fields:
- Code
- Title
- Main Actor
- Venue
- Date

---

### 🎵 Music Performances
- Add new performance
- Edit existing performance
- Delete performance
- View all performances

Fields:
- Code
- Title
- Singer
- Venue
- Date

---

### 👤 Customer Management
- Add customer
- Edit customer
- Delete customer
- View all customers

Fields:
- Customer Code
- Name

---

### 🎟 Ticket Reservations
- Reserve ticket for theatrical performance
- Reserve ticket for music performance
- Validation of customer & event existence
- Ticket count tracking

---

### 📊 Statistics
- Display ticket statistics per event
- Track total reservations per performance

---

## 🏗 Architecture & Design

The project follows Object-Oriented Programming principles:

- Encapsulation (private attributes + getters/setters)
- Separation of concerns (Models & Managers)
- Manager classes handle business logic
- Console-based menu navigation
- Input validation & exception handling
- File persistence using CSV format

Main structural components:

- `TheaterPlay`
- `MusicPerformance`
- `Customer`
- `Reservation`
- Manager classes for handling CRUD operations
- Main menu controller

---

## 💾 Data Persistence

All entities are stored in CSV files.

- Data is loaded at application startup
- Data is saved automatically on exit
- Ensures basic persistence without database usage

---

## ▶ How to Run

1. Open the project in IntelliJ IDEA (or any Java IDE)
2. Run the main class
3. Use the console menu to navigate between options

---

## 🛠 Technologies Used

- Java
- OOP principles
- ArrayList
- File I/O (CSV)
- Scanner for input handling

---

## 📈 Possible Future Improvements

- Database integration (JDBC)
- GUI implementation
- Unique ID auto-generation
- Logging system
- Layered architecture refactoring
- Unit testing

---

## 👨‍💻 My Contribution

- Designed the core application logic
- Implemented CRUD operations for all entities
- Developed manager-based structure
- Implemented CSV loading/saving functionality
- Designed menu navigation & application flow
- Implemented input validation and exception handling

---

## Author 

Panagiotis Zois, MSc ICT | Bridging Business & Technology
