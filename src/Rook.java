import java.util.ArrayList;
import java.util.List;

public class Rook implements Pieces {

    private static int xPosition = 3; //current position on x of the bishop
    private static int yPosition = 4; // current position on y of the bishop
    int x;
    int y;
    private String color;
    private String name = "Rook";
    //where the possible cells are going to be stored
    ArrayList<Integer> possibleCellsX = new ArrayList<>();
    ArrayList<Integer> possibleCellsY = new ArrayList<>();

    public Rook(String color) {
        this.color = color;
    }

    @Override
    public List<Rook.PossibleCells> movePiece(Pieces[][] boardField) {
        ArrayList<Rook.PossibleCells> possibleCells = new ArrayList<>();
        x = xPosition;
        y = yPosition;

    return possibleCells;
    }




    class PossibleCells {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        PossibleCells(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public String toString() {
            return "x: " + x + ", " + "y:" + " " + y;
        }
    }


    public int getX() {
        return xPosition;
    }

    public int getY() {
        return yPosition;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }


// @Override
// public List movePiece() {
//     // TODO Auto-generated method stub
//     return null;
// }

}