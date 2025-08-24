package Structural.Bridge;

// Abstraction - Chat App that uses any protocol
public class ChatApp {
    private MessageProtocol protocol;
    
    public ChatApp(MessageProtocol protocol) {
        this.protocol = protocol;
    }
    
    public void sendMessage(String message, String to) {
        System.out.println("ChatApp: User wants to send message");
        protocol.sendMessage(message, to);
    }
    
    public void switchProtocol(MessageProtocol newProtocol) {
        this.protocol = newProtocol;
        System.out.println("ChatApp: Switched to " + newProtocol.getClass().getSimpleName());
    }
}