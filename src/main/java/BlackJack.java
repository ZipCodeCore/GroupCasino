
import java.util.ArrayList;

public class BlackJack extends CardGame {
ArrayList<Card> playerHand = new ArrayList<>(5);
ArrayList<Card> houseHand = new ArrayList<>(5);

Integer sumHand = 0;


    public BlackJack(BlackJack_Player[] players, Integer numberOfDecks) {
        super(players, numberOfDecks);
    }

    public Boolean canSplit(){
        ArrayList<Card> playerHand =  new ArrayList<>(5);
        if(playerHand.get(0) == playerHand.get(1)){
            return true;
        }
        return false;}
     public Boolean checkWin(){
        if ()
     }
     public Integer HandSum(Hand hand){
         for (int i = 0; i < 5; i++) {
             if(playerHand.get(i).getValue() != null){

               sumHand  += playerHand.get(i).getValue();
             }

         }return sumHand;
     }
    public Boolean didWin(Player player) {return false;}

    public void playGame() {}
    public void endOfGame() {}

}
