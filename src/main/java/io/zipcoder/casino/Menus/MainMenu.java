package io.zipcoder.casino.Menus;


import io.zipcoder.casino.Interfaces.Menu;

import io.zipcoder.casino.Utility.Music;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

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
        choiceMap.put(++count, new NullMenu(this.player));
    }

    public static void main(String[] args) throws InterruptedException {
        Player player = new Player("Herb", "Tarlek", 45, 0.00);
        MainMenu mainMenu = new MainMenu(player);
        mainMenu.displayMenu();
    }

    @Override
    public void displayMenu() throws InterruptedException {
        console.clearScreen();
        console.println("      .======================================.\n" +
                "      | ___ ___ ___               _   _   _  |\n" +
                "      | \\_/ \\_/ \\_/ C|||C|||C||| |-| |-| |-| |\n" +
                "      | _|_ _|_ _|_  ||| ||| ||| |_| |_| |_| |\n" +
                "      '===================================== ,sSSSs\n" +
                "                 MILL'S WATERING HOLE       SSSS \"(\n" +
                "           .:.                              SSS@ =/  \\~/\n" +
                "          C|||'                             SSSS_(_  _Y_\n" +
                "        ___|||______________________________SS/  ) ) /.-\n" +
                "       [____________________________________] \\   /\\//\n" +
                "        |   ____    ____    ____    ____   | \\|==(\\_/\n" +
                "        |  (____)  (____)  (____)  (____)  | (/   ;\n" +
                "        |  |    |  |    |  |    |  |    |  | |____|\n" +
                "        |  |    |  |    |  |    |  |    |  |  \\  |\\\n" +
                "        |  |    |  |    |  |    |  |    |  |   ) ) )\n" +
                "        |  |____|  |____|  |____|  |____|  |  (  |/\n" +
                "        |  I====I  I====I  I====I  I====I  |  /\\ |\n" +
                "           |    |  |    |  |    |  |    |  | /.(=\\\n" +
                "                                               Y\\_\\" + "\n" + "\n");
        try {
            Music.filePath = "src/music/(Menu) All of Me Instrumental.wav";
            mainMusic = new Music();
            mainMusic.play();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

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
    public void handleChoice(int choice) throws InterruptedException {
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
        displayMenu();
    }
}

