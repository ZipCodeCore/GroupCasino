import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTest {

    @Test
    public void payoutTest() {
        House house = new House(2);
        house.takeBets(2);
        Integer expected = 4;
        Integer actual = house.payout(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeBetsTest() {
        Integer payoutRatio = 2;
        House house = new House(2);
        house.takeBets(1, 2);
        Integer expected = 6;
        Integer actual = house.getHouseWallet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void moneyToChipsTest1() {
        House house = new House(2);
        Integer expected = 20;
        Integer actual = house.moneyToChips(100.0);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void moneyToChipsTest2() {
        House house = new House(2);
        Integer expected = 20;
        Integer actual = house.moneyToChips(103.43);
        Assert.assertEquals(expected, actual);
    }
}