package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Craps.CrapsGame;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Utilities.Music;
import io.zipcoder.casino.Utilities.Console;

public class CrapsMenu implements Menu {

    private Console console;
    private String name = "Craps Menu";
    Music crapsMusic = null;

    public CrapsMenu(CrapsGame crapsGame) {
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
            Music.filePath = "src/music/(Craps) Amor maior - Higher Love.wav";
            crapsMusic = new Music();
            crapsMusic.play();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        console.clearScreen();

        console.println("Craaaaaps");
    }

    @Override
    public void handleChoice(int choice) {

    }



}
