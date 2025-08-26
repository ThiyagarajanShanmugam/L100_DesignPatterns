package Behavioural.State;

// Concrete State - Phone is dialing/ringing out
public class DialingState implements PhoneState {
    
    @Override
    public void dial(Phone phone, String number) {
        System.out.println("Already dialing, please wait");
    }
    
    @Override
    public void answer(Phone phone) {
        System.out.println("Call answered! Connected");
        phone.setState(new ConnectedState());
    }
    
    @Override
    public void hangup(Phone phone) {
        System.out.println("Call cancelled");
        phone.setState(new IdleState());
    }
    
    @Override
    public void reject(Phone phone) {
        System.out.println("Call cancelled");  
        phone.setState(new IdleState());
    }
    
    @Override
    public String getStateName() {
        return "Dialing";
    }
}