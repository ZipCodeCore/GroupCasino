package games;

import io.zipcoder.casino.Cards.Card;
import io.zipcoder.casino.Cards.Deck;
import io.zipcoder.casino.Players.CardPlayer;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {
    List<Card> userHand = new ArrayList<Card>();
    List<Card> dealerHand = new ArrayList<Card>();

    CardPlayer dealer = new CardPlayer();
    CardPlayer user = new CardPlayer();
    Deck currentDeck = new Deck();

    int userTotal;
    int dealerTotal;

    Console blackJackConsole = new Console();


    public int play() {

        dealsFirstCards(userHand);
        dealsFirstCards(dealerHand);
        user.setHand(userHand);
        dealer.setHand(dealerHand);

        userTotal = getTotal(userHand);
        dealerTotal = getTotal(dealerHand);

        blackJackConsole.print("this is your total hand "+userTotal);
        blackJackConsole.print("this is the dealers hand "+dealerTotal);
        return -1;
    }

    public void dealsFirstCards(List<Card> hand){
        hand.add(currentDeck.drawCard());
        hand.add(currentDeck.drawCard());

    }

    public int getTotal(List<Card> hand) {
        int sum = 0;

        for(Card card : hand) {
           // if(card.getRank().returnPrimaryRankValue() ==) {
                sum += card.getRank().returnPrimaryRankValue();
            }

        return sum;
    }


}
