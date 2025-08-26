package Behavioural.State;

// Concrete State - Phone is idle/ready
public class IdleState implements PhoneState {
    
    @Override
    public void dial(Phone phone, String number) {
        System.out.println("Dialing " + number + "...");
        phone.setState(new DialingState());
    }
    
    @Override
    public void answer(Phone phone) {
        System.out.println("No incoming call to answer");
    }
    
    @Override
    public void hangup(Phone phone) {
        System.out.println("No active call to hang up");
    }
    
    @Override
    public void reject(Phone phone) {
        System.out.println("No incoming call to reject");
    }
    
    @Override
    public String getStateName() {
        return "Idle";
    }
}
