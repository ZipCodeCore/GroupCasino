package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class BeetleTest {

    @Test
    public void playerBeetleTest() {
        //given
        Beetle beetle = new Beetle();
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
    public void gameEngineTest() {
        Beetle beetle = new Beetle();
        beetle.gameEngine();
    }

    @Test
    public void completeBeetleTest() {
        Beetle beetle = new Beetle();
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 1);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 2);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 3);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 4);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 5);
        beetle.analyzeRoll(beetle.getUsersRolls(), beetle.getUsersBeetle(), 6);

        Assert.assertEquals(beetle.getCompleteBeetle(),beetle.getUsersBeetle());

    }

}
