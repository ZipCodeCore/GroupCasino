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
        playersCards = new CardSet(0);
        opponentCards = new CardSet(0);
    //    goFishGame.initialDeal();
        ArrayList<Card> testHand = playersCards.getCards();
        int actual = testHand.size();
        int expected = 7;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void initialDealOpponent() {
        playersCards = new CardSet(0);
        opponentCards = new CardSet(0);
 //       goFishGame.initialDeal();
        ArrayList<Card> testHand = opponentCards.getCards();
        int actual = testHand.size();
        int expected = 7;
        Assert.assertEquals(actual, expected);

    }

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
