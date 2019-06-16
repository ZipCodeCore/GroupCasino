package io.zipcoder.casino;
import io.zipcoder.casino.games.*;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.CrapsPlayer;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.RoulettePlayer;
import io.zipcoder.casino.player.SlotsPlayer;
import io.zipcoder.casino.utilities.Console;


//
public class Handler {
    public Console console = new Console(System.in, System.out);
    public Player player;
    private Integer integerInput;
    private String name = "";
    private Double account = 0.0;
    private Boolean accoutIsSet = false;
    private Double tempDeposit;
    public Handler handler;



public void run() {


while (true) {
    System.out.println("WELCOME TO THE BIG TROUBLE CASINO \n PICK FROM ONE OF OUR GAMES \n \n 0 blackjack -- 1 go fish -- 2 roulette -- 3 craps -- 4 slots \n");
    getGameInput();



    switch (integerInput) {
        case 0:
            Blackjack blackjack = new Blackjack();
            break;
        case 1:
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
            Craps craps = new Craps(crapsPlayer, console /*,handler*/);
            craps.runGame();
            break;
        case 4:
            SlotsPlayer slotsPlayer = new SlotsPlayer(player);
            Slots slots = new Slots(slotsPlayer, console);
            slots.runGame();
            break;
        default:

            System.out.println("you blew it");
        }
    }
}

    public Player createPlayer (String name, Double account) {
        return player = new Player(name, account);
    }

    public void getNameInput() {
        this.name = console.getStringInput("Enter Name");
    }

    public void getAccountBalanceInput() {
       this.tempDeposit = console.getDoubleInput("How much do you want to deposit in your account?");
    }

    public Boolean testAccountInput (Double tempDeposit) {
        if (tempDeposit > 0 && tempDeposit < Double.MAX_VALUE) {
            return true;
        } else
            return false;
    }

    public void getGameInput() {
        this.integerInput = console.getIntegerInput("What game would you like to play?");
    }

    public void setUpPlayer(){
        getNameInput();
        getAccountBalanceInput();
        createPlayer(name, tempDeposit);
    }
}
//