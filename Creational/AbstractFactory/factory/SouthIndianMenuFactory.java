package Creational.AbstractFactory.factory;

import Creational.AbstractFactory.cuisine.SouthIndianAppetizer;
import Creational.AbstractFactory.cuisine.SouthIndianDessert;
import Creational.AbstractFactory.cuisine.SouthIndianMainCourse;
import Creational.AbstractFactory.product.Appetizer;
import Creational.AbstractFactory.product.Dessert;
import Creational.AbstractFactory.product.MainCourse;

/**
 * Concrete factory for South Indian cuisine menu items.
 */
public class SouthIndianMenuFactory extends MenuFactory {
    @Override
    public Appetizer createAppetizer() {
        return new SouthIndianAppetizer();
    }
    @Override
    public MainCourse createMainCourse() {
        return new SouthIndianMainCourse();
    }
    @Override
    public Dessert createDessert() {
        return new SouthIndianDessert();
    }
}
