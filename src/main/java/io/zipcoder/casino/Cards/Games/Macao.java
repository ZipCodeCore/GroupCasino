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

    public MacaoPlayer getMacaoGuest() {
        return macaoGuest;
    }

    public MacaoPlayer getMacaoDealer() {
        return macaoDealer;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public boolean getIsOver() {
        return isOver;
    }

    public void setIsOver(boolean gameOver) {
        this.isOver = gameOver;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public boolean getGuestStillPlaying() {
        return guestStillPlaying;
    }

    public void setGuestStillPlaying(boolean stillPlaying) {
        this.guestStillPlaying = stillPlaying;
    }

    public boolean getDealerStillPlaying() {
        return dealerStillPlaying;
    }

    public void setDealerStillPlaying(boolean stillPlaying) {
        this.dealerStillPlaying = stillPlaying;
    }

    public int playGame() {
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
                showDealerRoll();
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
                console.println("Try again.");
                i--;
            }
        }
        return beginGame;
    }

    public void rollDie(MacaoPlayer player) {
        player.setRoll(dice.roll());
    }

    public void showInitialRolls() {
        console.println("YOUR ROLL: %s | DEALER'S ROLL: %s", macaoGuest.getRoll(), macaoDealer.getRoll());
    }

    public void showGuestRoll() {
        console.println("YOUR NEW ROLL: %s | YOUR TOTAL: %s", macaoGuest.getRoll(), macaoGuest.getCumulativeRoll());
    }

    public void showDealerRoll() {
        console.println("\nDEALERS'S NEW ROLL: %s | DEALERS'S TOTAL: %s", macaoDealer.getRoll(), macaoDealer.getCumulativeRoll());
    }

    public void initialGameSetup() {
        rollDie(macaoGuest);
        rollDie(macaoDealer);
        showInitialRolls();
    }

    public boolean isGuestStillPlaying() {
        if (macaoGuest.getCumulativeRoll() == 9) {
            guestStillPlaying = false;
        }
        for (int i = 0; i < 1; i++) {
            if (macaoGuest.getCumulativeRoll() < 9 && guestStillPlaying) {
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
        if (macaoGuest.getCumulativeRoll() > 9) {
            guestStillPlaying = false;
            return true;
        }
        return guestWentOver;
    }

    public boolean isDealerStillPlaying() {
        if (dealerStillPlaying) {
            if (macaoDealer.getCumulativeRoll() > 6 && macaoDealer.getCumulativeRoll() > macaoGuest.getCumulativeRoll()) {
                dealerStillPlaying = false;
            }
            if (macaoDealer.getCumulativeRoll() > 7) {
                dealerStillPlaying = false;
            }
        }
        return dealerStillPlaying;
    }

    public void evaluate() {
        if (macaoDealer.getCumulativeRoll() > 9) {
            console.println("\nThe dealer went over. You win!");
            isOver = true;
        } else if (guestStillPlaying == false && dealerStillPlaying == false) {
            isOver = true;
            if (macaoGuest.getCumulativeRoll() > macaoDealer.getCumulativeRoll()) {
                console.println("\nYour total is %s and the dealer's total is %s. You win!", macaoGuest.getCumulativeRoll(), macaoDealer.getCumulativeRoll());
            } else if (macaoDealer.getCumulativeRoll() > macaoGuest.getCumulativeRoll()) {
                console.println("\nYour total is %s and the dealer's total is %s. Sorry, you lose!", macaoGuest.getCumulativeRoll(), macaoDealer.getCumulativeRoll());
            } else if (macaoGuest.getCumulativeRoll() == macaoDealer.getCumulativeRoll()) {
                console.println("\nYou both rolled %s. It's a tie!", macaoGuest.getCumulativeRoll());
            }
        }
    }

}
