package Structural.Bridge;

// Concrete Implementation - Telegram
// Implementation 2 - Telegram way  
public class Telegram implements MessageProtocol {
    
    @Override
    public void sendMessage(String message, String to) {
        System.out.println("Telegram: '" + message + "' sent to " + to);
        System.out.println("Telegram: Message synced to cloud");
    }
}