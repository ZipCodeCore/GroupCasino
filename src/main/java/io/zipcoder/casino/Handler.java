package io.zipcoder.casino;
import io.zipcoder.casino.games.*;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

public class Handler {
    private Console console = new Console(System.in, System.out);
    private Player player;
    private Integer intergerInput;
    private String name = "";
    private Double accout = 0.0;


void run() {
    getNameInput();
    getAccountBalanceInput();
    createPlayer(name, accout);




    switch (intergerInput) {
        case 0 :
            Blackjack blackjack = new Blackjack();
            break;
        case 1 :
            GoFish goFish = new GoFish();
            break;
        case 2:
            Roulette roulette = new Roulette();
            break;
        case 3:
            Craps craps = new Craps();
            break;
        case 4:
            Slots slots = new Slots();
            break;
        default:
            System.out.println("you blew it");
    }

}

    public Player createPlayer (String name, Double account) {
        return player = new Player(name, account);
    }

    public void getNameInput() {
        this.name = console.getStringInput("Enter Name");
    }

    public void getAccountBalanceInput() {
       this.accout = console.getDoubleInput("How much do you want to depoist in your account?");
    }

    public void getGameInput() {
        this.intergerInput = console.getIntegerInput("What game would you like to play?");
    }
}
