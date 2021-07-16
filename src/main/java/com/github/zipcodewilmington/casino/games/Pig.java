package com.github.zipcodewilmington.casino.games;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;

import static com.github.zipcodewilmington.casino.PigMenus.*;

public class Pig implements GameInterface {

    Casino casino;

    public static void main(String[] args) {

        Pig pig = new Pig();
        pig.run();
    }

    private int currentTurn;
    private int dieValue;
    private int turnScore;
    public int pOneTotal;
    public int pTwoTotal;
    private String rollAnswer;
    public Scanner input = new Scanner(System.in);
    // ThreadLocalRandom current = ThreadLocalRandom.current();

    public Pig() {
    }

    public void welcomeToPig() throws InterruptedException {
        welcomeScreen();
        Scanner input = new Scanner(System.in);
        String areYouGonnaPlay = input.next();
        if (areYouGonnaPlay.equals("q")) {
            casino.getGameSelectionInput();
        } else if (areYouGonnaPlay.equals("y")) {
            secondPlayerLoginOrCreate();
        }
    }

    public void secondPlayerLoginOrCreate() throws InterruptedException {
        secondPlayerMenu();
        String loginOrCreate = input.next();
        if (loginOrCreate.equals("l")) {
            playerTwoLogin();
        } else if (loginOrCreate.equals("c")) {
            playerTwoCreate();
            } else if (loginOrCreate.equals("q")) {
            casino.getGameSelectionInput();
            }
        }


    public void theRules() throws InterruptedException {
        pigRules();
        input.nextLine();
        String start = input.next();
        if (start.equals("s")) {
            itsPlayerOnesTurn();
            Thread.sleep(2000);
            new Pig();
        } else if (start.equals("q")) {
            casino.getGameSelectionInput();
        }
    }

    public String currentStateOfTheGame() {
        currentStateScreen();
        return "|*****                    Player 1 has " + pOneTotal + " points.                  *****|\n" +
                "|*****                    Player 2 has " + pTwoTotal + " points.                  *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n";
    }

    public int playerTurn() throws InterruptedException {
        System.out.println( "" +
                "|**********************************************************************|\n" +
                "|*****     Please enter 'r' to roll, 'h' to hold, or q to quit    *****|\n" +
                "|**********************************************************************|\n");
        rollAnswer = input.next();
        if (rollAnswer.equals("r")) {
            Random generator = new Random();
            dieValue = generator.nextInt(6) + 1;
            turnScore += dieValue;
            // dieValue = ThreadLocalRandom.current().nextInt(1, 7);
            if (dieValue == 1) {
                currentTurn++;
                turnScore = 0;
                youRolledAOne();
                Thread.sleep(2000);
                switchingPlayers();
            } else {
                whatDidYouRoll();
                System.out.println(PURPLE + "" +

                        "|*****                    Player earned " + turnScore + " points                  *****|\n" +
                        "|**********************************************************************|\n" +
                        "|**********************************************************************|\n");
                Thread.sleep(2000);
                playerTurn();
            }
        } else if (rollAnswer.equals("h")) {
            currentTurn++;
            switchingPlayers();
        } else if (rollAnswer.equals("q")){
            casino.getGameSelectionInput();
        }
        return turnScore;
    }

    public void whatDidYouRoll() {
        if (dieValue == 2) {
            youRolledATwo();
        } else if (dieValue == 3) {
            youRolledAThree();
        } else if (dieValue == 4) {
            youRolledAFour();
        } else if (dieValue == 5) {
            youRolledAFive();
        } else if (dieValue == 6) {
            youRolledASix();
        }

    }

    public void switchingPlayers() throws InterruptedException {
        if (currentTurn % 2 == 0) {
            pOneTotal += turnScore;
        } else {
            pTwoTotal += turnScore;
        }
        getWinner();
        if (getWinner() == false) {
            turnScore = 0;
            whosTurnIsIt();
            System.out.println(currentStateOfTheGame());
            Thread.sleep(2000);
            playerTurn();
        }
    }

    public void whosTurnIsIt() throws InterruptedException {
        if (currentTurn % 2 == 0) {
            itsPlayerTwosTurn();
            Thread.sleep(2000);
        } else {
            itsPlayerOnesTurn();
            Thread.sleep(2000);
        }
    }

    public boolean getWinner() throws InterruptedException {
        if (pOneTotal >= 10) {
            player1Wins();
            return true;
        } else if (pTwoTotal >= 10) {
            player2Wins();
            return true;
        }
        return false;
    }

    public void player1Wins() throws InterruptedException {
        Thread.sleep(2000);
        playerOneWon();
        System.out.println("|*****                    Player 1 has " + pOneTotal + " points.                 *****|\n" +
                "|*****                    Player 2 has " + pTwoTotal + " points.                  *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n");
        Thread.sleep(2000);
        doYouWantToPlayAgain();
    }

    public void player2Wins() throws InterruptedException {
        Thread.sleep(2000);
        playerTwoWon();
        System.out.println("|*****                    Player 1 has " + pOneTotal + " points.                  *****|\n" +
                "|*****                    Player 2 has " + pTwoTotal + " points.                 *****|\n" +
                "|**********************************************************************|\n" +
                "|**********************************************************************|\n");
        Thread.sleep(2000);
        doYouWantToPlayAgain();

    }

    public void doYouWantToPlayAgain() throws InterruptedException {
        System.out.println("Do you want to play again?\n" + "Enter 'y' to start again\n" + "Enter 'q' to quit to the main menu\n");
        String playAgain = input.next();
        if (playAgain.equals("y")) {
            pOneTotal = 0;
            pTwoTotal = 0;
            currentTurn = 0;
            itsPlayerOnesTurn();
            Thread.sleep(2000);
            playerTurn();
        } else if (playAgain.equals("q")) {
            casino.getGameSelectionInput();
        }
    }




    public void run() {
        try {
            welcomeToPig();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentTurn = 1;
        pOneTotal = 0;
        pTwoTotal = 0;

        while (true) {
            try {
                if (!(getWinner() == false)) break;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                playerTurn();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public String playerTwoLogin() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter Player 2's name: ");
        String playerTwosName = input.next();
        System.out.println("Please enter " + playerTwosName + " password: ");
        String playerTwosPassword = input.next();
        System.out.println("Enjoy the game " + playerTwosName);
        Thread.sleep(2000);
        theRules();
        return "Here come the rules!";
    }

    public String playerTwoCreate() throws InterruptedException {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        String playerTwosName = input.next();
        System.out.println(playerTwosName + " please enter your desired password: ");
        String playerTwosPassword = input.next();
        System.out.println("Thank you for creating an account & enjoy your game!");
        Thread.sleep(2000);
        theRules();
        return "Here come the rules!";
    }
    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }
}













