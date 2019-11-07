package io.zipcoder.casino;

import io.zipcoder.casino.PlayerCreation.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerMenuTest {


    @Test
    public void playerMenuLogicTest1() {
        PlayerMenu menu = new PlayerMenu();
        String expected = "thank you come again!";
        String actual = menu.playerMenuLogic(3);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void playerMenuLogicTest2() {
        PlayerMenu menu = new PlayerMenu();
        String expected = "Invalid Input";
        String actual = menu.playerMenuLogic(4);

        Assert.assertEquals(expected,actual);
    }

}