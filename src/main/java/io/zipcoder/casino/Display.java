package io.zipcoder.casino;
import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import java.util.Scanner;

public class Display {

    String currentDisplay;

    private Scanner s;
    private InputStream in;
    private PrintStream out;

    private Console c;

    public Display(){

        // INPUT/OUTPUT
        this.in = System.in;
        this.out = System.out;
        this.c = new Console(in, out);

        this.currentDisplay = "";
    }

    // UPDATE/PRINT CURRENT DISPLAY
    public void setCurrentDisplay(String newDisplay){
        this.currentDisplay = newDisplay;
    }

    public void printCurrentDisplay(){
        System.out.println(currentDisplay);
    }

    public void setPrintCurrentDisplay(String newDisplay){
        this.setCurrentDisplay(newDisplay);
        this.printCurrentDisplay();
    }


    // WELCOME MESSAGING
    public void printWelcomeMessage() {
        this.setPrintCurrentDisplay(
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

    public void printWelcomeBackMessage(String name, int getAccountBalance) {
        this.setPrintCurrentDisplay(
            "Welcome back " + name + "!\n"+
            "Your current account balance is " + getAccountBalance + "."
        );
    }

    // MENUS
    public void printLoginMenu() {
        this.setPrintCurrentDisplay(
            "What would you like to do?\n" +
                "1.Login\n" +
                "2.Create New Account"
        );
    }

    public void printGamesMenu() {
        this.setPrintCurrentDisplay(
            "Pick a Game to Play:\n"+
            "   1. BlackJack\n" +
            "   2. Craps\n" +
            "   3. Beetle\n" +
            "   4. GoFish\n" +
            "   5. Check Account Balance\n" +
            "   6. Make a Deposit\n" +
            "   7. Exit\n"
        );
    }

    // ERROR MESSAGING
    public void printErrorMessage() {
        this.setPrintCurrentDisplay("Invalid Input!");
    }


    // FUNDS MESSAGING
    public void printAccountBalance(double accountBalance) {
        BigDecimal formattedBalance = new BigDecimal(accountBalance).setScale(2, RoundingMode.HALF_UP);
        accountBalance = formattedBalance.doubleValue();
        this.setPrintCurrentDisplay(
           "Account Balance: " + accountBalance
        );
    }

    public void printLowFundsWarning(double accountBalance){
        this.setPrintCurrentDisplay(
            "\n\nWARNING: YOUR FUNDS ARE GETTING LOW!\n"+
            "Please consider making a deposit.\n"
        );
        this.printAccountBalance(accountBalance);

    }

    public void printZeroFundsWarning() {
        this.setPrintCurrentDisplay(
            "\n\nWARNING: YOUR ACCOUNT BALANCE HAS REACHED $0.00.\n"+
            "PLEASE MAKE A DEPOSIT TO CONTINUE PLAYING."
        );
    }

    public void printDepositMessage() {
        this.setPrintCurrentDisplay(
            "How much are you depositing?"
        );
    }

    // GENERIC GAME RESULT MESSAGING
    public void printRollResult(Integer[] diceResults) {
        String formattedRollResults = "";
        for(int i = 0; i < diceResults.length; i++) {
            formattedRollResults += "Dice " + (i+1) + ": " + diceResults[i] + "\n";
        }

        this.setPrintCurrentDisplay(
            formattedRollResults
        );
    }

    public void printDealResult(ArrayList dealResults) {
        String formattedDealResults = "";
        for(int i = 0; i < dealResults.size(); i++) {
            formattedDealResults += "Card " + (i+1) + ": " + dealResults.get(i) + "\n";
        }

        this.setPrintCurrentDisplay(
            formattedDealResults
        );
    }

    public void printAmountOfWinnings(Double winningsAmount) {
        setPrintCurrentDisplay("You won $" + winningsAmount+ "!!!");
    }

    public void printAmountOfLoss(Double lossAmount) {
        setPrintCurrentDisplay("You lost $" + lossAmount + ".");
    }

    // USER SET-UP MESSAGING
    public void printUserId(String userName){
        this.setPrintCurrentDisplay(
            "UserId: " + userName
        );
    }

    public void printRequestUserId() {
        this.setPrintCurrentDisplay(
            "Please enter username:"
        );
    }

    public void printRequestPassword() {
        this.setPrintCurrentDisplay(
            "Please enter your password:"
        );
    }

    public void printRequestInitialDeposit(){
        this.setPrintCurrentDisplay(
            "Please enter deposit amount:"
        );
    }

    // GENERIC BETTING MESSAGES
    public void printRequestBetAmount() {
        this.setPrintCurrentDisplay(
            "How much money would you like to bet?"
        );
    }

    public String getCurrentDisplay(){
        System.out.println(currentDisplay);
        return currentDisplay;
    }


}
