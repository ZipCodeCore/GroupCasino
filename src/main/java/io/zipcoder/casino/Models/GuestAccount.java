package io.zipcoder.casino.Models;

import io.zipcoder.casino.Casino;

public class GuestAccount {

    private String name;
    //private String password;
    private Double accountBalance;
    private Long idNumber;

    public String getName() {
        return name;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
        Casino.console.getDoubleInput("Hello");
    }
}
