package Structural.Adapter;

// External Google API (can't change this)
public class GoogleTranslator {
    public String performTranslation(String text, String fromLang, String toLang) {
        System.out.println("Google translating: " + text);
        return text + "_" + toLang;
    }
}