package Structural.Flyweight;

public class ChessDemo {
    
    public static void main(String[] args) {
        System.out.println("Chess Flyweight Pattern Demo");
        System.out.println("============================");
        
        // Create many chess pieces
        ChessPieceFlyweight whiteKing = ChessPieceFactory.getPiece("King");
        ChessPieceFlyweight blackKing = ChessPieceFactory.getPiece("King");
        ChessPieceFlyweight whitePawn1 = ChessPieceFactory.getPiece("Pawn");
        ChessPieceFlyweight whitePawn2 = ChessPieceFactory.getPiece("Pawn");
        ChessPieceFlyweight blackPawn1 = ChessPieceFactory.getPiece("Pawn");
        
        System.out.println("\nDisplaying pieces:");
        whiteKing.display("White", 0, 4);
        blackKing.display("Black", 7, 4);
        whitePawn1.display("White", 1, 0);
        whitePawn2.display("White", 1, 1);
        blackPawn1.display("Black", 6, 0);
        
        System.out.println("\nMemory usage:");
        System.out.println("Total pieces used: 5");
        System.out.println("Flyweight objects created: " + ChessPieceFactory.getCreatedPieces());
        System.out.println("Memory saved by sharing flyweights!");
        
        System.out.println("\nDemo Complete!");
    }
}