package Structural.Bridge;

// Bridge Interface - How messages are sent
public interface MessageProtocol {
    void sendMessage(String message, String to);
}
