package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Display {

    String currentDisplay;
    private Player p;
    private Console c;

    private Scanner s;
    private InputStream in;
    private PrintStream out;

    public Display(){

        this.in = System.in;
        this.out = System.out;
        this.c = new Console(in, out);

        this.currentDisplay = "";
        this.p = new Player();
    }

    public void testConsole() {
        String var = c.getStringInput("Prompt", null);
        System.out.println(var);
    }

    public void setCurrentDisplay(String currentDisplay){
        this.currentDisplay = currentDisplay;
    }

    public void printCurrentDisplay(){
        System.out.println(currentDisplay);
    }

    public void currentDisplaySP(String currentDisplay){
        this.setCurrentDisplay(currentDisplay);
        this.printCurrentDisplay();
    }


    // WELCOME MESSAGING
    public void printWelcomeMessage() {
        System.out.println(
            "'########:'####:'########::::::'######:::'#######::'########::'########::::\n"+
            "..... ##::. ##:: ##.... ##::::'##... ##:'##.... ##: ##.... ##: ##.....:::::\n"+
            ":::: ##:::: ##:: ##:::: ##:::: ##:::..:: ##:::: ##: ##:::: ##: ##::::::::::\n"+
            "::: ##::::: ##:: ########::::: ##::::::: ##:::: ##: ##:::: ##: ######::::::\n"+
            ":: ##:::::: ##:: ##.....:::::: ##::::::: ##:::: ##: ##:::: ##: ##...:::::::\n"+
            ": ##::::::: ##:: ##::::::::::: ##::: ##: ##:::: ##: ##:::: ##: ##::::::::::\n"+
            " ########:'####: ##:::::::::::. ######::. #######:: ########:: ########::::\n"+
            "........::....::..:::::::::::::......::::.......:::........:::........:::::\n"+
            ":'######:::::'###:::::'######::'####:'##::: ##::'#######::\n"+
            "'##... ##:::'## ##:::'##... ##:. ##:: ###:: ##:'##.... ##:\n"+
            " ##:::..:::'##:. ##:: ##:::..::: ##:: ####: ##: ##:::: ##:\n"+
            " ##:::::::'##:::. ##:. ######::: ##:: ## ## ##: ##:::: ##:\n"+
            " ##::::::: #########::..... ##:: ##:: ##. ####: ##:::: ##:\n"+
            " ##::: ##: ##.... ##:'##::: ##:: ##:: ##:. ###: ##:::: ##:\n"+
            ". ######:: ##:::: ##:. ######::'####: ##::. ##:. #######::\n"+
            ":......:::..:::::..:::......:::....::..::::..:::.......:::\n\n"+
            "WELCOME TO ZIP CODE CASINO, LOCATED IN WILMINGTON, DE!"
        );


    }

    public void printWelcomeBackMessage() {
        System.out.println(
            //"Welcome back " + p.getName() + "!\n"+
            //"Your current account balance is " + p.getAccountBalance + "."
        );
    }


    // MENUS
    public void printLoginMenu() {
        System.out.println(
                "What would you like to do?\n" +
                        "1.Login\n" +
                        "2.Create New Account"
        );
    }

    public void printGamesMenu() {
        System.out.println(
            "Pick a Game to Play:\n"+
            "   1. BlackJack\n" +
            "   2. Craps\n" +
            "   3. Beetle\n" +
            "   4. GoFish\n"
        );
    }


    // ERROR MESSAGING
    public void printErrorMessage() {
        System.out.println("Invalid Input!");
    }


    // FUNDS MESSAGING
    public void printAccountBalance() {
        System.out.println(
           // "Account Balance: " + p.getAccountBalance()
        );
    }

    public void printLowFundsWarning(){
        System.out.println(
            "WARNING: YOUR FUNDS ARE GETTING LOW!\n"+
            "Please consider making a deposit."
        );
        this.printAccountBalance();

    }

    public void printZeroFundsWarning() {
        System.out.println(
            "WARNING: YOUR ACCOUNT BALANCE HAS REACHED $0.00.\n"+
            "PLEASE MAKE A DEPOSIT TO CONTINUE PLAYING."
        );
    }

    // GENERIC GAME RESULT MESSAGING
    public void printRollResult() {

    }

    public void printDealResult() {

    }

    // USER SET-UP MESSAGING
    public void printUserId(){

    }

    public void printRequestForUserId() {

    }

    public void printRequestForInitialDeposit(){

    }

    // GENERIC BETTING MESSAGES
    public void printRequestBetAmount() {

    }


}
