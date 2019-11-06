package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Blackjack.BlackjackGame;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Utilities.Console;

public class BlackjackMenu implements Menu {

    private Console console;
    private String name = "Blackjack Menu";
    private BlackjackGame blackjackGame;


    public BlackjackMenu(BlackjackGame blackjackGame) {
        this.console = new Console (System.in, System.out);
        this.blackjackGame = blackjackGame;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {


        console.clearScreen();
        // temporary
        console.printWithDelays(" .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------. \n" +
                "| .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |\n" +
                "| |   ______     | || |   _____      | || |      __      | || |     ______   | || |  ___  ____   | || |     _____    | || |      __      | || |     ______   | || |  ___  ____   | |\n" +
                "| |  |_   _ \\    | || |  |_   _|     | || |     /  \\     | || |   .' ___  |  | || | |_  ||_  _|  | || |    |_   _|   | || |     /  \\     | || |   .' ___  |  | || | |_  ||_  _|  | |\n" +
                "| |    | |_) |   | || |    | |       | || |    / /\\ \\    | || |  / .'   \\_|  | || |   | |_/ /    | || |      | |     | || |    / /\\ \\    | || |  / .'   \\_|  | || |   | |_/ /    | |\n" +
                "| |    |  __'.   | || |    | |   _   | || |   / ____ \\   | || |  | |         | || |   |  __'.    | || |   _  | |     | || |   / ____ \\   | || |  | |         | || |   |  __'.    | |\n" +
                "| |   _| |__) |  | || |   _| |__/ |  | || | _/ /    \\ \\_ | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | || |  | |_' |     | || | _/ /    \\ \\_ | || |  \\ `.___.'\\  | || |  _| |  \\ \\_  | |\n" +
                "| |  |_______/   | || |  |________|  | || ||____|  |____|| || |   `._____.'  | || | |____||____| | || |  `.___.'     | || ||____|  |____|| || |   `._____.'  | || | |____||____| | |\n" +
                "| |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |\n" +
                "| '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |\n" +
                " '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------' \n");
        console.printWithDelays("Choose table stakes:");
        console.printWithDelays("1. $5 min / $25 max");
        console.printWithDelays("2. $20 min / $100 max");
        console.printWithDelays("3. $50 min / $250 max");
        console.printWithDelays("4. Set custom stakes ($5 - $500)");
        console.printWithDelays("5. Stand up and go back to game list");
        handleChoice(console.menuChoice(5));
    }

    @Override
    public void handleChoice(int choice) {
        switch (choice) {
            case 1: // low stakes
                this.blackjackGame.setMinBet(5.00);
                this.blackjackGame.setMaxBet(5*this.blackjackGame.getMinBet());
                break;
            case 2: // med stakes
                this.blackjackGame.setMinBet(20.00);
                this.blackjackGame.setMaxBet(5*this.blackjackGame.getMinBet());
                break;
            case 3: // max stakes
                this.blackjackGame.setMinBet(50.00);
                this.blackjackGame.setMaxBet(5*this.blackjackGame.getMinBet());
                break;
            case 4: // custom stakes
                this.blackjackGame.setMinBet(getStakes());
                this.blackjackGame.setMaxBet(5*this.blackjackGame.getMinBet());
                break;
        }

        double minBet = this.blackjackGame.getMinBet();
        double maxBet = this.blackjackGame.getMaxBet();
        console.printWithDelays(String.format("Minimum bet is %.2f; maximum bet is %.2f", minBet, maxBet));

    }

    double getStakes() {
        double minBet = console.getCurrency("Table stakes? ");
        if (minBet >= 5.00 && minBet <= 500.00) {
            return minBet;
        } else if (minBet < 5.00) {
            console.printWithDelays("Tables have a $5.00 minimum");
        } else {
            console.printWithDelays("Tables have a $500.00 maximum");
        }
        return getStakes();
     }


}
