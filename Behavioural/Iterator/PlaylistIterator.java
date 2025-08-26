package Behavioural.Iterator;

import java.util.*;

// Iterator for navigating playlist
public class PlaylistIterator {
    private List<Song> songs;
    private int currentIndex = 0;
    
    public PlaylistIterator(List<Song> songs) {
        this.songs = songs;
    }
    
    public boolean hasNext() {
        return currentIndex < songs.size();
    }
    
    public Song next() {
        return songs.get(currentIndex++);
    }
    
    public Song previous() {
        return currentIndex > 0 ? songs.get(--currentIndex) : null;
    }
    
    public Song current() {
        return currentIndex > 0 ? songs.get(currentIndex - 1) : null;
    }
}