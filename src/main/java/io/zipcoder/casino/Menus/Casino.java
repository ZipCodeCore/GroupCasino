package io.zipcoder.casino.Menus;


import io.zipcoder.casino.Player;
import io.zipcoder.casino.Utilities.Console;
import io.zipcoder.casino.Utilities.Music;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import static io.zipcoder.casino.Utilities.Console.printWithDelays;

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


    public static void prologue () throws InterruptedException {
        printWithDelays("\nYou had a really long day at work and decide to take the edge off by visiting the local casino.\n",TimeUnit.MILLISECONDS, 50);
        TimeUnit.SECONDS.sleep(1);
        printWithDelays("\"Maybe if I win some big bucks I'll get out of this boring job of mine,\" you think to yourself. \n", TimeUnit.MILLISECONDS, 50);
        TimeUnit.SECONDS.sleep(1);
        printWithDelays("The same thought always crosses your mind when passing by the big neon sign embroidered with flashing poker chips.\n", TimeUnit.MILLISECONDS, 50);
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


    public static Player newPlayerDialogue() throws InterruptedException {
        printWithDelays("\n" + "\n((You walk up to the entrance and get greeted by a tall, stocky man with a handlebar mustache))\n", TimeUnit.MILLISECONDS, 50);
        String firstName = console.getInput("\n[TELLER]: What's your first name?\n");
        String lastName = console.getInput("\n[TELLER]: What's your last name? \n");
        int age = console.getInteger("\n[TELLER]: How old are you? \n");
        return new Player(firstName, lastName, age, 0.0);
    }


    public static void displayEnding() throws InterruptedException {
        Music losingHorn = null;
        Music tadaMusic = null;
        //There's a "happy" and "sad" ending that's pertinent on if you won or lost money, even if it's just a $1!
        //Play again option that restarts the game?

        //Sad ending:

        /*try {
            console.println("    _____\n" +
                    "   /.---.\\\n" +
                    "   |`````|\n" +
                    "   \\     /\n" +
                    "    `-.-'           ____\n" +
                    "      |    /\\     .'   /\\\n" +
                    "    __|__  |K----;    |  |\n" +
                    "   `-----` \\/     '.___\\/");
            Music.filePath = "src/music/(Sad ending) The Price is Right Losing Horn.wav";
            tadaMusic = new Music();
            tadaMusic.play();
            TimeUnit.SECONDS.sleep(5);
            tadaMusic.stop();
            console.printWithDelays("\nDisgruntled and your spirits broken, you hobble home with (insert their initial balance - current balance) less in your pocket.\n" +
                    "Guess tonight just wasn't the night.\n",TimeUnit.MILLISECONDS, 50);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }*/


        //Happy ending:
        try {
            console.println("   ||====================================================================||\n" +
                    "   ||//$\\\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\//$\\\\||\n" +
                    "   ||(100)==================| FEDERAL RESERVE NOTE |================(100)||\n" +
                    "   ||\\\\$//        ~         '------========--------'                \\\\$//||\n" +
                    "   ||<< /        /$\\              // ____ \\\\                         \\ >>||\n" +
                    "   ||>>|  12    //L\\\\            // ///..) \\\\         L38036133B   12 |<<||\n" +
                    "   ||<<|        \\\\ //           || <||  >\\  ||                        |>>||\n" +
                    "   ||>>|         \\$/            ||  $$ --/  ||        One Hundred     |<<||\n" +
                    "||====================================================================||>||\n" +
                    "||//$\\\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\//$\\\\||<||\n" +
                    "||(100)==================| FEDERAL RESERVE NOTE |================(100)||>||\n" +
                    "||\\\\$//        ~         '------========--------'                \\\\$//||\\||\n" +
                    "||<< /        /$\\              // ____ \\\\                         \\ >>||)||\n" +
                    "||>>|  12    //L\\\\            // ///..) \\\\         L38036133B   12 |<<||/||\n" +
                    "||<<|        \\\\ //           || <||  >\\  ||                        |>>||=||\n" +
                    "||>>|         \\$/            ||  $$ --/  ||        One Hundred     |<<||\n" +
                    "||<<|      L38036133B        *\\\\  |\\_/  //* series                 |>>||\n" +
                    "||>>|  12                     *\\\\/___\\_//*   1989                  |<<||\n" +
                    "||<<\\      Treasurer     ______/Franklin\\________     Secretary 12 />>||\n" +
                    "||//$\\                 ~|UNITED STATES OF AMERICA|~               /$\\\\||\n" +
                    "||(100)===================  ONE HUNDRED DOLLARS =================(100)||\n" +
                    "||\\\\$//\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\\\$//||\n" +
                    "||====================================================================||\n");
            Music.filePath = "src/music/(Happy ending) Windows 3.1 - Tada.wav";
            tadaMusic = new Music();
            tadaMusic.play();
            TimeUnit.SECONDS.sleep(2);
            tadaMusic.stop();
            console.printWithDelays("\nScore! You ended up bagging (insert their initial balance - current balance).\n" +
                    "You head home with some pep in your step and even treat yourself to a scrumptious meal.\n",TimeUnit.MILLISECONDS, 50);
        } catch (Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }
}
