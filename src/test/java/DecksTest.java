import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecksTest {


    @Test
    public void buildDeckTest() {
        Decks deck = new Decks(3);
        Assert.assertEquals(deck.getCards().size(), 3*52);
    }

//    @Test
//    public void buildSuitTest() {
//        Decks deck = new Decks(1);
//        deck.buil
//    }
}