package Behavioural.Interpreter;

// Demo - shows rule evaluation using Interpreter Pattern
public class RuleEngineDemo {
    public static void main(String[] args) {
        System.out.println("Configuration Rule Engine - Interpreter Pattern Demo");
        System.out.println("===================================================\n");
        
        // Setup context with user data
        RuleContext context = new RuleContext();
        context.setVariable("age", 25);
        context.setVariable("experience", 3);
        context.setVariable("salary", 45000);
        
        context.showContext();
        
        // RULE 1: Simple rule - age > 21
        System.out.println("\n--- RULE 1: Access Check (age > 21) ---");
        RuleExpression accessRule = new GreaterThanExpression(
            new VariableExpression("age"),
            new VariableExpression(21)
        );
        
        boolean hasAccess = accessRule.interpret(context);
        System.out.println("Access granted: " + hasAccess);
        
        // RULE 2: Complex rule - (age > 18) AND (experience > 2)
        System.out.println("\n--- RULE 2: Job Eligibility ((age > 18) AND (experience > 2)) ---");
        RuleExpression jobRule = new AndExpression(
            new GreaterThanExpression(
                new VariableExpression("age"),
                new VariableExpression(18)
            ),
            new GreaterThanExpression(
                new VariableExpression("experience"),
                new VariableExpression(2)
            )
        );
        
        boolean jobEligible = jobRule.interpret(context);
        System.out.println("Job eligible: " + jobEligible);
        
        // RULE 3: Salary check - salary > 40000
        System.out.println("\n--- RULE 3: Bonus Check (salary > 40000) ---");
        RuleExpression bonusRule = new GreaterThanExpression(
            new VariableExpression("salary"),
            new VariableExpression(40000)
        );
        
        boolean bonusEligible = bonusRule.interpret(context);
        System.out.println("Bonus eligible: " + bonusEligible);
        
        System.out.println("\n--- FINAL RESULTS ---");
        System.out.println("Access Control: " + (hasAccess ? "GRANTED" : "DENIED"));
        System.out.println("Job Application: " + (jobEligible ? "APPROVED" : "REJECTED"));
        System.out.println("Bonus Eligibility: " + (bonusEligible ? "ELIGIBLE" : "NOT ELIGIBLE"));
        
        System.out.println("\nInterpreter Pattern Complete!");
        System.out.println("Each expression interpreted itself recursively!");
    }
}
