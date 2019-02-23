package io.zipcoder.casino.Cards.Games;

import io.zipcoder.casino.Cards.Dice;
import io.zipcoder.casino.Casino.Casino;
import io.zipcoder.casino.Players.MacaoPlayer;
import io.zipcoder.casino.utilities.Console;

public class Macao extends Game {

    private MacaoPlayer macaoGuest;
    private MacaoPlayer macaoComputer;
    private boolean isOver;
    private Dice dice;
    private Console console;
    private boolean guestStillPlaying;
    private boolean computerStillPlaying;


    public Macao() {
        this.macaoGuest = new MacaoPlayer(Casino.getProfile());
        this.macaoComputer = new MacaoPlayer();
        this.isOver = false;
        this.dice = new Dice();
        this.console = new Console();
        this.guestStillPlaying = true;
        this.computerStillPlaying = true;
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
            if (isComputerStillPlaying()) {
                rollDie(macaoComputer);
                showComputerRoll();
            }
            evaluate();
        }
        return -2;
    }

    public void printGameInstructions() {
        console.println("GAME: MACAO\nThe object of this game is to roll the die enough times to reach a total of 9 without going over.\nGood luck!\n");
    }

    public boolean beginGame() {
        boolean beginGame = false;
        for (int i = 0; i < 1; i++) {
            String begin = console.getStringInput("Enter 'Y' to begin:");
            if (begin.toLowerCase().equals("y")) {
                beginGame = true;
            } else {
                console.print("Try Again. ");
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
        console.println("YOUR ROLL: %s | COMPUTER'S ROLL: %s", macaoGuest.roll, macaoComputer.roll);
    }

    public void showGuestRoll() {
        console.println("YOUR NEW ROLL: %s | YOUR TOTAL: %s", macaoGuest.roll, macaoGuest.cumulativeRoll);
    }

    public void showComputerRoll() {
        console.println("\nCOMPUTER'S NEW ROLL: %s | COMPUTER'S TOTAL: %s", macaoComputer.roll, macaoComputer.cumulativeRoll);
    }

    public void initialGameSetup() {
        rollDie(macaoGuest);
        rollDie(macaoComputer);
        showInitialRolls();
    }

    public boolean isGuestStillPlaying() {
        if (macaoGuest.cumulativeRoll == 9) {
            guestStillPlaying = false;
        }
        for (int i = 0; i < 1; i++) {
            if (macaoGuest.cumulativeRoll < 9 && guestStillPlaying) {
                String yesOrNo = console.getStringInput("\nWould you like to roll again? (Y/N)");
                yesOrNo = yesOrNo.toLowerCase();
                if (!yesOrNo.equals("y") && !yesOrNo.equals("n")) {
                    console.print("Invalid response. ");
                    i--;
                } else if (yesOrNo.equals("n")) {
                    guestStillPlaying = false;
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

    public boolean isComputerStillPlaying() {
        if (computerStillPlaying) {
            if (macaoComputer.cumulativeRoll > 6 && macaoComputer.cumulativeRoll > macaoGuest.cumulativeRoll) {
                computerStillPlaying = false;
            }
            if (macaoComputer.cumulativeRoll > 7) {
                computerStillPlaying = false;
            }
        }
        return computerStillPlaying;
    }

    public void evaluate() {
        if (macaoComputer.cumulativeRoll > 9) {
            console.println("\nThe computer went over. You win!");
            isOver = true;
        } else if (guestStillPlaying == false && computerStillPlaying == false) {
            isOver = true;
            if (macaoGuest.cumulativeRoll > macaoComputer.cumulativeRoll) {
                console.println("\nYour total is %s and the computer's total is %s. You win!", macaoGuest.cumulativeRoll, macaoComputer.cumulativeRoll);
            } else if (macaoComputer.cumulativeRoll > macaoGuest.cumulativeRoll) {
                console.println("\nYour total is %s and the computer's total is %s. Sorry, you lose!", macaoGuest.cumulativeRoll, macaoComputer.cumulativeRoll);
            } else if (macaoGuest.cumulativeRoll == macaoComputer.cumulativeRoll) {
                console.println("\nIt's a tie!");
            }
        }
    }

    public static void main(String[] args) {
        Macao macao = new Macao();
        macao.play();
    }
}
