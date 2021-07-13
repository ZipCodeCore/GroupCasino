package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.models.Card;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class CardsTest {
    @Test
    public void constructorTest () {
        Integer expected = 52;

        Card card = new Card();
        Integer actual = card.getNumberOfCards();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createDeckTest () {
        // Given
        Card card = new Card();

        Integer expected = 52;
        Integer actual = card.getNumberOfCards();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void polishDeckTest () {
        Card card = new Card();

        card.createDeck(52);
        List<Integer> result = card.polishDeck();

        System.out.println(result);
    }

    @Test
    public void shuffleDeckTest () {
        Card card = new Card();

        List<Integer> result = card.shuffleDeck();

        System.out.println(result); // Visual test
    }

    @Test
    public void setCardPoolTest () {
        Card card = new Card();
    }

    @Test
    public void setNumberOfCardsTest () {

    }
}
