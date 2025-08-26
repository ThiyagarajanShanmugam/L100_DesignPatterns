package Behavioural.Memento;

import java.util.*;

// Caretaker - manages photo editing history and undo/redo
public class EditHistory {
    private Stack<PhotoMemento> history;
    
    public EditHistory() {
        this.history = new Stack<>();
    }
    
    public void saveState(PhotoMemento memento) {
        history.push(memento);
        System.out.println("✅ State saved to history");
    }
    
    public PhotoMemento undo() {
        if (!history.isEmpty()) {
            PhotoMemento memento = history.pop();
            System.out.println("↶ Undoing last edit");
            return memento;
        }
        System.out.println("❌ No more edits to undo");
        return null;
    }
    
    public int getHistorySize() {
        return history.size();
    }
}
