package Behavioural.Interpreter;

// Terminal Expression - represents variables and values
public class VariableExpression implements RuleExpression {
    private String variableName;
    private int value;
    private boolean isVariable;
    
    // Constructor for variable
    public VariableExpression(String variableName) {
        this.variableName = variableName;
        this.isVariable = true;
    }
    
    // Constructor for constant value
    public VariableExpression(int value) {
        this.value = value;
        this.isVariable = false;
    }
    
    @Override
    public boolean interpret(RuleContext context) {
        if (isVariable) {
            int val = context.getVariable(variableName);
            System.out.println("    Variable '" + variableName + "' = " + val);
            return val > 0;
        }
        return value > 0;
    }
    
    public int getValue(RuleContext context) {
        return isVariable ? context.getVariable(variableName) : value;
    }
    
    public String getName() {
        return isVariable ? variableName : String.valueOf(value);
    }
}
