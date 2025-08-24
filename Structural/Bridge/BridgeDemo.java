package Structural.Bridge;

public class BridgeDemo {
    
    public static void main(String[] args) {
        System.out.println("Chat Bridge Pattern Demo");
        System.out.println("=======================");
        
        // Create chat app with WhatsApp
        ChatApp myChat = new ChatApp(new WhatsApp());
        
        System.out.println("\n--- Using WhatsApp ---");
        myChat.sendMessage("Hello!", "John");
        
        // Switch to Telegram
        System.out.println("\n--- Switching to Telegram ---");
        myChat.switchProtocol(new Telegram());
        myChat.sendMessage("Hello!", "John");
        
        // Create another app with different protocol
        System.out.println("\n--- New App with Telegram ---");
        ChatApp workChat = new ChatApp(new Telegram());
        workChat.sendMessage("Meeting at 3 PM", "Team");
        
        System.out.println("\nDemo Complete!");
    }
}