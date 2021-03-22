package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class BeetleServiceTest {
    BeetleService service = new BeetleService();
    BeetleDisplay display = new BeetleDisplay();

    @Test
    public void playerBeetleTest() {
        //given
        Player player1 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player1);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 4);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 5);
        // and
        String[][] expected = new String[][]{{" ","0"," "},
                {" ","|"," "},
                {" ","|"," "},
                {" "," ","\\"}};
        String[][] actual = (display.drawPlayerBeetle(service.getUsersBeetle()));
        //assert
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void opponentBeetleTest() {
        //given
        Player player1 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player1);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 4);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 5);
        // and
        String[][] expected = new String[][]{{" ","0"," "},
                {" ","|"," "},
                {" ","|"," "},
                {" "," ","\\"}};
        String[][] actual = (display.drawPlayerBeetle(service.getOpponentsBeetle()));
        //assert
        Assert.assertEquals(expected,actual);

    }

    @Test
    public void completeBeetleTest() {
        Player player2 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 1);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 3);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 4);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 5);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 6);

        Assert.assertEquals(service.getCompleteBeetle(),service.getUsersBeetle());

    }

    @Test
    public void getUserRollsTest() {
        Player human = new Player("human", 50.00);
        Beetle beetle = new Beetle(human);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 1);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 2);

        Integer expected = 2;
        Integer actual = service.getUsersRolls().size();

        Assert.assertEquals(expected,actual);

    }

    @Test
    public void tieStateTrueTest() {
        Player player2 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 1);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 2);

        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 1);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 2);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 3);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 4);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 5);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 6);

        Assert.assertTrue(beetle.tieStateDoesNotExist(service.getUsersBeetle(), service.getOpponentsBeetle()));

    }

    @Test
    public void tieStateFalseTest() {
        Player player2 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 1);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 3);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 4);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 5);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 6);

        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 1);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 2);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 3);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 4);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 5);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 6);

        Assert.assertFalse(beetle.tieStateDoesNotExist(service.getUsersBeetle(), service.getOpponentsBeetle()));

    }


    @Test
    public void winningStateTrueTest() {
        Player player2 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 1);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 3);


        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 1);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 2);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 3);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 4);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 5);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 6);

        Assert.assertTrue(beetle.winningStateDoesNotExist(service.getUsersBeetle()));

    }

    @Test
    public void winningStateFalseTest() {
        Player player2 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 1);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 3);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 4);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 5);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 6);

        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 1);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 2);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 3);


        Assert.assertFalse(beetle.winningStateDoesNotExist(service.getUsersBeetle()));

    }

    @Test
    public void losingStateTrueTest() {
        Player player2 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 1);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 3);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 4);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 5);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 6);


        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 4);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 5);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 6);

        Assert.assertTrue(beetle.losingStateDoesNotExist(service.getOpponentsBeetle()));

    }

    @Test
    public void losingStateFalseTest() {
        Player player2 = new Player("player", 100.00);
        Beetle beetle = new Beetle(player2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 1);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 2);
        beetle.analyzeRoll(service.getUsersRolls(), service.getUsersBeetle(), 3);


        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 1);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 2);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 3);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 4);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 5);
        beetle.analyzeRoll(service.getOpponentsRolls(), service.getOpponentsBeetle(), 6);

        Assert.assertFalse(beetle.losingStateDoesNotExist(service.getOpponentsBeetle()));

    }


}
