import java.util.ArrayList;

public class CeeLoTurn extends Turn {
    private ArrayList<Integer> bin;
    public void move(){  }
    public Integer roll() {return  0;}
    public Integer compare(){return 1;}
    public boolean checkWin(){return true;}

    @Override
    Boolean validMove() {
        return null;
    }
}
