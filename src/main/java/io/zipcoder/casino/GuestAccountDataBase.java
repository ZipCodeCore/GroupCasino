package io.zipcoder.casino;

import io.zipcoder.casino.Models.GuestAccount;

import java.util.ArrayList;

public class GuestAccountDataBase {

    private ArrayList<GuestAccount> databaseOfGuestAccounts;
    static Long accountIdGenerator;

    public ArrayList<GuestAccount> getDatabaseOfGuestAccounts() {
        return databaseOfGuestAccounts;
    }

    public void setDatabaseOfGuestAccounts(ArrayList<GuestAccount> databaseOfGuestAccounts) {
        this.databaseOfGuestAccounts = databaseOfGuestAccounts;
    }

    public void addAnAccount(String name, Double startingBalance){

    }

    public void removeAnAccount(String name){

    }

}
