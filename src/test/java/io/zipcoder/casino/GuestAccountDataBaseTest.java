package io.zipcoder.casino;

import io.zipcoder.casino.Models.GuestAccount;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GuestAccountDataBaseTest {
    private GuestAccountDataBase testDataBase;

    @Before
    public void generateDataBase() {
        testDataBase = new GuestAccountDataBase();
    }

    @Test
    public void addAccountTest1() {
        // Given
        String name = "Miles";
        Double startingBalance = 1000.0;
        String expected = "Name: Miles, ID: 1, Balance: 1000.00\n";

        // When
        testDataBase.addAccount(name, startingBalance);
        String actual = testDataBase.getDatabaseOfGuestAccountsAsString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addAccountTest2() {
        // Given
        String name1 = "Miles";
        Double startingBalance1 = 1000.0;
        String name2 = "Sarah";
        Double startingBalance2 = 2000.0;

        String expected = "Name: Miles, ID: 1, Balance: 1000.00\n" +
                "Name: Sarah, ID: 2, Balance: 2000.00\n";

        // When
        testDataBase.addAccount(name1, startingBalance1);
        testDataBase.addAccount(name2, startingBalance2);
        String actual = testDataBase.getDatabaseOfGuestAccountsAsString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeAccountTest1() {
        // Given
        String name1 = "Miles";
        Double startingBalance1 = 1000.0;
        String name2 = "Sarah";
        Double startingBalance2 = 2000.0;

        String expected = "Name: Sarah, ID: 2, Balance: 2000.00\n";

        // When
        Integer idOfAccountToRemove = testDataBase.addAccount(name1, startingBalance1);
        testDataBase.addAccount(name2, startingBalance2);
        testDataBase.removeAccount(idOfAccountToRemove);
        String actual = testDataBase.getDatabaseOfGuestAccountsAsString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeAccountTest2() {
        // this is the test for if the specified does not exist in the database
        // Given
        String name1 = "Miles";
        Double startingBalance1 = 1000.0;
        String name2 = "Sarah";
        Double startingBalance2 = 2000.0;

        String expected = "Name: Miles, ID: 1, Balance: 1000.00\n" +
                "Name: Sarah, ID: 2, Balance: 2000.00\n";

        Integer idOfAccountToRemove = 4;
        // When
        testDataBase.addAccount(name1, startingBalance1);
        testDataBase.addAccount(name2, startingBalance2);
        testDataBase.removeAccount(idOfAccountToRemove);
        String actual = testDataBase.getDatabaseOfGuestAccountsAsString();

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAccountTest1() {
        // Given
        String name1 = "Miles";
        Double startingBalance1 = 1000.0;
        String name2 = "Sarah";
        Double startingBalance2 = 2000.0;

        String expectedString = "Sarah";

        // When
        testDataBase.addAccount(name1, startingBalance1);
        Integer idOfAccountToGet = testDataBase.addAccount(name2, startingBalance2);

        GuestAccount guestAccount = testDataBase.getAnAccount(idOfAccountToGet);

        String actualString = guestAccount.getName();

        // Then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void getAccountTest2() {
        // Given
        String name1 = "Miles";
        Double startingBalance1 = 1000.0;
        String name2 = "Sarah";
        Double startingBalance2 = 2000.0;

        String expectedString = "Miles";

        // When
        Integer idOfAccountToGet = testDataBase.addAccount(name1, startingBalance1);
        testDataBase.addAccount(name2, startingBalance2);

        GuestAccount guestAccount = testDataBase.getAnAccount(idOfAccountToGet);

        String actualString = guestAccount.getName();

        // Then
        Assert.assertEquals(expectedString, actualString);
    }

    @Test
    public void getAccountTest3() {
        // This is the null case
        // Given
        String name1 = "Miles";
        Double startingBalance1 = 1000.0;
        String name2 = "Sarah";
        Double startingBalance2 = 2000.0;

        GuestAccount expectedAccount = null;

        Integer idOfAccountToGet = 4;

        // When
        testDataBase.addAccount(name1, startingBalance1);
        testDataBase.addAccount(name2, startingBalance2);

        GuestAccount actualAccount = testDataBase.getAnAccount(idOfAccountToGet);

        // Then
        Assert.assertEquals(expectedAccount, actualAccount);
    }
}
