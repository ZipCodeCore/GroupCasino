package io.zipcoder.casino;

import io.zipcoder.casino.Models.GuestAccount;

import java.util.TreeMap;

public class GuestAccountDataBase {

    private TreeMap<Integer,GuestAccount> guestAccountDatabase;
    private Integer accountIdGenerator;

    /**
     * This is the constructor for the database. It intializes the TreeMap that holds all of the accounts and
     * initializes the accountIdGenerator to 1. Everytime a new account is added, that accountIdGenerator will
     * be incremented by 1.
     */
    GuestAccountDataBase() {
        this.guestAccountDatabase = new TreeMap<>();
        accountIdGenerator = 1;
    }

    /**
     * This method converts the entire database into a string, and returns that string.
     * @return the string representation of the database.
     */
    String getDatabaseOfGuestAccountsAsString() {
        String databaseAsString = guestAccountDatabase.toString();
        databaseAsString = databaseAsString.replaceAll("[{,}]", "");
        return databaseAsString;
    }

    /**
     * This method adds a new account to the database, and returns the Integer that is the new ID of the newly created
     * account. It also increments the accountIdGenerator by
     *
     * @param name name to be assigned to new account
     * @param startingBalance starting balance of new account
     * @return the Integer value that is the new id of the newly created account
     */
    Integer addAccount(String name, Double startingBalance){
        Integer idOfNewlyCreatedAccount = accountIdGenerator;

        GuestAccount newlyCreatedAccount = new GuestAccount(/*name, idOfNewlyCreatedAccount, startingBalance*/);
        this.guestAccountDatabase.put(idOfNewlyCreatedAccount, newlyCreatedAccount);
        accountIdGenerator++;

        return idOfNewlyCreatedAccount;
    }

    /**
     * This method removes an existing account from the Database using a given id (the id is the kay for the TreeMap
     * of GuestAccounts)
     * @param id the id of the account to remove
     */
    void removeAccount(Integer id){
        this.guestAccountDatabase.remove(id);
    }

    /**
     * This method takes in an Integer id, finds the associated GuestAccount and returns it.
     * @param id the id of the account to get
     * @return the GuestAccount associated with the specified ID
     */
    GuestAccount getAnAccount(Integer id) {
        return this.guestAccountDatabase.get(id);
    }

}
