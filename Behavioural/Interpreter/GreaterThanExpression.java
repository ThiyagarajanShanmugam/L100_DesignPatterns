package Behavioural.Interpreter;

// Non-terminal Expression - handles greater than comparison
public class GreaterThanExpression implements RuleExpression {
    private VariableExpression left;
    private VariableExpression right;
    
    public GreaterThanExpression(VariableExpression left, VariableExpression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public boolean interpret(RuleContext context) {
        int leftVal = left.getValue(context);
        int rightVal = right.getValue(context);
        
        System.out.println("    Comparing: " + left.getName() + " (" + leftVal + 
                          ") > " + right.getName() + " (" + rightVal + ")");
        
        boolean result = leftVal > rightVal;
        System.out.println("    Result: " + result);
        return result;
    }
}
