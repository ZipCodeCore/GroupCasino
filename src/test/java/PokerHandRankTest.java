import org.junit.Assert;
import org.junit.Test;

public class PokerHandRankTest {

    @Test
    public void royalFlushTest()
    {
        Assert.assertEquals(PokerHandRank.ROYAL_FLUSH,PokerHandRank.determineHand());
    }
}
