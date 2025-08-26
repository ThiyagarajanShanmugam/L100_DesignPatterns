package Behavioural.Interpreter;

// Context - stores variables for rule evaluation
public class RuleContext {
    private java.util.Map<String, Integer> variables = new java.util.HashMap<>();
    
    public void setVariable(String name, int value) {
        variables.put(name, value);
    }
    
    public int getVariable(String name) {
        return variables.getOrDefault(name, 0);
    }
    
    public void showContext() {
        System.out.println("Context variables: " + variables);
    }
}
