import java.util.ArrayList;

public abstract class DiceGame extends Game {
    protected Dice dice;


    public DiceGame(Player[] players, Integer numberOfDice) {
        super(players);
        dice = new Dice(numberOfDice);

    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }


    //   public ArrayList<Dice> makeDice(Integer numberOfDice) {return new ArrayList<Dice>();}


}
