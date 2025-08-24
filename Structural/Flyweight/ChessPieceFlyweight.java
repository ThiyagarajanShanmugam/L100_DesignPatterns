package Structural.Flyweight;

// Flyweight interface
public interface ChessPieceFlyweight {
    void display(String color, int row, int col);
}

// King flyweight
class King implements ChessPieceFlyweight {
    @Override
    public void display(String color, int row, int col) {
        System.out.println(color + " King at (" + row + "," + col + ")");
    }
}

// Pawn flyweight  
class Pawn implements ChessPieceFlyweight {
    @Override
    public void display(String color, int row, int col) {
        System.out.println(color + " Pawn at (" + row + "," + col + ")");
    }
}
