# Logger Service - Singleton Pattern (Enum)

## 📋 Overview

This project demonstrates the **Singleton Design Pattern** using a simple logger service. The Singleton pattern ensures that a class has only one instance and provides a global point of access to it. Here, the implementation uses a Java `enum` for a robust, thread-safe singleton.

## 🎯 Singleton Pattern Explained

**What it does:**
> Guarantees that only one instance of a class exists in the application, and provides a global access point to it.

**Key benefits:**
- Controls access to shared resources (e.g., logging, configuration).
- Ensures consistency and avoids resource conflicts.
- Enum-based singleton is simple, thread-safe, and protects against serialization and reflection attacks.

**Real-world analogy:**
A logging service in an application: you want all parts of your app to use the same logger instance for consistent logging.

## 🏗️ Pattern Components

| Component         | File(s) / Folder         | Role                | Description |
|-------------------|-------------------------|---------------------|-------------|
| **Singleton**     | `Logger.java`           | The single instance | Provides logging methods (info, error, debug) |
| **Client/Demo**   | `Main.java`             | Pattern usage       | Uses the singleton logger from different parts of the app |

## 🗂️ Project Structure

```
Singleton/
  Logger.java   # Enum-based singleton logger
  Main.java     # Demo and client code
```

## 🚦 How It Works

1. **Logger** is implemented as an enum with a single instance (`INSTANCE`).
2. Any part of the application can use `Logger.INSTANCE` to log messages.
3. The demo shows different services using the logger and verifies the singleton property.

## 🧩 Example Output

```
=== Simple Enum Singleton Demo ===

[INFO] User service started
[DEBUG] Processing user login
[INFO] Order service started
[ERROR] Order validation failed

Same instance? true
Logger1 hash: 12345678
Logger2 hash: 12345678
```

## 🛠️ How to Run

1. Open a terminal in the `DesignPatterns` directory.
2. Compile all Java files:
   ```
   javac Creational\Singleton\*.java
   ```
3. Run the demo:
   ```
   java Creational.Singleton.Main
   ```

## 📚 Key Takeaways

- The Singleton pattern ensures a class has only one instance and provides a global access point.
- Enum-based singletons are the recommended way in Java for simplicity and safety.
- Use Singleton for shared resources like loggers, configuration, or connection pools.
