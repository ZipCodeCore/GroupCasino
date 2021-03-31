package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class BeetleTest {

BeetleDisplay display = new BeetleDisplay();

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

    @Test (expected = NullPointerException.class)
    public void opponentBetTest2() {
        Player hubot = new Player("hubot", 100.00);
        Beetle beetle = new Beetle(hubot);

        Double expected = beetle.opponentBet(null);

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
    public void calculateRewardTest2() {
        Player player = new Player("player", 100.00);
        Beetle beetle = new Beetle(player);

        beetle.tableMinimumDeposit();
        beetle.acceptBetFromUser(14.00);

        Double actual = beetle.calculateReward();
        Double expected = 15.00;

        Assert.assertNotEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void calculateRewardTest3() {
        Player player = new Player("player", 100.00);
        Beetle beetle = new Beetle(player);

        beetle.tableMinimumDeposit();
        beetle.acceptBetFromUser(null);

        Double actual = beetle.calculateReward();
        Double expected = 1.00;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateLossTest() {
        Player player = new Player("player", 100.00);
        Beetle beetle = new Beetle(player);

        beetle.tableMinimumDeposit();
        beetle.acceptBetFromUser(50.0);

        Double actual = beetle.calculateLoss();
        Double expected = 51.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void calculateLossTest2() {
        Player player = new Player("player", 100.00);
        Beetle beetle = new Beetle(player);

        beetle.tableMinimumDeposit();
        beetle.acceptBetFromUser(50.0);

        Double actual = beetle.calculateLoss();
        Double expected = 50.0;

        Assert.assertNotEquals(expected, actual);
    }

    @Test (expected = NullPointerException.class)
    public void calculateLossTest3() {
        Player player = new Player("player", 100.00);
        Beetle beetle = new Beetle(player);

        beetle.tableMinimumDeposit();
        beetle.acceptBetFromUser(null);

        Double actual = beetle.calculateLoss();
        Double expected = 51.0;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPurseTest() {
        Player player = new Player("player", 100.00);
        Beetle beetle = new Beetle(player);

        beetle.setPurse(43.96666667);

        Double actual = beetle.getPurse();
        Double expected = 43.97;

        Assert.assertEquals(expected, actual);
    }


}
