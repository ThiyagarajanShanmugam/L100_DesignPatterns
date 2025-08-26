package Behavioural.Memento;

// Memento - stores snapshot of photo editor state
public class PhotoMemento {
    private final String filter;
    private final int brightness;
    private final String effect;
    
    public PhotoMemento(String imageName, String filter, int brightness, String effect) {
        this.filter = filter;
        this.brightness = brightness;
        this.effect = effect;
    }
    
    // Getters for restoring state
    public String getFilter() { return filter; }
    public int getBrightness() { return brightness; }
    public String getEffect() { return effect; }
}