import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void tossAndSum() {
        boolean b = false;
        Dice dice = new Dice(2);
        int j = dice.tossAndSum();
        if (j >= 2 && j <= 12)
            b = true;
        Assert.assertEquals(true, b);
    }

    @Test
    public void tossAndSum1() {
        boolean b = false;
        Dice dice = new Dice(2);
        int j = dice.tossAndSum();
        if (j < 2 && j > 12)
            b = false;
        Assert.assertNotEquals(false, b);
    }

    @Test
    public void toss() {
        boolean b = false;
        Dice dice = new Dice(1);
        Integer j = dice.toss();
        if (j >= 1 && j <= 6)
            b = true;
        Assert.assertEquals(true, b);
    }

    @Test
    public void toss1() {
        boolean b = false;
        Dice dice = new Dice(1);
        Integer j = dice.toss();
        if (j < 1 && j > 6)
            b = false;
        Assert.assertEquals(false, b);
    }
}




