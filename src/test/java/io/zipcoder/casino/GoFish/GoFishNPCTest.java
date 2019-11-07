package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Menus.GoFishMenu;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class GoFishNPCTest {

    private Player player;
    private GoFishPlayer goFishPlayer;
    private GoFishGame goFishGame;
    private GoFishNPC opponent;

    @Before
    public void setUp()  {
        player = new Player("Bamboo", "Rod", 25, 15);
        goFishGame = new GoFishGame(player);
        goFishPlayer = goFishGame.getPlayer();
        opponent = goFishGame.getOpponent();
    }

    @Test
    public void chooseCardTest() {
        goFishGame.initialDeal();
        CardSet hand = goFishGame.getOpponentsCards();
        ArrayList<String> ranks = new ArrayList<String>();
        for (Card card : hand.getCards()) {
            ranks.add(card.getRank());
        }

        for (int i = 0; i < 20; i++ ){
            String chosenRank = opponent.chooseCard(hand);
            Assert.assertTrue(ranks.contains(chosenRank));
        }
    }
}