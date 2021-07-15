package com.github.zipcodewilmington.casino;


import java.util.Scanner;
import com.github.zipcodewilmington.casino.games.Pig;

import static com.github.zipcodewilmington.utils.AnsiColor.PURPLE;


public class PigMenus {
    public static final String PURPLE = "\u001B[35m";
    public Scanner input = new Scanner(System.in);


    public static void welcomeScreen() {
        System.out.println(PURPLE + "" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n" +
                "|*     ___          ___   __                           		          *|\n" +
                "|*     \\  \\        /  /  |  |                         	              *|\n" +
                "|*      \\  \\  /\\  /  /___|  | ___   ___   _  __  ___   ____           *|\n" +
                "|*       \\  \\/  \\/  /  _ \\  |/ __| / _ \\ | ' _`  _  \\ / __ \\          *|\n" +
                "|*        \\   / \\  /   __/  | (__ | (_) ||  | | | | ||   __/          *|\n" +
                "|*         \\ /   \\/ \\___||__|\\___| \\___/ |__| |_| |_| \\___|           *|\n" +
                "|*                                                                    *|\n" +
                "|*	  				   __                                             *|\n" +
                "|*					  |  |                                            *|\n" +
                "|*					  |  |_____                                       *|\n" +
                "|*					  |  __/ _ \\                                      *|\n" +
                "|*					  |  || (_) |                                     *|\n" +
                "|* 				      \\__| \\___/                                      *|\n" +
                "|*                                                                    *|\n" +
                "|*                                                                    *|\n" +
                "|*        ___                                                         *|\n" +
                "|*        ',_`''\\        .---,,,                                      *|\n" +
                "|*           \\   :-''``/`      |                                      *|\n" +
                "|*            `;'      //` \\    /                                     *|\n" +
                "|*            /    __       |   ('.                                   *|\n" +
                "|*            |_ ./O)\\      \\  `)\\                                    *|\n" +
                "|*          _/.    `            `'` |`-.                              *|\n" +
                "|*      .-=; `                     /   `-.                            *|\n" +
                "|*     /o o \\   ,_,           .        '.                             *|\n" +
                "|*     \\._._;_.-'           .            `'-.                         *|\n" +
                "|*       `'-.`             '                 `'-.                     *|\n" +
                "|*           `.         '                        `-._                 *|\n" +
                "|*             '-._. -'                              '.               *|\n" +
                "|*                \\                                    `\\             *|\n" +
                "|*                 |                                     \\            *|\n" +
                "|*                 |     |                                ;   _.      *|\n" +
                "|*                 \\    |          |                     |-.((        *|\n" +
                "|*                  ;.  \\          /    /                |-.`\\).      *|\n" +
                "|*                  | '. ;         /    |                |(_) ).      *|\n" +
                "|*                  |   \\ \\     /`    |                 ;'--'         *|\n" +
                "|*                   \\   '.\\   /`     |                /              *|\n" +
                "|*                    |   /`|  ;        \\              /              *|\n" +
                "|*                    |   | |  |-._      '.           .'              *|\n" +
                "|*                    /   | |  |__.`'—'_;'-.     .-'``                *|\n" +
                "|*                   //___/ /  |    .-'``     _.-'`                   *|\n" +
                "|*                         //__/   //___/.--''`                       *|\n" +
                "|*                                                                    *|\n" +
                "|*	       							 _                                *|\n" +
                "|*     						 	    (_)                               *|\n" +
                "|*							  __ __  _  __ _                          *|\n" +
                "|*							  | '_ \\| |/ _` |                         *|\n" +
                "|*							  | |_) | | (_| |                         *|\n" +
                "|*							  | .__/|_|\\__, |                         *|\n" +
                "|*							  | |      __/  |                         *|\n" +
                "|*							  |_|      |___/                          *|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n" +
                "|*****                  This games requires 2 players             *****|\n" +
                "|*****            Enter 'y' to login or create a 2nd player       *****|\n" +
                "|*****                Enter 'q' to quit to the main menu          *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n");
    }

    public static void welcomeMenu() {
        welcomeScreen();
        Scanner input = new Scanner(System.in);
        String areYouGonnaPlay = input.next();
        if (areYouGonnaPlay == "q") {
          //  mainMenu();
        } else if (areYouGonnaPlay == "y") {
            //secondPlayerLogin();
        }

    }


    public static void secondPlayerMenu() {
        System.out.println(PURPLE + "" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n" +
                "|*****                        Welcome player 2!                   *****|\n" +
                "|*****           If you have an account enter 'l' to log in       *****|\n" +
                "|*****         If you need an account enter 'c' to create one     *****|\n" +
                "|*****             or enter 'q' to quit to the main menu          *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n" +
                "|*                                                                    *|\n" +
                "|*                <`---'\\>______       <`---'\\>______               *|\n" +
                "|*                /. . `'        \\      /. . `'       \\             *|\n" +
                "|*               (`')  ,          @     (`')  ,         @             *|\n" +
                "|*                `-._,          /      `-._,          /              *|\n" +
                "|*                   )-)_/---(  >          )-)_/---(  >               *|\n" +
                "|*                   '''      '''          '''      '''               *|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n");
    }

    public void secondPlayerLogin() {
        secondPlayerMenu();
        input.nextLine();
        String loginOrCreate = input.next();
        if (loginOrCreate == "l") {
          //  playerTwoLogin();
        } else if (loginOrCreate == "c") {
          //  creatAcount();
        }else if (loginOrCreate == "q"){
          //  mainMenu();
        }
        pigRules();
    }

    public static void pigRules() {
        System.out.println(PURPLE + "" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n" +
                "|*  <`---'\\>______              ________             ______</'---`>  *|\n" +
                "|*   /. . `'       \\           /       /'\\         /     '`  . . \\ *|\n" +
                "|* ('')  ,          @          /   *   /   \\       @        .   ('') *|\n" +
                "|*  `-._,          /          /       /   * \\      \\        `_.-'   *|\n" +
                "|*     )-)_/---(  >          /_______/       \\      <  )---\\_(_(    *|\n" +
                "|*     '''      '''          \\ *  * \\      /       '''      '''     *|\n" +
                "|*                            \\      \\  * /                         *|\n" +
                "|*                             \\ *  * \\  /                          *|\n" +
                "|*                              \\______\\/                           *|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n" +
                "|*****                       Here are the rules:                  *****|\n" +
                "|*****     ~Players take turns rolling a die                      *****|\n" +
                "|*****     ~Each player can roll the die however many times       *****|\n" +
                "|*****       they want during their turn                          *****|\n" +
                "|*****     ~Points are banked per roll per turn to add add to     *****|\n" +
                "|*****       a total score                                        *****|\n" +
                "|*****     ~The value of the die is how many points are banked    *****|\n" +
                "|*****     ~BUT if at anytime a 1 is rolled their turn is over    *****|\n" +
                "|*****       and they lose all points banked during that turn     *****|\n" +
                "|*****     ~The first player to reach 100 wins!                   *****|\n" +
                "|*****                    Please enter 's' to start               *****|\n" +
                "|*****             or enter 'q' to quit to the main menu          *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n");
    }
    public void theRules(){
        pigRules();
        input.nextLine();
        String start = input.next();
        if (start == "s"){
            new Pig();
        }else if (start == "q"){
           // mainMenu();
        }
    }
}