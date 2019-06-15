package io.zipcoder.casino;
import io.zipcoder.casino.games.*;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.RoulettePlayer;
import io.zipcoder.casino.utilities.Console;

//
public class Handler {
    private Console console = new Console(System.in, System.out);
    public Player player;
    private Integer integerInput;
    private String name = "";
    private Double account = 0.0;
    private Boolean hasStarted = false;


public void run() {
    if (!hasStarted) {
        getNameInput();
        getAccountBalanceInput();
        createPlayer(name, account);
    }

    hasStarted = true;

    System.out.println("0 blackjack -- 1 go fish -- 2 roulette -- 3 craps -- 4 slots ");
    getGameInput();



    switch (integerInput) {
        case 0 :
            Blackjack blackjack = new Blackjack();
            break;
        case 1 :
            GoFishPlayer goFishPlayer = new GoFishPlayer(player);
            GoFish goFish = new GoFish(goFishPlayer, console);
            goFish.runGame();
            break;
        case 2:
            RoulettePlayer roulettePlayer = new RoulettePlayer(name, account);
            Roulette roulette = new Roulette(roulettePlayer);
            roulette.play();
            break;
        case 3:
            CrapsPlayer crapsPlayer = new CrapsPlayer(player);
            Craps craps = new Craps(crapsPlayer,console);
            craps.runGame();
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
       this.account = console.getDoubleInput("How much do you want to deposit in your account?");
    }

    public void getGameInput() {
        this.integerInput = console.getIntegerInput("What game would you like to play?");
    }
}
