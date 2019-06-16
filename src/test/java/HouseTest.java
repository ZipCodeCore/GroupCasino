import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HouseTest {

    @Test
    public void payoutTest() {
        Decks decks = new Decks(1);
        House house = new House(2, decks);
        house.takeBets(2);
        Integer expected = 4;
        Integer actual = house.payout(2);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void takeBetsTest() {
        Decks decks = new Decks(1);
        House house = new House(2, decks);
        house.takeBets(1, 2);
        Integer expected = 6;
        Integer actual = house.getHouseWallet();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void moneyToChipsTest1() {
        Decks decks = new Decks(1);
        House house = new House(2, decks);
        Integer expected = 20;
        Integer actual = house.moneyToChips(100.0);
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void moneyToChipsTest2() {
        Decks decks = new Decks(1);
        House house = new House(2, decks);
        Integer expected = 20;
        Integer actual = house.moneyToChips(103.43);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shuffleTest() {
        Decks decks = new Decks(1);
        House house = new House(2, decks);
        Card firstCard = decks.getCards().get(0);
        Card secondCard = decks.getCards().get(1);
        Card thirdCard = decks.getCards().get(2);
        house.shuffle();
        decks = house.getDecks();
        if (!firstCard.equals(decks.getCards().get(0))) return;
        if (!secondCard.equals(decks.getCards().get(1))) return;
        if (!thirdCard.equals(decks.getCards().get(2))) return;
        assertNull(decks);
    }

    @Test
    public void dealRoundTest() {
        Decks decks = new Decks(1);
        House house = new House(2, decks);
    }

    @Test
    public void dealHandTest() {
        Decks decks = new Decks(1);
        House house = new House(2, decks);
    }

    @Test
    public void dealCardTest() {
        Decks decks = new Decks(1);
        House house = new House(2, decks);
    }
}