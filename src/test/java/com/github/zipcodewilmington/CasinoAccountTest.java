package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.player.Player;
import org.junit.Assert;
import org.junit.Test;

public class CasinoAccountTest {

    @Test
    public void testCreateAccount() {
        //given
        String password = "1234";
        String accountName = "Jen";
        int balance = 1000;
        //when
        CasinoAccount casinoAccount = new CasinoAccount(password, accountName);
        casinoAccount.createAccount();
        String actualPassword = casinoAccount.getPassword();
        String actualPlayer = casinoAccount.getAccountName();
        //then
        Assert.assertEquals(password, actualPassword);
        Assert.assertEquals(accountName, actualPlayer);
        System.out.println(casinoAccount.createAccount());
    }
}
