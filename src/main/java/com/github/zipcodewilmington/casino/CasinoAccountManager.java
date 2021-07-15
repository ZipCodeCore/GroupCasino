package com.github.zipcodewilmington.casino;

import com.github.zipcodewilmington.utils.IOConsole;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {

    Set<CasinoAccount> casinoAccounts = new HashSet<>();
    CasinoAccount casinoAccount;
    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount getAccount(String accountName, String accountPassword) {
        //String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        //String currentClassName = getClass().getName();
        //String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        //throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        IOConsole console = new IOConsole();
        for (CasinoAccount casinoAccount : casinoAccounts) {
            if (casinoAccount.getUsername().equals(accountName) && casinoAccount.getPassword().equals(accountPassword)) {
                return casinoAccount;
            }
            else if (!casinoAccounts.contains(casinoAccount.getUsername()) && !casinoAccounts.contains(casinoAccount.getPassword())) {
                console.println("No account found with name of [ %s ] and password of [ %s ]", accountName, accountPassword);
            }
        }
        return casinoAccount;
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword, Integer accountAge, Integer accountBalance) {
        //String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        //String currentClassName = getClass().getName();
        //String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        //throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        CasinoAccount casinoAccount = new CasinoAccount(accountName, accountPassword, accountAge, accountBalance);
        casinoAccounts.add(casinoAccount);
        return casinoAccount;
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        //String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        //String currentClassName = getClass().getName();
        //String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
        //throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
        casinoAccounts.add(casinoAccount);
    }

    public Set<CasinoAccount> getArcadeAccountList() {
        return casinoAccounts;
    }
}
