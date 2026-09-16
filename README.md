---
# 🚗 Parking Slot Booking System

### *Software Testing & Quality Assurance – Solved Assignment*

![Java](https://img.shields.io/badge/Java-17-blue)
![JUnit](https://img.shields.io/badge/JUnit-5-green)
![Status](https://img.shields.io/badge/Assignment-Solved-success)
![Type](https://img.shields.io/badge/Project-Academic-orange)

---

## 📘 Project Overview

This repository contains the **solved version of an academic assignment** given in the course
**Software Testing & Quality Assurance (CSE 4495)**.

The assignment was provided by the course instructor, and **this project was solved collaboratively by me and my teammate** as part of the course requirement.

The work includes:

* Unit test implementation
* Defect identification
* System behavior analysis
* Documentation of issues and fixes

✅ **All code, testing, and analysis in this repository were completed by our team.**

---
## 📋 Test Case Study (PDF)

The file **`Test Case/SQ_Test Case Studies.pdf`** contains a formal system test report with.

📄 **[View Test Case Report on Google Drive](https://drive.google.com/file/d/1LfmjJBQvHKTpEdjYXu3LhkV48UNMIoaO/view?usp=drive_link)**

- **Test Plan** — Input/parameter choices per endpoint and expected outputs
- **Test Cases Table** — Test ID, Class.Method, Why this test, Verdict, Comment/Observations
- **Defect Reports** — Defect ID, Class.Method, Description, Suggested Fix

---

## 🎯 Assignment Objectives

The main objectives of this assignment were to:

* Apply **unit testing using JUnit**
* Identify **logical and runtime defects**
* Analyze **real-world business logic**
* Understand **software quality assurance practices**
* Improve debugging and testing skills

---

## 🧠 What We Solved in This Project

✔ Implemented all required unit tests
✔ Executed test cases for all modules
✔ Identified intentional and logical defects
✔ Verified booking, wallet, and slot logic
✔ Documented issues and expected behavior
✔ Successfully completed the assignment as a team

---

## 🧩 System Components

| Component         | Description                          |
| ----------------- | ------------------------------------ |
| **Wallet**        | Manages balance and transactions     |
| **Vehicle**       | Represents a vehicle                 |
| **ParkingSlot**   | Represents parking spaces            |
| **Booking**       | Handles booking lifecycle            |
| **ParkingSystem** | Core system controller               |
| **Enums**         | VehicleType, SlotType, BookingStatus |

---

## 🔄 System Workflow

1. Vehicle requests a parking slot
2. System validates:

   * Time range
   * Slot availability
   * Vehicle compatibility
3. Booking is created
4. Payment is deducted
5. Booking is either:

   * **Completed** → Slot owner receives payment
   * **Cancelled** → Partial refund is issued

---

## 💰 Pricing Logic

```
Price = Duration × Base Rate × Vehicle Multiplier × Slot Multiplier
```

### Vehicle Pricing

| Vehicle    | Multiplier                    |
| ---------- | ----------------------------- |
| Bicycle    | 0.2                           |
| Motorcycle | 0.5                           |
| Car        | 1.0                           |
| Microcar   | ❌ Missing (Defect Identified) |
| Bus        | 2.0                           |
| Truck      | 3.0                           |

---

## 🧪 Testing Summary

### ✅ Successfully Tested

* Wallet operations
* Booking creation
* Slot availability
* Time validation
* Booking completion
* Cancellation logic

### ❌ Defects Identified

* Missing null validation
* Negative values allowed
* Zero-amount booking accepted
* Missing MICROCAR pricing
* Booking state violations
* Weak exception handling

> These defects were **intentionally identified and documented as part of the assignment solution.**

---

## 🐞 Major Issues Found

| Issue            | Description               |
| ---------------- | ------------------------- |
| Null handling    | Missing null checks       |
| Negative balance | Accepted incorrectly      |
| Zero booking     | Causes logic errors       |
| State violation  | Cancel → Complete allowed |
| Pricing bug      | MICROCAR not handled      |
| Validation       | Weak input validation     |

---

## 🛠 Suggested Improvements

✔ Add strict input validation
✔ Enforce booking lifecycle rules
✔ Prevent double transactions
✔ Improve exception handling
✔ Fix pricing logic
✔ Strengthen time validation

---

## 🧪 Tools & Technologies Used

* **Java 17**
* **JUnit 5**
* **IntelliJ IDEA**
* **Git & GitHub**

---

## 📁 Project Structure

```
SQA-unit-Testing-Assignment-Solving/
│
├── README.md
├── documentation.md
├── sqa-test-parking-system-master.iml
│
└── src/
    ├── Booking.java
    ├── BookingStatus.java
    ├── BookingTest.java
    ├── ParkingSlot.java
    ├── ParkingSlotTest.java
    ├── ParkingSlotType.java
    ├── ParkingSystem.java
    ├── ParkingSystem2.java
    ├── Vehicle.java
    ├── VehicleTest.java
    ├── VehicleType.java
    ├── Wallet.java
    ├── WalletTest.java
```

---

## 🎓 Academic Declaration

✔ This assignment was provided by the course instructor
✔ The solution was completed **collaboratively by me and my teammate**
✔ All testing and analysis were done by our team
✔ This repository is for **academic and learning purposes only**

---

## 👨‍🎓 Authors

* **Student 1:** *Md. Khademul Islam Nahin*
* **Student 2:** *Md. Abdullah Al Imran*
* **Course:** Software Testing & Quality Assurance
* **University:** United International University

---




