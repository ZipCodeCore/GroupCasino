package io.zipcoder.casino.Games.HighAndLow;

import io.zipcoder.casino.Games.HighAndLow.HighAndLow;
import org.junit.Assert;
import org.junit.Test;

public class HighAndLowTest {

    @Test
    public void firstRollTest(){
        HighAndLow highAndLow = new HighAndLow();
        Integer actual = highAndLow.firstRoll();
        Assert.assertTrue(actual >= 2 || actual <= 12);
    }

    @Test
    public void secondRollTest(){
        HighAndLow highAndLow = new HighAndLow();
        Integer actual = highAndLow.firstRoll();
        Assert.assertTrue(actual >= 2 || actual <= 12);
    }


}
