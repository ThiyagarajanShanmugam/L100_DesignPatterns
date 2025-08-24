package Structural.Flyweight;

import java.util.HashMap;
import java.util.Map;

// Factory that creates and reuses flyweights
public class ChessPieceFactory {
    private static Map<String, ChessPieceFlyweight> pieces = new HashMap<>();
    
    public static ChessPieceFlyweight getPiece(String type) {
        ChessPieceFlyweight piece = pieces.get(type);
        
        if (piece == null) {
            if (type.equals("King")) {
                piece = new King();
            } else if (type.equals("Pawn")) {
                piece = new Pawn();
            }
            pieces.put(type, piece);
            System.out.println("Created new flyweight: " + type);
        } else {
            System.out.println("Reused flyweight: " + type);
        }
        
        return piece;
    }
    
    public static int getCreatedPieces() {
        return pieces.size();
    }
}
