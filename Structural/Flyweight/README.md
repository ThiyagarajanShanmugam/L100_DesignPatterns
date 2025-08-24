# Chess Game Pieces - Flyweight Pattern Explanation

## 🧩 The Problem

Imagine you're running an **online chess website** where thousands of people play chess at the same time:

- **Game 1** has 32 chess pieces (King, Queen, Pawns, etc.)
- **Game 2** has 32 chess pieces
- **Game 3** has 32 chess pieces
- ... **1000 games** = **32,000 chess pieces!**

If every piece is a separate object storing its own graphics, rules, and appearance, your computer runs out of memory! 😰

But wait... **all White Kings look exactly the same!** Why create 1000 different White King objects when you can have **1 White King design** used in 1000 different positions?

## 🎯 The Solution - Flyweight Pattern

We separate chess pieces into two parts:
- **Flyweight (shared)** = The piece type and appearance (King looks like a crown)
- **Context (unique)** = The piece's position and color (White King at position 4,0)

It's like having **1 King costume** that different actors wear in different scenes!

## 📋 Step-by-Step Code Explanation

### Step 1: The Flyweight Interface
```java
public interface ChessPieceFlyweight {
    void display(String color, int row, int col);
}
```
**Translation:** "Every chess piece flyweight must be able to display itself when given a color and position!"

### Step 2: Concrete Flyweights (The Shared Parts)
```java
class King implements ChessPieceFlyweight {
    public void display(String color, int row, int col) {
        System.out.println(color + " King at (" + row + "," + col + ")");
    }
}

class Pawn implements ChessPieceFlyweight {
    public void display(String color, int row, int col) {
        System.out.println(color + " Pawn at (" + row + "," + col + ")");
    }
}
```
**Translation:** "I'm a King flyweight! I know how to display a king when you tell me what color and position to use. I'm a Pawn flyweight! I know how to display a pawn when you give me the details!"

### Step 3: The Factory (The Smart Manager)
```java
public class ChessPieceFactory {
    private static Map<String, ChessPieceFlyweight> pieces = new HashMap<>();
    
    public static ChessPieceFlyweight getPiece(String type) {
        ChessPieceFlyweight piece = pieces.get(type);
        
        if (piece == null) {
            // Create only if doesn't exist
            if (type.equals("King")) piece = new King();
            else if (type.equals("Pawn")) piece = new Pawn();
            
            pieces.put(type, piece);
            System.out.println("Created new flyweight: " + type);
        } else {
            System.out.println("Reused flyweight: " + type);
        }
        return piece;
    }
}
```
**Translation:** "I'm the factory manager! When someone asks for a King, I check if I already made one. If yes, I give them the existing one. If no, I make a new one and remember it for next time!"

### Step 4: Using the Flyweights
```java
ChessPieceFlyweight whiteKing = ChessPieceFactory.getPiece("King");
ChessPieceFlyweight blackKing = ChessPieceFactory.getPiece("King");

whiteKing.display("White", 0, 4);  // Same flyweight, different context
blackKing.display("Black", 7, 4);  // Same flyweight, different context
```

## 🎭 The Magic Memory Saving

**Without Flyweight Pattern:**
```java
// Each piece is a separate object
ChessPiece whiteKing1 = new WhiteKing(0, 4);     // Stores position + graphics + rules
ChessPiece whiteKing2 = new WhiteKing(0, 4);     // Stores position + graphics + rules  
ChessPiece blackKing1 = new BlackKing(7, 4);     // Stores position + graphics + rules
ChessPiece blackPawn1 = new BlackPawn(6, 0);     // Stores position + graphics + rules
ChessPiece blackPawn2 = new BlackPawn(6, 1);     // Stores position + graphics + rules

// 5 objects = 5 × (graphics + rules + position) = LOTS of memory! 😰
```

**With Flyweight Pattern:**
```java
// Only 2 flyweight objects created for graphics and rules
ChessPieceFlyweight kingFlyweight = factory.getPiece("King");    // Graphics + rules
ChessPieceFlyweight pawnFlyweight = factory.getPiece("Pawn");    // Graphics + rules

// Position and color stored separately when displaying
kingFlyweight.display("White", 0, 4);  // Position passed as parameter
kingFlyweight.display("Black", 7, 4);  // Same flyweight, different position
pawnFlyweight.display("White", 6, 0);  // Same flyweight, different context
pawnFlyweight.display("Black", 6, 1);  // Same flyweight, different context

// 2 flyweight objects + separate context data = MUCH less memory! 🎉
```

## 🌟 The Magic Output Analysis

Looking at our output:
```
Created new flyweight: King    ← First King request creates flyweight
Reused flyweight: King         ← Second King request reuses same flyweight!
Created new flyweight: Pawn    ← First Pawn request creates flyweight  
Reused flyweight: Pawn         ← Second Pawn request reuses same flyweight!
Reused flyweight: Pawn         ← Third Pawn request reuses same flyweight!
```

**The Pattern in Action:**
- **5 chess pieces requested**
- **Only 2 flyweight objects created** (1 King + 1 Pawn)
- **3 objects reused** from the flyweight pool
- **Memory saved** = 60% less objects created!

## 💡 The Two Types of State

### **Intrinsic State (Shared - Inside Flyweight):**
- King appearance and graphics
- Pawn appearance and graphics  
- Chess piece behavior and rules
- **Stored once, used many times**

### **Extrinsic State (Unique - Passed as Parameters):**
- Piece color ("White" or "Black")
- Board position (row, col)
- **Stored separately for each piece**

## 🔄 Real-World Chess.com Example

When you play on Chess.com:

1. **Without Flyweight:** Every game would create 32 separate piece objects with their own graphics
   - 1000 games = 32,000 objects with duplicate graphics! 💥

2. **With Flyweight:** Chess.com creates 6 flyweight types (King, Queen, Rook, Bishop, Knight, Pawn)
   - 1000 games = 6 flyweight objects + position data
   - **Massive memory savings!** ✨

## 🎯 Key Insights Demonstrated

### 1. **Object Sharing**
```java
ChessPieceFlyweight king1 = factory.getPiece("King");
ChessPieceFlyweight king2 = factory.getPiece("King");
// king1 and king2 reference THE SAME OBJECT in memory!
```

### 2. **Context Separation**
```java
// Same flyweight, different contexts
king1.display("White", 0, 4);    // White King at bottom
king1.display("Black", 7, 4);    // Black King at top (same flyweight!)
```

### 3. **Memory Efficiency**
- **Traditional approach:** 5 pieces = 5 objects
- **Flyweight approach:** 5 pieces = 2 flyweight objects + 5 context calls
- **Memory reduction:** 60% fewer objects!

## 🏆 Real Gaming Applications

This exact pattern is used in:

- **Chess.com**: Millions of games, shared piece graphics
- **World of Warcraft**: Thousands of trees sharing same 3D models
- **Minecraft**: Millions of blocks sharing texture data
- **Google Maps**: Millions of location pins sharing icon graphics
- **Text Editors**: Thousands of characters sharing font data

## 📱 Why This Matters

Without Flyweight Pattern:
- **Chess website crashes** when too many people play simultaneously
- **Games lag** because too many duplicate objects in memory  
- **Apps become slow** due to memory pressure

With Flyweight Pattern:
- **Websites handle millions** of simultaneous users
- **Games run smoothly** with efficient memory usage
- **Apps stay responsive** by sharing common resources

**Remember:** When you have lots of similar objects, **share the common parts** and **separate the unique parts** - that's Flyweight Pattern magic! ♟️✨

---

```markdown
# Chess Game Pieces - Flyweight Pattern

## 📋 Overview

This project demonstrates the **Flyweight Design Pattern** using a chess game system. The pattern optimizes memory usage when you need many similar objects by sharing common data (intrinsic state) while keeping unique data (extrinsic state) separate. Instead of creating thousands of separate chess piece objects, we create a few flyweight types that are reused across multiple game instances.

## 🎯 Flyweight Pattern Explained

**Simple analogy:** Like a theater costume closet! Instead of every actor owning their own costume, they share costumes from a common wardrobe. One "King" costume can be worn by different actors in different scenes - you just change who's wearing it and where they stand on stage!

**What it does:** Shares common object data among multiple instances to dramatically reduce memory usage.

**Key benefit:** Handle millions of similar objects (like trees in a forest game or characters in a text editor) without running out of memory.

## 🏗️ Pattern Components

| Component | File | Role | Description |
|-----------|------|------|-------------|
| **Flyweight Interface** | `ChessPieceFlyweight.java` | Common Contract | Defines operations that flyweights can perform using extrinsic state |
| **Concrete Flyweights** | `King`, `Pawn` classes | Shared Objects | Store intrinsic state (appearance, behavior) shared among many pieces |
| **Flyweight Factory** | `ChessPieceFactory.java` | Object Manager | Creates and manages flyweight instances, ensures sharing |
| **Client** | `ChessDemo.java` | Pattern User | Uses flyweights with different extrinsic states (positions, colors) |

## 📁 Project Structure

```
DesignPatterns/
└── Structural/
    └── Flyweight/
        ├── README.md                    # This documentation
        ├── ChessPieceFlyweight.java     # Flyweight interface and concrete flyweights
        ├── ChessPieceFactory.java       # Factory managing flyweight instances
        └── ChessDemo.java              # Client demonstrating pattern usage
```

## ⚡ How to Run

### Prerequisites
- Java 8 or higher
- Command line or IDE

### Running the Application

```bash
# Navigate to Flyweight directory
cd DesignPatterns/Structural/Flyweight

# Compile all Java files
javac *.java

# Run the demonstration
java ChessDemo
```

## 📖 Expected Output

```
Chess Flyweight Pattern Demo
============================
Created new flyweight: King
Reused flyweight: King
Created new flyweight: Pawn
Reused flyweight: Pawn
Reused flyweight: Pawn

Displaying pieces:
White King at (0,4)
Black King at (7,4)
White Pawn at (1,0)
White Pawn at (1,1)
Black Pawn at (6,0)

Memory usage:
Total pieces used: 5
Flyweight objects created: 2
Memory saved by sharing flyweights!

Demo Complete!
```

## 🔍 Flyweight Pattern in Action

### The Memory Magic
```
Pieces Requested: 5
├── White King at (0,4)     ┐
├── Black King at (7,4)     ┼─── Share 1 King flyweight
├── White Pawn at (1,0)     ┐
├── White Pawn at (1,1)     ┼─── Share 1 Pawn flyweight  
└── Black Pawn at (6,0)     ┘

Flyweight Objects Created: 2 (instead of 5!)
Memory Savings: 60% reduction
```

### State Separation
```java
// Intrinsic State (stored in flyweight, shared)
- King appearance and graphics
- Pawn appearance and graphics  
- Chess piece behavior rules

// Extrinsic State (passed as parameters, unique per piece)
- Piece color ("White", "Black")
- Board position (row, col)
- Game context
```

## 🎯 Pattern Benefits Demonstrated

### 1. **Memory Efficiency**
```java
// Without Flyweight: Each piece is separate object
ChessPiece whiteKing = new WhiteKing(0, 4);  // Graphics + rules + position
ChessPiece blackKing = new BlackKing(7, 4);  // Graphics + rules + position
// 5 pieces = 5 complete objects = High memory usage

// With Flyweight: Shared graphics and rules
ChessPieceFlyweight kingFlyweight = factory.getPiece("King");
kingFlyweight.display("White", 0, 4);  // Same flyweight, different context
kingFlyweight.display("Black", 7, 4);  // Same flyweight, different context  
// 5 pieces = 2 flyweights + context data = Low memory usage
```

### 2. **Object Reuse**
- First King request: Creates new King flyweight
- Second King request: Reuses existing King flyweight
- Third King request: Reuses existing King flyweight
- **Same object in memory, different usage contexts**

### 3. **Scalability**
```java
// Scale to thousands of games
for (int game = 0; game < 1000; game++) {
    // Each game reuses same flyweights
    ChessPieceFlyweight king = factory.getPiece("King");
    king.display("White", 0, 4);  // Same flyweight across all games!
}
// 1000 games still use only 2 flyweight objects!
```

## 🌟 Real-World Applications

This same Flyweight pattern is used in:

- **Chess.com**: Millions of chess games sharing piece graphics
- **Google Maps**: Millions of location pins sharing icon images
- **Text Editors**: Thousands of characters sharing font data
- **Video Games**: Forest scenes with thousands of trees sharing 3D models
- **Web Browsers**: Font rendering across multiple pages
- **Social Media**: Emoji sharing across billions of messages

## 🆚 Memory Usage Comparison

### Without Flyweight Pattern (Memory Hog)
```
Game 1: 32 piece objects × (graphics + rules + position) = High memory
Game 2: 32 piece objects × (graphics + rules + position) = High memory  
Game 3: 32 piece objects × (graphics + rules + position) = High memory
...
1000 Games = 32,000 objects with duplicate graphics = CRASH! 💥
```

### With Flyweight Pattern (Memory Efficient)
```
All Games: 6 flyweight types (King, Queen, Rook, Bishop, Knight, Pawn)
+ Position data for each piece instance = Manageable memory
1000 Games = 6 flyweights + position contexts = Smooth operation! ✨
```

## 🔧 Flyweight Pattern Rules

### ✅ **Do This (Good Flyweight Design):**
```java
// Intrinsic state - stored in flyweight
public class King implements ChessPieceFlyweight {
    private String appearance = "♔";  // Shared among all kings
    
    public void display(String color, int row, int col) {
        // Use extrinsic state passed as parameters
        System.out.println(color + " " + appearance + " at (" + row + "," + col + ")");
    }
}
```

### ❌ **Don't Do This (Breaks Flyweight):**
```java
//Wrong - storing extrinsic state in flyweight
public class BadKing implements ChessPieceFlyweight {
    private String color;      // Don't store this - varies per instance!
    private int position;      // Don't store this - varies per instance!
    
    // This defeats the purpose of flyweight pattern!
}
```

## 🎮 Gaming Example

In a forest game with 10,000 trees:

**Without Flyweight:**
- 10,000 tree objects
- Each stores 3D model, texture, animation data
- Memory usage: 10,000 × (model + texture + animation) = Game crashes

**With Flyweight:**
- 5 tree flyweight types (Oak, Pine, Birch, Maple, Willow)
- Each tree instance stores only position and size
- Memory usage: 5 × (model + texture) + 10,000 × (position + size) = Game runs smoothly

## 🚀 Key Takeaways

1. **Separate what changes from what doesn't change**
2. **Share common data (intrinsic state) among many objects**
3. **Pass unique data (extrinsic state) as method parameters**
4. **Use factory to ensure flyweights are shared, not duplicated**
5. **Perfect for scenarios with many similar objects**

## 💡 Remember

The Flyweight Pattern is like having a **smart library system**:
- Instead of everyone owning the same book (wasteful)
- The library has one copy that everyone can borrow (efficient)
- You just need to track who has it and where they're reading it

When you see applications handling **thousands or millions of similar objects** efficiently - that's Flyweight Pattern working behind the scenes! 📚✨

## 🎯 Learning Verification

After running this demo, you should understand:
- How flyweights share intrinsic state while extrinsic state varies
- Why factory pattern ensures flyweight objects are reused, not recreated
- How memory usage scales much better with flyweights
- When to use flyweight pattern in your own applications

This chess example perfectly demonstrates flyweight because chess pieces of the same type look identical - only their positions and colors differ!
```