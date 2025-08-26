package Structural.Composite;

public class PlaylistDemo {
    
    public static void main(String[] args) {
        System.out.println("TV Show Playlist - Composite Pattern Demo");
        System.out.println("========================================");
        
        // Create individual episodes (Leaf nodes)
        Episode ep1 = new Episode("Pilot", 45);
        Episode ep2 = new Episode("The Dragon Reborn", 50);
        Episode ep3 = new Episode("A Place of Safety", 52);
        
        Episode ep4 = new Episode("The Dragon Reborn Returns", 48);
        Episode ep5 = new Episode("Damane", 47);
        Episode ep6 = new Episode("Eyes Without Pity", 49);
        
        // Create Season 1 (Composite node)
        Season season1 = new Season("Season 1");
        season1.add(ep1);
        season1.add(ep2);
        season1.add(ep3);
        
        // Create Season 2 (Composite node)
        Season season2 = new Season("Season 2");
        season2.add(ep4);
        season2.add(ep5);
        season2.add(ep6);
        
        System.out.println("\n=== PLAYING INDIVIDUAL EPISODE ===");
        ep1.play();
        
        System.out.println("\n=== PLAYING ENTIRE SEASON 1 ===");
        season1.play();
        
        System.out.println("\n=== PLAYING ENTIRE SEASON 2 ===");
        season2.play();
        
        System.out.println("\n=== COMPOSITE PATTERN MAGIC ===");
        demonstrateCompositePattern(season1, ep2);
        
        System.out.println("\nComposite Pattern Demo Complete!");
    }
    
    // This method treats episodes and seasons the same way!
    private static void demonstrateCompositePattern(PlaylistComponent item1, PlaylistComponent item2) {
        System.out.println("Treating season and episode the same way:");
        
        System.out.println("Item 1 - " + item1.getTitle() + " (" + item1.getDuration() + " mins total)");
        System.out.println("Item 2 - " + item2.getTitle() + " (" + item2.getDuration() + " mins total)");
        
        // Same method calls work on both season (composite) and episode (leaf)!
        System.out.println("\nPlaying both items:");
        item1.play();
        System.out.println("---");
        item2.play();
    }
}