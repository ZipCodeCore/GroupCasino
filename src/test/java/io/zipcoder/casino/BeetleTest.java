package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class BeetleTest {

    @Test
    public void playerBeetleTest() {
        //given
        Player player1 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player1);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 4);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 5);
        // and
        String[][] expected = new String[][]{{" ","0"," "},
                {" ","|"," "},
                {" ","|"," "},
                {" "," ","\\"}};
        String[][] actual = (beetle.drawPlayerBeetle(beetle.getUsersBeetle()));
        //assert
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void opponentBeetleTest() {
        //given
        Player player1 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player1);
        beetle.analyzeRoll(beetle.getOpponentsRolls(), beetle.getOpponentsBeetle(), 4);
        beetle.analyzeRoll(beetle.getOpponentsRolls(), beetle.getOpponentsBeetle(), 5);
        // and
        String[][] expected = new String[][]{{" ","0"," "},
                {" ","|"," "},
                {" ","|"," "},
                {" "," ","\\"}};
        String[][] actual = (beetle.drawPlayerBeetle(beetle.getOpponentsBeetle()));
        //assert
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void completeBeetleTest() {
        Player player2 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player2);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 1);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 2);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 3);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 4);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 5);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 6);

        Assert.assertEquals(beetle.getCompleteBeetle(),beetle.getUsersBeetle());

    }

    @Test
    public void getUserRollsTest() {
        Player human = new Player("human", 50.00);
        Beetle beetle = new Beetle(human);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 1);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 2);

        Integer expected = 2;
        Integer actual = beetle.getUsersRolls().size();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void acceptUserBetTest() {
        Player robot = new Player("robot", 100.00);
        Beetle beetle = new Beetle(robot);

        beetle.acceptBetFromUser(50.00);

        Double actual = beetle.getPurse();
        Double expected = 50.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void openingBetTest() {
        Player hubot = new Player("hubot", 100.00);
        Beetle beetle = new Beetle(hubot);
        beetle.tableMinimumDeposit();

        Double expected = 2.0;
        Double actual = beetle.getPurse();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void opponentBetTest() {
        Player hubot = new Player("hubot", 100.00);
        Beetle beetle = new Beetle(hubot);

        Double expected = beetle.opponentBet(10.00);

        Assert.assertTrue(expected >=5 && expected <= 15);

    }

    @Test
    public void calculateRewardTest() {
        Player player = new Player("player", 100.00);
        Beetle beetle = new Beetle(player);

        beetle.tableMinimumDeposit();
        beetle.acceptBetFromUser(50.0);

        Double actual = beetle.calculateReward();
        Double expected = 1.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateLossTest() {
        Player player = new Player("player", 100.00);
        Beetle beetle = new Beetle(player);

        beetle.tableMinimumDeposit();
        beetle.acceptBetFromUser(50.0);

        Double actual = beetle.calculateLoss();
        Double expected = 50.0;

        Assert.assertEquals(expected, actual);
    }




}
