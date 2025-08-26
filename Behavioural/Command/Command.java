package Behavioural.Command;

// Command interface - what all commands must implement
public interface Command {
    void execute();
    void undo();
}
