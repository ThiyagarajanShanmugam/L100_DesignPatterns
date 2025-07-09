package Creational.AbstractFactory.cuisine;

import Creational.AbstractFactory.product.Appetizer;

/**
 * Concrete Appetizer for South Indian cuisine.
 */
public class SouthIndianAppetizer extends Appetizer {
    public SouthIndianAppetizer() {
        name = "Medu Vada";
        price = 4.49;
    }
    @Override
    public String prepare() {
        return "Deep frying fermented lentil donuts with coconut chutney";
    }
    @Override
    public String getDescription() {
        return "Crispy lentil donuts served with coconut chutney and sambar";
    }
}
