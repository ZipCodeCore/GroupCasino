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
        consolePrintDelay(1000);
        mainMenu();  // log in ...

    }


    private void mainMenu(){
        int userInput;
        userInput = this.menu.printMainMenu();
        mainMenuActions(userInput);
    }

    private void mainMenuActions(Integer userSelection){

        switch (userSelection) {
            case 1:
                // Log in
                if (authenticatePlayer()) {
                    this.menu.print("Logging in .");
                    consolePrintDelay(500);
                    this.menu.print(".");
                    consolePrintDelay(500);
                    this.menu.print(".\n\n");
                    consolePrintDelay(500);

                    selectGameToPlay();
                } else {
                    this.menu.print("We could not find this user. Please try again!\n\n");
                    consolePrintDelay(500);
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
                // Create new account
                consolePrintDelay(500);
                this.menu.println("Creating new account ...\n");
                if (authenticatePlayer()){
                    this.menu.println("This user already exists, please log in.\n");
                    consolePrintDelay(1000);
                    mainMenu();
                } else {
                    createPlayer();
                    selectGameToPlay();
                }
                break;

            case 3:
                // Exit
                this.menu.print("Have a great day!");
                System.exit(0);
                break;

            default:
                this.menu.print("Error! Please enter another option!\n\n");
                consolePrintDelay(1000);
                mainMenu();

        } // main menu actions

    }  // menuActions

    private void selectGameToPlay() {
        int userInput;
        consolePrintDelay(500);
        this.menu.println("You are now logged in - enjoy the ride!\n");
        userInput = this.menu.printSelectGame();

        selectGameToPlayActions(userInput);
    }  // select game

    private void selectGameToPlayActions(Integer gameSelected){
        consolePrintDelay(1000);
        this.menu.clearScreen();
        this.menu.printGameName(gameSelected);
        consolePrintDelay(1000);
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
                addMoneyToPlayer();
                newBlackJack.startGame();
                break;
            case 4:
                Craps newCraps = new Craps(this.newPlayer);
                addMoneyToPlayer();
                newCraps.startGame();
                break;
            case 5:
                mainMenu();
                break;
            default:
                this.menu.print("Error! Invalid Selection!\n\n");
                break;
        }

        selectGameToPlay();


    }  // game actions


    private Boolean authenticatePlayer(){
        consolePrintDelay(1000);
        this.userId = this.menu.getStringInput("Enter your ID:");
        this.userPassword = this.menu.getStringInput("Enter your password:");

        this.newPlayer = this.warehouse.getPlayer(this.userId+this.userPassword);
        return this.newPlayer != null;
    }

    private void createPlayer(){
        this.warehouse.addPlayer(this.userId,this.userPassword);
        this.newPlayer = warehouse.getPlayer(this.userId+this.userPassword);
    }

    private void consolePrintDelay (int miliSeconds){
        try {
            TimeUnit.MILLISECONDS.sleep(miliSeconds);
        } catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    private void addMoneyToPlayer (){
        double amount;
        amount = this.menu.getDoubleInput("How much money would you like to add to your account?");
        this.newPlayer.addAmount(amount);
    }

} // class
