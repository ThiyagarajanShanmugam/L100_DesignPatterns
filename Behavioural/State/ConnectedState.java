package Behavioural.State;

// Concrete State - Phone call is active/connected
public class ConnectedState implements PhoneState {
    
    @Override
    public void dial(Phone phone, String number) {
        System.out.println("Cannot dial during active call");
    }
    
    @Override
    public void answer(Phone phone) {
        System.out.println("Already in a call");
    }
    
    @Override
    public void hangup(Phone phone) {
        System.out.println("Call ended");
        phone.setState(new IdleState());
    }
    
    @Override
    public void reject(Phone phone) {
        System.out.println("Call ended");
        phone.setState(new IdleState());
    }
    
    @Override
    public String getStateName() {
        return "Connected";
    }
}
