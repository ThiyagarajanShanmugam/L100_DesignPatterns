# Payment Processing - Strategy Pattern

## 📋 Overview

This project demonstrates the **Strategy Design Pattern** using a payment processing system. The pattern defines a family of algorithms (payment methods), encapsulates each one, and makes them interchangeable at runtime. Just like how you can pay for your coffee with cash, card, or mobile payment - same purchase, different payment strategies!

## 🎯 Strategy Pattern Explained

**Simple analogy:** Like choosing your route to work! You can take the highway (fast but tolls), city streets (free but slower), or public transport (cheap but fixed schedule). Same destination, different strategies with different trade-offs.

**What it does:** Encapsulates different algorithms for the same task in separate strategy classes and allows switching between them at runtime without changing the client code.

**Key benefit:** Eliminates complex conditional statements and makes adding new algorithms easy without modifying existing code.

## 🧩 The Problem

Imagine you have an **online shopping cart** and customers want to pay different ways:

**Without Strategy Pattern (Payment Chaos):**
```java
public void processPayment(String paymentType, double amount) {
    if (paymentType.equals("credit-card")) {
        // Validate card number
        // Connect to bank
        // Process credit card payment
        // Handle credit card errors
    } else if (paymentType.equals("paypal")) {
        // Validate PayPal credentials
        // Connect to PayPal API
        // Process PayPal payment
        // Handle PayPal errors
    } else if (paymentType.equals("apple-pay")) {
        // Validate device ID
        // Check biometric auth
        // Process Apple Pay payment
        // Handle Apple Pay errors
    }
    // Complex if-else everywhere! 😵
    // Adding new payment method = modify this method! 😰
}
```

**This creates payment madness:** Every payment processing needs to check ALL possible payment types!

## 🎯 The Solution - Strategy Pattern

Create **smart payment strategies** that know how to process payments:
- **Credit Card Strategy** knows: "I need card number and holder name"
- **PayPal Strategy** knows: "I need email and password authentication"  
- **Apple Pay Strategy** knows: "I need device ID and biometric verification"
- **Shopping Cart** just asks its **current payment strategy**: "Hey, user wants to pay $100, handle it!"

**The magic:** Each strategy **knows exactly how to process its payment type** - no complex checking needed!

## 📋 Step-by-Step Code Explanation

### Step 1: The Strategy Interface (Payment Contract)
```java
public interface PaymentStrategy {
    void pay(double amount);                // How to process payment
    String getPaymentType();               // What payment method am I?
    boolean validatePaymentDetails();      // Are my details valid?
}
```
**Translation:** "Every payment method must know how to pay, validate itself, and tell me its type!"

### Step 2: Credit Card Strategy (Bank Payment)
```java
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;
    
    public void pay(double amount) {
        System.out.println("💳 Connecting to bank...");      // Credit card specific process
        System.out.println("✅ Paid $" + amount + " via Credit Card");
    }
}
```
**Translation:** "I'm credit card strategy! I connect to banks and process card payments!"

### Step 3: PayPal Strategy (Online Payment)
```java
public class PayPalPayment implements PaymentStrategy {
    private String email;
    private String password;
    
    public void pay(double amount) {
        System.out.println("🔵 Connecting to PayPal...");   // PayPal specific process
        System.out.println("✅ Paid $" + amount + " via PayPal");
    }
}
```
**Translation:** "I'm PayPal strategy! I authenticate with PayPal and process online payments!"

### Step 4: Apple Pay Strategy (Mobile Payment)
```java
public class ApplePayPayment implements PaymentStrategy {
    private String deviceId;
    private boolean biometricAuth;
    
    public void pay(double amount) {
        System.out.println("🍎 Connecting to Apple Pay...");  // Apple Pay specific process
        System.out.println("✅ Paid $" + amount + " via Apple Pay");
    }
}
```
**Translation:** "I'm Apple Pay strategy! I use biometrics and process mobile payments!"

### Step 5: The Shopping Cart (Context)
```java
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;  // Current payment method
    
    public void setPaymentMethod(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;  // Switch payment method dynamically
    }
    
    public void checkout() {
        paymentStrategy.pay(totalAmount);       // Delegate to current strategy
    }
}
```
**Translation:** "I'm the shopping cart! I don't know how to process payments - I just ask my current payment strategy to handle everything!"

## 🎭 The Magic Payment Strategy Flow

### **Step 1: Cart Creates Without Payment Method**
```java
ShoppingCart cart = new ShoppingCart();  // No payment method set yet
// Current behavior: Cannot checkout until payment method set
```

### **Step 2: User Selects Credit Card**
```java
PaymentStrategy creditCard = new CreditCardPayment("1234567812345678", "John Doe");
cart.setPaymentMethod(creditCard);
```
**What happens inside:**
```java
// ShoppingCart.setPaymentMethod() gets called
public void setPaymentMethod(PaymentStrategy paymentStrategy) {
    this.paymentStrategy = paymentStrategy;                           // Store credit card strategy
    System.out.println("Payment method set: " + paymentStrategy.getPaymentType());
}
// Cart now uses CreditCardPayment strategy
```

### **Step 3: User Checks Out**
```java
cart.checkout();  // Process payment using current strategy
```
**What happens inside:**
```java
// ShoppingCart.checkout() gets called  
public void checkout() {
    paymentStrategy.pay(totalAmount);     // Delegate to CreditCardPayment.pay()
}
// CreditCardPayment.pay() executes
public void pay(double amount) {
    System.out.println("💳 Connecting to bank...");
    System.out.println("✅ Paid $" + amount + " via Credit Card");
}
```

### **Step 4: User Switches to PayPal**
```java
PaymentStrategy paypal = new PayPalPayment("john@email.com", "secure123");
cart.setPaymentMethod(paypal);  // Switch strategy at runtime
```
**What happens inside:**
```java
// Same cart, different strategy
this.paymentStrategy = paypal;  // Now cart uses PayPalPayment strategy
// Cart behavior completely changes without cart code changing!
```

### **Step 5: User Checks Out Again**
```java
cart.checkout();  // Same method call, different behavior!
```
**What happens inside:**
```java
// Same ShoppingCart.checkout() method
public void checkout() {
    paymentStrategy.pay(totalAmount);     // Now delegates to PayPalPayment.pay()
}
// PayPalPayment.pay() executes (completely different algorithm)
public void pay(double amount) {
    System.out.println("🔵 Connecting to PayPal...");
    System.out.println("✅ Paid $" + amount + " via PayPal");
}
```

## 🌟 Why This is Amazing

### **Without Strategy Pattern (Messy Code):**
```java
public class MessyShoppingCart {
    private String paymentType = "credit-card";  // String type - bad!
    
    public void checkout() {
        if (paymentType.equals("credit-card")) {
            System.out.println("Processing credit card...");
            // Credit card logic here
        } else if (paymentType.equals("paypal")) {
            System.out.println("Processing PayPal...");
            // PayPal logic here
        } else if (paymentType.equals("apple-pay")) {
            System.out.println("Processing Apple Pay...");
            // Apple Pay logic here
        }
        // Same messy if-else repeated everywhere! 😰
        // Adding new payment = modify this method! 😰
    }
}
```

### **With Strategy Pattern (Clean Code):**
```java
public class SmartShoppingCart {
    private PaymentStrategy paymentStrategy;
    
    public void checkout() {
        paymentStrategy.pay(totalAmount);  // Strategy handles everything!
    }
    
    // Clean, simple, no if-else mess! 🎉
    // Adding new payment = create new strategy class! 🎉
}
```

## 🏗️ Pattern Components

| Component | File | Role | Description |
|-----------|------|------|-------------|
| **Strategy Interface** | `PaymentStrategy.java` | Algorithm Contract | Defines methods all payment strategies must implement |
| **Concrete Strategies** | `CreditCardPayment.java`, `PayPalPayment.java`, `ApplePayPayment.java` | Algorithm Implementations | Specific payment processing algorithms |
| **Context** | `ShoppingCart.java` | Strategy Manager | Cart that uses payment strategy to process payments |
| **Client** | `PaymentDemo.java` | Pattern User | Demonstrates payment strategy switching and usage |

## 📁 Project Structure
```
DesignPatterns/
└── Behavioral/
    └── Strategy/
        ├── README.md                   # This documentation
        ├── PaymentStrategy.java        # Strategy interface (payment contract)
        ├── CreditCardPayment.java      # Concrete strategy (bank payment)
        ├── PayPalPayment.java          # Concrete strategy (online payment)
        ├── ApplePayPayment.java        # Concrete strategy (mobile payment)
        ├── ShoppingCart.java           # Context (cart managing payments)
        └── PaymentDemo.java            # Client (payment usage demonstration)
```

## ⚡ How to Run

### Prerequisites
- Java 8 or higher
- Command line or IDE

### Running the Application
```bash
# Navigate to Strategy directory
cd DesignPatterns/Behavioral/Strategy

# Compile all Java files  
javac *.java

# Run the demonstration
java PaymentDemo
```

## 📖 Expected Output
```
Payment Processing - Strategy Pattern Demo
=========================================

--- Adding items to cart ---
🛒 Added Laptop - $999.99
🛒 Added Mouse - $29.99
🛒 Added Keyboard - $79.99

=== PAYMENT SCENARIO 1: CREDIT CARD ===
Payment method set: Credit Card

--- CHECKOUT ---
Total: $1109.97
💳 Connecting to bank...
Card: ****5678
Holder: John Doe
✅ Paid $1109.97 via Credit Card

=== PAYMENT SCENARIO 2: PAYPAL ===
Payment method set: PayPal

--- CHECKOUT ---
Total: $1109.97
🔵 Connecting to PayPal...
Email: john@email.com
Authenticating PayPal account...
✅ Paid $1109.97 via PayPal

=== PAYMENT SCENARIO 3: APPLE PAY ===
Payment method set: Apple Pay

--- CHECKOUT ---
Total: $1109.97
🍎 Connecting to Apple Pay...
Device: iPhone-12-Pro
Biometric authentication verified
✅ Paid $1109.97 via Apple Pay

🎉 Strategy Pattern Demo Complete!
Same cart, different payment algorithms!
```

## 🔍 The Strategy Behavior in Action

### Strategy Selection Flow
```
Payment Processing Lifecycle:
├── Shopping Cart Created (No payment method)
│   └── checkout() → Error: No payment method selected
├── Credit Card Strategy Set
│   ├── checkout() → Credit card processing algorithm
│   └── Processes via bank connection
├── PayPal Strategy Set (Runtime Switch)
│   ├── checkout() → PayPal processing algorithm  
│   └── Processes via PayPal API connection
└── Apple Pay Strategy Set (Runtime Switch)
    ├── checkout() → Apple Pay processing algorithm
    └── Processes via biometric authentication
```

### Same Action, Different Algorithms
```
checkout() action with different strategies:
├── Credit Card Strategy: "💳 Connecting to bank..." → Bank processing
├── PayPal Strategy: "🔵 Connecting to PayPal..." → API processing
└── Apple Pay Strategy: "🍎 Connecting to Apple Pay..." → Biometric processing

setPaymentMethod() enables runtime algorithm switching:
├── cart.setPaymentMethod(creditCard) → Cart uses credit card algorithm
├── cart.setPaymentMethod(paypal) → Cart switches to PayPal algorithm
└── cart.setPaymentMethod(applePay) → Cart switches to Apple Pay algorithm
```

## 🎯 Pattern Benefits Demonstrated

### 1. **Eliminates Complex Payment Conditionals**
```java
// Without Strategy Pattern (messy):
public void processPayment(String type, double amount) {
    if (type.equals("credit-card")) {
        // credit card logic
    } else if (type.equals("paypal")) {
        // paypal logic  
    } else if (type.equals("apple-pay")) {
        // apple pay logic
    }
    // Repeated payment checking everywhere!
}

// With Strategy Pattern (clean):
public void checkout() {
    paymentStrategy.pay(amount); // Strategy handles everything!
}
```

### 2. **Algorithm Encapsulation**
```java
// Each payment method encapsulates its own processing logic
public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        // All credit card specific logic here
        validateCardDetails();
        connectToBank();
        processCardPayment(amount);
        handleCardErrors();
    }
}
```

### 3. **Runtime Algorithm Switching**
```java
// Change payment method without changing cart code
cart.setPaymentMethod(new CreditCardPayment("1234", "John"));  // Credit card algorithm
cart.setPaymentMethod(new PayPalPayment("john@email.com"));    // PayPal algorithm  
cart.setPaymentMethod(new ApplePayPayment("iPhone", true));    // Apple Pay algorithm
// Same cart.checkout(), completely different processing!
```

### 4. **Easy Extension**
```java
// Add new payment method without modifying existing code
public class CryptoCurrencyPayment implements PaymentStrategy {
    private String walletAddress;
    
    public void pay(double amount) {
        System.out.println("₿ Processing cryptocurrency payment...");
        System.out.println("Wallet: " + walletAddress);
        System.out.println("✅ Paid $" + amount + " via Bitcoin");
    }
    
    public String getPaymentType() {
        return "Bitcoin";
    }
}

// Use immediately without changing ShoppingCart
cart.setPaymentMethod(new CryptoCurrencyPayment("1A2B3C4D..."));
```

## 🌟 Real-World Applications

This same Strategy pattern is used in:

- **E-commerce Platforms**: Amazon, eBay payment processing (cards, PayPal, wallets)
- **Ride Sharing**: Uber/Lyft pricing strategies (standard, surge, pool pricing)
- **Gaming**: Different AI strategies for NPCs (aggressive, defensive, stealth)
- **Compression Software**: Different compression algorithms (ZIP, RAR, 7Z)
- **Sorting Algorithms**: Collections.sort() with different Comparator strategies
- **Database Drivers**: JDBC with different database connection strategies
- **File Processing**: Different file format handlers (PDF, DOC, TXT)
- **Authentication**: Multiple login strategies (OAuth, LDAP, local database)

## 🆚 Without vs With Strategy Pattern

### Without Strategy Pattern (Algorithm Chaos)
```java
public class MessyPaymentProcessor {
    public void processPayment(String type, double amount, Map<String, String> details) {
        if (type.equals("credit-card")) {
            String cardNumber = details.get("cardNumber");
            String holderName = details.get("holderName");
            // Validate card
            if (cardNumber != null && cardNumber.length() == 16) {
                System.out.println("Processing credit card...");
                // Credit card processing logic
            } else {
                System.out.println("Invalid card details");
            }
        } else if (type.equals("paypal")) {
            String email = details.get("email");
            String password = details.get("password");
            // Validate PayPal
            if (email != null && email.contains("@")) {
                System.out.println("Processing PayPal...");
                // PayPal processing logic
            } else {
                System.out.println("Invalid PayPal credentials");
            }
        } else if (type.equals("apple-pay")) {
            String deviceId = details.get("deviceId");
            boolean biometric = Boolean.parseBoolean(details.get("biometric"));
            // Validate Apple Pay
            if (deviceId != null && biometric) {
                System.out.println("Processing Apple Pay...");
                // Apple Pay processing logic
            } else {
                System.out.println("Apple Pay authentication failed");
            }
        }
        // Adding new payment type requires modifying this method! 😱
        // Same validation logic repeated everywhere! 😱
    }
}
```

### With Strategy Pattern (Clean & Organized)
```java
public class SmartPaymentProcessor {
    private PaymentStrategy paymentStrategy;
    
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.paymentStrategy = strategy;
    }
    
    public void processPayment(double amount) {
        if (paymentStrategy.validatePaymentDetails()) {
            paymentStrategy.pay(amount); // Strategy handles everything!
        } else {
            System.out.println("❌ Invalid payment details");
        }
    }
    
    // Adding new payment type? Just create new strategy class! 🎉
    // Existing code doesn't change! 🎉
}
```

## 🔧 Strategy Pattern Extensions

### Adding Cryptocurrency Payment
```java
public class CryptoCurrencyPayment implements PaymentStrategy {
    private String walletAddress;
    private String privateKey;
    
    public CryptoCurrencyPayment(String walletAddress, String privateKey) {
        this.walletAddress = walletAddress;
        this.privateKey = privateKey;
    }
    
    @Override
    public boolean validatePaymentDetails() {
        return walletAddress != null && walletAddress.startsWith("1") && privateKey != null;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("₿ Connecting to blockchain network...");
        System.out.println("Wallet: " + walletAddress);
        System.out.println("Confirming transaction on blockchain...");
        System.out.println("✅ Paid $" + amount + " via Bitcoin");
    }
    
    @Override
    public String getPaymentType() {
        return "Bitcoin";
    }
}
```

### Adding Payment Result Tracking
```java
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;
    private List<String> paymentHistory = new ArrayList<>();
    
    public boolean checkout() {
        if (paymentStrategy == null) {
            System.out.println("❌ Please select a payment method");
            return false;
        }
        
        String paymentMethod = paymentStrategy.getPaymentType();
        boolean success = paymentStrategy.validatePaymentDetails();
        
        if (success) {
            paymentStrategy.pay(totalAmount);
            paymentHistory.add("SUCCESS: $" + totalAmount + " via " + paymentMethod);
        } else {
            paymentHistory.add("FAILED: Invalid " + paymentMethod + " details");
        }
        
        return success;
    }
    
    public void showPaymentHistory() {
        System.out.println("Payment History:");
        paymentHistory.forEach(System.out::println);
    }
}
```

## 🚀 Key Strategy Pattern Rules

### ✅ **Do This (Good Strategy Design):**
```java
// Strategies encapsulate complete algorithms
public class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        // Complete PayPal payment algorithm here
        validateCredentials();
        connectToPayPal();
        processPayment(amount);
        handleErrors();
    }
}

// Context delegates to current strategy
public void checkout() {
    paymentStrategy.pay(amount); // Let strategy handle everything
}

// Strategies are interchangeable at runtime
cart.setPaymentStrategy(new CreditCardPayment());  // Switch to credit card
cart.setPaymentStrategy(new PayPalPayment());      // Switch to PayPal
```

### ❌ **Don't Do This (Breaks Strategy Pattern):**
```java
// Don't check strategy type in context
public void checkout() {
    if (paymentStrategy instanceof CreditCardPayment) { // Wrong! Defeats the purpose
        // Context shouldn't know specific strategy types
    }
}

// Don't put strategy logic in context
public void checkout() {
    if (paymentType.equals("credit-card")) { // Wrong! Use strategy objects
        // This brings back the complex conditionals
    }
}

// Don't make strategies dependent on each other
public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        PayPalPayment paypal = new PayPalPayment(); // Wrong! Strategies should be independent
    }
}
```

## 💡 Amazon Real Example

**Amazon Payment Processing Strategy Pattern:**

**Payment Strategies:**
1. **Credit/Debit Cards**: Visa, MasterCard, American Express processing
2. **Digital Wallets**: PayPal, Apple Pay, Google Pay integration
3. **Amazon Pay**: Amazon's own payment processing system
4. **Gift Cards**: Amazon gift card balance processing
5. **Bank Transfer**: Direct bank account payments
6. **Buy Now Pay Later**: Klarna, Affirm installment payments

**Strategy-Specific Behaviors:**
- **Credit Cards**: CVV validation, billing address verification, fraud detection
- **PayPal**: OAuth redirect, PayPal account authentication, balance checking
- **Apple Pay**: Touch ID/Face ID verification, device authentication
- **Gift Cards**: Balance validation, partial payment handling, code verification

**Runtime Strategy Selection:**
- User selects payment method → Amazon sets appropriate payment strategy
- Same checkout process → Different payment algorithms execute
- Payment validation → Each strategy validates its own requirements
- Transaction processing → Strategy-specific processing logic runs

**Strategy Pattern Benefits in Amazon:**
- **Easy Payment Addition**: New payment methods don't require changing checkout flow
- **Regional Adaptation**: Different countries use different payment strategy combinations
- **A/B Testing**: Can test new payment strategies without affecting existing ones
- **Maintenance**: Each payment method's code is isolated and independently maintainable

This demonstrates how Strategy Pattern enables Amazon to support dozens of payment methods seamlessly!

## 🎯 Learning Takeaway

After running this demo, you should understand:
- How Strategy pattern eliminates complex payment processing conditionals
- Why each strategy should encapsulate its complete algorithm
- How the same context can use different algorithms interchangeably
- When to use Strategy pattern for systems with multiple ways to perform the same task

## 💭 Remember

The Strategy Pattern is like having **different tools for the same job**:
- **Same job** (payment processing) with **different tools** (payment methods)
- **Each tool** (strategy) knows exactly how to do its specific job
- **Switching tools** (strategies) changes how the job gets done
- **No confusion** - each tool has clear instructions for its use

When you see **multiple ways to accomplish the same task**, **algorithms that need to be swapped at runtime**, **complex conditional logic for similar operations**, or **systems that need easy algorithm extension** - that's Strategy Pattern organizing interchangeable behaviors into clean, maintainable strategies! 💳🔄✨

This payment processing example perfectly demonstrates how Strategy Pattern makes complex algorithmic systems flexible, maintainable, and easily extensible!