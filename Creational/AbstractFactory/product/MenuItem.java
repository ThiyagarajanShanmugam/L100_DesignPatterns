package Creational.AbstractFactory.product;

/**
 * Abstract product for menu items (Appetizer, MainCourse, Dessert).
 * Each cuisine must provide concrete implementations.
 */
public abstract class MenuItem {
    protected String name;
    protected double price;
    
    /**
     * Prepare the menu item (cooking/serving instructions).
     */
    public abstract String prepare();
    /**
     * Get a description of the menu item.
     */
    public abstract String getDescription();
    
    public String getName() { return name; }
    public double getPrice() { return price; }
}
