package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Utilities.Music;
import io.zipcoder.casino.Utilities.Console;


public class RRMenu implements Menu {

    private Console console;
    private String name = "Russian Roulette Dice Menu";
    Music rouletteMusic = null;

    public RRMenu() {
        this.console = new Console (System.in, System.out);
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

        console.printWithDelays("Da");
    }

    @Override
    public void handleChoice(int choice) {

    }
}
