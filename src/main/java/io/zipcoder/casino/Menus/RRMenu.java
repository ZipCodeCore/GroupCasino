package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.RR.RRGame;
import io.zipcoder.casino.Utilities.Music;
import io.zipcoder.casino.Utilities.Console;


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

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {
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

        console.println("Welcome To Russian Roulette! ");
        console.println("First The House Will Roll A Die ");
        console.println("Your Bet Will Be Your Entire Balance ");
        console.println("Next You Will Roll A Die ");
        console.println("If Your Roll Does Not Match The House's Roll, Your Balance Is Doubled ");
        console.println("If Your Roll Matches The House, You Lose All Your Balance ");
        int choice = console.getInteger("Press 1 to play or 2 to exit.");
        handleChoice(console.menuChoice(2));
    }

    @Override
    public void handleChoice(int choice) {
        switch (choice) {
            case 1:
                play = true;
                rrGame.startPlay();
             break;

            case 2:
                play = false;
                MainMenu mainMenu = new MainMenu(this.player);
                mainMenu.displayMenu();
        }
        
    }
}
