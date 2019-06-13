import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PokerPlayerTest {
    PokerPlayer player;

    @Before
    public void setUp() throws Exception {
        PokerPlayer player = new PokerPlayer(new Person(100,"John", 21));

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
        Assert.assertEquals(10, (int) player.call(10));
    }

    @Test
    public void check() {
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
    public void smallBlind() {
        Assert.assertEquals(1, (int) player.smallBlind());
    }

    @Test
    public void bigBlind() {
        Assert.assertEquals(2, (int) player.bigBlind());
    }
}