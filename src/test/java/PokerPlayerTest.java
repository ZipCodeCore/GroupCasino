import exceptions.NegativeBetException;
import exceptions.NotEnoughChipException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerPlayerTest {
    PokerPlayer player;
    Integer originalChips;

    @Before
    public void setUp() throws Exception {
        player = new PokerPlayer(new Person(100.0,"John", 21));
        player.setChips(100);
        originalChips = player.getChip();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void leaveGame() {
    }

    @Test
    public void callTest() {
        Assert.assertEquals(10, (int) player.call(10));
    }

    @Test
    public void callChipTest() {
        Integer lastPlayerBet = 10;
        Integer expected = originalChips-lastPlayerBet;
        player.call(lastPlayerBet);
        Assert.assertEquals(expected,player.getChip());
    }

    @Test
    public void checkTestChip() {
        Assert.assertEquals(originalChips,player.getChip());
    }

    @Test
    public void checkTest() {
        Assert.assertEquals(0, (int) player.check());
    }

    @Test
    public void fold() {
        player.fold();
        Assert.assertTrue(player.isFolded());
    }

    @Test
    public void NotFold() {
        Assert.assertFalse(player.isFolded());
    }

    @Test
    public void raise1() {
        Assert.assertEquals(30, (int) player.raise(10,20));
    }

    @Test
    public void raiseAfterCheck() {
        Assert.assertEquals(2, (int) player.raise(0,2));
    }

    @Test
    public void raise2() {
        Assert.assertEquals(50, (int) player.raise(30,20));
    }

    @Test
    public void raiseChip() {
        Integer expected = originalChips-50;
        player.raise(30,20);
        Assert.assertEquals(50, (int) player.getChip());
    }

    @Test
    public void smallBlind() {
        Assert.assertEquals(1, (int) player.smallBlind());
    }

    @Test
    public void bigBlind() {
        Assert.assertEquals(2, (int) player.bigBlind());
    }


    @Test
    public void smallBlindChip() {
        Integer expected = originalChips-1;
         player.smallBlind();
         Assert.assertEquals(expected, player.getChip());
    }

    @Test
    public void bigBlindChip() {
        Integer expected = originalChips-2;
        player.bigBlind();
        Assert.assertEquals(expected, player.getChip());
    }

    @Test
    public void betTest() {
        Assert.assertEquals(30, (int) player.bet(30));
    }

    @Test
    public void betTestChip() {
        Integer bet = 50;
        Integer expected = originalChips-bet;
        player.bet(bet);
        Assert.assertEquals(expected,player.getChip());
    }

    @Test (expected = NegativeBetException.class)
    public void betTestNegative() {
        player.bet(-10);
    }

    @Test (expected = NotEnoughChipException.class)
    public void betTestNotEnoughChip() {
        player.bet(110);

    }
}