package io.zipcoder.casino.Menus;


import io.zipcoder.casino.GameObject;
import io.zipcoder.casino.Interfaces.Menu;

import io.zipcoder.casino.Music;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.HashMap;


public class MainMenu implements Menu {


    private HashMap<Integer, Menu> choiceMap;
    private Player player;
    private Console console;
    private String name = "Main Menu";

    Music mainMusic = null;

    public MainMenu(Player player) {
        this.player = player;
        this.console = new Console(System.in, System.out);

        choiceMap = new HashMap<Integer, Menu>();
        int count = 0;
        choiceMap.put(++count, new GameMenu(this.player));
        choiceMap.put(++count, new TellerMenu(this.player));
        choiceMap.put(++count, new NullMenu());
    }

//    public static void main(String[] args) {
//        Player player = new Player("Herb", "Tarlek", 45, 0.00);
//        MainMenu mainmenu = new MainMenu(player);
//        mainmenu.displayMenu();
//    }

    @Override
    public void displayMenu() {
        try {
            Music.filePath = "src/music/(Menu) All of Me Instrumental.wav";
            mainMusic = new Music();
            mainMusic.play();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

        // temporary
        for (int gameNum : choiceMap.keySet()) {
            console.println(String.format("%d: %s", gameNum, (choiceMap.get(gameNum)).getName()));
        }

        handleChoice(console.menuChoice(this.choiceMap.size()));


    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void handleChoice(int choice) {
        try {
            mainMusic.stop();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        choiceMap.get(choice).displayMenu();

    }
}

