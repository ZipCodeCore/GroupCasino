package io.zipcoder.casino.Models;

import io.zipcoder.casino.Casino;

public class GuestAccount {

    private String name;
    //private String password;
    private Double accountBalance;
    private Integer id;


    public GuestAccount(String name, Integer id, Double accountBalance) {
        this.name = name;
        this.id = id;
        this.accountBalance = accountBalance;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }


    public Double getAccountBalance() {
        return this.accountBalance;
    }

    /*public void setAccountBalance(Double balance) {
        this.accountBalance = accountBalance;
    }*/


    public String toString() {

        return String.format("Name: %s, ID: %d, Balance: $%.2f\n", name, id, accountBalance);

    }

    public Double addFunds(Double funds){

        return this.accountBalance + funds;
    }

    public Double removeFunds(Double funds){

        return this.accountBalance - funds;
    }
}

