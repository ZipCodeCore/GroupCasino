package io.zipcoder.casino;

import io.zipcoder.casino.DiceGame.Dice;
import io.zipcoder.casino.DiceGame.YahtzeePlayer;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class YahtzeePlayerTests {

    Dice d1 = new Dice(1, 1);
    Dice d2 = new Dice(1, 2);
    Dice d3 = new Dice(1, 3);
    Dice d4 = new Dice(1, 4);
    Dice d5 = new Dice(1, 5);
    Dice d6 = new Dice(1, 6);

    @Test
    public void YahtzeePlayerConstructorTest(){
        // Given
        String expectedName = "Cara";
        Player expectedPlayer = new Player(expectedName, 1000.0);

        // When
        YahtzeePlayer yahtzeePlayer = new YahtzeePlayer(expectedPlayer);
        Player actualPlayer = yahtzeePlayer.getPlayer();
        String actualName = yahtzeePlayer.getName();

        // Then
        Assert.assertEquals(expectedName, actualName);
        Assert.assertEquals(expectedPlayer, actualPlayer);
    }


    @Test
    public void rollDiceTest(){

    }

}
