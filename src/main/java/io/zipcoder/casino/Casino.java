package io.zipcoder.casino;

import io.zipcoder.casino.utilities.Console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Casino {

    private Console c;
    private Scanner s;
    private Display d;
    private InputStream in;
    private PrintStream out;
    private PlayerWarehouse pwh;
    private Random rand;
    private Boolean atLogin;
    private Player currentPlayer;

    public Casino() {
        this.in = System.in;
        this.out = System.out;
        this.c = new Console(in, out);
        this.d = new Display();
        this.pwh = new PlayerWarehouse();
        this.rand = new Random();
        this.atLogin = true;
        this.currentPlayer = new Player("TIMBERDOODLE72", 2.0);
    }

    public void run() {
        while (atLogin) {

            d.setPrintCurrentDisplay("Welcome! Are you a new or returning user?");
            Integer input1 = c.getIntegerInput("Press 1 for new, 2 for returning.");

            if (input1 == 1) {

                String newName = c.getStringInput("What's your name?");
                String newPass = c.getStringInput("Make a password.");
                Double newDeposit = c.getDoubleInput("Make an initial deposit.");
                String newId;

                while(true) {
                    newId = "" + rand.nextInt(9999);
                    if(pwh.validateUniquePlayer(newId)){
                        break;
                    }
                }

                d.setPrintCurrentDisplay("Your user ID is " + newId + ". Remember it!\n");
                pwh.addNewPlayer(newId, new Player(newName, newDeposit), newPass);
                d.setPrintCurrentDisplay("And you're all set!\n");

            } else if (input1 == 2) {

                while(true) {
                    String oldId;
                    oldId = c.getStringInput("What's your user ID?");
                    String oldPass;
                    oldPass = c.getStringInput("What's your password?");
                    if(pwh.validateLoginCredentials(oldId, oldPass)){
                        currentPlayer = pwh.getPlayer(oldId);
                        break;
                    }else{
                        d.setPrintCurrentDisplay("Improper login credentials.\n");
                        break;
                    }
                }

            } else {
                d.printErrorMessage();
            }

            if(currentPlayer.getName() != "TIMBERDOODLE72"){
                break;
            }

        }
    }
}








