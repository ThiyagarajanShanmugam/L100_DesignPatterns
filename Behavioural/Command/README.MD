# Restaurant Ordering System - Command Pattern Explanation

## 🧩 The Problem (Like Explaining to a 5-Year-Old)

Imagine you're at a **fancy restaurant** and you want to order food:

**Without Command Pattern (Chaos):**
- You walk directly to the kitchen and tell the chef: "Make me a pizza!"
- Another customer pushes past you: "No, make my pasta first!"
- You argue with the chef about ingredients
- The chef gets confused about who ordered what
- No way to cancel orders or keep track of what was ordered
- Total chaos in the kitchen! 😰

**This creates problems:** Who ordered what? Can't cancel orders! Can't prepare orders in sequence!

## 🎯 The Solution - Command Pattern

Create a **professional restaurant system**:
- **You** (Customer) tell the **Waiter** what you want
- **Waiter** writes down your order on a **ticket** (Command)
- **Waiter** takes all order tickets to the **Kitchen**
- **Kitchen** prepares orders based on tickets in sequence
- **Orders can be modified or cancelled** using the tickets

**The magic:** The **order ticket** contains everything needed - what dish, for which table, special instructions! 🎫

## 📋 Step-by-Step Code Explanation

### Step 1: The Command Interface
```java
public interface Command {
    void execute();  // Do the action
    void undo();     // Undo the action
}
```
**Translation:** "Every command (order ticket) must be able to execute (send to kitchen) and undo (cancel order)!"

### Step 2: The Concrete Order Command
```java
public class OrderCommand implements Command {
    private Kitchen kitchen;  // Who will fulfill this order
    private String dish;      // What dish to make
    
    public void execute() {
        kitchen.prepare(dish);  // Tell kitchen to prepare this dish
    }
    
    public void undo() {
        kitchen.cancel(dish);   // Tell kitchen to cancel this dish
    }
}
```
**Translation:** "I'm an order ticket! I know which kitchen to send the order to and what dish to make. I can also cancel the order!"

### Step 3: The Kitchen (Receiver)
```java
public class Kitchen {
    public void prepare(String dish) {
        System.out.println("Kitchen preparing: " + dish);
    }
    
    public void cancel(String dish) {
        System.out.println("Kitchen cancelling: " + dish);
    }
}
```
**Translation:** "I'm the kitchen! I know how to prepare dishes and cancel orders. I just do what the order tickets tell me!"

### Step 4: The Waiter (Invoker)
```java
public class Waiter {
    private List<Command> orders = new ArrayList<>();  // Collection of order tickets
    
    public void takeOrder(Command order) {
        orders.add(order);  // Add order ticket to my list
    }
    
    public void serveOrders() {
        for (Command order : orders) {
            order.execute();  // Send each ticket to kitchen
        }
    }
}
```
**Translation:** "I'm the waiter! I collect order tickets from customers and send them all to the kitchen in sequence!"

## 🎭 The Magic Restaurant Flow

### **Step 1: Customer Places Orders**
```java
Kitchen kitchen = new Kitchen();
Waiter waiter = new Waiter();

Command pizzaOrder = new OrderCommand(kitchen, "Pizza");
Command pastaOrder = new OrderCommand(kitchen, "Pasta");

waiter.takeOrder(pizzaOrder);  // Waiter gets pizza order ticket
waiter.takeOrder(pastaOrder);  // Waiter gets pasta order ticket
```

**What happens:**
- Customer says "I want pizza" → Waiter creates pizza order ticket
- Customer says "I want pasta" → Waiter creates pasta order ticket  
- Waiter has collection: [Pizza Ticket, Pasta Ticket]

### **Step 2: Waiter Sends Orders to Kitchen**
```java
waiter.serveOrders();  // Waiter takes all tickets to kitchen
```

**What happens inside:**
```java
for (Command order : orders) {
    order.execute();  // Each ticket tells kitchen what to prepare
}
```

**Kitchen receives:**
```
Kitchen preparing: Pizza
Kitchen preparing: Pasta
```

### **Step 3: Customer Changes Mind**
```java
waiter.cancelLastOrder();  // Cancel the last order
```

**What happens:**
```java
Command lastOrder = orders.remove(orders.size() - 1);  // Remove pasta ticket
lastOrder.undo();  // Tell kitchen to cancel pasta
```

**Result:** `Kitchen cancelling: Pasta`

## 🌟 Why This is Amazing

### **Without Command Pattern (Direct Communication):**
```java
// Customer talks directly to kitchen - messy!
public class Customer {
    public void orderFood() {
        Kitchen kitchen = new Kitchen();
        kitchen.prepare("Pizza");  // Direct call to kitchen
        kitchen.prepare("Pasta");  // Another direct call
        
        // Problems:
        // - Customer must know about kitchen
        // - No way to queue orders
        // - No way to undo orders
        // - No tracking of what was ordered
    }
}
```

### **With Command Pattern (Professional Service):**
```java
// Customer uses waiter service - organized!
Command order = new OrderCommand(kitchen, "Pizza");
waiter.takeOrder(order);  // Waiter handles everything

// Benefits:
// - Customer doesn't deal with kitchen directly  
// - Orders queued and processed in sequence
// - Orders can be cancelled/modified
// - Full tracking of all orders
```

## 💡 Real McDonald's Example

### **McDonald's Order System:**
1. **Customer** tells **Cashier**: "I want Big Mac and fries"
2. **Cashier** creates **order ticket** with all details
3. **Order ticket** goes to **kitchen display**
4. **Kitchen** prepares food based on ticket
5. **Order can be cancelled** if customer changes mind before cooking starts

### **The Command Pattern in Action:**
- **Command:** Order ticket (contains items, customer number, special requests)
- **Invoker:** Cashier/POS system (manages tickets)
- **Receiver:** Kitchen (prepares food)
- **Client:** Customer (places order)

## 🔄 Command Pattern Benefits Shown

### 1. **Decoupling (Separation of Concerns)**
```java
// Customer doesn't know about kitchen
// Kitchen doesn't know about customers  
// Waiter coordinates between them
Customer → Waiter → Kitchen
```

### 2. **Undo Operations**
```java
waiter.cancelLastOrder();  // Easy to cancel
lastOrder.undo();          // Command knows how to undo itself
```

### 3. **Queue Management** 
```java
// Orders stored and processed in sequence
waiter.takeOrder(order1);  // First order
waiter.takeOrder(order2);  // Second order  
waiter.serveOrders();      // Process all in order
```

### 4. **Logging and Tracking**
```java
// All orders are tracked in the waiter's list
List<Command> orders = new ArrayList<>();  // Complete order history
```

## 🍕 Other Command Pattern Examples

### **TV Remote Control:**
- **Command:** PowerOn, VolumeUp, ChannelChange
- **Invoker:** Remote control
- **Receiver:** TV, Sound system
- **Benefit:** Same remote works with different devices

### **Text Editor Undo/Redo:**
- **Command:** TypeText, DeleteText, Bold, Italic
- **Invoker:** Editor application
- **Receiver:** Document
- **Benefit:** Can undo/redo any operation

### **Voice Assistant:**
- **Command:** "Turn on lights", "Play music", "Lock door"
- **Invoker:** Alexa/Google Home
- **Receiver:** Smart lights, Music system, Door lock
- **Benefit:** Same voice interface controls different devices

## 🎯 Command Pattern Magic Rules

### **The Command Should:**
- ✅ Know which receiver to call
- ✅ Know what method to call
- ✅ Store all necessary parameters
- ✅ Be able to undo the operation

### **The Invoker Should:**
- ✅ Store commands without knowing their details
- ✅ Execute commands when needed  
- ✅ Support un

### **The Receiver Should:**
- ✅ Know how to perform the actual work
- ✅ Not need to know about commands or invokers

## 🏪 Real Restaurant Workflow

**Olive Garden Restaurant:**
1. **Customer** orders "Chicken Parmigiana" 
2. **Waiter** writes order on ticket and assigns table number
3. **Ticket** goes to kitchen with all details (dish, table, special requests)
4. **Kitchen** prepares dish according to ticket
5. **If customer cancels** before cooking starts, ticket is voided
6. **Kitchen tracks** which orders are ready for which tables

**Command Pattern Elements:**
- **Command:** Order ticket with dish, table, special instructions
- **Invoker:** Waiter managing multiple orders
- **Receiver:** Kitchen fulfilling orders
- **Undo:** Cancelling orders before preparation starts

## 💭 Remember

The Command Pattern is like having a **professional intermediary service**:
- You don't handle tasks directly
- You create **task instructions** (commands)
- **Service coordinator** (invoker) manages when and how tasks are done
- **Task executor** (receiver) does the actual work
- Instructions can be **stored, queued, cancelled, or replayed**

When you see **remote controls**, **undo/redo functionality**, **task queues**, or **voice assistants** - that's Command Pattern making interactions smooth and manageable! 🎯✨

---

```markdown
# Restaurant Ordering System - Command Pattern

## 📋 Overview

This project demonstrates the **Command Design Pattern** using a restaurant ordering system. The pattern encapsulates requests as objects, allowing you to parameterize clients with different requests, queue operations, and support undo operations. Just like how restaurants use order tickets to manage food preparation efficiently!

## 🎯 Command Pattern Explained

**Simple analogy:** Like a restaurant waiter system! Instead of customers running directly to the kitchen to demand food, they tell the waiter their order. The waiter writes it on a ticket, takes it to the kitchen, and the kitchen prepares the food. The ticket can also be cancelled before cooking starts.

**What it does:** Wraps requests in objects that contain all information needed to execute the action, including the method to call, method arguments, and the object that owns the method.

**Key benefit:** Separates the object that invokes the operation from the object that performs it, enabling features like undo, queuing, and logging.

## 🏗️ Pattern Components

| Component | File | Role | Description |
|-----------|------|------|-------------|
| **Command Interface** | `Command.java` | Command Contract | Defines execute() and undo() methods all commands must implement |
| **Concrete Command** | `OrderCommand.java` | Specific Command | Encapsulates a food order with dish details and kitchen reference |
| **Receiver** | `Kitchen.java` | Action Performer | Knows how to prepare and cancel dishes |
| **Invoker** | `Waiter.java` | Command Manager | Stores commands, executes them, and handles cancellations |
| **Client** | `RestaurantDemo.java` | Pattern User | Creates commands and sets up the restaurant ordering workflow |

## 📁 Project Structure

```
DesignPatterns/
└── Behavioral/
    └── Command/
        ├── README.md          # This documentation
        ├── Command.java       # Command interface (execute/undo contract)
        ├── OrderCommand.java  # Concrete command (food order details)
        ├── Kitchen.java       # Receiver (prepares/cancels dishes)
        ├── Waiter.java        # Invoker (manages order queue)
        └── RestaurantDemo.java # Client (restaurant ordering demo)
```

## ⚡ How to Run

### Prerequisites
- Java 8 or higher
- Command line or IDE

### Running the Application

```bash
# Navigate to Command directory
cd DesignPatterns/Behavioral/Command

# Compile all Java files
javac *.java

# Run the demonstration
java RestaurantDemo
```

## 📖 Expected Output

```
Restaurant Ordering - Command Pattern Demo
=========================================
Waiter took order
Waiter took order
Waiter took order
Waiter serving all orders:
Kitchen preparing: Pizza
Kitchen preparing: Pasta
Kitchen preparing: Burger

Customer wants to cancel last order:
Kitchen cancelling: Burger
Demo Complete!
```

## 🔍 The Command Flow in Action

### Order Creation and Execution
```
1. Customer Request: "I want Pizza"
   ├── Create OrderCommand(kitchen, "Pizza")
   ├── Waiter stores command in order list
   └── Command contains: receiver=kitchen, dish="Pizza"

2. Waiter Processes Orders:
   ├── For each command in list
   ├── Call command.execute()
   └── Command tells kitchen.prepare("Pizza")

3. Kitchen Receives: prepare("Pizza")
   └── Kitchen preparing: Pizza
```

### Cancellation Flow
```
1. Customer Changes Mind: "Cancel last order"
   ├── Waiter removes last command from list
   ├── Call removed command.undo()
   └── Command tells kitchen.cancel("Burger")

2. Kitchen Receives: cancel("Burger")
   └── Kitchen cancelling: Burger
```

## 🎯 Pattern Benefits Demonstrated

### 1. **Decoupling (Separation of Concerns)**
```java
// Customer doesn't interact with kitchen directly
Customer → OrderCommand → Waiter → Kitchen
//        ↑ Command encapsulates the request
```

### 2. **Undo Operations**
```java
public void undo() {
    kitchen.cancel(dish); // Each command knows how to reverse itself
}
```
**Real Restaurant:** Orders can be cancelled before cooking starts

### 3. **Queue Management**
```java
// Orders stored and processed in sequence
private List<Command> orders = new ArrayList<>();
// Process all orders: waiter.serveOrders()
```
**Real Restaurant:** Kitchen processes orders in the order received

### 4. **Command Encapsulation**
```java
// Command contains everything needed to execute
private Kitchen kitchen; // WHO will do the work
private String dish;     // WHAT work to do
```

## 🌟 Real-World Applications

This same Command pattern is used in:

- **GUI Applications**: Button clicks, menu selections, toolbar actions
- **Text Editors**: Undo/Redo operations (Ctrl+Z, Ctrl+Y)
- **Remote Controls**: TV/Audio system control, smart home devices
- **Database Systems**: Transaction management, rollback operations  
- **Game Engines**: Player input handling, macro recording
- **Web Frameworks**: HTTP request handling, middleware processing
- **Voice Assistants**: "Turn on lights", "Play music" commands

## 🆚 Without vs With Command Pattern

### Without Command Pattern (Direct Coupling)
```java
public class Customer {
    public void orderFood() {
        Kitchen kitchen = new Kitchen();
        kitchen.prepare("Pizza");  // Direct call - tightly coupled
        kitchen.prepare("Pasta");  // No undo capability
        
        // Problems:
        // - Customer must know kitchen interface
        // - No queuing or sequencing
        // - No undo operations
        // - Hard to add logging/monitoring
    }
}
```

### With Command Pattern (Flexible & Extensible)
```java
public class Customer {
    public void orderFood() {
        Command order = new OrderCommand(kitchen, "Pizza");
        waiter.takeOrder(order);  // Loose coupling
        
        // Benefits:
        // - Customer doesn't know kitchen details
        // - Orders can be queued, logged, undone
        // - Easy to add new command types
        // - Professional service workflow
    }
}
```

## 🔧 Command Pattern Extensions

### Adding Order Modification
```java
public class ModifyOrderCommand implements Command {
    private Kitchen kitchen;
    private String oldDish, newDish;
    
    public void execute() {
        kitchen.cancel(oldDish);
        kitchen.prepare(newDish);
    }
    
    public void undo() {
        kitchen.cancel(newDish);
        kitchen.prepare(oldDish);
    }
}
```

### Adding Macro Commands (Combo Meals)
```java
public class ComboMealCommand implements Command {
    private List<Command> commands;
    
    public void execute() {
        for (Command cmd : commands) {
            cmd.execute(); // Execute all commands in combo
        }
    }
}
```

## 🚀 Key Command Pattern Rules

### ✅ **Do This (Good Command Design):**
```java
// Command contains all info needed for execution
public class OrderCommand implements Command {
    private Kitchen kitchen;  // Receiver reference
    private String dish;      // Action parameters
    
    public void execute() {
        kitchen.prepare(dish);  // Delegate to receiver
    }
}
```

### ❌ **Don't Do This (Breaks Command Pattern):**
```java
// Don't put business logic in command
public void execute() {
    // Wrong: Command shouldn't know cooking details
    ingredients = getIngredients(dish);
    cookingTime = calculateTime(dish);
    kitchen.cookWithDetails(ingredients, cookingTime);
}
```

## 💡 McDonald's Real Example

**McDonald's POS System:**

**Order Taking:**
1. Customer: "Big Mac combo, no pickles"
2. Cashier creates order command with details
3. Order appears on kitchen display screen

**Order Processing:**  
1. Kitchen sees: "Big Mac, no pickles, with fries and drink"
2. Kitchen prepares items according to order
3. Order marked complete when ready

**Order Modification:**
1. Customer: "Actually, make that a Quarter Pounder"
2. If not started cooking: modify order command
3. If already cooking: create new order, void old one

**Command Elements:**
- **Command**: Order with item details, customer number, modifications
- **Invoker**: POS system managing order queue
- **Receiver**: Kitchen preparing food
- **Undo**: Voiding orders before preparation starts

## 🎯 Learning Takeaway

After running this demo, you should understand:
- How commands encapsulate requests with all necessary information
- Why decoupling invoker from receiver provides flexibility
- How undo operations work through command reversibility  
- When to use Command pattern in your own applications

## 💭 Remember

The Command Pattern is like having **smart instruction cards**:
- Each card contains **complete instructions** for a task
- Cards can be **stored, sorted, and executed later**
- Cards can be **cancelled or undone** if needed
- **Task performers** just follow the cards without knowing who created them

When you see **undo/redo buttons**, **remote controls**, **voice commands**, or **task queues** - that's Command Pattern making complex operations simple and manageable! 🎯🍽️✨

This restaurant example perfectly demonstrates how professional service industries use systematic approaches to manage customer requests efficiently while maintaining flexibility and accountability!
```