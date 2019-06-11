package io.zipcoder.casino.Players;

import io.zipcoder.casino.Account;

abstract class Gambler {

    public void updateAccout(Integer c) {
        Account account = new Account();
        account.setBalance(c);

    }
}
