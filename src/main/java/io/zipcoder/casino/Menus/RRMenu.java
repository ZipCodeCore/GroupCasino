package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.RR.RRGame;
import io.zipcoder.casino.Utilities.Music;
import io.zipcoder.casino.Utilities.Console;

import java.util.concurrent.TimeUnit;


public class RRMenu implements Menu {
    private boolean play;
    private Console console;
    private String name = "Russian Roulette Dice Menu";
    private RRGame rrGame;
    Music rouletteMusic = null;
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
    public void displayMenu() throws InterruptedException {
        //Starts playing music!
        try {
            Music.filePath = "src/music/(Roulette) Kirby Star Allies Music.wav";
            rouletteMusic = new Music();
            rouletteMusic.play();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        console.clearScreen();

        console.println("██████╗ ██╗   ██╗███████╗███████╗██╗ █████╗ ███╗   ██╗    ██████╗  ██████╗ ██╗   ██╗██╗     ███████╗████████╗████████╗███████╗\n" +
                "██╔══██╗██║   ██║██╔════╝██╔════╝██║██╔══██╗████╗  ██║    ██╔══██╗██╔═══██╗██║   ██║██║     ██╔════╝╚══██╔══╝╚══██╔══╝██╔════╝\n" +
                "██████╔╝██║   ██║███████╗███████╗██║███████║██╔██╗ ██║    ██████╔╝██║   ██║██║   ██║██║     █████╗     ██║      ██║   █████╗  \n" +
                "██╔══██╗██║   ██║╚════██║╚════██║██║██╔══██║██║╚██╗██║    ██╔══██╗██║   ██║██║   ██║██║     ██╔══╝     ██║      ██║   ██╔══╝  \n" +
                "██║  ██║╚██████╔╝███████║███████║██║██║  ██║██║ ╚████║    ██║  ██║╚██████╔╝╚██████╔╝███████╗███████╗   ██║      ██║   ███████╗\n" +
                "╚═╝  ╚═╝ ╚═════╝ ╚══════╝╚══════╝╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝    ╚═╝  ╚═╝ ╚═════╝  ╚═════╝ ╚══════╝╚══════╝   ╚═╝      ╚═╝   ╚══════╝\n" +
                "                                                                                                                              \n");
        console.printWithDelays("Welcome To Russian Roulette!\n\n",TimeUnit.MILLISECONDS,30);
        TimeUnit.MILLISECONDS.sleep(500);
        console.printWithDelays("- First the House will roll a die\n", TimeUnit.MILLISECONDS,30);
        TimeUnit.MILLISECONDS.sleep(500);
        console.printWithDelays("- Your bet will be your ENTIRE balance\n", TimeUnit.MILLISECONDS,30);
        TimeUnit.MILLISECONDS.sleep(500);
        console.printWithDelays("- Next, you will roll a die:\n", TimeUnit.MILLISECONDS,30);
        TimeUnit.MILLISECONDS.sleep(500);
        console.printWithDelays("- If your roll DOES NOT Match the House's roll, your balance is doubled!\n", TimeUnit.MILLISECONDS,30);
        TimeUnit.MILLISECONDS.sleep(500);
        console.printWithDelays("- If your roll matches the house......You lose all your balance.\n\nAre you willing to risk it all to win it all?\n\n", TimeUnit.MILLISECONDS,60);
        TimeUnit.MILLISECONDS.sleep(1000);

        int choice = console.getInteger("Press 1 to play or 2 to exit.\n");
        handleChoice(choice);
    }

    @Override
    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                play = true;
                rrGame.roundOfPlay();
             break;

            case 2:
                play = false;
                MainMenu mainMenu = new MainMenu(this.player);

        }
        
    }
}
