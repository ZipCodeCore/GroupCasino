package io.zipcoder.casino.RR;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Menus.RRMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Interfaces.Game;


public class RRGame extends DiceGame implements Game {
    public static void main(String[] args) throws InterruptedException {
        Player rrPlayer = new Player("Grace","Bunde",23,500);
        RRGame rrGame = new RRGame(rrPlayer);
        rrGame.startPlay();
    }

    private Console console = new Console(System.in, System.out);
    private String name = "Russian Dice Roulette";
    private Integer userDieNum = 0;
    private GameServices gameServices = new GameServices();
    private Player player;


    public RRGame(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    @Override
    public void startPlay() {
        // store menu
        RRMenu rrMenu = new RRMenu(this);
        rrMenu.displayMenu();
    }

    @Override
    public void endChoice() {
        //implements menu whether you want to quit or go again

        String endChoiceInput = console.getInput(("\n[DEALER]: You have finished this Russian Roulette Game.\n[DEALER]: Would you like to play again? (Y/N)\n"));

        if (endChoiceInput.toUpperCase().equals("N")) {
            console.printWithDelays("\n[DEALER]: Have a good rest of your day.\n");
            console.sleep(1200);

            //also, return to the main menu
        } else if (endChoiceInput.toUpperCase().equals("Y")) {

            console.clearScreen();

            roundOfPlay();

        } else {
            console.println("(That's not a valid selection. Please choose again.)");
            endChoice();
        }

    }
    @Override
    public void roundOfPlay() {
        Integer computerRoll=roll();
        console.println(String.format("------------------------------------------------------\n\n** The House rolled %d **\n", computerRoll));
        userRollsDice();
        //console.println("Your Current Balance Is %d", this.player.getBalance());

        console.println(String.format("\n** You rolled %d **\n\n------------------------------------------------------", userDieNum));
        if (userDieNum.equals(computerRoll)) {
            gameServices.wager(player.getBalance(),player);
            console.println("You Lost!!!");
            console.sleep(2000);
            console.clearScreen();
            console.printWithDelays("[DEALER]: Don't you know how Russian Roulette works?",100);
            console.sleep(1000);

            console.printWithDelays("                                  \n\n\n" +
                    "   )                               /=>\n" +
                    "  (  +____________________/\\/\\___ / /|\n" +
                    "   .''._____________'._____      / /|/\\\n" +
                    "  : () :              :\\ ----\\|    \\ )\n" +
                    "   '..'______________.'0|----|      \\\n" +
                    "                    0_0/____/        \\\n" +
                    "                        |----    /----\\\n" +
                    "                       || -\\\\ --|      \\\n" +
                    "                       ||   || ||\\      \\\n" +
                    "                        \\\\____// '|      \\\n" +
                    "      Bang!                     .'/       |\n" +
                    "                               .:/        |\n" +
                    "                               :/_________|", 2);
            console.sleep(1000);
            console.clearScreen();
            console.printWithDelays("   ,ggggggg,             ,gggggggggggggg                  \n" +
                    " ,dP\"\"\"\"\"\"Y8b ,dPYb,    dP\"\"\"\"\"\"88\"\"\"\"\"\"                  \n" +
                    " d8'    a  Y8 IP'`Yb    Yb,_    88                        \n" +
                    " 88     \"Y8P' I8  8I     `\"\"    88      gg                \n" +
                    " `8baaaa      I8  8'         ggg88gggg  \"\"                \n" +
                    ",d8P\"\"\"\"      I8 dP             88   8  gg    ,ggg,,ggg,  \n" +
                    "d8\"           I8dP              88      88   ,8\" \"8P\" \"8, \n" +
                    "Y8,           I8P         gg,   88      88   I8   8I   8I \n" +
                    "`Yba,,_____, ,d8b,_        \"Yb,,8P    _,88,_,dP   8I   Yb,\n" +
                    "  `\"Y8888888 8P'\"Y88         \"Y8P'    8P\"\"Y88P'   8I   `Y8\n\n\n\n",2);
            console.sleep(2000);
            System.exit(0);

        }
        else {
            gameServices.payOut(this.player.getBalance(), this.player);
            console.println(String.format("\n\nYou Won!!! Your Balance Is Now $%.2f\n",player.getBalance()));
            endChoice();
    }

    }
    public Integer userRollsDice() {
        console.getInput("\n(Press Enter to roll the dice): \n");
        userDieNum=roll();
        return userDieNum;
    }

    public int selectTargetNum () {
        return 0;
    }

    public boolean evaluateResult (int target, int roll) {
        return false;
    }


}