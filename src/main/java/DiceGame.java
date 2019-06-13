import java.util.ArrayList;

public abstract class DiceGame extends Game {
    private Dice dice;


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

    public DiceGame(Integer numberOfDice){
        dice=new Dice(numberOfDice);

   }

    //   public ArrayList<Dice> makeDice(Integer numberOfDice) {return new ArrayList<Dice>();}


}
