import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DStyleCrapsPlayerTest {
    @Test
    public void testChips() {
        Dice dice = new Dice(2);
        DStyleCrapsPlayer player1 = new DStyleCrapsPlayer(new Person(500, "Jon", 25));
        Integer numchips = player1.numOfChips();
        Assert.assertEquals(100, numchips, 0.0001);
    }

    @Test
    public void testChips1() {
        Dice dice = new Dice(2);
        DStyleCrapsPlayer player1 = new DStyleCrapsPlayer(new Person(00, "Jon", 25));
        Integer numchips = player1.numOfChips();
        Assert.assertEquals(0, numchips, 0.0001);
    }

    @Test
    public void testRoll() {
        Dice dice = new Dice(2);
        DStyleCrapsPlayer player1 = new DStyleCrapsPlayer(new Person(500, "Jon", 25));
        Integer numroll = player1.roll(dice);
        Boolean b = false;
        if (numroll >= 12 || numroll <= 2)
            b = true;
        Assert.assertEquals(true, b);
    }

    @Test
    public void testBet() {
        Dice dice = new Dice(2);
        DStyleCrapsPlayer player1 = new DStyleCrapsPlayer(new Person(500, "Jon", 25));
        Integer betWon=0;
       if( player1.dcraps.didWin(player1)==true)
          betWon=player1.bet(4);
       Assert.assertEquals(8, betWon,0.0001);
    }
    @Test
    public void testBet1() {
        Dice dice = new Dice(2);
        DStyleCrapsPlayer player1 = new DStyleCrapsPlayer(new Person(500, "Jon", 25));
        Integer betWon=0;
        if( player1.dcraps.didWin(player1)==false)
            betWon=player1.bet(4);
        Assert.assertEquals(0, betWon,0.0001);
    }
}