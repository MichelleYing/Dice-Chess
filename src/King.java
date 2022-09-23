import java.util.ArrayList;
import java.util.List;

public class King implements Pieces {

    private static int xPosition = 7; //current position on x of the bishop
    private static int yPosition = 0; // current position on y of the bishop
    int x;
    int y;
    private String color;
    private String name = "King";
    //where the possible cells are going to be stored
    ArrayList<Integer> possibleCellsX = new ArrayList<>();
    ArrayList<Integer> possibleCellsY = new ArrayList<>();

    public King(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
        Pieces[][] boardField = {
                {null, null, null, null, null, null, null, new Rook("black")},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {new King("black"), null, null, null, null, null, null, new Rook("black")}
        };

        King king1 = new King("white");
        System.out.println(king1.movePiece(boardField).toString());
        // king.movePiece(Field);

    }

    public boolean eatOpponent(String color1, String color2){
        if (color1.equals("white") && color2.equals("black")) {
            return true;
        }
        if (color1.equals("black") && color2.equals("white")) {
            return true;
        }
        return false;
    }

    @Override
    public List<King.PossibleCells> movePiece(Pieces[][] boardField) {
        ArrayList<King.PossibleCells> possibleCells = new ArrayList<>();
        x = xPosition;
        y = yPosition;

        //8 positions of white
        if (boardField[x][y].getColor() == "white" && boardField[x][y].getName() == "King") {
            //top left，can eat 0，7-12
            if (x - 1 >= 0 && y - 1 >= 0 && (boardField[x-1][y-1] == null || eatOpponent("white",boardField[x-1][y-1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x-1, y-1));
            }
            //top right
            if (x - 1 >= 0 && y + 1 <= 7 && (boardField[x-1][y+1] == null || eatOpponent("white",boardField[x-1][y+1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x-1, y+1));
            }
            //bottom right
            if (x + 1 <= 7 && y + 1 <= 7 && (boardField[x+1][y+1] == null || eatOpponent("white",boardField[x+1][y+1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x+1, y+1));
            }
            //bottom left
            if (x + 1 <= 7 && y - 1 >= 0 && (boardField[x+1][y-1] == null || eatOpponent("white",boardField[x+1][y-1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x+1, y-1));
            }
            //top
            if (x - 1 >= 0 && (boardField[x-1][y] == null || eatOpponent("white",boardField[x-1][y].getColor()))) {
                possibleCells.add(new King.PossibleCells(x-1, y));
            }
            //right
            if (y + 1 <= 7 && (boardField[x][y+1] == null || eatOpponent("white",boardField[x][y+1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x, y+1));
            }

            //left
            if (y - 1 >= 0 && (boardField[x][y-1] == null || eatOpponent("white",boardField[x][y-1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x, y-1));
            }

            //bottom
            if (x + 1 <= 7 && (boardField[x+1][y] == null || eatOpponent("white",boardField[x+1][y].getColor()))) {
                possibleCells.add(new King.PossibleCells(x+1, y));
            }
            //normal--1 square, castling--2 squares
            //white side--Short castling
            if (y == 0 && x == 4 && boardField[x+1][y] == null && boardField[x+2][y] == null
                    && boardField[x+3][y] != null && boardField[x+3][y].getColor() == "white" && boardField[x+3][y].getName() == "Rook") {
                possibleCells.add(new King.PossibleCells(x+2, y));
            }
            //white side--Long castling
            if (y == 0 && x == 4 && boardField[x-1][y] == null && boardField[x-2][y] == null
                    && boardField[x-3][y] == null &&  boardField[x-4][y] != null && boardField[x-4][y].getColor() == "white" && boardField[x-4][y].getName() == "Rook") {
                possibleCells.add(new King.PossibleCells(x-2, y));
            }
        }
        //8 positions of black
        if (boardField[x][y].getColor() == "black" && boardField[x][y].getName() == "King") {
            //8
            //top left，can eat 0，1-6
            if (x - 1 >= 0 && y - 1 >= 0 && (boardField[x-1][y-1] == null || eatOpponent("black",boardField[x-1][y-1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x-1, y-1));
            }
            //top right
            if (x - 1 >= 0 && y + 1 <= 7 && (boardField[x-1][y+1] == null || eatOpponent("black",boardField[x-1][y+1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x-1, y+1));
            }
            //bottom right
            if (x + 1 <= 7 && y + 1 <= 7 && (boardField[x+1][y+1] == null || eatOpponent("black",boardField[x+1][y+1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x+1, y+1));
            }
            //bottom left
            if (x + 1 <= 7 && y - 1 >= 0 && (boardField[x+1][y-1] == null || eatOpponent("black",boardField[x+1][y-1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x+1, y-1));
            }
            //top
            if (x - 1 >= 0 && (boardField[x-1][y] == null || eatOpponent("black",boardField[x-1][y].getColor()))) {
                possibleCells.add(new King.PossibleCells(x-1, y));
            }
            //right
            if (y + 1 <= 7 && (boardField[x][y+1] == null || eatOpponent("black",boardField[x][y+1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x, y+1));
            }

            //left
            if (y - 1 >= 0 && (boardField[x][y - 1] == null || eatOpponent("black",boardField[x][y-1].getColor()))) {
                possibleCells.add(new King.PossibleCells(x, y-1));
            }

            //bottom
            if (x + 1 <= 7 && (boardField[x + 1][y] == null || eatOpponent("black",boardField[x+1][y].getColor()))) {
                possibleCells.add(new King.PossibleCells(x+1, y));
            }

            //black side--Short castling
            if (y == 7 && x == 4 && boardField[x + 1][y] == null && boardField[x + 2][y] == null
                    && boardField[x+3][y] != null && boardField[x+3][y].getColor() == "black" && boardField[x+3][y].getName() == "Rook") {
                possibleCells.add(new King.PossibleCells(x+2, y));
            }
            //black side--Long castling
            if (y == 7 && x == 4 && boardField[x-1][y] == null && boardField[x-2][y] == null
                    && boardField[x-3][y] == null && boardField[x-4][y] != null && boardField[x-4][y].getColor() == "black" && boardField[x+3][y].getName() == "Rook") {
                possibleCells.add(new King.PossibleCells(x-2, y));
            }

        }
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