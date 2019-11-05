package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.Utilities.Console;

import java.util.concurrent.TimeUnit;


public class TellerMenu implements Menu {


    private Console console;
    private Player player;
    private String name = "Teller Menu";
    private GameServices gameServices = new GameServices();

    public TellerMenu(Player player) {
        this.player = player;
        this.console = new Console(System.in, System.out);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() throws InterruptedException {
        console.clearScreen();

        console.println("Teller...");

        // temporary
        console.println("1. Deposit funds");
        console.println("2. Cash out");
        console.println("3. Back to lobby");
        console.println(String.format("Current balance: $%.2f\n", player.getBalance()));

        handleChoice(console.getInteger(3));
    }

    @Override
    public void handleChoice(int choice) throws InterruptedException {

        switch (choice) {
            case 1:
                depositFunds();
                displayMenu();
                break;
            case 2:
                cashOut();
                Casino.displayEnding(this.player);
                break;
            case 3:
                // let's nix this, get it to just fall through back into MM
//                MainMenu mainmenu = new MainMenu(this.player);
//                mainmenu.displayMenu();
                break;
        }
    }

    public void depositFunds() throws InterruptedException {
        double funds = console.getCurrency("[TELLER]: How much are you depositing?\n");
        if (funds == 0.0) {
            console.printWithDelays("[TELLER]: Quit wastin' my time, buddy\n", TimeUnit.MILLISECONDS, 50);
        } else if (funds > 10000.0) {
            console.printWithDelays("[TELLER]: Whoa, jeez, OK: you just knock over a bank or something?\n", TimeUnit.MILLISECONDS, 50);
            gameServices.deposit(funds, this.player);
            console.printWithDelays("[TELLER]: Good luck, fancy pants!\n", TimeUnit.MILLISECONDS, 50);
        } else if (funds <= 20.0){
            console.printWithDelays("[TELLER]: Wow, are you sure that it's safe walkin' around with all that?\n", TimeUnit.MILLISECONDS, 50);
            gameServices.deposit(funds, this.player);
            console.printWithDelays("[TELLER]: Don't spend it all in once place\n", TimeUnit.MILLISECONDS, 50);
        } else {
            console.println(String.format("Depositing $%.2f",funds));
            gameServices.deposit(funds, this.player);
            console.printWithDelays("[TELLER]: Good luck at the tables\n", TimeUnit.MILLISECONDS, 50);
        }

        console.getInput("\nPress Enter to continue\n");
    }

    public Double cashOut () {
        Double withdrawal = gameServices.withdraw(this.player);
        if (withdrawal != null) {
            this.player.setWinnings(withdrawal - this.player.getInitialBalance());
            return withdrawal;
        } else {
            return 0.0;
        }

    }

}
