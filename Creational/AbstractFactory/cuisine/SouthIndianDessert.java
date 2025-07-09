package Creational.AbstractFactory.cuisine;

import Creational.AbstractFactory.product.Dessert;

/**
 * Concrete Dessert for South Indian cuisine.
 */
public class SouthIndianDessert extends Dessert {
    public SouthIndianDessert() {
        name = "Payasam";
        price = 4.99;
    }
    @Override
    public String prepare() {
        return "Simmering rice, milk, and jaggery with cardamom and nuts";
    }
    @Override
    public String getDescription() {
        return "Sweet South Indian pudding with rice, milk, and nuts";
    }
}
