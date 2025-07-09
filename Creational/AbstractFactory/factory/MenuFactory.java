package Creational.AbstractFactory.factory;

import Creational.AbstractFactory.product.Appetizer;
import Creational.AbstractFactory.product.Dessert;
import Creational.AbstractFactory.product.MainCourse;

/**
 * Abstract Factory for creating families of menu items (Appetizer, MainCourse, Dessert).
 * Concrete factories will implement cuisine-specific creation methods.
 */
public abstract class MenuFactory {
    /**
     * Factory method for creating an appetizer.
     */
    public abstract Appetizer createAppetizer();
    /**
     * Factory method for creating a main course.
     */
    public abstract MainCourse createMainCourse();
    /**
     * Factory method for creating a dessert.
     */
    public abstract Dessert createDessert();
    
    /**
     * Template method to display a full menu with prices.
     */
    public void displayFullMenu() {
        Appetizer appetizer = createAppetizer();
        MainCourse mainCourse = createMainCourse();
        Dessert dessert = createDessert();
        
        System.out.println("=== COMPLETE MENU ===");
        System.out.println("Appetizer: " + appetizer.getName() + " - $" + appetizer.getPrice());
        System.out.println("Main Course: " + mainCourse.getName() + " - $" + mainCourse.getPrice());
        System.out.println("Dessert: " + dessert.getName() + " - $" + dessert.getPrice());
        System.out.println("Total: $" + (appetizer.getPrice() + mainCourse.getPrice() + dessert.getPrice()));
    }
}
