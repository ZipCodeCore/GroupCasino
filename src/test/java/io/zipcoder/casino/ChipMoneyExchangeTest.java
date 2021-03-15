package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class ChipMoneyExchangeTest {

    @Test
    public void chipsToMoney() {
        //Given
        ChipMoneyExchange exchange = new ChipMoneyExchange();
        int expected = 10;

        //When
        int actual = exchange.chipsToMoney(10);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void moneyToChips() {
        //Given
        ChipMoneyExchange exchange = new ChipMoneyExchange();
        int expected = 12;

        //When
        int actual = exchange.moneyToChips(12);

        //Then
        Assert.assertEquals(expected, actual);
    }
}
