package Structural.Proxy;

public class NetflixDemo {
    
    public static void main(String[] args) {
        System.out.println("Netflix Video Streaming - Proxy Pattern Demo");
        System.out.println("===========================================");
        
        // Create video proxies (lightweight, instant creation)
        VideoProxy movie1 = new VideoProxy("Stranger Things S4", true);  // Premium user
        VideoProxy movie2 = new VideoProxy("Wednesday", false);          // Free user
        VideoProxy movie3 = new VideoProxy("The Crown", true);           // Premium user
        
        System.out.println("\n=== NETFLIX INTERFACE LOADS INSTANTLY ===");
        movie1.showThumbnail();
        movie2.showThumbnail();
        movie3.showThumbnail();
        System.out.println("All thumbnails loaded instantly (no heavy video loading yet!)");
        
        System.out.println("\n=== USER TRIES TO PLAY VIDEOS ===");
        
        // Premium user plays video (lazy loading happens here)
        System.out.println("\n--- Premium user plays Stranger Things ---");
        System.out.println(movie1.getInfo());
        movie1.play(); // Heavy loading only happens now!
        System.out.println(movie1.getInfo());
        
        // Free user tries premium content (access control)
        System.out.println("\n--- Free user tries to play Wednesday ---");
        movie2.play(); // Proxy blocks access
        
        // Premium user plays another video
        System.out.println("\n--- Premium user plays The Crown ---");
        movie3.play(); // Another heavy loading
        
        System.out.println("\n=== PROXY PATTERN BENEFITS ===");
        demonstrateProxyBenefits();
        
        System.out.println("\nProxy Pattern Demo Complete!");
    }
    
    private static void demonstrateProxyBenefits() {
        System.out.println("1. LAZY LOADING:");
        System.out.println("   - Netflix interface loads instantly (thumbnails only)");
        System.out.println("   - Heavy video files loaded only when user presses play");
        
        System.out.println("\n2. ACCESS CONTROL:");
        System.out.println("   - Proxy checks subscription before allowing video access");
        System.out.println("   - Prevents unauthorized access to premium content");
        
        System.out.println("\n3. PERFORMANCE:");
        System.out.println("   - Without Proxy: Load all videos on page load (slow!)");
        System.out.println("   - With Proxy: Load videos on-demand (fast interface!)");
        
        // Demonstrate pause functionality
        System.out.println("\n=== PAUSE/RESUME DEMO ===");
        VideoProxy demo = new VideoProxy("Demo Video", true);
        demo.play();
        demo.pause();
        
        // Show pre-loading feature
        System.out.println("\n=== PRE-LOADING FEATURE ===");
        VideoProxy preloadDemo = new VideoProxy("Popular Movie", true);
        System.out.println("User is browsing... proxy can pre-load popular content:");
        preloadDemo.preloadVideo();
        System.out.println("When user clicks play, video starts immediately:");
        preloadDemo.play(); // Already loaded, starts instantly!
    }
}