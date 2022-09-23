import java.util.List;

public interface Pieces {
    public String name = null; 
    public List movePiece(Pieces [][] field);
    public int getX();
    public int getY();
    public String getColor();
    public String getName();


}
