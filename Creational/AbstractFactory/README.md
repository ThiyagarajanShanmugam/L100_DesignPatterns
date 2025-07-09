
# Indian Restaurant Menu System - Abstract Factory Pattern

## 📋 Overview

This project demonstrates the **Abstract Factory Design Pattern** using an Indian restaurant menu system. The pattern creates families of related menu items from different Indian regional cuisines (North Indian vs South Indian), ensuring that all items in a meal come from the same regional cuisine and complement each other.

## 🎯 Abstract Factory Pattern Explained

**What it does:**
> Creates families of related objects (menu items) without specifying their concrete classes.

**Key difference from Factory Method:**
- Factory Method creates **one type** of object
- Abstract Factory creates **families** of related objects that work together

**Real-world analogy:**
An Indian restaurant kitchen that can prepare complete meals from different regional cuisines, ensuring all dishes in a meal belong to the same regional family and have complementary flavors.

## 🏗️ Pattern Components

| Component            | File(s) / Folder                | Role                  | Description |
|----------------------|---------------------------------|-----------------------|-------------|
| **Abstract Products**| `product/MenuItem.java`         | Product Interface     | Defines Appetizer, MainCourse, Dessert base classes |
| **Concrete Products**| `cuisine/NorthIndian*`, `cuisine/SouthIndian*` | Product Implementations | Specific menu items for each regional cuisine |
| **Abstract Factory** | `factory/MenuFactory.java`      | Factory Interface     | Declares methods to create each product type |
| **Concrete Factories**| `factory/NorthIndianMenuFactory.java`, `factory/SouthIndianMenuFactory.java` | Factory Implementations | Creates specific regional cuisine families |
| **Factory Producer** | `demo/RestaurantDemo.java`      | Factory Selector      | Decides which factory to use based on cuisine |
| **Client**           | `demo/RestaurantDemo.java`      | Pattern Usage         | Uses factories to create complete regional meals |

## �️ Project Structure

```
AbstractFactory/
  factory/   # Abstract and concrete factory classes
  product/   # Abstract and base product classes
  cuisine/   # Concrete menu item implementations for each cuisine
  demo/      # Demo and client code
```

## 🚦 How It Works

1. **Client** (`RestaurantDemo.java`) asks the `MenuFactoryProducer` for a factory based on cuisine (e.g., "northindian").
2. The **factory** (e.g., `NorthIndianMenuFactory`) creates a family of related menu items: Appetizer, MainCourse, Dessert.
3. The client uses these products to display and process a complete meal order.

## 🧩 Example Output

```
Indian Restaurant - Abstract Factory Pattern Demo
===========================================

=== NORTH INDIAN RESTAURANT ===
Processing order...
Preparing crispy samosas with spiced potato filling
Cooking tender chicken in rich tomato and butter gravy
Preparing soft milk-solid balls soaked in rose-flavored syrup

Order Summary:
=== COMPLETE MENU ===
Appetizer: Samosa - $4.99
Main Course: Butter Chicken - $12.99
Dessert: Gulab Jamun - $5.99
Total: $23.97

=== SOUTH INDIAN RESTAURANT ===
Processing order...
Deep frying fermented lentil donuts with coconut chutney
Making crispy rice crepe with spiced potato filling
Simmering rice, milk, and jaggery with cardamom and nuts

Order Summary:
=== COMPLETE MENU ===
Appetizer: Medu Vada - $4.49
Main Course: Masala Dosa - $8.99
Dessert: Payasam - $4.99
Total: $18.47

Abstract Factory Pattern Demo Complete!
```

## 🛠️ How to Run

1. Open a terminal in the `DesignPatterns` directory.
2. Compile all Java files:
   ```
   javac Creational\AbstractFactory\product\*.java Creational\AbstractFactory\cuisine\*.java Creational\AbstractFactory\factory\*.java Creational\AbstractFactory\demo\*.java
   ```
3. Run the demo:
   ```
   java Creational.AbstractFactory.demo.RestaurantDemo
   ```

## 📚 Key Takeaways

- Abstract Factory lets you create families of related objects without binding your code to their concrete classes.
- It is ideal for scenarios where products must be used together and you want to enforce consistency among them (e.g., all menu items from the same cuisine).
- This example can be extended to add more cuisines or menu categories with minimal changes to client code.
