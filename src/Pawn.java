import java.util.ArrayList;
import java.util.List;

public class Pawn implements Pieces{

    private static int xPosition = 7; //current position on x of the bishop
    private static int yPosition = 7; // current position on y of the bishop
    int x;
    int y;
    private String color;
    private String name = "Pawn";
    //where the possible cells are going to be stored
    ArrayList <Integer> possibleCellsX  = new ArrayList<>();
    ArrayList <Integer> possibleCellsY  = new ArrayList<>();

    // public  int topLeft = Math.min(getX(), getY()) ;
    // public  int bottomRight = 7 - Math.max(getX(), getY());
    // public  int topRight = Math.min(getX(), 9 - getY()) ;
    // public  int bottomLeft = 9 - Math.max(getX(), 9 - getY());

    public Pawn(String color){
        this.color = color;
    }
    public static void main(String[] args) {
        Pieces [][]boardField = {
//                {null,null,null,null,null,null,null,null},
//                {null,null,null,null,null,null,null,null},
//                {null,null,null,null,new Pawn("black"),null,null,null},
//                {null,null,null,null,new Pawn("white"),null,null,null},
//                {null,null,null,null,null,null,null,null},
//                {null,null,null,null,null,null,null,null},
//                {null,null,null,null,null,null,null,null},
//                {null,null,null,null,null,null,null,null}

                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,new Pawn("white"),null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,null,null},
                {null,null,null,null,null,null,new King("white"),null},
                {null,null,null,null,null,null,null,new Pawn("black")}
        };

//        Pawn pawn1 = new Pawn("white");
        Pawn pawn2 = new Pawn("black");
//        System.out.println(pawn1.movePiece(boardField).toString());
        System.out.println(pawn2.movePiece(boardField).toString());
       // pawn.movePiece(Field);
        
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
    public List<PossibleCells> movePiece(Pieces [][] boardField){
        ArrayList <PossibleCells> possibleCells = new ArrayList<>();
        x = xPosition;
        y = yPosition;

        //white side pawn--its starting position--top one space or two spaces
        if (boardField[x][y].getColor().equals("white")) {
            if(y==1 && x>=0 && x<=7){
                //one or two steps
                if(boardField[x][y+1] == null){
                    possibleCells.add(new PossibleCells(x, y+1));
                    if(boardField[x][y+2] == null){
                        possibleCells.add(new PossibleCells(x, y+2));
                    }
                }
            } else { //Not in the initial position can only be one step
                // No pieces in front
                if(x>=0 && x<=7 && y+1<=7 && boardField[x][y+1] == null){
                    possibleCells.add(new PossibleCells(x, y+1));
                }
            }
            //Normal diagonal a frame to eat a piece, special eat a piece crossing the pawn, diagonal opposite no piece before (important)
            //Normal Piece Eating
            if(x-1>=0 && y+1<=7
                    && boardField[x-1][y+1] != null
                    && eatOpponent("white",boardField[x-1][y+1].getColor())
            ){
                possibleCells.add(new PossibleCells(x-1, y+1));
            }
            if(x+1<=7 && y+1<=7
                    && boardField[x+1][y+1] != null
                    && eatOpponent("white",boardField[x+1][y+1].getColor())
            ){
                possibleCells.add(new PossibleCells(x+1, y+1));
            }
            //check top and bottom, en passant==7，move to top left or bottom left,，meet at y==4，
            //top right
            if(y==4 && boardField[x-1][y] != null && boardField[x-1][y].getColor().equals("black") && boardField[x-1][y].getName().equals("Pawn") && boardField[x-1][y+1] == null) {
                    possibleCells.add(new PossibleCells(x-1, y+1));
            }
            //bottom right
            if(y==4 && boardField[x+1][y] != null && boardField[x+1][y].getColor().equals("black") && boardField[x+1][y].getName().equals("Pawn") && boardField[x+1][y+1]== null){
                    possibleCells.add(new PossibleCells(x+1, y+1));
            }

        }
        //black side pawn---its starting position--top one space or two spaces
        else if(boardField[x][y].getColor().equals("black")){
            if(y==6 && x>=0 && x<= 7 ){
                //one or two
                if(boardField[x][y-1] == null){
                    //one step OK
                    possibleCells.add(new PossibleCells(x, y-1));
                    //even two steps OK
                    if(boardField[x][y-2] == null){
                        possibleCells.add(new PossibleCells(x, y-2));
                    }
                }
            }else{
                //Not in the initial position can only be one step
                if(x>=0 && x<=7 && y-1>=0 && boardField[x][y-1] == null){
                    possibleCells.add(new PossibleCells(x, y-1));
                }
            }
            //Eat pieces normally, only 1 square on the diagonal
            if(x-1>=0 && y-1>=0 && boardField[x-1][y-1] != null && eatOpponent("black",boardField[x-1][y-1].getColor())){
                possibleCells.add(new PossibleCells(x-1, y-1));
            }
            if(x+1<=7 && y-1>=0 && boardField[x+1][y-1] != null && eatOpponent("black",boardField[x+1][y-1].getColor())){
                possibleCells.add(new PossibleCells(x+1, y-1));
            }

            //check top and bottom, en passant==1，move to top left or bottom left,meet at y==3
            //top left
            if(y==3 && boardField[x-1][y] != null && boardField[x-1][y].getColor().equals("white") && boardField[x-1][y].getName().equals("Pawn") && boardField[x-1][y-1]== null) {
                possibleCellsX.add(x-1);
                possibleCellsY.add(y-1);
                possibleCells.add(new PossibleCells(x-1, y+1));
            }
            //bottom left
            if(y==3 && boardField[x+1][y] != null && boardField[x+1][y].getColor().equals("white") && boardField[x+1][y].getName().equals("Pawn") && boardField[x+1][y-1]== null) {
                possibleCellsX.add(x+1);
                possibleCellsY.add(y-1);
                possibleCells.add(new PossibleCells(x+1, y-1));
            }
        }
        // possibleCells.add(new PossibleCells(x+1, y-1));
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
            return "x: "+ x + ", "+ "y:"+ " "+ y;
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