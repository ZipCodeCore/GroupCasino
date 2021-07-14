package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.Casino;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccount` is registered for each user of the `Arcade`.
 * The `ArcadeAccount` is used to log into the system to select a `Game` to play.
 */
public class CasinoAccount {
    private String password;
    private String accountName;


    public CasinoAccount(String accountName, String accountPassword){
        this.accountName = accountName;
        this.password = accountPassword;
    }



<<<<<<< HEAD
=======
feature/CasinoAccount
>>>>>>> eb43adc5aea6f2808ae5192219035b42dfc3e7ff
    public String getPassword() {
        return password;
    }

    public String getAccountName() {
        return accountName;
    }

}
