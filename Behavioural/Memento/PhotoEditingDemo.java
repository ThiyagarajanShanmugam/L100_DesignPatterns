package Behavioural.Memento;

public class PhotoEditingDemo {
    
    public static void main(String[] args) {
        System.out.println("Photo Editing Software - Memento Pattern Demo");
        System.out.println("==============================================");
        
        // Create photo editor and history manager
        PhotoEditor editor = new PhotoEditor("vacation_photo.jpg");
        EditHistory history = new EditHistory();
        
        System.out.println("📸 Original: " + editor);
        
        // Save initial state
        history.saveState(editor.createMemento());
        
        // Apply filter
        System.out.println("\n--- Applying Vintage Filter ---");
        editor.applyFilter("Vintage");
        System.out.println("📸 Current: " + editor);
        history.saveState(editor.createMemento());
        
        // Adjust brightness
        System.out.println("\n--- Increasing Brightness ---");
        editor.setBrightness(80);
        System.out.println("📸 Current: " + editor);
        history.saveState(editor.createMemento());
        
        // Add effect
        System.out.println("\n--- Adding Blur Effect ---");
        editor.applyEffect("Blur");
        System.out.println("📸 Current: " + editor);
        
        // Undo operations
        System.out.println("\n--- User presses UNDO ---");
        PhotoMemento lastState = history.undo();
        if (lastState != null) {
            editor.restoreFromMemento(lastState);
        }
        System.out.println("📸 After Undo: " + editor);
        
        System.out.println("\n--- User presses UNDO again ---");
        lastState = history.undo();
        if (lastState != null) {
            editor.restoreFromMemento(lastState);
        }
        System.out.println("📸 After Undo: " + editor);
        
        System.out.println("\nMemento Pattern Demo Complete! 📷");
    }
}