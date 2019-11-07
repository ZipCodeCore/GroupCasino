package io.zipcoder.casino.Menus;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.RR.RRGame;

import io.zipcoder.casino.utilities.Console;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;



public class RRMenu implements Menu {
    private boolean play;
    private Console console;
    private String name = "Russian Roulette Dice Menu";
    private RRGame rrGame;
    private Player player;


    public RRMenu(RRGame rrGame) {

        this.console = new Console(System.in, System.out);
        this.rrGame = rrGame;
    }

    public boolean isPlay() {
        return play;
    }

    @Override
    public String getName() {
        return name;
    }


    @Override
    public void displayMenu() {

        console.clearScreen();


        console.println("██████╗ ██╗   ██╗███████╗███████╗██╗ █████╗ ███╗   ██╗    ██████╗  ██████╗ ██╗   ██╗██╗     ███████╗████████╗████████╗███████╗\n" +
                "██╔══██╗██║   ██║██╔════╝██╔════╝██║██╔══██╗████╗  ██║    ██╔══██╗██╔═══██╗██║   ██║██║     ██╔════╝╚══██╔══╝╚══██╔══╝██╔════╝\n" +
                "██████╔╝██║   ██║███████╗███████╗██║███████║██╔██╗ ██║    ██████╔╝██║   ██║██║   ██║██║     █████╗     ██║      ██║   █████╗  \n" +
                "██╔══██╗██║   ██║╚════██║╚════██║██║██╔══██║██║╚██╗██║    ██╔══██╗██║   ██║██║   ██║██║     ██╔══╝     ██║      ██║   ██╔══╝  \n" +
                "██║  ██║╚██████╔╝███████║███████║██║██║  ██║██║ ╚████║    ██║  ██║╚██████╔╝╚██████╔╝███████╗███████╗   ██║      ██║   ███████╗\n" +
                "╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚══════╝╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝    ╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚══════╝╚══════╝   ╚═╝      ╚═╝   ╚══════╝\n" +
                "                                                                                                                              \n");
        console.sleep(1000);
        console.printWithDelays("Welcome To Russian Roulette!\n\n", 20, 1000);
        console.printWithDelays("- First the House will roll a die\n", 20, 1000);
        console.printWithDelays("- Your bet will be your ENTIRE balance\n", 20, 1000);
        console.printWithDelays("- Next, you will roll a die:\n", 20, 1000);
        console.printWithDelays("- If your roll DOES NOT match the House's roll, your balance is DOUBLED!\n", 20, 1000);
        console.printWithDelays("- If your roll matches the house......You lose all your balance.\n\n", 20, 1000);
        console.printWithDelays("Are you willing to risk it all to win it all?\n\n", 20, 2000);

        console.println(DiceGame.diceToASCII());
        int choice = console.getInteger("(Press 1 to play or 2 to exit):\n\n");
        handleChoice(choice);

    }

    @Override
    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                play = true;
                console.clearScreen();
                rrGame.roundOfPlay();


             break;

            case 2:
                play = false;


        }

    }
}
