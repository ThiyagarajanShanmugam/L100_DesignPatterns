package Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

// Subject - Stock that notifies investors
public class Stock {
    private String name;
    private double price;
    private List<String> investors;
    
    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
        this.investors = new ArrayList<>();
    }
    
    public void addInvestor(String investorName) {
        investors.add(investorName);
        System.out.println(investorName + " watching " + name);
    }
    
    public void setPrice(double newPrice) {
        this.price = newPrice;
        System.out.println("\n" + name + " price: $" + price);
        
        // Notify all investors
        for (String investor : investors) {
            System.out.println("  -> " + investor + " notified!");
        }
    }
}
