package io.zipcoder.casino.Menus;

import io.zipcoder.casino.GoFish.GoFishGame;
import io.zipcoder.casino.Interfaces.Menu;
import io.zipcoder.casino.Music;
import io.zipcoder.casino.Utilities.Console;

public class GoFishMenu implements Menu {

    private Console console;
    private String name = "Go Fish Menu";
    private GoFishGame goFishGame;
    Music fishMusic = null;

    public GoFishMenu(GoFishGame goFishGame) {
        this.console = new Console (System.in, System.out);
        this.goFishGame = goFishGame;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayMenu() {
        //Starts playing music!
        try {
            Music.filePath = "src/music/(Go Fish) Underwater Theme GuitarMarimba Cover - Super Mario Bros. 1.wav";
            fishMusic = new Music();
            fishMusic.play();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
        console.clearScreen();



        console.println("Go Fiiiiiish");


    }

    @Override
    public void handleChoice(int choice) {

    }
}
