import java.util.ArrayList;
import java.util.List;

public class Queen implements Pieces{

    private static int xPosition = 4; //current position on x of the bishop
    private static int yPosition = 0; // current position on y of the bishop
    int x;
    int y;
    private String color;
    private String name = "Queen";
    //where the possible cells are going to be stored
    ArrayList <Integer> possibleCellsX  = new ArrayList<>();
    ArrayList <Integer> possibleCellsY  = new ArrayList<>();


    public Queen(String color){
        this.color = color;
    }
    public static void main(String[] args) {
        Pieces [][]boardField = {
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {new Queen("white"),null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {new Queen("black"),null,null,null,null,null,null,null}
        };

        Queen Queen1 = new Queen("white");

        System.out.println(Queen1.movePiece(boardField).toString());
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

    //8 kinds of directions, 8 kinds of method calls,
    public void topLeft(int xPosition, int yPosition, Pieces [][] boardField, ArrayList <Queen.PossibleCells> possibleCells) {
        int counter = 0;
        int x = xPosition;//不是全局变量的x,y.这是局部。写int就是局部，不写int就是上面的属性
        int y = yPosition;
        boolean stop = false;
        String side = boardField[x][y].getColor();

        while(!stop) {
            if (x-1>=0 && y-1>=0 && boardField[x-1][y-1] == null) {
                //if there are no pieces in the topLeft，
                x--; y--;
                counter = counter + 1;
                possibleCells.add(new Queen.PossibleCells(x, y));
            } else if(x-1>=0 && y-1>=0 && boardField[x-1][y-1] != null && eatOpponent(side,boardField[x-1][y-1].getColor())){
                //The opponent blocks the topLeft
                counter = counter + 1;
                possibleCells.add(new Queen.PossibleCells(x-1, y-1));
                stop = true;
            } else {
                //White's own piece blocks the topLeft
                stop = true;
            }
        }
        System.out.println("topLeft"+counter);
    }
    private void bottomRight(int xPosition, int yPosition, Pieces [][] boardField, ArrayList <Queen.PossibleCells> possibleCells){
        int counter = 0;
        x = xPosition;
        y = yPosition;
        boolean stop = false;
        String side = boardField[x][y].getColor();

        while(!stop) {
            if (x+1<=7 && y+1<=7 && boardField[x+1][y+1]==null) {
                //if there are no pieces in the bottomRight
                x++; y++;
                counter = counter + 1;
                possibleCells.add(new Queen.PossibleCells(x, y));
            } else if(x+1<=7 && y+1<=7 && boardField[x+1][y+1]!=null && eatOpponent(side,boardField[x+1][y+1].getColor())){
                //The opponent blocks the bottomRight
                counter = counter + 1;
                possibleCells.add(new Queen.PossibleCells(x+1, y+1));
                stop = true;
            } else {
                //White's own piece blocks the bottomRight
                stop = true;
            }
        }
        System.out.println("bottomRight"+counter);
    }
    private void topRight(int xPosition, int yPosition, Pieces [][] boardField, ArrayList <Queen.PossibleCells> possibleCells) {
        int counter = 0;
        x = xPosition;
        y = yPosition;
        boolean stop = false;
        String side = boardField[x][y].getColor();

        while(!stop) {
            if (x-1>=0 && y+1<=7 && boardField[x-1][y+1]==null) {
                //if there are no pieces in the topRight
                x--; y++;
                counter = counter + 1;
                possibleCells.add(new Queen.PossibleCells(x, y));
            } else if(x-1>=0 && y+1<=7 && boardField[x-1][y+1]!=null && eatOpponent(side,boardField[x-1][y+1].getColor())){
                //The opponent blocks the topRight
                counter = counter + 1;
                possibleCells.add(new Queen.PossibleCells(x-1, y+1));
                stop = true;
            } else {
                //White's own piece blocks the topRight
                stop = true;
            }
        }
        System.out.println("topRight"+counter);
    }
    private void bottomLeft(int xPosition, int yPosition, Pieces [][] boardField, ArrayList <Queen.PossibleCells> possibleCells){
        int counter = 0;
        x = xPosition;
        y = yPosition;
        boolean stop = false;
        String side = boardField[x][y].getColor();

        while(!stop) {
            if (x+1<=7 && y-1>=0 && boardField[x+1][y-1]==null) {
                //if there are no pieces in the bottomLeft
                x++; y--;
                counter = counter + 1;
                possibleCells.add(new Queen.PossibleCells(x, y));
            } else if(x+1<=7 && y-1>=0 && boardField[x+1][y-1]!=null && eatOpponent(side,boardField[x+1][y-1].getColor())){
                //The opponent blocks the bottomLeft
                counter = counter + 1;
                possibleCells.add(new Queen.PossibleCells(x+1, y-1));
                stop = true;
            } else {
                //White's own piece blocks the bottomLeft
                stop = true;
            }
        }
        System.out.println("bottomLeft"+counter);
    }
    private void top(int xPosition, int yPosition, Pieces [][] boardField, ArrayList <Queen.PossibleCells> possibleCells) {
        int counter = 0;
        x = xPosition;
        y = yPosition;
        boolean stop = false;
        String side = boardField[x][y].getColor();

        while(!stop) {
            if (x-1>=0 && boardField[x-1][y]==null) {
                //if there are no pieces in the top
                x--;
                counter++;
                possibleCells.add(new Queen.PossibleCells(x, y));
            } else if(x-1>=0 && boardField[x-1][y]!=null && eatOpponent(side,boardField[x-1][y].getColor())){
                //The opponent blocks the top
                counter++;
                possibleCells.add(new Queen.PossibleCells(x-1, y));
                stop = true;
            } else {
                //White's own piece blocks the top
                stop = true;
            }
        }
        System.out.println("top"+counter);
    }
    private void left(int xPosition, int yPosition, Pieces [][] boardField, ArrayList <Queen.PossibleCells> possibleCells) {
        int counter=0;
        x = xPosition;
        y = yPosition;
        boolean stop = false;
        String side = boardField[x][y].getColor();

        while(!stop) {
            if (y-1>=0 && boardField[x][y-1]==null) {
                //if there are no pieces in the left
                y--;
                counter++;
                possibleCells.add(new Queen.PossibleCells(x, y));
            } else if(y-1>=0 && boardField[x][y-1]!=null && eatOpponent(side,boardField[x][y-1].getColor())){
                //The opponent blocks the left
                counter++;
                possibleCells.add(new Queen.PossibleCells(x, y-1));
                stop = true;
            } else {
                //White's own piece blocks the left
                stop = true;
            }
        }
        System.out.println("left"+counter);

    }
    private void right(int xPosition, int yPosition, Pieces [][] boardField, ArrayList <Queen.PossibleCells> possibleCells) {
        int counter = 0;
        x = xPosition;
        y = yPosition;
        boolean stop = false;
        String side = boardField[x][y].getColor();

        while(!stop) {
            if (y+1<=7 && boardField[x][y+1]==null) {
                //if there are no pieces in the right
                y++;
                counter++;
                possibleCells.add(new Queen.PossibleCells(x, y));
            } else if(y+1<=7 && boardField[x][y+1]!=null && eatOpponent(side,boardField[x][y+1].getColor())){
                //The opponent blocks the right
                counter++;
                possibleCells.add(new Queen.PossibleCells(x, y+1));
                stop = true;
            } else {
                //White's own piece blocks the right
                stop = true;
            }
        }
        System.out.println("right"+counter);
    }
    private void bottom(int xPosition, int yPosition, Pieces [][] boardField, ArrayList <Queen.PossibleCells> possibleCells) {
        int counter = 0;
        x = xPosition;
        y = yPosition;
        boolean stop = false;
        String side = boardField[x][y].getColor();

        while(!stop) {
            if (x+1<=7 && boardField[x+1][y]==null) {
                //if there are no pieces in the bottom
                x++;
                counter++;
                //Each counter is used to test whether it is good or not, and it is convenient to see the number of 8 directions of movement
                possibleCells.add(new Queen.PossibleCells(x, y));
            } else if(x+1<=7 && boardField[x+1][y]!=null && eatOpponent(side,boardField[x+1][y].getColor())){
                //The opponent blocks the bottom
                counter++;
                possibleCells.add(new Queen.PossibleCells(x+1, y));
                stop = true;
            } else {
                //White's own piece blocks the bottom
                stop = true;
            }
        }
        System.out.println("bottom"+counter);
    }


    @Override
    public List<Queen.PossibleCells> movePiece(Pieces[][] boardField){
        ArrayList <Queen.PossibleCells> possibleCells = new ArrayList<>();
        x = xPosition;
        y = yPosition;

        //topLeft--white/black
        topLeft(xPosition, yPosition, boardField, possibleCells);

        //bottomRight--white/black
        bottomRight(xPosition, yPosition, boardField, possibleCells);

        //topRight--white/black
        topRight(xPosition, yPosition, boardField, possibleCells);

        //bottomLeft--white/black
        bottomLeft(xPosition, yPosition, boardField, possibleCells);

        //top
        top(xPosition, yPosition, boardField, possibleCells);

        //left
        left(xPosition, yPosition, boardField, possibleCells);

        //right
        right(xPosition, yPosition, boardField, possibleCells);

        //bottom
        bottom(xPosition, yPosition, boardField, possibleCells);

        return possibleCells;
    }

    class PossibleCells{
        int x;
        int y;
        public int getX(){
            return x;
        }
        public int getY(){
            return y;
        }
        PossibleCells(int x , int y){
            this.x = x;
            this.y = y;
        }
        public String toString(){
            return "x: "+ x + ", "+ "y: " + y + "\n";
        }
    }



    public int getX(){
        return xPosition;
    }
    public int getY(){
        return yPosition;
    }

    public void setColor(String color){
        this.color = color;
    }
    public String getColor(){
        return color;
    }
    public String getName(){
        return name;
    }


    // @Override
    // public List movePiece() {
    //     // TODO Auto-generated method stub
    //     return null;
    // }


}
