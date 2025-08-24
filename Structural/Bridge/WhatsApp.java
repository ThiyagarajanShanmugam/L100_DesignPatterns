package Structural.Bridge;

// Concrete Implementation - WhatsApp
// Implementation 1 - WhatsApp way
public class WhatsApp implements MessageProtocol {
    
    @Override
    public void sendMessage(String message, String to) {
        System.out.println("WhatsApp: '" + message + "' sent to " + to);
        System.out.println("WhatsApp: Double blue checkmarks");
    }
}