package Creational.AbstractFactory.cuisine;

import Creational.AbstractFactory.product.Appetizer;

//Concrete Appetizer for North Indian cuisine.
 
public class NorthIndianAppetizer extends Appetizer {
    public NorthIndianAppetizer() {
        name = "Samosa";
        price = 4.99;
    }
    @Override
    public String prepare() {
        return "Preparing crispy samosas with spiced potato filling";
    }
    @Override
    public String getDescription() {
        return "Deep-fried pastry with spiced potato and pea filling";
    }
}