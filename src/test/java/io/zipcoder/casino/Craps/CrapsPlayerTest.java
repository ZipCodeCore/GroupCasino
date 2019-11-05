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

    //Test craps player constructor method
//    @Test
//    public void constructorTest () {
//        // Given
//        Integer expectedAge = 5;
//        String expectedName = "Leon";
//
//        // When
//        CrapsPlayer testPerson = new CrapsPlayer(Player player);
//
//        // Then
//        Integer actualAge = person.getAge();
//        String actualName = person.getName();
//
//        Assert.assertEquals(expectedAge, actualAge);
//        Assert.assertEquals(expectedName, actualName);
//    }

}