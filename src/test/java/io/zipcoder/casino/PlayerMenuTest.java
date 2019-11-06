package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class PlayerMenuTest {

    @Test
    public void runPlayerMenutest() {
//        Console console = new Console(System.in,System.out);
//        PlayerMenu playerMenu = new PlayerMenu();
//        playerMenu.runPlayerMenu();



    }

    @Test
    public void getPlayerInput() {
    }

    @Test
    public void playerMenuLogic() {
    }
    @Test
    public void PlayerMenuLogicTest1() {
        PlayerMenu playerMenu = new PlayerMenu();
        String expected = "should be taking you to create a player menu";
        String actual = playerMenu.playerMenuLogic(2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PlayerMenuLogicTest2() {
        PlayerMenu playerMenu = new PlayerMenu();
        String expected = "should be taking you to existing player repository";
        String actual = playerMenu.playerMenuLogic(1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void PlayerMenuLogicTest3() {
        PlayerMenu playerMenu = new PlayerMenu();
        String expected = "thank you come again!";
        String actual = playerMenu.playerMenuLogic(3);

        Assert.assertEquals(expected, actual);
    }
}