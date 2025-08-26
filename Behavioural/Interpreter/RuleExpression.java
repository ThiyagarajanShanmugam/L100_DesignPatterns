package Behavioural.Interpreter;

// Abstract Expression - defines interface for rule evaluation
public interface RuleExpression {
    boolean interpret(RuleContext context);
}
