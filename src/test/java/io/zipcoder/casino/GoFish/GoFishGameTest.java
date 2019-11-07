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
    private CardSet playerSuites;
    private CardSet opponentSuites;


    @Before
    public void before() {
        player = new Player("Bamboo", "Rod", 25, 15);
        goFishGame = new GoFishGame(player);
        goFishMenu = new GoFishMenu(goFishGame);
        goFishPlayer = goFishGame.getPlayer();
        opponent = goFishGame.getOpponent();
        shoe = new CardSet(1);
        playersCards = goFishGame.getPlayersCards();
        opponentCards = goFishGame.getOpponentsCards();
        playerSuites = goFishGame.getPlayerSuites();
        opponentSuites = goFishGame.getOpponentSuites();
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
        int actual = playersCards.size();
        int expected = 0;
        Assert.assertEquals(actual, expected);
        goFishGame.initialDeal();
        actual = playersCards.size();
        expected = 7;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void initialDealOpponent() {
        int actual = opponentCards.size();
        int expected = 0;
        Assert.assertEquals(actual, expected);
        goFishGame.initialDeal();
        actual = opponentCards.size();
        expected = 7;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void integrateStolenCardsTest() {
        ArrayList<Card> stolenCards = new ArrayList<Card>();
        goFishGame.initialDeal();
        Card card1 = new Card("J", "H");
        Card card2 = new Card("J", "D");
        stolenCards.add(card1);
        stolenCards.add(card2);
        int actual = playersCards.size();
        int expected = 7;
        Assert.assertEquals(expected, actual);
        goFishGame.integrateStolenCards(stolenCards, goFishGame.getPlayersCards());
        actual = playersCards.size();
        expected = 9;
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void drawCardTest() {
        goFishGame.initialDeal();
        int actual = playersCards.size();
        int expected = 7;
        Assert.assertEquals(expected, actual);
        goFishGame.drawCard(playersCards);
        actual = playersCards.size();
        expected = 8;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void emptyHandDrawCardTest() {

        int actual = playersCards.size();
        int expected = 0;
        Assert.assertEquals(expected, actual);
        goFishGame.drawCard(playersCards);
        actual = playersCards.size();
        expected = 1;
        Assert.assertEquals(expected, actual);
    }

/*    @Test
    public void winCheckTest1() {
        for (int i = 0; i < 6; i++ ) {
            playerSuites.addCard(new Card("A", "H"));
        }
        for (int i = 0; i < 4; i++ ) {
            opponentSuites.addCard(new Card("A", "H"));
        }
        GoFishPlayer expected = null;
        GoFishPlayer actual = goFishGame.checkForWin(goFishPlayer, goFishNPC, playerSuites, opponentSuites);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void winCheckTest2() {
        for (int i = 0; i < 6; i++ ) {
            playerSuites.addCard(new Card("A", "H"));
        }
        for (int i = 0; i < 8; i++ ) {
            opponentSuites.addCard(new Card("A", "H"));
        }
        GoFishPlayer expected = goFishNPC;
        GoFishPlayer actual = goFishGame.checkForWin(goFishPlayer, goFishNPC, playerSuites, opponentSuites);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void winCheckTest3() {
        for (int i = 0; i < 0; i++ ) {
            playerSuites.addCard(new Card("A", "H"));
        }
        for (int i = 0; i < 4; i++ ) {
            opponentSuites.addCard(new Card("A", "H"));
        }
        GoFishPlayer expected = null;
        GoFishPlayer actual = goFishGame.checkForWin(goFishPlayer, goFishNPC, playerSuites, opponentSuites);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void winCheckTest4() {
        for (int i = 0; i < 8; i++ ) {
            playerSuites.addCard(new Card("A", "H"));
        }
        for (int i = 0; i < 4; i++ ) {
            opponentSuites.addCard(new Card("A", "H"));
        }
        GoFishPlayer expected = goFishPlayer;
        GoFishPlayer actual = goFishGame.checkForWin(goFishPlayer, goFishNPC, playerSuites, opponentSuites);
        Assert.assertEquals(expected, actual);*/


    @Test
    public void npcPickACardTest(){
        playersCards = new CardSet(0);
        opponentCards = new CardSet(0);
        opponentCards.addCard(new Card("A","S"));
        opponentCards.addCard(new Card("A","H"));
        opponentCards.addCard(new Card("A","D"));
        opponentCards.addCard(new Card("K","C"));
        opponentCards.addCard(new Card("2","H"));
        opponentCards.addCard(new Card("K","D"));
        opponentCards.addCard(new Card("5","C"));

       /* ArrayList<Card> testHand = opponentCards.getCards();
        String testCard = goFishGame.npcPickACard();
        for (int i = 0; i < opponentCards.size(); i++) {
            if (opponentCards.getCards(). == testCard) {

            }
        }
*/
    }

    @Test
    public void displaySuiteTest(){

    }
    @Test
    public void scanForSuitesTest(){
        playersCards = new CardSet(0);
        opponentCards = new CardSet(0);
        playersCards.addCard(new Card("A","C"));
        playersCards.addCard(new Card("A","H"));
        playersCards.addCard(new Card("A","D"));
        playersCards.addCard(new Card("A","C"));
        playersCards.addCard(new Card("2","H"));
        playersCards.addCard(new Card("K","D"));
        playersCards.addCard(new Card("5","H"));

        int testHand = playersCards.size();
        //goFishGame.scanForSuites();
        int postScanHand = playersCards.size();
        System.out.println(playersCards.getCards().get(0).toString());
        Assert.assertEquals(testHand-4,postScanHand);





    }

}
