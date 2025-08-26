package Structural.Composite;

// Leaf - Individual episode (cannot contain other episodes)
public class Episode extends PlaylistComponent {
    private String title;
    private int duration; // in minutes
    
    public Episode(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }
    
    @Override
    public void play() {
        System.out.println("Playing episode: " + title + " (" + duration + " mins)");
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public int getDuration() {
        return duration;
    }
}