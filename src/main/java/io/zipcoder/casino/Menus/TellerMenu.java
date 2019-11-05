package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.Utilities.Console;

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
    public void displayMenu() {
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
    public void handleChoice(int choice) {

        switch (choice) {
            case 1:
                depositFunds();
                displayMenu();
                break;
            case 2:
                cashOut();
                displayMenu();
                break;
            case 3:
                // let's nix this, get it to just fall through back into MM
                MainMenu mainmenu = new MainMenu(this.player);
                mainmenu.displayMenu();
                break;
        }
    }

    public void depositFunds() {
        double funds = console.getCurrency("How much are you depositing? ");
        if (funds == 0.0) {
            console.println("Quit wastin' my time, buddy");
        } else if (funds > 10000.0) {
            console.println("Whoa, jeez, OK: you just knock over a bank or something'?");
            gameServices.deposit(funds, this.player);
            console.println("Good luck, fancy pants!");
        } else if (funds <= 20.0){
            console.println("Wow, are you sure that it's safe walkin' around with all that?");
            gameServices.deposit(funds, this.player);
            console.println("Don't spend it all in once place");
        } else {
            console.println(String.format("Depositing $%.2f",funds));
            gameServices.deposit(funds, this.player);
            console.println("Good luck at the tables");
        }

        console.getInput("Press Enter to continue");
    }

    public Double cashOut () {
        Double withdrawal = gameServices.withdraw(this.player);
        if (withdrawal != null) {
            return withdrawal;
        } else {
            return 0.0;
        }
        // cash out behaviors?
    }

}
