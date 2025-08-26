package Behavioural.Interpreter;

// Non-terminal Expression - handles logical AND
public class AndExpression implements RuleExpression {
    private RuleExpression left;
    private RuleExpression right;
    
    public AndExpression(RuleExpression left, RuleExpression right) {
        this.left = left;
        this.right = right;
    }
    
    @Override
    public boolean interpret(RuleContext context) {
        System.out.println("  Evaluating AND condition:");
        
        boolean leftResult = left.interpret(context);
        boolean rightResult = right.interpret(context);
        
        boolean result = leftResult && rightResult;
        System.out.println("  AND Result: " + leftResult + " AND " + rightResult + " = " + result);
        return result;
    }
}
