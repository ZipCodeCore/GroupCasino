package io.zipcoder.casino;

import io.zipcoder.casino.Models.GuestAccount;
import org.junit.Assert;
import org.junit.Test;


public class CasinoTest {

    @Test
    public void createNewCasinoTestWithParameters() {
        //given
        GuestAccountDataBase expected = new GuestAccountDataBase();
        Casino newCasino = new Casino(expected,System.in, System.out);
        //when
        GuestAccountDataBase actual = newCasino.getGuestAccountDatabase();
        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createNewCasinoTestWithNoParameters() {
        //given
        Casino newCasino = new Casino();
        //when
        GuestAccountDataBase gab = newCasino.getGuestAccountDatabase();
        //then
        Assert.assertNotEquals(null, gab);
    }

    @Test
    public void setGuestInCasinoTest() {
        //given
        Casino newCasino = new Casino();
        String name = "Marci Brahma";
        Double startingBalance = 500.00;
        GuestAccount newGuestAcc = new GuestAccount(name, 23,startingBalance);

        newCasino.setGuest(name, newGuestAcc);
        //when
        Guest actual = newCasino.getGuest();
        //then
        Assert.assertEquals("Marci Brahma",actual.getName());

    }

    @Test
    public void getGuestAccountTest() {
        //given
        Casino newCasino = new Casino();
        String name = "Marci Brahma";
        Double startingBalance = 500.00;
        GuestAccount newGuestAcc = new GuestAccount(name, 23,startingBalance);

        newCasino.setGuest(name, newGuestAcc);
        //when
        Guest actual = newCasino.getGuest();
        //then
        Assert.assertEquals("Marci Brahma",actual.getName());
    }


}
