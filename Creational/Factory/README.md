
# Transportation Booking System - Factory Pattern

## 📋 Overview

This project demonstrates the **Factory Method Design Pattern** using a transportation booking system. The Factory pattern allows the creation of objects (rides) without specifying the exact class of object that will be created.

## 🎯 Factory Pattern Explained

**What it does:**
> Defines an interface for creating an object, but lets subclasses decide which class to instantiate.

**Key benefits:**
- Decouples object creation from usage.
- Makes it easy to introduce new types without changing client code.

**Real-world analogy:**
When you book a ride (taxi, Uber, etc.), you don't care about the exact class of the vehicle—you just want a ride. The system decides which ride to provide.

## �️ Pattern Components

| Component         | File(s) / Folder         | Role                | Description |
|-------------------|-------------------------|---------------------|-------------|
| **Product**       | `product/Transportation.java` | Interface/base class | Defines the contract for all transportation types |
| **Concrete Products** | `product/TaxiRide.java`, `product/UberRide.java` | Implementations | Concrete ride types |
| **Factory**       | `factory/TransportationFactory.java` | Creator/factory | Decides which ride to instantiate |
| **Client/Demo**   | `demo/TransportationBookingDemo.java` | Pattern usage | Uses the factory to book rides |

## 🗂️ Project Structure

```
Factory/
  factory/   # Factory class for ride creation
  product/   # Ride interface and concrete ride types
  demo/      # Demo and client code
```

## 🚦 How It Works

1. **Client** (`TransportationBookingDemo.java`) asks the `TransportationFactory` for a ride by type (e.g., "taxi", "uber").
2. The **factory** creates and returns the appropriate ride object.
3. The client uses the ride object without knowing its concrete class.

## 🧩 Example Output

```
Transportation Booking System - Factory Pattern Demo
========================================

Booking a Taxi Ride...
Taxi Ride booked! Driver: John, Car: Toyota

Booking an Uber Ride...
Uber Ride booked! Driver: Alice, Car: Honda

Factory Pattern Demo Complete!
```

## 🛠️ How to Run

1. Open a terminal in the `DesignPatterns` directory.
2. Compile all Java files:
   ```
   javac Creational\Factory\product\*.java Creational\Factory\factory\*.java Creational\Factory\demo\*.java
   ```
3. Run the demo:
   ```
   java demo.TransportationBookingDemo
   ```

## 📚 Key Takeaways

- The Factory pattern decouples object creation from usage.
- It is ideal for scenarios where you want to introduce new types with minimal changes to client code.
- This example can be extended to add more ride types easily.