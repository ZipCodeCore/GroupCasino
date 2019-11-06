package io.zipcoder.casino;

import io.zipcoder.casino.CardGames.BlackJack;
import io.zipcoder.casino.CardGames.GoFish;
import io.zipcoder.casino.DiceGames.Craps;
import io.zipcoder.casino.DiceGames.Yahtzee;
import io.zipcoder.casino.Player.Player;
import io.zipcoder.casino.Player.PlayerWarehouse;
import io.zipcoder.casino.utilities.Console;

import java.util.concurrent.TimeUnit;

public class App {

    private Console menu;
    private String userId = "";
    private String userPassword = "";
    private Player newPlayer;
    private PlayerWarehouse warehouse = new PlayerWarehouse();
    private int counter = 0;

    public void App (){

        this.menu = new Console(System.in,System.out);
        this.menu.print("Welcome to Casino 5! \n\n");
        pause(1000);
        mainMenu();  // log in ...

    }


    private void mainMenu(){
        int userInput;
        userInput = this.menu.getIntegerInput("What would you like to do?\n" +
                "1.) Log In\n" +
                "2.) Create Account\n" +
                "3.) Exit");
        mainMenuActions(userInput);
    }

    private void mainMenuActions(Integer userSelection){

        switch (userSelection) {
            case 1:
                this.menu.print("Logging in .");
                pause(500);
                this.menu.print(".");
                pause(500);
                this.menu.print(".\n\n");
                //this.menu.println("Logging in ...\n");
                pause(500);
                if (authenticatePlayer()) {
                    selectGameToPlay();
                } else {
                    this.menu.print("We could not find this user. Please try again!\n\n");
                    pause(500);
                    counter++;
                    this.userId = "";
                    this.userPassword = "";
                    if ((counter > 1)) {
                        counter = 0;
                        this.menu.print("You exceeded the allowed number of tries!\n\n");
                        mainMenu();
                    } else {
                        mainMenuActions(userSelection);
                    }
                }
                break;
            case 2:
                this.menu.println("Creating new account ...\n");
                pause(500);
                if (authenticatePlayer()){
                    this.menu.println("This user already exists, please log in.\n");
                    mainMenu();
                } else {
                    createPlayer();
                    selectGameToPlay();
                }
                break;

            case 3:
                this.menu.print("Have a great day!");
                System.exit(0);
                break;

            default:
                this.menu.print("Error! Please enter another option!");
                mainMenu();

        } // main menu actions

    }  // menuActions

    private void selectGameToPlay() {
        int userInput;
        pause(500);
        menu.println("You are now logged in - enjoy the ride!\n");
        userInput = menu.getIntegerInput("Please select game to play\n" +
                "1.) Go Fish\n" +
                "2.) Yahtzee\n" +
                "3.) BlackJack\n" +
                "4.) Craps\n" +
                "5.) Go to Main Menu");

        selectGameToPlayActions(userInput);
    }  // select game

    private void selectGameToPlayActions(Integer gameSelected){
        pause(1000);
        switch (gameSelected){
            case 1:
                GoFish newGoFish = new GoFish(this.newPlayer);
                newGoFish.startGame();
                break;
            case 2:
                Yahtzee newYahtzee = new Yahtzee(this.newPlayer);
                newYahtzee.startGame();
                break;
            case 3:
                BlackJack newBlackJack = new BlackJack(this.newPlayer);
                newBlackJack.startGame();
                break;
            case 4:
                Craps newCraps = new Craps(this.newPlayer);
                newCraps.startGame();
            case 5:
                mainMenu();
                break;
            default:
                menu.print("Error! Invalid Selection!\n\n");
                break;
        }

        selectGameToPlay();


    }  // game actions


    private Boolean authenticatePlayer(){
        pause(1);
        this.userId = this.menu.getStringInput("Enter your ID:");
        this.userPassword = this.menu.getStringInput("Enter your password:");

        this.newPlayer = warehouse.getPlayer(this.userId+this.userPassword);
        return this.newPlayer != null;
    }

    private void createPlayer(){
        warehouse.addPlayer(this.userId,this.userPassword);
        this.newPlayer = warehouse.getPlayer(this.userId+this.userPassword);
    }

    private void pause (int miliSeconds){
        try {
            TimeUnit.MILLISECONDS.sleep(miliSeconds);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

} // class
