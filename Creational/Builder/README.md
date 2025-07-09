# House Construction System - Builder Pattern

## 📋 Overview

This project demonstrates the **Builder Design Pattern** using a house construction system. The Builder pattern allows step-by-step construction of complex objects (houses) with varying configurations, separating the construction process from the final representation.

## 🎯 Builder Pattern Explained

**What it does:**  
> Separates the construction of a complex object from its representation, allowing the same construction process to create different representations.

**Key benefits:**  
- Enables step-by-step construction and customization.
- Hides the construction logic from the client.
- Supports different representations (house types) with the same building process.

**Real-world analogy:**  
A construction company can build different types of houses (basic, family, luxury) by following different sequences of steps, but the process is always controlled by a builder.

## 🏗️ Pattern Components

| Component         | File(s) / Folder         | Role                | Description |
|-------------------|-------------------------|---------------------|-------------|
| **Builder**       | `builder/HouseBuilder.java` | Step-by-step builder | Provides methods to construct parts of a house and returns the final product |
| **Product**       | `product/House.java`    | Complex object      | The house being built, with many optional features |
| **Client/Demo**   | `demo/HouseConstructionDemo.java` | Pattern usage        | Uses the builder to construct various house types |

## 🗂️ Project Structure

```
Builder/
  builder/   # Builder class for step-by-step construction
  product/   # House class (the product)
  demo/      # Demo and client code
```

## 🚦 How It Works

1. **Client** (`HouseConstructionDemo.java`) creates a `HouseBuilder`.
2. The builder provides fluent methods to add features (foundation, walls, rooms, etc.).
3. The client calls `build()` to get the final `House` object.
4. The house can be displayed or queried for its type.

## 🧩 Example Output

```
House Construction System - Builder Pattern Demo
===============================================

=== BUILDING LUXURY VILLA ===
Building Reinforced Concrete foundation...
Constructing Brick and Stone walls...
Installing Clay Tiles roof...
Adding 6 rooms...
Building garage...
Landscaping garden...
Building swimming pool...
Painting house: Cream White
=== HOUSE CONSTRUCTION COMPLETE ===
Foundation: Reinforced Concrete
Walls: Brick and Stone
Roof: Clay Tiles
Rooms: 6
Garage: Yes
Garden: Yes
Swimming Pool: Yes
Paint Color: Cream White
=====================================
House Type: Luxury Villa

=== BUILDING FAMILY HOME ===
... (similar output for other house types)
```

## 🛠️ How to Run

1. Open a terminal in the `DesignPatterns` directory.
2. Compile all Java files:
   ```
   javac Creational\Builder\product\*.java Creational\Builder\builder\*.java Creational\Builder\demo\*.java
   ```
3. Run the demo:
   ```
   java demo.HouseConstructionDemo
   ```

## 📚 Key Takeaways

- The Builder pattern is ideal for constructing complex objects with many optional parts.
- It provides a fluent, readable API for object construction.
- The construction process is decoupled from the final product, making it easy to extend and maintain.
