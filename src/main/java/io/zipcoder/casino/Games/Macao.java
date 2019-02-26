package io.zipcoder.casino.Games;

import io.zipcoder.casino.Cards.Dice;
import io.zipcoder.casino.Casino.Casino;
import io.zipcoder.casino.Casino.Greeter;
import io.zipcoder.casino.Players.MacaoPlayer;
import io.zipcoder.casino.utilities.Console;

public class Macao implements Game {

    private MacaoPlayer user;
    private MacaoPlayer dealer;
    private boolean isOver;
    private Dice dice;
    private Console console;
    private boolean guestStillPlaying;
    private boolean dealerStillPlaying;


    public Macao() {
        this.user = new MacaoPlayer(Casino.getProfile());
        this.dealer = new MacaoPlayer();
        this.isOver = false;
        this.dice = new Dice();
        this.console = Console.getConsole();
        this.guestStillPlaying = true;
        this.dealerStillPlaying = true;
    }

    public Macao(Console console) {
        this.user = new MacaoPlayer(Casino.getProfile());
        this.dealer = new MacaoPlayer();
        this.isOver = false;
        this.dice = new Dice();
        this.console = console;
        this.guestStillPlaying = true;
        this.dealerStillPlaying = true;
    }

    public MacaoPlayer getUser() {
        return user;
    }

    public MacaoPlayer getDealer() {
        return dealer;
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

    public void play() {
        console.println(Greeter.getMacaoName());
        printGameInstructions();
        if (beginGame()) {
            initialGameSetup();
        }
        while (!isOver) {
            if (isGuestStillPlaying()) {
                rollDie(user);
                showGuestRoll();
            }
            if (didGuestGoOver()) {
                youWentOver();
                break;
            }
            if (isDealerStillPlaying()) {
                rollDie(dealer);
                showDealerRoll();
            }
            evaluate();
        }
        user.getProfile().setBalance(user.getProfile().getBalance() - 5);
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
                console.print("Hm, I expected something different. ");
                i--;
            }
        }
        return beginGame;
    }

    public void rollDie(MacaoPlayer player) {
        player.setRoll(dice.roll());
    }

    public void showInitialRolls() {
        console.println("YOUR ROLL     DEALER'S ROLL\n%s", Dice.getDiceStringWithSpace(user.getRoll(), dealer.getRoll()));
    }

    public void showGuestRoll() {
        console.println("YOUR NEW ROLL\n%sYOUR TOTAL IS NOW... %s\nHERE'S WHAT YOU ROLLED SO FAR\n%s", Dice.getDiceStringWithSpace(user.getRoll()), user.getCumulativeRoll(), Dice.getDiceString(user.getDiceRolls()));
    }

    public void showDealerRoll() {
        console.println("DEALERS'S NEW ROLL\n%sTHE DEALERS'S TOTAL IS NOW... %s\nHERE'S WHAT THE DEALER ROLLED SO FAR\n%s", Dice.getDiceString(dealer.getRoll()), dealer.getCumulativeRoll(), Dice.getDiceString(dealer.getDiceRolls()));
    }

    public void initialGameSetup() {
        rollDie(user);
        rollDie(dealer);
        showInitialRolls();
    }

    public boolean isGuestStillPlaying() {
        if (user.getCumulativeRoll() == 9) {
            guestStillPlaying = false;
        }
        for (int i = 0; i < 1; i++) {
            if (user.getCumulativeRoll() < 9 && guestStillPlaying) {
                String yesOrNo = console.getStandardInput("Would you like to roll again?");
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
        console.println("Oh no! Looks like you went over! You lose.");
    }

    public boolean didGuestGoOver() {
        boolean guestWentOver = false;
        if (user.getCumulativeRoll() > 9) {
            guestStillPlaying = false;
            return true;
        }
        return guestWentOver;
    }

    public boolean isDealerStillPlaying() {
        if (dealerStillPlaying) {
            if (dealer.getCumulativeRoll() > 6 && dealer.getCumulativeRoll() > user.getCumulativeRoll()) {
                dealerStillPlaying = false;
            }
            if (dealer.getCumulativeRoll() > 7) {
                dealerStillPlaying = false;
            }
        }
        return dealerStillPlaying;
    }

    public void evaluate() {
        if (dealer.getCumulativeRoll() > 9) {
            console.println("Lucky you! The dealer went over. YOU WIN!");
            isOver = true;
        } else if (guestStillPlaying == false && dealerStillPlaying == false) {
            isOver = true;
            if (user.getCumulativeRoll() > dealer.getCumulativeRoll()) {
                console.println("Your total is %s and the dealer's total is %s. You're our winner!", user.getCumulativeRoll(), dealer.getCumulativeRoll());
            } else if (dealer.getCumulativeRoll() > user.getCumulativeRoll()) {
                console.println("Your total is %s and the dealer's total is %s. Better luck next time.", user.getCumulativeRoll(), dealer.getCumulativeRoll());
            } else if (user.getCumulativeRoll() == dealer.getCumulativeRoll()) {
                console.println("You both rolled %s. It's a tie!", user.getCumulativeRoll());
            }
        }
    }


}
