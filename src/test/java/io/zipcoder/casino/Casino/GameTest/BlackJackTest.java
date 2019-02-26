package io.zipcoder.casino.Casino.GameTest;

import io.zipcoder.casino.CardsAndDice.Card;
import io.zipcoder.casino.Games.BlackJack;
import io.zipcoder.casino.CardsAndDice.Rank;
import io.zipcoder.casino.CardsAndDice.Suit;
import io.zipcoder.casino.Players.BlackJackPlayer;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class BlackJackTest {

    private Console console;
    private int userTotal;
    private int dealerTotal;
    private int userBet;

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
        BlackJackPlayer testPlayer =  newBlkJ.getUser();
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
        int expected = 2;

        //When
        newBlkJ.dealFirstHand();

        //Then
        Assert.assertEquals(expected, newBlkJ.getUser().getHand().size());
        Assert.assertEquals(expected, newBlkJ.getDealer().getHand().size());
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

    @Test
    public void testAcesTotalOneEleven(){
        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> testH = new ArrayList<Card>();
        Card card1 = new Card(Suit.SPADES, Rank.ACE);
        Card card2 = new Card(Suit.DIAMONDS, Rank.ACE);

        //When
        testH.add(card1);
        testH.add(card2);
        int expected = 12;
        int actual = blackJack.getTotal(testH);

        //Then
       Assert.assertEquals(expected,actual);

    }

    @Test
    public void testCheckHandTwentyOneFirst() {
        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> testHand = new ArrayList<Card>();
        Card card1 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card2 = new Card(Suit.SPADES, Rank.ACE);

        //When
        testHand.add(card1);
        testHand.add(card2);
        int expected = 21;
        int actual = blackJack.getTotal(testHand);

        //Then

        Assert.assertEquals(expected,actual);
    }

    @Test

    public void testCheckHandTwentyOneSecond () {
        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> testHand = new ArrayList<Card>();
        Card card1 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card2 = new Card(Suit.SPADES, Rank.TWO);
        Card card3 = new Card(Suit.HEARTS, Rank.EIGHT);
        Card card4 = new Card(Suit.CLUBS, Rank.ACE);
        //When
        testHand.add(card1);
        testHand.add(card2);
        testHand.add(card3);
        testHand.add(card4);
        int expected = 21;
        int actual = blackJack.getTotal(testHand);

        //Then
        Assert.assertEquals(expected,actual);
    }
    @Test

    public void testCheckHandTwentyOneThird () {
        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> testHand = new ArrayList<Card>();

        Card card1 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card2 = new Card(Suit.SPADES, Rank.TWO);
        Card card3 = new Card(Suit.HEARTS, Rank.EIGHT);
        Card card4 = new Card(Suit.CLUBS, Rank.ACE);
        //When
        testHand.add(card1);
        testHand.add(card2);
        testHand.add(card3);
        testHand.add(card4);

        int total = blackJack.getTotal(testHand);
        blackJack.setUserTotal(total);

       Assert.assertTrue(blackJack.checkIfHandIs21());
    }
    @Test
    public void testCheckHandTwentyOneFourth () {
        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> testHand = new ArrayList<Card>();

        Card card1 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card2 = new Card(Suit.SPADES, Rank.TWO);
        Card card3 = new Card(Suit.HEARTS, Rank.EIGHT);

        //When
        testHand.add(card1);
        testHand.add(card2);
        testHand.add(card3);

        int total = blackJack.getTotal(testHand);
        blackJack.setUserTotal(total);

        Assert.assertFalse(blackJack.checkIfHandIs21());
    }

    @Test
    public void testCheckIfUserBustTrue() {
        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> testHand = new ArrayList<Card>();

        Card card1 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card2 = new Card(Suit.SPADES, Rank.TWO);
        Card card3 = new Card(Suit.HEARTS, Rank.EIGHT);
        Card card4 = new Card(Suit.DIAMONDS, Rank.QUEEN);

        //When
        testHand.add(card1);
        testHand.add(card2);
        testHand.add(card3);
        testHand.add(card4);

        int total = blackJack.getTotal(testHand);
        blackJack.setUserTotal(total);

        Assert.assertTrue(blackJack.checkGameOverByBust());
    }


    @Test
    public void testCheckIfUserBustFalse() {
        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> testHand = new ArrayList<Card>();

        Card card1 = new Card(Suit.DIAMONDS, Rank.QUEEN);
        Card card2 = new Card(Suit.SPADES, Rank.TWO);
        Card card3 = new Card(Suit.HEARTS, Rank.EIGHT);
        Card card4 = new Card(Suit.DIAMONDS, Rank.ACE);

        //When
        testHand.add(card1);
        testHand.add(card2);
        testHand.add(card3);
        testHand.add(card4);

        int total = blackJack.getTotal(testHand);
        blackJack.setUserTotal(total);

        Assert.assertFalse(blackJack.checkGameOverByBust());
    }

    @Test
    public void displayDealerHandTest() {
        //Given
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput(null, baos);
        BlackJack blackJack = new BlackJack(console);
        List<Card> hand = new ArrayList<>();
        Card card1 = new Card(Suit.DIAMONDS, Rank.TEN);
        Card card2 = new Card(Suit.HEARTS, Rank.SEVEN);

        //When
        hand.add(card1);
        hand.add(card2);
        blackJack.getDealer().setHand(hand);
        blackJack.displayDealerHand();
        String expected = "Dealer's hand is now: \n" +
                "10━━┓7━━━┓\n" +
                "┃   ┃┃   ┃\n" +
                "┃ ♢ ┃┃ ♡ ┃\n" +
                "┃   ┃┃   ┃\n" +
                "┗━━10┗━━━7\n" +
                "\n";

        //Then
        Assert.assertEquals(expected, baos.toString());
    }

    @Test

    public void checkUserInputTestHit(){
        //Given
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput("hit", baos);
        BlackJack blackJack = new BlackJack(console);

        //When
       String black = blackJack.getUserInput();
       String expected = "hit";

        //Then
        Assert.assertTrue(baos.toString().contains("Would you like to Hit or Stay?"));
        Assert.assertEquals(expected, black);

    }

    @Test

    public void checkUserInputTestStay(){
        //Given
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput("stay", baos);
        BlackJack blackJack = new BlackJack(console);

        //When
        String black = blackJack.getUserInput();
        String expected = "stay";

        //Then
        Assert.assertTrue(baos.toString().contains("Would you like to Hit or Stay?"));
        Assert.assertEquals(expected, black);

    }

    @Test
    public void checkHitTest1(){

        //Given
        BlackJack blackJack = new BlackJack();
        List<Card> hand = new ArrayList<Card>();
        Card c = new Card(Suit.HEARTS, Rank.ACE);
        hand.add(c);
        hand.add(c);
        blackJack.getUser().setHand(hand);

        //When
        blackJack.hit();

        //Then
        Assert.assertTrue(hand.size() == 3);
    }

    @Test
    public void displayUserTotalTest(){
        //Given
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput(null, baos);
        BlackJack blackJack = new BlackJack(console);

        //When
        userTotal  = 19;
        blackJack.displayUserTotal(userTotal);
        String expected = "Your total is 19\n";

        //Then
        Assert.assertEquals(expected,baos.toString());
    }

    @Test

    public void displayDealerTotalTest() {
        //Given
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput(null, baos);
        BlackJack blackJack = new BlackJack(console);

        //When
        dealerTotal  = 21;
        blackJack.displayDealerTotal(dealerTotal);
        String expected = "Dealer total is 21\n";

        //Then
        Assert.assertEquals(expected,baos.toString());
    }
    @Test

    public void displayUserBalanceTest(){
        //Given
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput(null, baos);
        BlackJack blackJack = new BlackJack(console);

        //When
        blackJack.getUser().setBalance(21);
        blackJack.displayUserBalance();
        String expected = "Your balance is: $21\n";

        //Then
        Assert.assertEquals(expected,baos.toString());
    }

    @Test
    public void testCelebrateUser(){
        //Given
        String input = "10\n";
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Console console = getConsoleWithBufferedInputAndOutput(input, baos);
        BlackJack blackJack = new BlackJack(console);


        //When
        blackJack.getUser().setBalance(100);
        blackJack.getUserBet();

        blackJack.celebrateUser();

        //Then
        Assert.assertTrue(baos.toString().contains("You are the Winner!!!!"));
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







