package Creational.AbstractFactory.cuisine;

import Creational.AbstractFactory.product.Dessert;

//Concrete Dessert for North Indian cuisine.

public class NorthIndianDessert extends Dessert {
    public NorthIndianDessert() {
        name = "Gulab Jamun";
        price = 5.99;
    }
    @Override
    public String prepare() {
        return "Preparing soft milk-solid balls soaked in rose-flavored syrup";
    }
    @Override
    public String getDescription() {
        return "Sweet deep-fried balls in cardamom and rose syrup";
    }
}
