package io.zipcoder.casino.utilities;

import io.zipcoder.casino.Players.MacaoPlayer;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.Players.Profile;
import javafx.application.Platform;

public class Macao {

    private MacaoPlayer macaoGuest;
    private MacaoPlayer macaoComputer;
    private boolean isOver;
    private Dice dice;
    private Console console;
    private boolean guestStillPlaying;
    private boolean computerStillPlaying;


    public Macao(MacaoPlayer macaoGuest) {
        this.macaoGuest = macaoGuest;
        this.macaoComputer = new MacaoPlayer(new Profile());
        this.isOver = false;
        this.dice = new Dice();
        this.console = new Console();
        this.guestStillPlaying = true;
        this.computerStillPlaying = true;
    }

    public void play() {
        initialGameSetup();
        while(!isOver) {
            if (isGuestStillPlaying()) {
                rollDie(macaoGuest);
                showGuestRoll();
            }
            if(didGuestGoOver()) {break;}
            if(isComputerStillPlaying()) {
                rollDie(macaoComputer);
                showComputerRoll();
            }
            isOver();
    }

    }

    public void rollDie(MacaoPlayer player) {
        player.roll = dice.roll();
        player.cumulativeRoll += player.roll;
    }

    public void showInitialRolls() {
        console.print("You rolled a %s and the computer rolled a %s. ", macaoGuest.roll, macaoComputer.roll);
    }

    public void showGuestRoll() {
        console.println("You rolled a %s and your total is now %s.", macaoGuest.roll, macaoGuest.cumulativeRoll);
    }

    public void showComputerRoll() {
        console.println("The computer rolled a %s and its total is now %s.", macaoComputer.roll, macaoComputer.cumulativeRoll);
    }

    public void initialGameSetup(){
        rollDie(macaoGuest);
        rollDie(macaoComputer);
        showInitialRolls();
    }

    public boolean isGuestStillPlaying() {
        if (macaoGuest.cumulativeRoll < 9 && guestStillPlaying == true) {
            String yesOrNo = console.getStringInput("Would you like to roll again?");
            if (yesOrNo.equals("yes")) {
                guestStillPlaying = true;
            } else {
                guestStillPlaying = false;
            }
        }
        return guestStillPlaying;
    }

    public boolean didGuestGoOver() {
        boolean guestWentOver = false;
        if (macaoGuest.cumulativeRoll > 9) {
            guestStillPlaying = false;
            return true;
        }
        return guestWentOver;
    }

    public boolean isComputerStillPlaying() {
        if (macaoComputer.cumulativeRoll > 7 && macaoComputer.cumulativeRoll > macaoGuest.cumulativeRoll) {
            computerStillPlaying = false;
        } else if (guestStillPlaying = false && macaoComputer.cumulativeRoll > macaoGuest.cumulativeRoll) {
            computerStillPlaying = false;
        }
        return computerStillPlaying;
    }

    public boolean isOver() {
        if (macaoComputer.cumulativeRoll > 9) {
            console.println("The computer went over. You win!");
            isOver = true;
        } else if (guestStillPlaying == false && computerStillPlaying == false) {
            isOver = true;
            if (macaoGuest.cumulativeRoll > macaoComputer.cumulativeRoll) {
                console.println("You rolled %s and the computer rolled %s. You win!", macaoGuest.cumulativeRoll, macaoComputer.cumulativeRoll);
            } else if (macaoComputer.cumulativeRoll >  macaoGuest.cumulativeRoll) {
                console.println("You rolled %s and the computer rolled %s. Sorry, you lose!", macaoGuest.cumulativeRoll, macaoComputer.cumulativeRoll);
            } else if (macaoGuest.cumulativeRoll == macaoComputer.cumulativeRoll) {
                console.println("It's a tie!");
            }
        }
        return isOver;
    }

    public static void main(String[] args) {
        Macao macao = new Macao(new MacaoPlayer(new Profile("Ashley", false)));
        macao.play();
    }
}
