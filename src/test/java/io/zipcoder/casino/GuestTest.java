package io.zipcoder.casino;

import io.zipcoder.casino.Models.GuestAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuestTest {

    private GuestAccount given;

    @Before
    public void tester() {
        given = new GuestAccount(null, null, 100.0);
    }

    @Test
    public void getMyAccountTest() {

        //Given
//        GuestAccount given = new GuestAccount();
        Guest guest = new Guest("blah", given);


        //When
        GuestAccount expected = guest.getMyAccount();


        //Then
        Assert.assertEquals(given,expected);
    }

    @Test
    public void getNameTest() {
        // Given
//        GuestAccount guestAccount = new GuestAccount();
        String expected = "Julian";
        Guest guest = new Guest(expected, given);

        // When
        String actual = guest.getName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setMyAccountTest(){
        //Given
//        GuestAccount oldAccount = new GuestAccount();
        Guest guest = new Guest("Marlys",given);
//        GuestAccount given = new GuestAccount();


        //When

        guest.setMyAccount(given);
        GuestAccount expected = guest.getMyAccount();


        //Then
        Assert.assertEquals(expected,given);
    }

    @Test
    public void setNameTest() {
        // Given
//        GuestAccount guestAccount = new GuestAccount();
        String oldName = "jdaskjdksj";
        Guest guest = new Guest(oldName, given);
        String expected = "Toby";

        // When
        guest.setName(expected);
        String actual = guest.getName();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addFundsTest(){
        //Given
//        GuestAccount guestAccount = new GuestAccount(null,null,0.0);
        Guest guest = new Guest("Kevin",given);
        Double given = 100.50;
        Double expected = 200.5;

        //When
        guest.addFunds(given);
        Double actual = guest.getAccountBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeFundsTest(){
        //Given
//        GuestAccount guestAccount = new GuestAccount(null,null,0.0);
        Guest guest = new Guest("Kevin",given);
        Double given = 50.00;
        Double expected = 50.0;

        //When
        guest.removeFunds(given);
        Double actual = guest.getAccountBalance();

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getAccountBalanceTest() {
     // Tested with setMethod -> updateAccountBalanceTest
    }
}
