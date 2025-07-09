package Creational.AbstractFactory.cuisine;

import Creational.AbstractFactory.product.MainCourse;

//Concrete Main Course for North Indian cuisine.
public class NorthIndianMainCourse extends MainCourse {
    public NorthIndianMainCourse() {
        name = "Butter Chicken";
        price = 12.99;
    }
    @Override
    public String prepare() {
        return "Cooking tender chicken in rich tomato and butter gravy";
    }
    @Override
    public String getDescription() {
        return "Creamy chicken curry in tomato-based sauce with aromatic spices";
    }
}
