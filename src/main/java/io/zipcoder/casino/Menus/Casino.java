package io.zipcoder.casino.Menus;


import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;
import io.zipcoder.casino.Utilities.Music;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Casino {



    private static Console console = new Console(System.in, System.out);


    public static void main(String[] args) throws InterruptedException {

        //Starts playing music!
        Music introMusic = null;
        try {
            Music.filePath = "src/music/(Intro) City sound effect 1 - downtown.wav";
            introMusic = new Music();
            introMusic.play();
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }

        // write your tests before you start fucking with this
        Casino.prologue();
        Player player = Casino.newPlayerDialogue();

        MainMenu mainMenu = new MainMenu(player);

        //stops the sound effects
        try {
            introMusic.stop();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        mainMenu.displayMenu();
        Casino.displayEnding();
    }

    public static void printWithDelays(String data, TimeUnit unit, long delay)
            throws InterruptedException {
        for (char ch : data.toCharArray()) {
            System.out.print(ch);
            unit.sleep(delay);
        }
    }

    public static void prologue () throws InterruptedException {
        printWithDelays("\nYou had a really long day at work and decide to take the edge off by visiting the local casino.\n",TimeUnit.MILLISECONDS, 50);
        TimeUnit.SECONDS.sleep(1);
        printWithDelays("\"Maybe if I win some big bucks I'll get out of this boring job of mine,\" You think to yourself. \n", TimeUnit.MILLISECONDS, 50);
        TimeUnit.SECONDS.sleep(1);
        printWithDelays("The same thought always crosses your mind when passing by the big flashy sign embroidered with flashing poker chips.\n", TimeUnit.MILLISECONDS, 50);
        TimeUnit.SECONDS.sleep(1);
        printWithDelays("But tonight is a little different... \n" + "\n" + "\n", TimeUnit.MILLISECONDS, 50);
        TimeUnit.SECONDS.sleep(1);
        printWithDelays("Tonight you're feeling lucky. \uD83C\uDF40" + "\n" + "\n" + "\n" + "\n", TimeUnit.MILLISECONDS, 50);

        TimeUnit.SECONDS.sleep(2);
        printWithDelays("------------------------------------------------------------------------------------------------------------------------------\n",TimeUnit.MILLISECONDS, 10);
        printWithDelays("       ,----,.                                                                                                              \n" +
                "     ,'   ,' |                                                                                          ,--.     ,----..    \n" +
                "   ,'   .'   |              ,----,             ,----..      ,---,          .--.--.       ,---,        ,--.'|    /   /   \\   \n" +
                " ,----.'    .'            .'   .' \\           /   /   \\    '  .' \\        /  /    '.  ,`--.' |    ,--,:  : |   /   .     :  \n" +
                " |    |   .'            ,----,'    |         |   :     :  /  ;    '.     |  :  /`. /  |   :  : ,`--.'`|  ' :  .   /   ;.  \\ \n" +
                " :    :  |--,           |    :  .  ;         .   |  ;. / :  :       \\    ;  |  |--`   :   |  ' |   :  :  | | .   ;   /  ` ; \n" +
                " :    |  ;.' \\          ;    |.'  /          .   ; /--`  :  |   /\\   \\   |  :  ;_     |   :  | :   |   \\ | : ;   |  ; \\ ; | \n" +
                " |    |      |          `----'/  ;           ;   | ;     |  :  ' ;.   :   \\  \\    `.  '   '  ; |   : '  '; | |   :  | ; | ' \n" +
                " `----'.'\\   ;            /  ;  /            |   : |     |  |  ;/  \\   \\   `----.   \\ |   |  | '   ' ;.    ; .   |  ' ' ' : \n" +
                "   __  \\  .  |           ;  /  /-,           .   | '___  '  :  | \\  \\ ,'   __ \\  \\  | '   :  ; |   | | \\   | '   ;  \\; /  | \n" +
                " /   /\\/  /  :          /  /  /.`|           '   ; : .'| |  |  '  '--'    /  /`--'  / |   |  ' '   : |  ; .'  \\   \\  ',  /  \n" +
                "/ ,,/  ',-   .  ___   ./__;      :           '   | '/  : |  :  :         '--'.     /  '   :  | |   | '`--'     ;   :    /   \n" +
                "\\ ''\\       ;  /  .\\  |   :    .'            |   :    /  |  | ,'           `--'---'   ;   |.'  '   : |          \\   \\ .'    \n" +
                " \\   \\    .'   \\  ; | ;   | .'                \\   \\ .'   `--''                        '---'    ;   |.'           `---`      \n" +
                "  `--`-,-'      `--\"  `---'                    `---`                                           '---'                     ", TimeUnit.NANOSECONDS, 100);
        printWithDelays("\n------------------------------------------------------------------------------------------------------------------------------\n",TimeUnit.MILLISECONDS, 10);
    }


    public static Player newPlayerDialogue() {



        String firstName = console.getInput("((You walk up to the entrance and get greeted by a tall, stocky man with a handlebar mustache))\n" +
                "\n[TELLER]: What's your first name?\n");
        String lastName = console.getInput("\n[TELLER]: What's your last name? \n");
        int age = console.getInteger("\n[TELLER]: How old are you? \n");
        return new Player(firstName, lastName, age, 0.0);
    }


    public static void displayEnding() {
        console.println("Lorem impsum ending...");
    }
}
