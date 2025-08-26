package Behavioural.State;

// State interface - defines what all phone states can do
public interface PhoneState {
    void dial(Phone phone, String number);
    void answer(Phone phone);
    void hangup(Phone phone);
    void reject(Phone phone);
    String getStateName();
}
