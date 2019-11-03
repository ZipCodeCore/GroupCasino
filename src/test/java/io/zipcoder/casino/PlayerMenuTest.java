package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerMenuTest {

    @Test
    public void displayPlayerMenu() {
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
    public void gameMenuLogicTest2() {
        GameMenu gameMenu = new GameMenu();
        String expected = "You would be playing Roulette now.";
        String actual = gameMenu.gameMenuLogic(5);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void gameMenuLogicTest3() {
        GameMenu gameMenu = new GameMenu();
        String expected = "You would be playing Go Fish now.";
        String actual = gameMenu.gameMenuLogic(1);

        Assert.assertEquals(expected, actual);
    }
}