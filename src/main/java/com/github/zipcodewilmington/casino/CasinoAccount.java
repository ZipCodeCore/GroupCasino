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
<<<<<<< HEAD
=======
feature/CasinoAccount
>>>>>>> 215c282dea0773bd7aa0b3a7ddaf24f06beed64c
=======
feature/CasinoAccount
>>>>>>> 6f696bfd3d8b08440df417b0a383f72391cab149
    public String getPassword() {
        return password;
    }

    public String getAccountName() {
        return accountName;
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======

>>>>>>> 215c282dea0773bd7aa0b3a7ddaf24f06beed64c
=======

>>>>>>> 6f696bfd3d8b08440df417b0a383f72391cab149
}
