package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface  {
    private Integer accountTotal;

    public SlotsPlayer(){
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public void setArcadeAccount(CasinoAccount casinoAccount) {

    }

    public void subtractFromTotal(Integer value){
        Integer newTotal = accountTotal - value;
        accountTotal = newTotal;
    }

    public void addToTotal(Integer value){
        Integer newTotal = accountTotal + value;
        accountTotal = newTotal;
    }

    public Integer getAccountTotal() {
        return accountTotal;
    }

    public void setAccountTotal(Integer accountTotal) {
        this.accountTotal = accountTotal;
    }

}