import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class Game {
    protected Player[] players;
    protected Turn turn;
    public Game(Player[] players) {
        this.players = players;
    }
    public Game(){}
//    abstract Boolean didWin(Player player);
    abstract void playGame();
    abstract void endOfGame();


}
