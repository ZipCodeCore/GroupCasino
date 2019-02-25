package io.zipcoder.casino.Casino;

import io.zipcoder.casino.Cards.Card;
import io.zipcoder.casino.Cards.Games.BlackJack;
import io.zipcoder.casino.Cards.Rank;
import io.zipcoder.casino.Cards.Suit;
import io.zipcoder.casino.Players.CardPlayer;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.Players.Profile;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("all")
public class BlackJackTest {

    private Console console;
    private int userTotal;
    private int dealerTotal;
    private int userBet;

    @Test
    public void dealTwoCardsFirstCardTest() {

        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> userHand = new ArrayList<Card>();

       //When
        blackJack.dealTwoCards(userHand);

        //Then
        Assert.assertTrue(userHand.get(0)!=null);
        Assert.assertTrue(userHand.get(1)!=null);

    }

    @Test
    public void dealTwoCardsSecondCardTest(){
        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> userHand = new ArrayList<Card>();
        int expected = 2;
        //When
        blackJack.dealTwoCards(userHand);

        //Then
        Assert.assertEquals(expected, userHand.size());

    }
    @Test
    public void testTakingUserBet() {
        String input = "10\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console testConsole = new Console(bais, new PrintStream(baos));

        String output = baos.toString();

        //Given
        BlackJack blackJack = new BlackJack(testConsole);
        blackJack.getUserBet();

        //Then
        Assert.assertEquals((int)blackJack.getUserBetAsInteger(), 10);
    }

    @Test
    public void dealOneCardTest() {
        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> userhand = new ArrayList<Card>();
        int expected = 1;
        //When
        blackJack.dealOneCard(userhand);

        //Then
        Assert.assertTrue(userhand.get(0) != null);
        Assert.assertEquals(expected,userhand.size());
    }

    @Test
    public void testTakeUserBetWithInsult(){
        //Given
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput("600\n200",baos);
        BlackJack newBlkJ = new BlackJack(console);
        //When
        newBlkJ.getUserBet();
        //Then
        Assert.assertTrue(baos.toString().contains("Place a bet if you DARE"));
        Assert.assertTrue(baos.toString().contains("Your broke ass has insufficient funds.."));
    }
    @Test
    public void testTakeUserBetWithInsultCheckUserBet(){
        //Given
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput("600\n200",baos);
        BlackJack newBlkJ = new BlackJack(console);
        int expected = 200;
        //When
        newBlkJ.getUserBet();
        //Then
        Assert.assertEquals(expected,(int)newBlkJ.getUserBetAsInteger());
    }
    @Test
    public void testTakeUserBetWithInsultCheckBalance(){
        //Given
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput("600\n200",baos);
        BlackJack newBlkJ = new BlackJack(console);
        CardPlayer testPlayer =  newBlkJ.getUser();
        int expected = 300;

        //When
        newBlkJ.getUserBet();
        int actual = testPlayer.getProfile().getBalance();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void testTellUserDeyPoor(){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput(null ,baos);
        BlackJack newBlkJ = new BlackJack(console);

        //When
        newBlkJ.tellUserDeyPoor();

        //Then
        Assert.assertTrue(baos.toString().contains("Your broke ass has insufficient funds.."));
    }
    @Test
    public void testDealFirstHand(){

        BlackJack newBlkJ = new BlackJack();
        List<Card> userHand = new ArrayList<Card>();
        List<Card> dealerHand = new ArrayList<Card>();
        int expected = 2;

        //When
        newBlkJ.dealFirstHand(userHand,dealerHand);

        //Then
        Assert.assertEquals(expected, userHand.size());
        Assert.assertEquals(expected, dealerHand.size());
    }
    @Test
    public void testGetTotal(){
        //Given
        BlackJack newBlkJ = new BlackJack();
        List<Card> testHand = new ArrayList<Card>();
        Card c1 = new Card(Suit.DIAMONDS,Rank.NINE);
        Card c2 = new Card(Suit.SPADES, Rank.QUEEN);
        Card c3 = new Card(Suit.HEARTS, Rank.SIX);

        testHand.add(c1);
        testHand.add(c2);
        testHand.add(c3);

        //When
        int actual = newBlkJ.getTotal(testHand);
        int expected = 25;

        //Then
        Assert.assertEquals(expected, actual);

    }
    @Test
    public void testGetTotalAcesOver21(){
        //Given
        BlackJack newBlkJ = new BlackJack();
        List<Card> testHand = new ArrayList<Card>();
        Card c1 = new Card(Suit.DIAMONDS,Rank.NINE);
        Card c2 = new Card(Suit.SPADES, Rank.QUEEN);
        Card c3 = new Card(Suit.HEARTS, Rank.ACE);
        Card c4 = new Card(Suit.CLUBS, Rank.ACE);
        
        testHand.add(c1);
        testHand.add(c2);
        testHand.add(c3);
        testHand.add(c4);

        //When
        int actual = newBlkJ.getTotal(testHand);
        int expected = 21;

        //Then
        Assert.assertEquals(expected, actual);

    }

    public Console getConsoleWithBufferedInputAndOutput(String input, ByteArrayOutputStream baos){
        Console testConsole;
        if (input == null) {
             testConsole = new Console(System.in, new PrintStream(baos));
        } else {
            ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
             testConsole = new Console(bais, new PrintStream(baos));
        }

       return testConsole;
    }




}
