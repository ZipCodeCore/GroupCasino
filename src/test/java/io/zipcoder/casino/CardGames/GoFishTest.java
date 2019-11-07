package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.Player.Player;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoFishTest {


    @Test
    public void game() {

        GoFish newgame = new GoFish(new Player("John", "007"));

        newgame.startGame();

    }

    @Test
    public void haveCard() {
        boolean result = false;
        Player testPlayer = new Player("V","B");
        GoFish testHaveCard = new GoFish(testPlayer);
        Card newCard = new Card(Suit.HEARTS,Rank.KING);
        ArrayList<Card> cards = new ArrayList<>();
        cards.add(newCard);
        CardHand testHand = new CardHand(cards);
        result = testHaveCard.haveCard(testHand,"KING");

        Assert.assertTrue(result);
    }

    @Test
    public void tradeCards() {
    }

    @Test
    public void goFishForCard() {
    }

    @Test
    public void checkIfWinner() {
    }

    @Test
    public void getCompCard() {
    }
}