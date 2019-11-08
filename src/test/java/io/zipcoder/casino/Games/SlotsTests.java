package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.SlotMachine;
import io.zipcoder.casino.Games.Slots.Slots;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SlotsTests {

    @Before
    public void setup(){
        /*Integer[][] slot =
                        {{7,7,7},
                        {2,6,1},
                        {8,4,9}};

        this.slotMachine = new SlotMachine(slot);*/


    }

    @Test
    public void pullLeverTest(){}

    @Test
    public void isWinnerTrueTest(){
        Slots slots = new Slots();
        Integer[][] slot =
                        {{7,7,7},
                        {2,6,1},
                        {8,4,9}};
        Boolean actualWinner = slots.isWinner(slot);

        Assert.assertTrue(actualWinner);
    }

    @Test
    public void isWinnerFalseTest(){
        Slots slots = new Slots();
        Integer[][] slot =
                        {{7,7,6},
                        {2,6,1},
                        {8,4,9}};
        Boolean actualWinner = slots.isWinner(slot);

        Assert.assertFalse(actualWinner);
    }

    @Test
    public void checkHorizontalTrueTest(){
        Slots slots = new Slots();
        Integer[][] slot =
                        {{7,7,7},
                        {2,6,1},
                        {8,4,9}};

        Boolean actualWinner = slots.checkHorizontal(slot);

        Assert.assertTrue(actualWinner);
    }

    @Test
    public void checkHorizontalFalseTest(){
        Slots slots = new Slots();
        Integer[][] slot =
                        {{7,4,7},
                        {2,6,1},
                        {8,4,9}};

        Boolean actualWinner = slots.checkHorizontal(slot);

        Assert.assertFalse(actualWinner);
    }

    @Test
    public void checkVerticalTrueTest(){
        Slots slots = new Slots();
        Integer[][] slot =
                        {{7,5,7},
                        {7,6,1},
                        {7,4,9}};

        Boolean actualWinner = slots.checkVertical(slot);

        Assert.assertTrue(actualWinner);
    }

    @Test
    public void checkVerticalFalseTest() {
        Slots slots = new Slots();
        Integer[][] slot =
                        {{7,7,7},
                        {2,6,1},
                        {8,4,9}};

        Boolean actualWinner = slots.checkVertical(slot);

        Assert.assertFalse(actualWinner);
    }


        @Test
    public void checkDiagonalTrueTest(){
            Slots slots = new Slots();
            Integer[][] slot =
                            {{7,4,7},
                            {2,7,1},
                            {8,4,7}};

        Boolean actualWinner = slots.checkDiagonal(slot);

        Assert.assertTrue(actualWinner);
    }

    @Test
    public void checkDiagonalFalseTest(){
        Slots slots = new Slots();
        Integer[][] slot =
                        {{7,7,7},
                        {2,2,1},
                        {8,4,9}};
        Boolean actualWinner = slots.checkDiagonal(slot);

        Assert.assertFalse(actualWinner);
    }

    @Test
    public void returnWinningsTest(){}

    @Test
    public void youLoseTest(){}

}
