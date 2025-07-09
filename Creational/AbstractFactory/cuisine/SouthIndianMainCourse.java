package Creational.AbstractFactory.cuisine;

import Creational.AbstractFactory.product.MainCourse;

/**
 * Concrete Main Course for South Indian cuisine.
 */
public class SouthIndianMainCourse extends MainCourse {
    public SouthIndianMainCourse() {
        name = "Masala Dosa";
        price = 8.99;
    }
    @Override
    public String prepare() {
        return "Making crispy rice crepe with spiced potato filling";
    }
    @Override
    public String getDescription() {
        return "Fermented rice and lentil crepe with spiced potato curry filling";
    }
}
