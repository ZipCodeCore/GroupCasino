package io.zipcoder.casino.GamePieces;


import io.zipcoder.casino.Games.Roulette.Roulette;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class RouletteSpinnerTest {

    @Test
    public void winningNumber() {
        Integer actual = RouletteSpinner.winningNumber();
        Assert.assertTrue(actual <= 36 && actual >=0);

    }
}