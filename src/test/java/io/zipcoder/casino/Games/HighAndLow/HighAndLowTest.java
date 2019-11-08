package io.zipcoder.casino.Games.HighAndLow;


import io.zipcoder.casino.PlayerCreation.Player;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HighAndLowTest {
    DateTimeFormatter dateTimeReformatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    @Test
    public void firstRollTest(){
        HighAndLow highAndLow = new HighAndLow();
        Integer actual = highAndLow.firstRoll();
        Assert.assertTrue(actual >= 2 || actual <= 12);
    }

    @Test
    public void secondRollTest(){
        HighAndLow highAndLow = new HighAndLow();
        Integer actual = highAndLow.secondRoll();
        Assert.assertTrue(actual >= 2 || actual <= 12);
    }

    @Test
    public void enoughBalanceTest1(){
        HighAndLow highAndLow = new HighAndLow();
        Player currentPlayer = new Player(null,0);
        Assert.assertFalse(highAndLow.enoughBalance(currentPlayer.getBalance()));
        }


    @Test
    public void enoughBalanceTest2(){
        HighAndLow highAndLow = new HighAndLow();
        Player currentPlayer = new Player(null,Integer.MAX_VALUE);
        Assert.assertTrue(highAndLow.enoughBalance(currentPlayer.getBalance()));
    }

    @Test
    public void returnWinnings1(){
        HighAndLow highAndLow = new HighAndLow();
        Player currentPlayer = new Player(null,60);
        Integer totalBetValue = 40;
        Integer expected = 100;
        highAndLow.returnWinnings(currentPlayer, totalBetValue);
        Integer actual = currentPlayer.getBalance();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void returnWinnings2(){
        HighAndLow highAndLow = new HighAndLow();
        Player currentPlayer = new Player(null,100);
        Integer totalBetValue = 100;
        Integer expected = 200;
        highAndLow.returnWinnings(currentPlayer, totalBetValue);
        Integer actual = currentPlayer.getBalance();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void showRulesTest(){
        HighAndLow highAndLow = new HighAndLow();
        String expected = "\n\nA simple game for meager winnings. At High and Low,\n" +
                "you'll only be able to but in at $10. Simply roll two dice, and our pit boss will\n" +
                "present to you the sum of the rolls and the chance to bet $10 more on High or Low.\n" +
                "If you believe the sum of the second roll will be higher, bet high.\n" +
                "Likewise, if you believe the sum of the second roll will be lower, bet low.\n";
        String actual = highAndLow.showRules();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void winOrLose1(){
        HighAndLow highAndLow = new HighAndLow();
        Integer firstRoll = 7;
        Integer secondRoll = 9;
        String bet = "high";
        Boolean actual = highAndLow.winOrLose(firstRoll,secondRoll,bet);
        Assert.assertTrue(actual);
    }

    @Test
    public void winOrLose2(){
        HighAndLow highAndLow = new HighAndLow();
        Integer firstRoll = 9;
        Integer secondRoll = 7;
        String bet = "high";
        Boolean actual = highAndLow.winOrLose(firstRoll,secondRoll,bet);
        Assert.assertFalse(actual);
    }

    @Test
    public void winOrLose3(){
        HighAndLow highAndLow = new HighAndLow();
        Integer firstRoll = 7;
        Integer secondRoll = 9;
        String bet = "low";
        Boolean actual = highAndLow.winOrLose(firstRoll,secondRoll,bet);
        Assert.assertFalse(actual);
    }

    @Test
    public void winOrLose4(){
        HighAndLow highAndLow = new HighAndLow();
        Integer firstRoll = 9;
        Integer secondRoll = 7;
        String bet = "low";
        Boolean actual = highAndLow.winOrLose(firstRoll,secondRoll,bet);
        Assert.assertTrue(actual);
    }

    @Test
    public void highOrLowTest1(){
        HighAndLow highAndLow = new HighAndLow();
        Integer playerInput = 1;
        String actual = "high";
        String expected = highAndLow.highOrLowBet(playerInput);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void highOrLowTest2(){
        HighAndLow highAndLow = new HighAndLow();
        Integer playerInput = 2;
        String actual = "low";
        String expected = highAndLow.highOrLowBet(playerInput);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void secondBetTest1(){
        HighAndLow highAndLow = new HighAndLow();
        Integer playerInput = 1;
        Assert.assertTrue(highAndLow.secondBet(playerInput));
    }

    @Test
    public void secondBetTest2(){
        HighAndLow highAndLow = new HighAndLow();
        Integer playerInput = 2;
        Assert.assertFalse(highAndLow.secondBet(playerInput));
    }
    @Test
    public void placeBetTest(){
        HighAndLow highAndLow = new HighAndLow();
        Player currentPlayer = new Player(null,500);
        Integer expected = 490;
        highAndLow.placeBet(currentPlayer);
        Integer actual = currentPlayer.getBalance();
        Assert.assertEquals(expected,actual);
    }
    @Test
    public void placeBetTes2(){
        HighAndLow highAndLow = new HighAndLow();
        Player currentPlayer = new Player(null,450);
        Integer expected = 440;
        highAndLow.placeBet(currentPlayer);
        Integer actual = currentPlayer.getBalance();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void resetGameTest(){
        HighAndLow highAndLow = new HighAndLow();
        Assert.assertTrue(highAndLow.resetGame());
    }

    @Test
    public void noBetTest(){
        HighAndLow highAndLow = new HighAndLow();
        Integer totalBetValue = 1000;
        String expected = String.format("You lost $%d.00 at High and Low. ** ", totalBetValue);
        String actual = highAndLow.noBet(1000);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addHistoryTest1(){
        LocalDateTime now = LocalDateTime.now();
        Player currentPlayer = new Player(null,null);
        Boolean winner = true;
        Integer totalBetValue = 1000;
        HighAndLow highAndLow = new HighAndLow();
        String expected = String.format("You won $%d.00 at High and Low! ** ", totalBetValue);
        expected += dateTimeReformatter.format(now) + "\n";
        highAndLow.addHistory(winner, totalBetValue, currentPlayer);
        String actual = currentPlayer.printHistory();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addHistoryTest2(){
        LocalDateTime now = LocalDateTime.now();
        Player currentPlayer = new Player(null,null);
        Boolean winner = false;
        Integer totalBetValue = 1000;
        HighAndLow highAndLow = new HighAndLow();
        String expected = String.format("You lost $%d.00 at High and Low. ** ", totalBetValue);
        expected += dateTimeReformatter.format(now) + "\n";
        highAndLow.addHistory(winner, totalBetValue, currentPlayer);
        String actual = currentPlayer.printHistory();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void notEnoughmoneyTest(){
        HighAndLow highAndLow = new HighAndLow();
        String expected = "Loser";
        String actual = highAndLow.notEnoughMoney();
        Assert.assertEquals(actual,expected);
    }
}
