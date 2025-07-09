package Creational.AbstractFactory.factory;

import Creational.AbstractFactory.cuisine.NorthIndianAppetizer;
import Creational.AbstractFactory.cuisine.NorthIndianDessert;
import Creational.AbstractFactory.cuisine.NorthIndianMainCourse;
import Creational.AbstractFactory.product.Appetizer;
import Creational.AbstractFactory.product.Dessert;
import Creational.AbstractFactory.product.MainCourse;

/**
 * Concrete factory for North Indian cuisine menu items.
 */
public class NorthIndianMenuFactory extends MenuFactory {
    @Override
    public Appetizer createAppetizer() {
        return new NorthIndianAppetizer();
    }
    @Override
    public MainCourse createMainCourse() {
        return new NorthIndianMainCourse();
    }
    @Override
    public Dessert createDessert() {
        return new NorthIndianDessert();
    }
}
