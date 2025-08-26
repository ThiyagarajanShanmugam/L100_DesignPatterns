package Behavioural.State;

// Context - Phone that has different states
public class Phone {
    private PhoneState currentState;
    
    public Phone() {
        this.currentState = new IdleState();  // Start in idle state
    }
    
    public void setState(PhoneState state) {
        this.currentState = state;
        System.out.println("Phone state: " + state.getStateName());
    }
    
    // Delegate all actions to current state
    public void dial(String number) {
        currentState.dial(this, number);
    }
    
    public void answer() {
        currentState.answer(this);
    }
    
    public void hangup() {
        currentState.hangup(this);
    }
    
    public void reject() {
        currentState.reject(this);
    }
    
    public String getCurrentState() {
        return currentState.getStateName();
    }
}
