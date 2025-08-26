package Structural.Proxy;

// Proxy - controls access to RealVideo and adds extra functionality
public class VideoProxy implements Video {
    private String filename;
    private RealVideo realVideo;
    private boolean userHasAccess;
    
    public VideoProxy(String filename, boolean userHasAccess) {
        this.filename = filename;
        this.userHasAccess = userHasAccess;
        this.realVideo = null; // Lazy loading - create only when needed
    }
    
    @Override
    public void play() {
        // Security check
        if (!userHasAccess) {
            System.out.println("Access denied! Please subscribe to Netflix Premium to watch '" + filename + "'");
            return;
        }
        
        // Lazy loading - create RealVideo only when user actually plays
        if (realVideo == null) {
            System.out.println("Proxy: First time playing '" + filename + "' - loading from server...");
            realVideo = new RealVideo(filename);
        }
        
        // Delegate to real video
        System.out.println("Proxy: Starting playback...");
        realVideo.play();
    }
    
    @Override
    public void pause() {
        if (realVideo != null) {
            System.out.println("Proxy: Pausing video...");
            realVideo.pause();
        } else {
            System.out.println("No video is currently loaded");
        }
    }
    
    @Override
    public String getInfo() {
        if (realVideo != null) {
            return "Proxy -> " + realVideo.getInfo();
        } else {
            return "Proxy: Video '" + filename + "' [Not loaded yet - will load when played]";
        }
    }
    
    // Proxy can add extra functionality
    public void showThumbnail() {
        System.out.println("Showing thumbnail for '" + filename + "' (instant load)");
    }
    
    public void preloadVideo() {
        if (realVideo == null && userHasAccess) {
            System.out.println("Proxy: Pre-loading video for better experience...");
            realVideo = new RealVideo(filename);
        }
    }
}
