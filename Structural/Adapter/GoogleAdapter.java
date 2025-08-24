package Structural.Adapter;

// Adapter that makes Google work with our app
public class GoogleAdapter implements TranslationService {
    private GoogleTranslator googleTranslator;
    
    public GoogleAdapter() {
        this.googleTranslator = new GoogleTranslator();
    }
    
    @Override
    public String translate(String text, String language) {
        // Convert our method to Google's method
        return googleTranslator.performTranslation(text, "english", language);
    }
}
