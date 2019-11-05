package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameMenu;
import io.zipcoder.casino.GamePieces.SnakesLaddersPiece;
import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.Arrays;
import java.util.Random;


public class SnakesAndLadders implements Game {
    Console console = new Console(System.in, System.out);
    Dice dice = new Dice();
    private SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
    private SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
    private Player currentPlayer;
    private boolean running = true;
    private boolean currentGame = true;

    public void runSnakesAndLadders(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        runGame(currentPlayer);
    }

    public String startNewGame(){
        Integer playerPosition = playerPiece.getCurrentPosition();
        Integer aiPosition = aiPiece.getCurrentPosition();
        while (currentGame) {
            String playerWinner = playerTurn(playerPosition);
            if(playerWinner.equals("Player")) {
                currentGame = false;
                return playerWinner;
            }
            String aiWinner = aiTurn(aiPosition);
            if (aiWinner.equals("Ai")){
                currentGame = false;
                return aiWinner;
            }

        }
        return null;
    }

    public String playerTurn(Integer playerPosition){
        console.getStringInput("Roll the dye");
        playerPosition = playerDiceRoll();
        if(playerPosition >= 100){
            return "Player";
        }
        playerSnakesAndLadders(playerPosition);
        return "no winner yet";
    }

    public String aiTurn(Integer aiPosition){
        console.getStringInput("Now it's my turn!");
        aiPosition = aiDiceRoll();
        if (aiPosition >= 100){
            return "Ai";
        }
        aiSnakesAndLadder(aiPosition);
        return "no winner yet";
    }


    public Integer playerDiceRoll(){
        Integer roll = dice.rollDice(1);
        playerPiece.setCurrentPosition(playerPiece.getCurrentPosition() + roll);
        Integer currentPosition = playerPiece.getCurrentPosition();
        diceArt(roll);
        console.println("You've rolled a %d. Your current position is now %d.", roll, currentPosition);
        return currentPosition;
    }

    public Integer aiDiceRoll(){
        Integer roll = dice.rollDice(1);
        aiPiece.setCurrentPosition(aiPiece.getCurrentPosition() + roll);
        Integer currentPosition = aiPiece.getCurrentPosition();
        diceArt(roll);
        console.println("I've rolled a %d. My current position is now %d.", roll, currentPosition);
        return currentPosition;
    }

    public Integer SnakesAndLaddersChecker(Integer position) {
        Integer newPosition = 0;
        switch (position) {
            case 1:
                newPosition = 38;
                break;
            case 4:
                newPosition = 14;
                break;
            case 9:
                newPosition = 31;
                break;
            case 16:
                newPosition = 6;
                break;
            case 21:
                newPosition = 42;
                break;
            case 28:
                newPosition = 84;
                break;
            case 36:
                newPosition = 44;
                break;
            case 51:
                newPosition = 67;
                break;
            case 71:
                newPosition = 91;
                break;
            case 47:
                newPosition = 26;
                break;
            case 49:
                newPosition = 11;
                break;
            case 56:
                newPosition = 53;
                break;
            case 62:
                newPosition = 19;
                break;
            case 64:
                newPosition = 60;
                break;
            case 80:
                newPosition = 100;
                break;
            case 87:
                newPosition = 24;
                break;
            case 93:
                newPosition = 73;
                break;
            case 95:
                newPosition = 75;
                break;
            case 98:
                newPosition = 78;
                break;
            default:
                return position;
        }
        return newPosition;
    }

    public Integer playerSnakesAndLadders(Integer position) {
        Integer newPosition = SnakesAndLaddersChecker(position);
        if (position > newPosition) {
            console.println("Uh-oh! You've hit a Snake! You're back at %d", newPosition);
            playerPiece.setCurrentPosition(newPosition);
            return newPosition;
        } else if (position < newPosition){
            console.println("Hooray! You've hit a ladder! You're now at %d.", newPosition);
            playerPiece.setCurrentPosition(newPosition);
            return newPosition;
        }
        return position;
    }

    public Integer aiSnakesAndLadder(Integer position){
        Integer newPosition = SnakesAndLaddersChecker(position);
        if (position > newPosition) {
            console.println("Uh-oh! I've hit a Snake! I'm back at %d", newPosition);
            aiPiece.setCurrentPosition(newPosition);
            return newPosition;
        } else if (position < newPosition){
            console.println("Hooray! I've hit a ladder! I'm now at %d.", newPosition);
            aiPiece.setCurrentPosition(newPosition);
            return newPosition;
        }
        return position;
    }



    public void diceArt(Integer roll){
        switch(roll){
            case 1:
                console.println("+-----+\n" +
                        "|     |\n" +
                        "|  o  |\n" +
                        "|     |\n" +
                        "+-----+");
                break;
            case 2:
                console.println("+-----+\n" +
                        "| o   |\n" +
                        "|     |\n" +
                        "|   o |\n" +
                        "+-----+");
                break;
            case 3:
                console.println("+-----+\n" +
                        "| o   |\n" +
                        "|  o  |\n" +
                        "|   o |\n" +
                        "+-----+");
                break;
            case 4:
                console.println("+-----+\n" +
                        "| o o |\n" +
                        "|     |\n" +
                        "| o o |\n" +
                        "+-----+");
                break;
            case 5:
                console.println("+-----+\n" +
                        "| o o |\n" +
                        "|  o  |\n" +
                        "| o o |\n" +
                        "+-----+");
                break;
            case 6:
                console.println("+-----+\n" +
                        "| o o |\n" +
                        "| o o |\n" +
                        "| o o |\n" +
                        "+-----+");
                break;
        }
    }
    public void showRules(){
        console.println("Snakes and Ladders finds its origins in Ancient India, where it\n" +
                "was first created under the name Moksha Patam.\n" +
                "It was used to teach children values, rewarding proper behavior with\n" +
                "a boost in point value, via climing a ladder, or punishing a player\n" +
                "in point value for bad behavior, via sliding down the back of a snake.\n\n" +
                "Commercially known in the West as Chutes and Ladders, the game has been published by Milton Bradley\n" +
                "since the 1940's, and players compete by rolling dice and\n" +
                "and racing to the value of 100 points, the final spot on the board.\n" +
                "But beware! Certain spots on the board will send you down the backs of the Snakes!\n" +
                "Likewise, certain spots on the board will push you closer to your goal.\n" +
                "Roll the dice and see who gets there first!");
    }



    @Override
    public void approachTable(Player currentPlayer) {
        console.println("You approach the Snakes and Ladders table. What would you like to do?");
        console.println("(1) - Play the game");
        console.println("(2) - Hear the rules");
        console.println("(3) - Return to the game menu");
        Integer playerInput = console.getIntegerInput(":");
        while(running) {
            switch (playerInput) {
                case 1:
                    runSnakesAndLadders(currentPlayer);
                    break;
                case 2:
                    showRules();
                    break;
                case 3:
                    GameMenu gameMenu = new GameMenu();
                    gameMenu.runGameMenu(currentPlayer);
                    running = false;
                    break;
            }
        }
    }

    @Override
    public void runGame(Player currentPlayer) {
        while (running) {
            console.println("Welcome to Snakes and Ladders, %s!", currentPlayer.getName());
            console.println("In this house, the player always goes first! Step on up!");
            String winner = startNewGame();
            if (winner.equals("Player")) {
                console.println("Congratulations! You won!");
            } else if (winner.equals("Ai")) {
                console.println("Oh, Too bad! I won! Better lucky next time!");
            }
            exitGame(currentPlayer);
        }

    }

    @Override
    public void exitGame(Player currentPlayer) {
        console.println("Would you like to play again?");
        console.println("(1) - Yes");
        console.println("(2) - No");
        Integer playerInput = console.getIntegerInput(":");
        switch (playerInput){
            case 1:
                runSnakesAndLadders(currentPlayer);
                break;
            case 2:
                running = false;
                break;
        }

    }
}
