package io.zipcoder.casino;

import io.zipcoder.casino.Models.GuestAccount;

import java.util.ArrayList;
import java.util.Arrays;

public class GuestAccountDataBase {

    private ArrayList<GuestAccount> databaseOfGuestAccounts;
    private Integer accountIdGenerator;

    public GuestAccountDataBase() {
        this.databaseOfGuestAccounts = new ArrayList<>();
        accountIdGenerator = 1;
    }

    public String getDatabaseOfGuestAccountsAsString() {
        return Arrays.toString(databaseOfGuestAccounts.toArray());
    }

    public void addAnAccount(String name, Double startingBalance){
        // GuestAccount newAccount = new GuestAccount(name, accountIdGenerator, startingBalance);
        accountIdGenerator++;
    }

    public void removeAnAccount(String name){

    }

    public GuestAccount getAnAccount() {
        return null;
    }

}
