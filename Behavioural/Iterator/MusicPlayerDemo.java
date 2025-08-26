package Behavioural.Iterator;

public class MusicPlayerDemo {
    
    public static void main(String[] args) {
        System.out.println("Music Playlist Player - Iterator Pattern Demo");
        System.out.println("============================================");
        
        // Create playlist
        Playlist myPlaylist = new Playlist("My Favorites");
        myPlaylist.addSong(new Song("Bohemian Rhapsody", "Queen"));
        myPlaylist.addSong(new Song("Hotel California", "Eagles"));
        myPlaylist.addSong(new Song("Sweet Child O Mine", "Guns N Roses"));
        myPlaylist.addSong(new Song("Stairway to Heaven", "Led Zeppelin"));
        
        // Get iterator for playlist
        PlaylistIterator iterator = myPlaylist.createIterator();
        
        System.out.println("Playing " + myPlaylist.getName() + ":");
        
        // Play songs forward
        System.out.println("\n--- Playing Forward ---");
        while (iterator.hasNext()) {
            Song song = iterator.next();
            System.out.println("♪ Now playing: " + song);
        }
        
        // Play songs backward
        System.out.println("\n--- Playing Backward ---");
        Song previousSong = iterator.previous();
        while (previousSong != null) {
            System.out.println("♪ Previous: " + previousSong);
            previousSong = iterator.previous();
        }
        
        System.out.println("\nDemo Complete!");
    }
}
