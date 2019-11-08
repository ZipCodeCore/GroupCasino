package io.zipcoder.casino.Games.Roulette;

import io.zipcoder.casino.PlayerCreation.Player;
import org.junit.Test;

import java.lang.management.PlatformLoggingMXBean;

import static org.junit.Assert.*;

public class RouletteTest {

    @Test
    public void winningNumberTest() {
        Roulette roulette = new Roulette();
        Integer expected = roulette.winningNumber();
        boolean greaterThanZero = expected >= 0;
        boolean lessThan36 = expected <=36;

        assertTrue(greaterThanZero);
        assertTrue(lessThan36);
    }

    @Test
    public void isWinnerTrueTest() {
        //Given
        Roulette roulette = new Roulette();
        roulette.setOddEvenGame(false);
        Integer num = 10;
        roulette.setPlaceBetInt(num);
        roulette.setSpinNum(num);
        //When
        boolean actual = roulette.isWinner();
        //
        assertTrue(actual);
    }
    @Test
    public void isWinnerFalseTest(){
        Roulette roulette = new Roulette();
        roulette.setOddEvenGame(false);
        Integer num = 10;
        roulette.setPlaceBetInt(num);
        roulette.setSpinNum(num-2);
        //When
        boolean actual = roulette.isWinner();
        //
        assertFalse(actual);
    }
    @Test
    public void isOddWinnerTrueTest() {
        Roulette roulette = new Roulette();
        roulette.setOddEvenGame(true);
        Integer num = 9;
        roulette.setSpinNum(num);
        roulette.setPlaceBetInt(1);

        boolean actual = roulette.isWinner();

        assertTrue(actual);
    }
    @Test
    public void isOddWinnerFalseTest(){Roulette roulette = new Roulette();
        roulette.setOddEvenGame(true);
        Integer num = 9;
        roulette.setSpinNum(num +1);
        roulette.setPlaceBetInt(1);

        boolean actual = roulette.isWinner();

        assertFalse(actual);}
    @Test
    public void isEvenWinnerTrueTest(){Roulette roulette = new Roulette();
        roulette.setOddEvenGame(true);
        Integer num = 10;
        roulette.setSpinNum(num);
        roulette.setPlaceBetInt(0);

        boolean actual = roulette.isWinner();

        assertTrue(actual);}
    @Test
    public void isEvenWinnerFalseTest(){Roulette roulette = new Roulette();
        roulette.setOddEvenGame(true);
        Integer num = 10;
        roulette.setSpinNum(num +1);
        roulette.setPlaceBetInt(0);

        boolean actual = roulette.isWinner();

        assertFalse(actual);}
    @Test
    public void returnWinningsTest() {
        Roulette roulette = new Roulette();
        Player player = new Player("Bob", 999);

        roulette.setOddEvenGame(true);
        Integer num = 9;
        roulette.setSpinNum(num);
        roulette.setPlaceBetInt(1);

        Integer pot = 5;
        Integer multiplier = 2;
        roulette.setPot(pot);
        roulette.setMultiplier(multiplier);

        Integer expected = player.getBalance() + pot * multiplier;
        roulette.returnWinnings(player, 999);

        Integer actual = player.getBalance();

        assertEquals(expected,actual);
    }

    @Test
    public void youLose() {
        Roulette roulette = new Roulette();
        Player player = new Player("Bob", 999);

        roulette.setOddEvenGame(true);
        Integer num = 9;
        roulette.setSpinNum(num);
        roulette.setPlaceBetInt(0);

        Integer pot = 5;
        roulette.setPot(pot);


        Integer expected = player.getBalance() - pot ;
        roulette.returnWinnings(player, 999);

        Integer actual = player.getBalance()- pot;

        assertEquals(expected,actual);
    }

}