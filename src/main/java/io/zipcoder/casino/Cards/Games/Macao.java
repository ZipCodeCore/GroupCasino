package io.zipcoder.casino.Cards.Games;

import io.zipcoder.casino.Cards.Dice;
import io.zipcoder.casino.Casino.Casino;
import io.zipcoder.casino.Players.MacaoPlayer;
import io.zipcoder.casino.Players.Player;
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
        this.console = Console.getConsole();
        this.guestStillPlaying = true;
        this.computerStillPlaying = true;
    }

    public boolean getIsOver() {
        return isOver;
    }

    public void setIsOver(boolean gameOver) {
        this.isOver = gameOver;
    }

    public boolean getGuestStillPlaying() {
        return guestStillPlaying;
    }

    public void setGuestStillPlaying(boolean stillPlaying) {
        this.guestStillPlaying = stillPlaying;
    }

    public boolean getComputerStillPlaying() {
        return computerStillPlaying;
    }

    public void setComputerStillPlaying(boolean stillPlaying) {
        this.computerStillPlaying = stillPlaying;
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
        player.setRoll(dice.roll());
    }

    public void showInitialRolls() {
        console.println("YOUR ROLL: %s | COMPUTER'S ROLL: %s", macaoGuest.getRoll(), macaoComputer.getRoll());
    }

    public void showGuestRoll() {
        console.println("YOUR NEW ROLL: %s | YOUR TOTAL: %s", macaoGuest.getRoll(), macaoGuest.getCumulativeRoll());
    }

    public void showComputerRoll() {
        console.println("\nCOMPUTER'S NEW ROLL: %s | COMPUTER'S TOTAL: %s", macaoComputer.getRoll(), macaoComputer.getCumulativeRoll());
    }

    public void initialGameSetup() {
        rollDie(macaoGuest);
        rollDie(macaoComputer);
        showInitialRolls();
    }

    public boolean isGuestStillPlaying() {
        if (macaoGuest.getCumulativeRoll() == 9) {
            guestStillPlaying = false;
        }
        for (int i = 0; i < 1; i++) {
            if (macaoGuest.getCumulativeRoll() < 9 && guestStillPlaying) {
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
        if (macaoGuest.getCumulativeRoll() > 9) {
            guestStillPlaying = false;
            return true;
        }
        return guestWentOver;
    }

    public boolean isComputerStillPlaying() {
        if (computerStillPlaying) {
            if (macaoComputer.getCumulativeRoll() > 6 && macaoComputer.getCumulativeRoll() > macaoGuest.getCumulativeRoll()) {
                computerStillPlaying = false;
            }
            if (macaoComputer.getCumulativeRoll() == 9) {
                computerStillPlaying = false;
            }
        }
        return computerStillPlaying;
    }

    public void evaluate() {
        if (macaoComputer.getCumulativeRoll() > 9) {
            console.println("\nThe computer went over. You win!");
            isOver = true;
        } else if (guestStillPlaying == false && computerStillPlaying == false) {
            isOver = true;
            if (macaoGuest.getCumulativeRoll() > macaoComputer.getCumulativeRoll()) {
                console.println("\nYour total is %s and the computer's total is %s. You win!", macaoGuest.getCumulativeRoll(), macaoComputer.getCumulativeRoll());
            } else if (macaoComputer.getCumulativeRoll() > macaoGuest.getCumulativeRoll()) {
                console.println("\nYour total is %s and the computer's total is %s. Sorry, you lose!", macaoGuest.getCumulativeRoll(), macaoComputer.getCumulativeRoll());
            } else if (macaoGuest.getCumulativeRoll() == macaoComputer.getCumulativeRoll()) {
                console.println("\nIt's a tie!");
            }
        }
    }

    public static void main(String[] args) {
        Macao macao = new Macao();
        macao.playGame();
    }
}
