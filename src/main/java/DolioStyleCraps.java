import java.util.ArrayList;

public class DolioStyleCraps extends DiceGame {
    public DolioStyleCraps(Integer numberOfDice) {
        super(numberOfDice);
    }
    public DolioStyleCraps(Player[] players, Integer numberOfDice) {
        super(players, numberOfDice);
    }
    Dice dice=new Dice(2);
    DStyleCrapsPlayer player;
public DolioStyleCraps(DStyleCrapsPlayer[] players) {
       super(players, 2);
   }

    public Boolean didWin(Player player) {
        if(dice.tossAndSum()==7||dice.tossAndSum()==11)
        return true;
        else if(dice.tossAndSum()==2)
            return  false;
        return false;
       }
    public void playGame() {
        player.roll(dice);


    }
    public void endOfGame() {
        if(didWin(players[0])==true)
            System.out.println("Player "+players[0]+" won the game");
        else if(didWin(players[0])==false)
            System.out.println("Player "+players[0]+" lost the game");
        else
            playGame();
    }
}
