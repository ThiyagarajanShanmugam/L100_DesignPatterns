# Photo Editing Software - Memento Pattern Explanation

## 🧩 The Problem (Like Explaining to a 5-Year-Old)

Imagine you're editing a **photo on Instagram** and making it look perfect:

**Without Memento Pattern (Photo Disaster):**
- You apply a **vintage filter** → Photo looks good! 
- You increase **brightness** → Still looks great!
- You add a **blur effect** → Oh no, it looks terrible! 😱
- You want to go back to before the blur, but you can't!
- You have to start over completely from the original photo
- All your previous work (vintage filter + brightness) is lost forever! 💔

**This is frustrating:** No way to undo just the last change!

## 🎯 The Solution - Memento Pattern

Create a **photo editing app with "Save Points"**:
- **Before each edit**, take a **snapshot** (memento) of current photo state
- **Apply your edit** (filter, brightness, effect)
- **If you don't like it**, press **UNDO** to restore the previous snapshot
- **Keep multiple snapshots** so you can undo multiple steps
- **Never lose your work** - always can go back to any previous state! ✨

**The magic:** Each snapshot remembers **exactly how the photo looked** at that moment!

## 📋 Step-by-Step Code Explanation

### Step 1: The Photo Editor (Originator)
```java
public class PhotoEditor {
    private String filter = "None";
    private int brightness = 50;
    private String effect = "None";
    
    // Create a snapshot of current photo state
    public PhotoMemento createMemento() {
        return new PhotoMemento(imageName, filter, brightness, effect);
    }
    
    // Restore photo to a previous state
    public void restoreFromMemento(PhotoMemento memento) {
        this.filter = memento.getFilter();
        this.brightness = memento.getBrightness();
        this.effect = memento.getEffect();
    }
}
```
**Translation:** "I'm the photo editor! I can take snapshots of how I currently look, and I can restore myself to any previous snapshot!"

### Step 2: The Photo Snapshot (Memento)
```java
public class PhotoMemento {
    private final String filter;      // Saved filter state
    private final int brightness;     // Saved brightness state  
    private final String effect;      // Saved effect state
    
    public PhotoMemento(String imageName, String filter, int brightness, String effect) {
        this.filter = filter;         // Store current filter
        this.brightness = brightness; // Store current brightness
        this.effect = effect;         // Store current effect
    }
}
```
**Translation:** "I'm a photo snapshot! I remember exactly what filter, brightness, and effect the photo had at this moment!"

### Step 3: The History Manager (Caretaker)
```java
public class EditHistory {
    private Stack<PhotoMemento> history = new Stack<>();  // Stack of snapshots
    
    public void saveState(PhotoMemento memento) {
        history.push(memento);  // Add snapshot to history
    }
    
    public PhotoMemento undo() {
        return history.pop();   // Get last snapshot and remove from history
    }
}
```
**Translation:** "I'm the history manager! I keep all the photo snapshots in order. When you want to undo, I give you the most recent snapshot!"

## 🎭 The Magic Photo Editing Flow

### **Step 1: Original Photo**
```java
PhotoEditor editor = new PhotoEditor("vacation_photo.jpg");
// Photo state: Filter=None, Brightness=50, Effect=None
```

### **Step 2: Save Initial State**
```java
history.saveState(editor.createMemento());
// History now contains: [Snapshot1(None, 50, None)]
```

### **Step 3: Apply Vintage Filter**
```java
editor.applyFilter("Vintage");
// Photo state: Filter=Vintage, Brightness=50, Effect=None

history.saveState(editor.createMemento());
// History now contains: [Snapshot1(None, 50, None), Snapshot2(Vintage, 50, None)]
```

### **Step 4: Increase Brightness**
```java
editor.setBrightness(80);  
// Photo state: Filter=Vintage, Brightness=80, Effect=None

history.saveState(editor.createMemento());
// History: [Snapshot1, Snapshot2, Snapshot3(Vintage, 80, None)]
```

### **Step 5: Add Blur Effect (Oops, looks bad!)**
```java
editor.applyEffect("Blur");
// Photo state: Filter=Vintage, Brightness=80, Effect=Blur
// User doesn't like this - wants to undo!
```

### **Step 6: User Presses UNDO**
```java
PhotoMemento lastState = history.undo();  // Gets Snapshot3(Vintage, 80, None)
editor.restoreFromMemento(lastState);     // Restore photo to that state

// Photo restored to: Filter=Vintage, Brightness=80, Effect=None
// Blur effect is gone, but vintage filter and brightness remain!
```

## 🌟 Why This is Amazing

### **Without Memento Pattern (Photoshop Nightmare):**
```java
public class BadPhotoEditor {
    private String filter, effect;
    private int brightness;
    
    public void undoLastEdit() {
        // How do we know what the last edit was?
        // How do we restore to previous state?
        // We'd need complex tracking of every single change!
        
        filter = ???;      // Don't know what it was before
        brightness = ???;  // Don't know previous value  
        effect = ???;      // Lost forever!
        
        // Result: Can't implement undo - must start over!
    }
}
```

### **With Memento Pattern (Instagram Magic):**
```java
public class SmartPhotoEditor {
    public void undoLastEdit() {
        PhotoMemento lastState = history.undo();        // Get previous snapshot
        restoreFromMemento(lastState);                  // Restore to exact state
        
        // Perfect! Photo restored to exactly how it was before last edit
    }
}
```

## 💡 Real Instagram/Photoshop Example

### **Instagram Story Editing:**
1. **Upload photo** → Auto-save original state
2. **Apply Valencia filter** → Save snapshot
3. **Increase brightness** → Save snapshot  
4. **Add text overlay** → Save snapshot
5. **User doesn't like text** → Press undo
6. **Photo restores** to state before text (but keeps filter + brightness)

### **Photoshop Professional Workflow:**
1. **Open image** → History panel shows initial state
2. **Adjust levels** → New history state created
3. **Apply blur** → New history state  
4. **Add layer effect** → New history state
5. **Designer changes mind** → Click any previous history state
6. **Image instantly restores** to that exact moment

## 🔄 Memento Pattern Benefits Shown

### 1. **State Encapsulation**
```java
// Memento stores complete state without exposing internals
PhotoMemento memento = editor.createMemento();  // All state captured
// Editor's private fields (filter, brightness, effect) remain private
```

### 2. **Perfect Restoration**
```java
// Restore to exact previous state
editor.restoreFromMemento(snapshot);
// Photo looks EXACTLY like it did when snapshot was taken
```

### 3. **Multiple Undo Levels**
```java
// Can undo multiple steps
PhotoMemento step1 = history.undo();  // Undo blur effect
PhotoMemento step2 = history.undo();  // Undo brightness change  
PhotoMemento step3 = history.undo();  // Undo vintage filter
// Each undo goes back one more step
```

### 4. **Non-Destructive Editing**
```java
// Original photo never modified - only states change
// Can always go back to original or any intermediate state
```

## 📸 Other Memento Pattern Examples

### **Microsoft Word:**
- **Document:** Text content with formatting
- **Memento:** Document snapshots after each edit
- **History:** Undo/Redo functionality (Ctrl+Z, Ctrl+Y)

### **Video Games:**
- **Game State:** Player level, items, location, progress
- **Memento:** Save game files
- **History:** Save slots, quicksave, checkpoint system

### **Code Editors:**
- **Code File:** Source code with current edits
- **Memento:** File snapshots after each change
- **History:** Undo/Redo in VS Code, IntelliJ

## 🎯 Memento Pattern Magic Rules

### **The Originator Should:**
- ✅ Create mementos of its internal state
- ✅ Restore its state from mementos
- ✅ Control what state information is saved
- ✅ Keep internal structure private

### **The Memento Should:**
- ✅ Store immutable snapshots of originator state
- ✅ Only allow originator to access stored state
- ✅ Be lightweight and efficient to create
- ✅ Not expose originator's internal structure

### **The Caretaker Should:**
- ✅ Manage memento storage and retrieval
- ✅ Not modify or inspect memento contents
- ✅ Handle undo/redo logic and history limits
- ✅ Treat mementos as opaque objects

## 🎨 Adobe Creative Suite Real Workflow

**Photoshop Layer Editing:**
1. **Create new layer** → History state saved automatically
2. **Apply Gaussian blur** → New history state  
3. **Adjust opacity** → New history state
4. **Add color overlay** → New history state
5. **Artist doesn't like result** → Click history state from step 2
6. **Image restores** to after blur but before opacity and overlay changes

**Memento Pattern Elements:**
- **Originator:** Photoshop document with all layers, effects, adjustments
- **Memento:** History panel states storing complete document snapshots
- **Caretaker:** History panel managing up to 1000 undo states
- **User Benefit:** Professional non-destructive editing workflow

**Advanced Features:**
- **Snapshots:** Manual save points for important states
- **History Brush:** Paint using pixels from any previous state
- **Non-linear History:** Jump to any state, not just sequential undo

## 💭 Remember

The Memento Pattern is like having a **time machine for objects**:
- **Take snapshots** at important moments
- **Travel back in time** when things go wrong
- **Restore perfect previous states** without losing encapsulation
- **Enable professional undo/redo** functionality

When you see **Ctrl+Z functionality**, **save game systems**, **version history**, or **checkpoint systems** - that's Memento Pattern letting you safely experiment and easily recover! 📸⏪✨

---

```markdown
# Photo Editing Software - Memento Pattern

## 📋 Overview

This project demonstrates the **Memento Design Pattern** using a photo editing software system. The pattern provides the ability to restore an object to its previous state without violating encapsulation, enabling undo functionality. Just like how Instagram or Photoshop lets you undo edits and return to previous versions of your photo!

## 🎯 Memento Pattern Explained

**Simple analogy:** Like taking a photograph of your LEGO castle before adding more pieces. If you mess up the castle, you can look at the photo and rebuild it exactly as it was before. The photo (memento) remembers the exact state without changing your building process.

**What it does:** Captures and externalizes an object's internal state so the object can be restored to this state later, without violating encapsulation.

**Key benefit:** Enables undo/redo functionality and state restoration while keeping the object's internal structure private and secure.

## 🏗️ Pattern Components

| Component | File | Role | Description |
|-----------|------|------|-------------|
| **Originator** | `PhotoEditor.java` | State Owner | Photo editing object that creates and restores from mementos |
| **Memento** | `PhotoMemento.java` | State Snapshot | Immutable snapshot storing photo editor state at specific moment |
| **Caretaker** | `EditHistory.java` | State Manager | Manages collection of mementos and handles undo operations |
| **Client** | `PhotoEditingDemo.java` | Pattern User | Demonstrates photo editing with save/restore functionality |

## 📁 Project Structure

```
DesignPatterns/
└── Behavioral/
    └── Memento/
        ├── README.md              # This documentation
        ├── PhotoEditor.java       # Originator (photo editing state)
        ├── PhotoMemento.java      # Memento (state snapshot)
        ├── EditHistory.java       # Caretaker (undo/redo manager)
        └── PhotoEditingDemo.java  # Client (photo editing simulation)
```

## ⚡ How to Run

### Prerequisites
- Java 8 or higher
- Command line or IDE

### Running the Application

```bash
# Navigate to Memento directory
cd DesignPatterns/Behavioral/Memento

# Compile all Java files
javac *.java

# Run the demonstration
java PhotoEditingDemo
```

## 📖 Expected Output

```
Photo Editing Software - Memento Pattern Demo
==============================================
📸 Original: Photo: vacation_photo.jpg | Filter: None | Brightness: 50 | Effect: None
✅ State saved to history

--- Applying Vintage Filter ---
📸 Current: Photo: vacation_photo.jpg | Filter: Vintage | Brightness: 50 | Effect: None
✅ State saved to history

--- Increasing Brightness ---
📸 Current: Photo: vacation_photo.jpg | Filter: Vintage | Brightness: 80 | Effect: None
✅ State saved to history

--- Adding Blur Effect ---
📸 Current: Photo: vacation_photo.jpg | Filter: Vintage | Brightness: 80 | Effect: Blur

--- User presses UNDO ---
↶ Undoing last edit
📸 After Undo: Photo: vacation_photo.jpg | Filter: Vintage | Brightness: 80 | Effect: None

--- User presses UNDO again ---
↶ Undoing last edit
📸 After Undo: Photo: vacation_photo.jpg | Filter: Vintage | Brightness: 50 | Effect: None

Memento Pattern Demo Complete! 📷
```

## 🔍 The Memento State Management in Action

### State Progression and Snapshots
```
1. Original Photo State:
   └── Filter: None, Brightness: 50, Effect: None
   └── Snapshot saved to history

2. Apply Vintage Filter:
   └── Filter: Vintage, Brightness: 50, Effect: None  
   └── New snapshot saved to history

3. Increase Brightness:
   └── Filter: Vintage, Brightness: 80, Effect: None
   └── New snapshot saved to history

4. Add Blur Effect (user doesn't like this):
   └── Filter: Vintage, Brightness: 80, Effect: Blur
   └── No snapshot saved yet

5. User Undos:
   └── Restore to: Filter: Vintage, Brightness: 80, Effect: None
   └── Blur effect removed, previous edits preserved
```

### Memento Creation and Restoration Flow
```
PhotoEditor State Change:
├── editor.applyFilter("Vintage")
├── memento = editor.createMemento()  // Capture current state
├── history.saveState(memento)        // Store in history
└── Continue editing...

User Undo Operation:
├── lastMemento = history.undo()      // Retrieve last snapshot
├── editor.restoreFromMemento(lastMemento)  // Restore state
└── Photo returns to exact previous appearance
```

## 🎯 Pattern Benefits Demonstrated

### 1. **Encapsulation Preservation**
```java
// PhotoEditor's internal state remains private
private String filter;
private int brightness;
private String effect;

// Memento provides controlled access without exposing internals
public PhotoMemento createMemento() {
    return new PhotoMemento(imageName, filter, brightness, effect);
}
```

### 2. **Perfect State Restoration**
```java
// Restore to exact previous state
public void restoreFromMemento(PhotoMemento memento) {
    this.filter = memento.getFilter();
    this.brightness = memento.getBrightness();
    this.effect = memento.getEffect();
    // Photo looks exactly as it did when memento was created
}
```

### 3. **Multiple Undo Levels**
```java
// Stack-based history allows multiple undos
private Stack<PhotoMemento> history = new Stack<>();

// Each undo goes back one more step
PhotoMemento step1 = history.undo();  // Remove blur
PhotoMemento step2 = history.undo();  // Remove brightness change  
PhotoMemento step3 = history.undo();  // Remove filter
```

### 4. **Non-Destructive Editing**
```java
// Original state never lost - can always restore
// Snapshots are immutable - can't be accidentally modified
private final String filter;  // Final fields prevent modification
private final int brightness;
```

## 🌟 Real-World Applications

This same Memento pattern is used in:

- **Photo/Video Editors**: Photoshop, GIMP, Instagram, TikTok (undo/redo)
- **Text Editors**: Microsoft Word, Google Docs, VS Code (document history)
- **Gaming**: Save games, checkpoints, quicksave functionality  
- **Database Systems**: Transaction rollback, savepoints, recovery
- **Version Control**: Git commits, SVN revisions, backup systems
- **CAD Software**: AutoCAD, SolidWorks (design history, feature rollback)

## 🆚 Without vs With Memento Pattern

### Without Memento Pattern (Limited Undo)
```java
public class BasicPhotoEditor {
    private String lastFilter, lastEffect;
    private int lastBrightness;
    
    public void undoLastChange() {
        // Can only undo one step, and only if we manually tracked it
        this.filter = lastFilter;       // What if we made multiple changes?
        this.brightness = lastBrightness; // How do we know what was "last"?
        this.effect = lastEffect;       // Complex state tracking required
        
        // Problems:
        // - Only single level undo
        // - Manual state tracking for each property
        // - No way to undo multiple steps
        // - Breaks encapsulation with exposed state tracking
    }
}
```

### With Memento Pattern (Professional Undo)
```java
public class ProfessionalPhotoEditor {
    public void undoToAnyPreviousState() {
        PhotoMemento desiredState = history.undo();
        restoreFromMemento(desiredState);
        
        // Benefits:
        // - Multiple undo levels supported
        // - Complete state restoration
        // - Encapsulation maintained
        // - Clean, professional implementation
    }
}
```

## 🔧 Memento Pattern Extensions

### Adding Redo Functionality
```java
public class EditHistory {
    private Stack<PhotoMemento> undoHistory = new Stack<>();
    private Stack<PhotoMemento> redoHistory = new Stack<>();
    
    public PhotoMemento undo() {
        if (!undoHistory.isEmpty()) {
            PhotoMemento current = undoHistory.pop();
            redoHistory.push(current);
            return undoHistory.isEmpty() ? null : undoHistory.peek();
        }
        return null;
    }
    
    public PhotoMemento redo() {
        if (!redoHistory.isEmpty()) {
            PhotoMemento state = redoHistory.pop();
            undoHistory.push(state);
            return state;
        }
        return null;
    }
}
```

### Adding Named Snapshots
```java
public class EditHistory {
    private Map<String, PhotoMemento> namedSnapshots = new HashMap<>();
    
    public void saveNamedSnapshot(String name, PhotoMemento memento) {
        namedSnapshots.put(name, memento);
        System.out.println("Saved snapshot: " + name);
    }
    
    public PhotoMemento loadNamedSnapshot(String name) {
        return namedSnapshots.get(name);
    }
}
```

## 🚀 Key Memento Pattern Rules

### ✅ **Do This (Good Memento Design):**
```java
// Memento should be immutable
public class PhotoMemento {
    private final String filter;    // Immutable state
    private final int brightness;   // Cannot be changed after creation
    
    // Only originator should access memento internals
    String getFilter() { return filter; }  // Package-private access
}

// Originator controls memento creation and restoration
public PhotoMemento createMemento() {
    return new PhotoMemento(imageName, filter, brightness, effect);
}
```

### ❌ **Don't Do This (Breaks Memento Pattern):**
```java
// Don't make memento mutable
public class BadMemento {
    public String filter;  // Public mutable field - wrong!
    
    public void setFilter(String filter) {  // Setter allows modification - wrong!
        this.filter = filter;
    }
}

// Don't let caretaker access memento internals
public class BadCaretaker {
    public void inspectMemento(PhotoMemento memento) {
        String filter = memento.getFilter();  // Caretaker shouldn't access internals
        memento.setFilter("Modified");        // Caretaker shouldn't modify
    }
}
```

## 💡 Adobe Photoshop Real Example

**Photoshop History Panel:**

**Professional Workflow:**
1. **Open photo** → Initial state automatically saved
2. **Levels adjustment** → New history state created
3. **Gaussian blur** → New history state  
4. **Color balance** → New history state
5. **Drop shadow layer style** → New history state

**History Panel Features:**
- **Linear History:** Click any previous state to restore
- **Non-Linear History:** Branch from any previous state
- **History Snapshots:** Manual save points for important moments
- **History Brush:** Paint using pixels from any previous state

**Memento Pattern Elements:**
- **Originator:** Photoshop document with layers, adjustments, effects
- **Memento:** History states storing complete document snapshots  
- **Caretaker:** History panel managing up to 1000 undo states
- **Advanced Features:** Named snapshots, history brushes, non-linear editing

## 🎯 Learning Takeaway

After running this demo, you should understand:
- How mementos capture complete object state for later restoration
- Why encapsulation is maintained through controlled memento access
- How undo/redo functionality is implemented using state snapshots
- When to use Memento pattern for state management in applications

## 💭 Remember

The Memento Pattern is like having a **professional photography studio**:
- **Take test shots** (snapshots) during the editing process
- **Compare different versions** to see what works best
- **Go back to any previous version** when current edits don't work
- **Never lose your work** - always have safe restore points

When you see **Ctrl+Z functionality**, **save game systems**, **document version history**, or **checkpoint/rollback features** - that's Memento Pattern providing safe experimentation and reliable state recovery! 📸💾✨

This photo editing example perfectly demonstrates how professional creative software enables non-destructive workflows where artists can experiment freely, knowing they can always return to any previous state!
```