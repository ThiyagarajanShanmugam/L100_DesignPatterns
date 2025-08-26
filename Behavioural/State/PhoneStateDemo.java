package Behavioural.State;

public class PhoneStateDemo {
    
    public static void main(String[] args) {
        System.out.println("Phone Call States - State Pattern Demo");
        System.out.println("=====================================");
        
        Phone myPhone = new Phone();
        System.out.println("Initial state: " + myPhone.getCurrentState());
        
        // User tries to answer when no call - should fail
        System.out.println("\n--- User tries to answer when no call ---");
        myPhone.answer();
        
        // User dials a number
        System.out.println("\n--- User dials 555-1234 ---");
        myPhone.dial("555-1234");
        
        // Try to dial another number while already dialing
        System.out.println("\n--- User tries to dial another number ---");
        myPhone.dial("555-5678");
        
        // Call gets answered
        System.out.println("\n--- Other party answers the call ---");
        myPhone.answer();
        
        // Try to dial while connected
        System.out.println("\n--- User tries to dial while connected ---");
        myPhone.dial("555-9999");
        
        // End the call
        System.out.println("\n--- User hangs up ---");
        myPhone.hangup();
        
        // Try to hang up again
        System.out.println("\n--- User tries to hang up again ---");
        myPhone.hangup();
        
        System.out.println("\nState Pattern Demo Complete!");
    }
}
