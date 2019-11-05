package io.zipcoder.casino;

import io.zipcoder.casino.CardGames.GoFish;
import io.zipcoder.casino.utilities.Console;

public class App {

    private Console menu;
    private String userId = "";
    private String userPassword = "";

    public void App (){

        menu = new Console(System.in,System.out);
        menu.print("Welcome to Casino 5! \n\n");

        mainMenu();  // log in ...

    }


    private void mainMenu(){
        int userInput;
        userInput = menu.getIntegerInput("What would you like to do?\n" +
                "1.) Log In\n" +
                "2.) Create Account\n" +
                "3.) Exit");
        mainMenuActions(userInput);
    }

    private void mainMenuActions(Integer userSelection){

        switch (userSelection) {
            case 1:
                userId = menu.getStringInput("Enter your ID:");
                userPassword = menu.getStringInput("Enter your password:");

                authenticatePlayer();
                selectGame();
                break;
            case 2:
                createPlayer();
                break;

            case 3:
                menu.print("Have a great day!");
                System.exit(0);
                break;

            default:
                System.out.println("Error! Please enter another option!");
                mainMenu();
        }

    }  // menuActions

    private void authenticatePlayer(){

    }

    private void createPlayer(){

    }

    private void selectGame() {
        int userInput;
        userInput = menu.getIntegerInput("Please select game to play\n" +
                "1.) Go Fish\n" +
                "2.) Yahtzee\n" +
                "3.) BlackJack\n" +
                "4.) Craps");
    }

    private void selectGameActions(Integer gameSelected){
        switch (gameSelected){

            case 1:
                GoFish newGoFish = new GoFish();
                newGoFish.startGame();
                break;
            case 2:

                break;
            case 3:
                break;
            case 4:
                break;
            default:
                menu.print("Error! Invalid Selection!");
                selectGame();
                break;
        }
    }

} // class
