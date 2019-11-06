package io.zipcoder.casino.GoFish;


import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Menus.GoFishMenu;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class GoFishGameTest {
    private GoFishMenu goFishMenu;
    private GoFishGame goFishGame;
    private Player player;
    private GoFishPlayer goFishPlayer;
    private GoFishNPC opponent;
    private GoFishNPC goFishNPC;
    private CardSet playersCards;
    private CardSet opponentCards;
    private CardSet shoe;


    @Before
    public void before() {
        player = new Player("Bamboo", "Rod", 25, 15);
        goFishGame = new GoFishGame(player);
        goFishMenu = new GoFishMenu(goFishGame);
        goFishPlayer = goFishGame.getPlayer();
        opponent = goFishGame.getOpponent();
        this.playersCards = new CardSet(0);
        this.opponentCards = new CardSet(0);
        shoe = new CardSet(1);
    }

    @Test
    public void getNameTest() {
        Assert.assertEquals("Go Fish", goFishGame.getName());
    }

    @Test
    public void startGameTest() {

    }

    @Test
    public void initialDealPlayer() {
        goFishGame.initialDeal();
        ArrayList<Card> testHand = playersCards.getCards();
        int actual = testHand.size();
        int expected = 7;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void initialDealOpponent() {
        goFishGame.initialDeal();
        ArrayList<Card> testHand = opponentCards.getCards();
        int actual = testHand.size();
        int expected = 7;
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void npcPickACardTest(){

    }

    @Test
    public void displaySuiteTest(){

    }
    @Test
    public void scanForSuitesTest(){

    }
}
