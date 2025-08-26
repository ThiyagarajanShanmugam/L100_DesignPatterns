package Structural.Proxy;

// Real Subject - the actual expensive video object
public class RealVideo implements Video {
    private String filename;
    private boolean isLoaded;
    private boolean isPlaying;
    
    public RealVideo(String filename) {
        this.filename = filename;
        this.isLoaded = false;
        this.isPlaying = false;
        loadVideoFromServer(); // Expensive operation!
    }
    
    private void loadVideoFromServer() {
        System.out.println("Loading video '" + filename + "' from Netflix servers...");
        // Simulate expensive loading process
        try {
            Thread.sleep(2000); // 2 second delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        isLoaded = true;
        System.out.println("Video '" + filename + "' loaded successfully!");
    }
    
    @Override
    public void play() {
        if (isLoaded) {
            isPlaying = true;
            System.out.println("Playing '" + filename + "' in HD quality");
        }
    }
    
    @Override
    public void pause() {
        if (isPlaying) {
            isPlaying = false;
            System.out.println("Paused '" + filename + "'");
        }
    }
    
    @Override
    public String getInfo() {
        return "Video: " + filename + " [Loaded: " + isLoaded + ", Playing: " + isPlaying + "]";
    }
}
