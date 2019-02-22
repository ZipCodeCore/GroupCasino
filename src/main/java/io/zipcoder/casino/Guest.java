package io.zipcoder.casino;

import io.zipcoder.casino.Models.GuestAccount;

/**
 * This class creates a new Guest for the Casino
 *
 * @version 2019-02-22
 */

public class Guest {
    private GuestAccount myAccount;
    private String name;


    public Guest(String name, GuestAccount myAccount) {
        this.myAccount = myAccount;
        this.name = name;
    }

    /**
     *This method gets the Guest's name
     * @return This returns the Guest's name
     */
    public String getName() {
        return name;
    }

    /**
     * This method sets the account information for the Guest created by GuestAccount
     * @param myAccount This is the parameter for SetMyAccount method.
     */
    public void setMyAccount(GuestAccount myAccount) {
        this.myAccount = myAccount;
    }

    /**
     * This method sets the Guest's name
     * @param name This is a String parameter used for the setName method.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method add funds to the account balance in the GuestAccount class
     * @param amount This is the parameter for addFunds method
     */
    public void addFunds(Double amount){
        myAccount.addFunds(amount);
    }

    /**
     * This method removes funds from the Guest's account balance
     * @param amount This is the parameter for removeFunds method
     */
    public void removeFunds(Double amount) {
        myAccount.removeFunds(amount);
    }
    /**
     * This method gets the account balance from the GuestAccount class
     * @return the balance of the Guest's account
     */
    public Double getAccountBalance(){
        return myAccount.getAccountBalance();
    }

    /**
     * This method gets the account information for the Guest from the GuestAccount
     * @return This return the Guest Account information
     */

    public GuestAccount getMyAccount() {
        return myAccount;
    }
}
