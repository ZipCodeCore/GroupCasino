package io.zipcoder.casino.RR;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Menus.RRMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameServices;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Utility.Music;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

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
    Music rouletteMusic = null;
    Music bang = null;
    Music elFin = null;


    public RRGame(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    @Override

    public void startPlay()  {
        try {
            io.zipcoder.casino.Utility.Music.filePath = "src/music/(Roulette) Kirby Star Allies Music.wav";
            rouletteMusic = new io.zipcoder.casino.Utility.Music();
            rouletteMusic.play();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

        // store menu
        RRMenu rrMenu = new RRMenu(this);
        rrMenu.displayMenu();
    }

    @Override
    public void endChoice() {
        //implements menu whether you want to quit or go again

        String endChoiceInput = console.getInput(("\n[DEALER]: You have finished this Russian Roulette Game.\n[DEALER]: Would you like to play again? (Y/N)\n"));

        if (endChoiceInput.toUpperCase().equals("N")) {
            try {
                rouletteMusic.stop();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
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
            try {
                rouletteMusic.stop();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            gameServices.wager(player.getBalance(),player);
            console.println("\nYou Lost!!!");
            console.sleep(2000);
            console.clearScreen();
            console.printWithDelays("[DEALER]: Don't you know how Russian Roulette works?\n\n",80);
            console.sleep(1500);

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
            try {
                io.zipcoder.casino.Utility.Music.filePath = "src/music/(bang) sound effect.wav";
                bang = new io.zipcoder.casino.Utility.Music();
                bang.play();
            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
            console.sleep(1000);
            try {
                bang.stop();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            console.sleep(1000);

            console.clearScreen();
            try {
                io.zipcoder.casino.Utility.Music.filePath = "src/music/(el fin) Super Mario Bros. - Game Over Sound Effect.wav";
                elFin = new io.zipcoder.casino.Utility.Music();
                elFin.play();
            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
            console.printWithDelays("   ,ggggggg,             ,gggggggggggggg                  \n" +
                    " ,dP\"\"\"\"\"\"Y8b ,dPYb,    dP\"\"\"\"\"\"88\"\"\"\"\"\"                  \n" +
                    " d8'    a  Y8 IP'`Yb    Yb,_    88                        \n" +
                    " 88     \"Y8P' I8  8I     `\"\"    88      gg                \n" +
                    " `8baaaa      I8  8'         ggg88gggg  \"\"                \n" +
                    ",d8P\"\"\"\"      I8 dP             88   8  gg    ,ggg,,ggg,  \n" +
                    "d8\"           I8dP              88      88   ,8\" \"8P\" \"8, \n" +
                    "Y8,           I8P         gg,   88      88   I8   8I   8I \n" +
                    "`Yba,,_____, ,d8b,_        \"Yb,,8P    _,88,_,dP   8I   Yb,\n" +
                    "  `\"Y8888888 8P'\"Y88         \"Y8P'    8P\"\"Y88P'   8I   `Y8\n\n\n\n",3);
            console.sleep(3000);
            try {
                elFin.stop();
            } catch (UnsupportedAudioFileException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (LineUnavailableException e) {
                e.printStackTrace();
            }
            System.exit(0);

        }
        else {
            gameServices.payOut(this.player.getBalance(), this.player);
            console.println(String.format("\n\nYou Won!!! Your Balance Is Now $%.2f\n",player.getBalance()));
            console.sleep(1000);
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