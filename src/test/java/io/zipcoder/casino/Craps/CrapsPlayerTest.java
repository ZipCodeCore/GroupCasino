package io.zipcoder.casino.Craps;

import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsPlayerTest {

    @Test
    public void crapsPlayerConstructorTest(){
        Player testPlayer = new Player ("Warren", "G", 40, 1200.0);
        CrapsPlayer crapsTest = new CrapsPlayer(testPlayer);
        Assert.assertNotNull(crapsTest.getPlayer());
    }
    @Test
    public void crapsPlayerConstructorTest2(){
        Player testPlayer = new Player ("Warren", "G", 40, 1200.0);
        CrapsPlayer crapsTest = new CrapsPlayer(testPlayer);
        Assert.assertTrue(crapsTest instanceof CrapsPlayer);
    }

}