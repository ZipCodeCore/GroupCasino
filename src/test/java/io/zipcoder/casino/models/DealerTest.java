package io.zipcoder.casino.models;

import models.people.dealers.Dealer;
import org.junit.Assert;
import org.junit.Test;

public class DealerTest {
    private Dealer dealer;

    @org.junit.Before
    public void setUp() throws Exception {
        dealer = new Dealer("Richard", "Turner", Double.MAX_VALUE);
    }

    @org.junit.After
    public void tearDown() throws Exception {
    }

    @Test
    public void dealerNameTest(){
        String expectedName = "Richard Turner";
        String actualName = dealer.getFirstName() + " " + dealer.getLastName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void dealerBalanceTest(){
        Double expectedBalance = Double.MAX_VALUE;
        Double actualBalance = dealer.getBalance();
        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void dealerWinBet(){
        Double depositAmount = 10000.00;
        Double expectedBalance = Double.MAX_VALUE;
        Double actualBalance = dealer.getBalance() + depositAmount;
        Assert.assertEquals(expectedBalance, actualBalance);
    }

    @Test
    public void dealerLoseBet(){
        Double withdrawAmount = 40000.00;
        Double expectedBalance = Double.MAX_VALUE;
        Double actualBalance = dealer.getBalance() - withdrawAmount;
        Assert.assertEquals(expectedBalance, actualBalance);
    }
}
