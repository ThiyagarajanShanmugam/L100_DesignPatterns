package Behavioural.Iterator;

import java.util.*;

// Collection that provides iterator
public class Playlist {
    private List<Song> songs;
    private String name;
    
    public Playlist(String name) {
        this.name = name;
        this.songs = new ArrayList<>();
    }
    
    public void addSong(Song song) {
        songs.add(song);
    }
    
    public PlaylistIterator createIterator() {
        return new PlaylistIterator(songs);
    }
    
    public String getName() { return name; }
}
