import java.util.ArrayList;

public class BlackJack_Player extends Player implements Gambling, Dealer {

    private Person player;
    Integer bet;
    Hand playerHand = dealHand(1);



    public BlackJack_Player(Person player) {
        super(player);
    }

    public Boolean didWin(){ return false;}
    public void makeMove(){}
    public void leaveGame(){}
    public Boolean canSplit(){
        ArrayList<Card> playerHand =  new ArrayList<>(5);
        if(playerHand.get(0) == playerHand.get(1)){
            return true;
        }
        return false;}
    public void split() {}
    public void hitOrStay() {}
    public void doubleDown() {}

    @Override
    public Integer bet() {
        return null;
    }
}
