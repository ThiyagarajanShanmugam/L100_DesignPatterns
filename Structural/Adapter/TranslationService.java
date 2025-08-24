package Structural.Adapter;

// What our mobile app expects
public interface TranslationService {
    String translate(String text, String language);
}