package Behavioural.Memento;

// Originator - maintains current photo state and creates mementos
public class PhotoEditor {
    private String imageName;
    private String filter;
    private int brightness;
    private String effect;
    
    public PhotoEditor(String imageName) {
        this.imageName = imageName;
        this.filter = "None";
        this.brightness = 50;
        this.effect = "None";
    }
    
    // Create memento to save current state
    public PhotoMemento createMemento() {
        return new PhotoMemento(imageName, filter, brightness, effect);
    }
    
    // Restore from memento
    public void restoreFromMemento(PhotoMemento memento) {
        this.filter = memento.getFilter();
        this.brightness = memento.getBrightness();
        this.effect = memento.getEffect();
    }
    
    // Photo editing operations
    public void applyFilter(String filter) {
        this.filter = filter;
    }
    
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }
    
    public void applyEffect(String effect) {
        this.effect = effect;
    }
    
    @Override
    public String toString() {
        return "Photo: " + imageName + " | Filter: " + filter + 
               " | Brightness: " + brightness + " | Effect: " + effect;
    }
}