package Structural.Proxy;

// Subject interface - common interface for RealVideo and VideoProxy
public interface Video {
    void play();
    void pause();
    String getInfo();
}
