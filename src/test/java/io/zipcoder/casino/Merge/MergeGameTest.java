package io.zipcoder.casino.Merge;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MergeGameTest {

    private Player player;
    private Console console = new Console(System.in, System.out);
    private MergeGame mergeGame;

    @Before
    public void setUp() throws Exception {
        player = new Player("Mary", "Worth", 45, 300.0);
        mergeGame = new MergeGame(player);
    }
//    {2,10,3,4,17,14,19,1,11,7,6,13,20,5,18,15,12,16,9,8}

    @Test
    public void mergeTest1() {
        int[] inputArray = new int[] {2,10,3,4,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        Assert.assertEquals(20, inputArray.length);
        mergeGame.setArrayToSort(inputArray);

        int[] expected = new int[] {2,4,3,10,17,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int[] actual = mergeGame.merge(mergeGame.getArrayToSort(), 0, 3, 4);
        console.println(Arrays.toString(expected));
        console.println(Arrays.toString(actual));

        //Assert.assertArrayEquals(expected, actual);
    }
}