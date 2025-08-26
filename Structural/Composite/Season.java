package Structural.Composite;

import java.util.ArrayList;
import java.util.List;

// Composite - Season that contains episodes
public class Season extends PlaylistComponent {
    private String title;
    private List<PlaylistComponent> episodes;
    
    public Season(String title) {
        this.title = title;
        this.episodes = new ArrayList<>();
    }
    
    @Override
    public void add(PlaylistComponent episode) {
        episodes.add(episode);
    }
    
    @Override
    public void remove(PlaylistComponent episode) {
        episodes.remove(episode);
    }
    
    @Override
    public PlaylistComponent getChild(int index) {
        return episodes.get(index);
    }
    
    @Override
    public void play() {
        System.out.println("Playing season: " + title);
        System.out.println("Total episodes: " + episodes.size());
        System.out.println("Total duration: " + getDuration() + " minutes");
        System.out.println("--- Episodes ---");
        
        // Play all episodes in the season
        for (PlaylistComponent episode : episodes) {
            episode.play();
        }
    }
    
    @Override
    public String getTitle() {
        return title;
    }
    
    @Override
    public int getDuration() {
        // Calculate total duration of all episodes
        int totalDuration = 0;
        for (PlaylistComponent episode : episodes) {
            totalDuration += episode.getDuration();
        }
        return totalDuration;
    }
}
