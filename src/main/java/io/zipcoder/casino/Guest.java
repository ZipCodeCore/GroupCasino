package io.zipcoder.casino;

import io.zipcoder.casino.Models.GuestAccount;

public class Guest {
    private GuestAccount myAccount;
    private String name;

    public Guest(String name, GuestAccount myAccount) {
        this.myAccount = myAccount;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setMyAccount(GuestAccount myAccount) {
        this.myAccount = myAccount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updateAccountBalance(Double amount){
        myAccount.setAccountBalance(amount);
    }
    public Double getAccountBalance(){
        return myAccount.getAccountBalance();
    }

    public GuestAccount getMyAccount() {
        return myAccount;
    }
}
