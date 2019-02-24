package io.zipcoder.casino.Cards.Games;

import io.zipcoder.casino.Cards.Dice;
import io.zipcoder.casino.Casino.Casino;
import io.zipcoder.casino.Players.MacaoPlayer;
import io.zipcoder.casino.utilities.Console;

public class Macao extends Game {

    private MacaoPlayer macaoGuest;
    private MacaoPlayer macaoDealer;
    private boolean isOver;
    private Dice dice;
    private Console console;
    private boolean guestStillPlaying;
    private boolean dealerStillPlaying;


    public Macao() {
        this.macaoGuest = new MacaoPlayer(Casino.getProfile());
        this.macaoDealer = new MacaoPlayer();
        this.isOver = false;
        this.dice = new Dice();
        this.console = Console.getConsole();
        this.guestStillPlaying = true;
        this.dealerStillPlaying = true;
    }

    public Macao(Console console) {
        this.macaoGuest = new MacaoPlayer(Casino.getProfile());
        this.macaoDealer = new MacaoPlayer();
        this.isOver = false;
        this.dice = new Dice();
        this.console = console;
        this.guestStillPlaying = true;
        this.dealerStillPlaying = true;
    }

    public int play() {
        printGameInstructions();
        if (beginGame()) {
            initialGameSetup();
        }
        while (!isOver) {
            if (isGuestStillPlaying()) {
                rollDie(macaoGuest);
                showGuestRoll();
            }
            if (didGuestGoOver()) {
                youWentOver();
                break;
            }
            if (isDealerStillPlaying()) {
                rollDie(macaoDealer);
                showdealerRoll();
            }
            evaluate();
        }
        return -2;
    }

    public void printGameInstructions() {
        console.println("Rules:\nThe object of this game is to roll the die enough times to reach a total of 9 without going over.\nGood luck!\n");
    }

    public boolean beginGame() {
        boolean beginGame = false;
        for (int i = 0; i < 1; i++) {
            String begin = console.getStandardInput("Are you ready to begin?");
            if (begin.equals("y") || begin.equals("yes")) {
                beginGame = true;
            } else {
                console.println("Try Again.");
                i--;
            }
        }
        return beginGame;
    }

    public void rollDie(MacaoPlayer player) {
        player.roll = dice.roll();
        player.cumulativeRoll += player.roll;
    }

    public void showInitialRolls() {
        console.println("YOUR ROLL: %s | DEALER'S ROLL: %s", macaoGuest.roll, macaoDealer.roll);
    }

    public void showGuestRoll() {
        console.println("YOUR NEW ROLL: %s | YOUR TOTAL: %s", macaoGuest.roll, macaoGuest.cumulativeRoll);
    }

    public void showdealerRoll() {
        console.println("\nDEALER'S NEW ROLL: %s | DEALER'S TOTAL: %s", macaoDealer.roll, macaoDealer.cumulativeRoll);
    }

    public void initialGameSetup() {
        rollDie(macaoGuest);
        rollDie(macaoDealer);
        showInitialRolls();
    }

    public boolean isGuestStillPlaying() {
        if (macaoGuest.cumulativeRoll == 9) {
            guestStillPlaying = false;
        }
        for (int i = 0; i < 1; i++) {
            if (macaoGuest.cumulativeRoll < 9 && guestStillPlaying) {
                String yesOrNo = console.getStandardInput("\nWould you like to roll again?");
                if (yesOrNo.equals("yes") || yesOrNo.equals("y")) {
                    console.println("Great, here's your die.");
                } else if(yesOrNo.equals("no") || yesOrNo.equals("n")) {
                    console.println("Bold tactic.");
                    guestStillPlaying = false;
                } else {
                    console.println("I didn't catch that.");
                    i--;
                }
            }
        }
        return guestStillPlaying;
    }

    public void youWentOver() {
        console.println("\nSorry, you went over. You lose!");
    }

    public boolean didGuestGoOver() {
        boolean guestWentOver = false;
        if (macaoGuest.cumulativeRoll > 9) {
            guestStillPlaying = false;
            return true;
        }
        return guestWentOver;
    }

    public boolean isDealerStillPlaying() {
        if (dealerStillPlaying) {
            if (macaoDealer.cumulativeRoll > 6 && macaoDealer.cumulativeRoll > macaoGuest.cumulativeRoll) {
                dealerStillPlaying = false;
            }
            if (macaoDealer.cumulativeRoll > 7) {
                dealerStillPlaying = false;
            }
        }
        return dealerStillPlaying;
    }

    public void evaluate() {
        if (macaoDealer.cumulativeRoll > 9) {
            console.println("\nThe dealer went over. You win!");
            isOver = true;
        } else if (guestStillPlaying == false && dealerStillPlaying == false) {
            isOver = true;
            if (macaoGuest.cumulativeRoll > macaoDealer.cumulativeRoll) {
                console.println("\nYour total is %s and the dealer's total is %s. You win!", macaoGuest.cumulativeRoll, macaoDealer.cumulativeRoll);
            } else if (macaoDealer.cumulativeRoll > macaoGuest.cumulativeRoll) {
                console.println("\nYour total is %s and the dealer's total is %s. Sorry, you lose!", macaoGuest.cumulativeRoll, macaoDealer.cumulativeRoll);
            } else if (macaoGuest.cumulativeRoll == macaoDealer.cumulativeRoll) {
                console.println("\nIt's a tie!");
            }
        }
    }

    public static void main(String[] args) {
        Macao macao = new Macao();
        macao.play();
    }
}
