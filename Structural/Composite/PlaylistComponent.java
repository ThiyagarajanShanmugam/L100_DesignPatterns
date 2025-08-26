package Structural.Composite;

// Component - Common interface for both individual episodes and seasons
public abstract class PlaylistComponent {
    
    // Operations that both episodes and seasons can do
    public void play() {
        throw new UnsupportedOperationException("Operation not supported");
    }
    
    public int getDuration() {
        throw new UnsupportedOperationException("Operation not supported");
    }
    
    public String getTitle() {
        throw new UnsupportedOperationException("Operation not supported");
    }
    
    // Operations only seasons (composites) can do
    public void add(PlaylistComponent component) {
        throw new UnsupportedOperationException("Cannot add to episode");
    }
    
    public void remove(PlaylistComponent component) {
        throw new UnsupportedOperationException("Cannot remove from episode");
    }
    
    public PlaylistComponent getChild(int index) {
        throw new UnsupportedOperationException("No children in episode");
    }
}