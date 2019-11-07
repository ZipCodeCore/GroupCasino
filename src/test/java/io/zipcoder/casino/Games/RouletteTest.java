package io.zipcoder.casino.Games;

import io.zipcoder.casino.Games.Roulette.Roulette;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.GamePieces.RouletteSpinner;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RouletteTest {
    Roulette roulette;
    Player currentPlayer;
    RouletteSpinner rouletteSpinner;
    @Before
    public void setup(){
        roulette = new Roulette();
        currentPlayer = new Player("Lucy", 5000);
        rouletteSpinner = new RouletteSpinner();
    }
//    @Test
//    public void isWinnerTest(){
//        //Given
//        roulette.setOddEvenGame(true);
//
//
//         Integer spinNum = RouletteSpinner.winningNumber();
//        //When
//        Integer expected  = 0;
//        spinNum = expected;
//
//        //Then
//        Assert.assertEquals(expected, roulette.isWinner());
//
//    }
}
