package io.zipcoder.casino;

import org.junit.Test;

public class YahtzeeTests {

    @Test
    public void YahtzeeConstructorTest(){
        // Given
        Player player = new Player(String name, double wallet);
        YahtzeePlayer expectedYahtzeePlayer = new YahtzeePlayer(player);

        // When
        Yahtzee yahtzee = new Yahtzee(player);

        // Then
    }
}
