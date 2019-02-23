package io.zipcoder.casino;

import io.zipcoder.casino.Models.GuestAccount;
import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;


public class Casino {
    public static GuestAccountDataBase guestAccountDatabase;
    public static Console console;
    private Guest currentGuest;

    /**
     *Constructor to instantiate the Casino class taking 3 params
     */
    public Casino(){
       this(new GuestAccountDataBase(), System.in,System.out);
    }

    /**
     * Constructor to instantiate the Casino class taking 3 params
     * @param gab
     * @param inStream
     * @param outputStream
     */
    public Casino(GuestAccountDataBase gab, InputStream inStream, PrintStream outputStream){
        this.guestAccountDatabase = gab;
        this.console = new Console(inStream, outputStream);
    }

    /**
     * Method sets a newly created guest as the class' currentGuest
     * @param name
     * @param guestAccount
     */
    public void setGuest(String name, GuestAccount guestAccount){
        this.currentGuest = new Guest(name, guestAccount);
    }

    /**
     * Returns the current guest that is set for the class
     * @return
     */
    public Guest getGuest() {
        return this.currentGuest;
    }

    /**
     * Returns the guest account database that houses all the guest accounts
     * @return
     */

    public GuestAccountDataBase getGuestAccountDatabase(){
        return this.guestAccountDatabase;
    }


    /**
     * Prints out the welcome header
     */

    public void welcomeHeader(){
        console.println("*******************************************\nWELCOME TO THE CASINO\n*******************************************");
    }

    /**
     * Prompts the user to provide their name
     * @return String representation of user inputted name
     */
    private String getGuestName() {
        return console.getStringInput("Please provide your name to start a new guest account.");
    }

    /**
     *Prompts the user to provide their starting balance
     *@return Double representation of user inputted starting balance
     */
    private Double getStartingBalance(){
        return console.getDoubleInput("How much money would you like to deposit into your account?");
    }

    /**
     * Creates the guest account, stores the returned id number to retrieve the the newly created account and return it.
     * @param name
     * @param startingBalance
     * @return
     */
    private GuestAccount createGuestAccount(String name, Double startingBalance){
        Integer guestId = guestAccountDatabase.addAccount(name, startingBalance);
        return guestAccountDatabase.getAccount(guestId);
    }

    /**
     * Begins the start of taking user input and return of account creation. Begins Casino Games run method.
     */
    public void startCasinoExperience() {
        this.welcomeHeader();
        String guestNewName = this.getGuestName();
        Double guestStartingBalance = this.getStartingBalance();

        GuestAccount newGuestAccount = createGuestAccount(guestNewName, guestStartingBalance);
        setGuest(guestNewName, newGuestAccount);

        Integer accountId = newGuestAccount.getId();
        console.println(String.format("This is your new account.\n%s",guestAccountDatabase.getAccount(accountId).toString()));

        CasinoGames casinoGames = new CasinoGames();
        casinoGames.runSelectedGames(currentGuest);
    }



}