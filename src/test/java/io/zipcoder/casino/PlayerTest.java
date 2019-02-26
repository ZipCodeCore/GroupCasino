package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testGetSetName(){
        //given - setting up data
        Player player = new Player("Robyn");
        String expected = "Bob";

        //when - when you call the method test
        player.setName("Bob");
        String actual = player.getName();

        Assert.assertEquals(expected, actual);

    }

}