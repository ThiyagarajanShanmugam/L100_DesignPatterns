package Behavioural.Iterator;

// Simple song data class
public class Song {
    private String title;
    private String artist;
    
    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }
    
    @Override
    public String toString() {
        return title + " by " + artist;
    }
    
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
}
