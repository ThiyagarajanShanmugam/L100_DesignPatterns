package Structural.Adapter;

public class MobileAppDemo {
    public static void main(String[] args) {
        System.out.println("Mobile App Translation - Adapter Pattern");
        System.out.println("========================================");
        
        // Mobile app uses simple interface
        TranslationService translator = new GoogleAdapter();
        
        String result1 = translator.translate("Hello", "Spanish");
        String result2 = translator.translate("Good Morning", "French");
        
        System.out.println("Spanish: " + result1);
        System.out.println("French: " + result2);
        
        System.out.println("Demo Complete!");
    }
}
