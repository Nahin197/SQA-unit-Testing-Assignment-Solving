#Software Testing and Quality Assurance Assignment
Here is a **clean, professional, GitHub-ready README.md** you can **directly copy–paste** into your repository.
It is written clearly, academically, and matches your project exactly.

---

# 🚗 Parking Slot Booking System

### *Unit Testing with Intentional Defects (Java)*

## 📘 Project Overview

This project is a **Parking Slot Booking System** developed for the course **Software Testing & Quality Assurance (CSE 4495)**.
The main goal of this project is to **apply unit testing techniques**, identify **software defects**, and analyze system behavior under different scenarios.

⚠️ **Important:**
This project intentionally contains **logical and validation defects** to demonstrate how unit testing helps detect real-world issues.

---

## 🧠 Key Concepts Covered

* Unit Testing using **JUnit**
* Software defect identification
* Input validation testing
* Boundary value analysis
* Exception handling
* Business rule verification
* Object-oriented design testing

---

## 🏗 System Architecture

### Main Components

| Component         | Description                                 |
| ----------------- | ------------------------------------------- |
| **Wallet**        | Manages balance and money transfer          |
| **Vehicle**       | Represents a vehicle with wallet            |
| **ParkingSlot**   | Represents a parking space                  |
| **Booking**       | Manages booking lifecycle                   |
| **ParkingSystem** | Core controller                             |
| **Enums**         | VehicleType, ParkingSlotType, BookingStatus |

---

## 🔄 System Workflow

1. Vehicle requests a parking slot
2. System checks:

   * Slot availability
   * Time validity
   * Vehicle compatibility
3. Booking is created
4. Payment is transferred to system wallet
5. Booking is either:

   * **Completed** → 80% paid to slot owner
   * **Cancelled** → 90% refunded to vehicle

---

## 💰 Pricing Logic

```
Price = Hours × BaseRate × VehicleMultiplier × SlotMultiplier
```

### Vehicle Multipliers

| Vehicle Type | Multiplier         |
| ------------ | ------------------ |
| Bicycle      | 0.2                |
| Motorcycle   | 0.5                |
| Car          | 1.0                |
| Microcar     | ❌ Missing (Defect) |
| Bus          | 2.0                |
| Truck        | 3.0                |

### Slot Multipliers

| Slot Type   | Multiplier |
| ----------- | ---------- |
| Compact     | 0.8        |
| Regular     | 1.0        |
| Large       | 1.5        |
| Handicapped | 1.2        |

---

## 🧪 Testing Summary

### ✅ Passed Tests

* Wallet balance operations
* Booking creation
* Slot availability
* Overlapping time detection
* Booking completion
* Refund processing
* Singleton behavior

### ❌ Failed Tests (Intentional Defects)

| Issue                | Description         |
| -------------------- | ------------------- |
| Negative balance     | Not validated       |
| Null object handling | Missing checks      |
| Zero amount booking  | Allowed incorrectly |
| Cancel → Complete    | Not restricted      |
| MICROCAR pricing     | Missing case        |
| Time validation      | Weak validation     |
| Double payment       | Possible            |
| Null slot / vehicle  | Not handled         |

---

## 🐞 Major Defects Identified

* ❌ No null checks in constructors
* ❌ Negative and zero values accepted
* ❌ Booking lifecycle not enforced
* ❌ Missing MICROCAR pricing
* ❌ Double transaction possible
* ❌ Improper exception handling

---

## 🛠 Suggested Improvements

✔ Add input validation
✔ Enforce booking state rules
✔ Add null safety
✔ Fix pricing logic
✔ Prevent double payment
✔ Improve exception handling
✔ Validate time ranges strictly

---

## 🧪 Testing Tools Used

* **JUnit 5**
* **IntelliJ IDEA**
* **Java 17**

---

## 📁 Project Structure

```
📦 ParkingSystem
 ┣ 📂 src
 ┃ ┣ Wallet.java
 ┃ ┣ Vehicle.java
 ┃ ┣ ParkingSlot.java
 ┃ ┣ Booking.java
 ┃ ┣ ParkingSystem.java
 ┃ ┣ Enums/
 ┣ 📂 test
 ┃ ┣ WalletTest.java
 ┃ ┣ VehicleTest.java
 ┃ ┣ BookingTest.java
 ┃ ┣ ParkingSlotTest.java
 ┃ ┣ ParkingSystemTest.java
 ┣ README.md
```

---

## 🎯 Learning Outcome

This project helped in understanding:

✔ Unit testing practices
✔ Real-world bug detection
✔ Importance of validation
✔ Exception handling
✔ Software quality assurance
✔ Test-driven thinking

---

## 👨‍🎓 Author

**Course:** Software Testing & Quality Assurance
**Project Type:** Academic Assignment
**Language:** Java
**Testing Framework:** JUnit

---

If you want, I can also:
✅ Format this for **GitHub Markdown preview**
✅ Add **badges (JUnit, Java)**
✅ Create a **report version (PDF)**
✅ Add **screenshots explanation**

Just tell me 👍

