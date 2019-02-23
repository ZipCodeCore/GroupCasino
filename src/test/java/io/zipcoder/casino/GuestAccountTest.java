package io.zipcoder.casino;

import io.zipcoder.casino.Models.GuestAccount;
import org.junit.Assert;
import org.junit.Test;



public class GuestAccountTest {

    @Test
    public void setName(){

        //Given
        GuestAccount guestAccount = new GuestAccount("Reed Richards", 4, 300.00);
        String expected = "Victor Von Doom";

        //When
        guestAccount.setName("Victor Von Doom");
        String actual = guestAccount.getName();

        //Then
        Assert.assertEquals(expected,actual);

    }


    @Test
public void createGuestAccountTest1() {

        //Given
        String name = "Maurice Moss";
        Integer id = 4547;
        Double balance = 1000.00;

        //When
        GuestAccount guestAccount = new GuestAccount(name, id, balance);
        String actualName = guestAccount.getName();
        Integer actualId = guestAccount.getId();
        Double actualBalance = guestAccount.getAccountBalance();

        //Then
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(id, actualId);
        Assert.assertEquals(balance, actualBalance);

    }
    @Test
    public void createGuestAccountTest2 (){

        //Given
        String name = "Jen Barber";
        Integer id = 357;
        Double balance = 40.00;

        //When
        GuestAccount guestAccount = new GuestAccount(name, id, balance);
        String actualName = guestAccount.getName();
        Integer actualId= guestAccount.getId();
        Double actualBalance = guestAccount.getAccountBalance();

        //Then
        Assert.assertEquals(name, actualName);
        Assert.assertEquals(id, actualId);
        Assert.assertEquals(balance, actualBalance);
    }

    /*@Test
    public void removeGuestAccountTest1(){

        //Given
        String name = "Douglas Reynhold";
        Integer id = 4547;
        Double accountBalance = 250.00;
        GuestAccount guestAccount = new GuestAccount(name, id, accountBalance);



         //When
        guestAccount.removeGuestAccount(id);
        GuestAccount actual = guestAccount.checkGuestAccount(id);

        //Then
        Assert.assertNull(actual);

    }*/

    @Test
    public void addFunds(){

        //Given
        GuestAccount guestAccount = new GuestAccount("Marsi Marse", 2345, 250.00);
        Double funds = 100.00;
        Double expected = 350.00;

        //When
        Double actual = guestAccount.addFunds(funds);


        //
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeFunds(){

        //Given
        GuestAccount guestAccount = new GuestAccount("Mad Dog", 187, 150.00);
        Double funds = 150.00;
        Double expected = 0.00;

        //When
        Double actual = guestAccount.removeFunds(funds);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringTest(){

        //Given
        GuestAccount guestAccount = new GuestAccount("Johnny Blaze", 888, 555.00);
        String expected = "Name: Johnny Blaze, ID: 888, Balance: $555.00\n";

        //When
        String actual = guestAccount.toString();

        //Then
        Assert.assertEquals(expected, actual);
    }

}
