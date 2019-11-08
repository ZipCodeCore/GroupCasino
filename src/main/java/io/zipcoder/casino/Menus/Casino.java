package io.zipcoder.casino.Menus;


import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.Utility.Music;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Casino {

    private static Console console = new Console(System.in, System.out);


    public static void main(String[] args) {

        //Starts playing music!
        Music introMusic = null;
        try {
            Music.filePath = "src/music/(Intro) City sound effect 1 - downtown.wav";
            introMusic = new Music();
            introMusic.play();
        } catch (Exception ex) {
            console.println("Error with playing sound.");
            ex.printStackTrace();
        }

        Casino.prologue();
        Player player = Casino.newPlayerDialogue();

        MainMenu mainMenu = new MainMenu(player);

        //stops the sound effects
        try {
            introMusic.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }

        mainMenu.displayMenu();
    }


    public static void prologue() {
        Thread inputThread = new Thread(new Runnable() {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            long startTime = System.currentTimeMillis();

            @Override
            public void run() {
                while (true) {
                    try {
                        if (((System.currentTimeMillis() - startTime) < 5000 && in.ready())) {
                            in.read();
                            break;
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return;
            }
        });

        inputThread.start();

        String[] lines = new String[] {
                "\nYou had a really long day at work and decide to take the edge off by visiting the local casino.\n",
                "\"Maybe if I win some big bucks I'll get out of this boring job of mine,\" you think to yourself. \n",
                "The same thought always crosses your mind when passing by the big neon sign embroidered with flashing poker chips.\n",
                "But tonight is a little different... \n\n\n",
                "Tonight you're feeling lucky. \uD83C\uDF40\n\n\n\n",
        };

        for (String line : lines) {
            for (char letter : line.toCharArray()){
                if (inputThread.isAlive()) {
                    console.print(Character.toString(letter));
                    console.sleep(20);
                }
            }
            if (inputThread.isAlive()) {
                console.sleep(1200);
            }
        }

        console.printWithDelays("------------------------------------------------------------------------------------------------------------------------------\n",5);
        console.printWithDelays("       ,----,.                                                                                                              \n" +
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
                "  `--`-,-'      `--\"  `---'                    `---`                                           '---'                     ",1);
        console.printWithDelays("\n------------------------------------------------------------------------------------------------------------------------------\n",5);
    }


    public static Player newPlayerDialogue() {

        console.printWithDelays("\n" + "\n((You walk up to the entrance and get greeted by a tall, stocky man with a handlebar mustache))\n");

        String firstName = console.getInput("\n[TELLER]: What's your first name?\n");
        String lastName = console.getInput("\n[TELLER]: What's your last name? \n");
        int age = console.getInteger("\n[TELLER]: How old are you? \n");
        return new Player(firstName, lastName, age, 0.0);
    }


    public static void displayEnding(Player player)  {
        Music losingHorn = null;
        Music tadaMusic = null;
        Music neutral = null;

        if (player.getWinnings() < 0) {
            //Sad ending:
            try {
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
                console.sleep(3000);
                tadaMusic.stop();
                console.printWithDelays(String.format("\nDisgruntled and with your spirits broken, you hobble home with $%.2f less in your pocket.\nGuess tonight just wasn't the night.\n", Math.abs(player.getWinnings())),20,1200);
            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }


            //Happy ending:
        } else if (player.getWinnings() > 0)
            try {
                console.println("   ||====================================================================||\n" +
                        "   ||//$\\\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\//$\\\\||\n" +
                        "   ||(100)==================| FEDERAL RESERVE NOTE |================(100)||\n" +
                        "   ||\\\\$//        ~         '------========--------'                \\\\$//||\n" +
                        "   ||<< /        /$\\              // ____ \\\\                         \\ >>||\n" +
                        "   ||>>|  12    //L\\\\            // ///..) \\\\         L38036134B   12 |<<||\n" +
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
                losingHorn = new Music();
                losingHorn.play();
                console.sleep(1500);
                losingHorn.stop();
                console.printWithDelays((String.format("\nScore! You ended up bagging $%.2f in profit.\n", player.getWinnings()) +
                        "You head home with some pep in your step and even treat yourself to a scrumptious meal.\n"),20,1500);
            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();

                //Neutral ending
            }
        else {
            try {
                console.println("\n" +
                        "                   .------. \n" +
                        ".------.           |A .   |      \n" +
                        "|A_  _ |    .------; / \\  |   \"YOU WIN SOME,    \n" +
                        "|( \\/ )|-----. _   |(_,_) |     YOU LOSE SOME.\"\n" +
                        "| \\  / | /\\  |( )  |  I  A| \n" +
                        "|  \\/ A|/  \\ |_x_) |------'   \n" +
                        "`-----+'\\  / | Y  A|             -GAYLE FORMAN \n" +
                        "      |  \\/ A|-----' \n" +
                        "       `------'  " + "\n" + "\n");
                Music.filePath = "src/music/(Happy ending) Windows 3.1 - Tada.wav";
                neutral = new Music();
                neutral.play();
                console.sleep(2000);
                neutral.stop();
                console.printWithDelays("You left without winning or losing money, but hey at least you had fun!\n\n\n", 50, 3000);
            } catch (Exception ex) {
                System.out.println("Error with playing sound.");
                ex.printStackTrace();
            }
        }
        System.exit(0);
    }
}