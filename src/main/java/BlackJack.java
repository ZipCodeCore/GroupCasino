import java.util.ArrayList;

public class BlackJack extends CardGame {

 //   PileOfCards deck = new PileOfCards();

    public BlackJack(BlackJack_Player[] players, Integer numberOfDecks) {
        super(players, numberOfDecks);
    }

    public Boolean didWin(Player player) {return false;}
    public void playGame() {}
    public void endOfGame() {}

}
