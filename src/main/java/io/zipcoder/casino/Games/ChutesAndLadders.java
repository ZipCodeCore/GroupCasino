package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.ChutesLaddersPiece;
import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.Arrays;
import java.util.Random;


public class ChutesAndLadders implements Game {
    Console console = new Console(System.in, System.out);
    Dice dice = new Dice();
    private ChutesLaddersPiece playerPiece = new ChutesLaddersPiece();
    private ChutesLaddersPiece aiPiece = new ChutesLaddersPiece();
    private Player currentPlayer;
    private boolean running = true;
    private boolean currentGame = true;

    public void runChutesAndLadders(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        setUpGame();
        while (running) {
            console.println("Welcome to Chutes and Ladders, %s!", currentPlayer);
            console.println("In this house, the player always goes first! Step on up!");
            String winner = startNewGame();
            if (winner.equals("Player")) {
                console.println("Congratulations! You won!");
            } else if (winner.equals("Ai")) {
                console.println("Oh, Too bad! I won! Better lucky next time!");
            }
            Integer playAgainInput = playAgain();
            playAgainOrMain(playAgainInput);
        }
    }


    public void setUpGame(){
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
        playerChutesAndLadders(playerPosition);
        return "no winner yet";
    }

    public String aiTurn(Integer aiPosition){
        console.getStringInput("Now it's my turn!");
        aiPosition = aiDiceRoll();
        if (aiPosition >= 100){
            return "Ai";
        }
        aiChutesAndLadder(aiPosition);
        return "no winner yet";
    }


    public Integer playerDiceRoll(){
        Integer roll = dice.rollDice(1);
        playerPiece.setCurrentPosition(playerPiece.getCurrentPosition() + roll);
        Integer currentPosition = playerPiece.getCurrentPosition();
        console.println("You've rolled a %d. Your current position is now %d.", roll, currentPosition);
        return currentPosition;
    }

    public Integer aiDiceRoll(){
        Integer roll = dice.rollDice(1);
        aiPiece.setCurrentPosition(aiPiece.getCurrentPosition() + roll);
        Integer currentPosition = aiPiece.getCurrentPosition();
        console.println("I've rolled a %d. My current position is now %d.", roll, currentPosition);
        return currentPosition;
    }

    public Integer chutesAndLaddersChecker(Integer position) {
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

    public Integer playerChutesAndLadders(Integer position) {
        Integer newPosition = chutesAndLaddersChecker(position);
        if (position > newPosition) {
            console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
            playerPiece.setCurrentPosition(newPosition);
            return newPosition;
        } else if (position < newPosition){
            console.println("Hooray! You've hit a ladder! You're now at %d.", newPosition);
            playerPiece.setCurrentPosition(newPosition);
            return newPosition;
        }
        return position;
    }

    public Integer aiChutesAndLadder(Integer position){
        Integer newPosition = chutesAndLaddersChecker(position);
        if (position > newPosition) {
            console.println("Uh-oh! I've hit a chute! I'm back at %d", newPosition);
            return newPosition;
        } else if (position < newPosition){
            console.println("Hooray! I've hit a ladder! I'm now at %d.", newPosition);
            return newPosition;
        }
        return position;
    }

    public Integer playAgain(){
        console.println("Would you like to play again?");
        console.println("(1) - Yes");
        console.println("(2) - No");
        Integer playerInput = console.getIntegerInput(":");
        return playerInput;
    }

    public void playAgainOrMain(Integer playAgainInput){
        switch (playAgainInput){
            case 1:
                runChutesAndLadders(currentPlayer);
                break;
            case 2:
                running = false;
                break;
        }
    }



    @Override
    public void approachTable(Player currentPLayer) {

    }

    @Override
    public void runGame(Player currentPlayer) {

    }

    @Override
    public void exitGame() {

    }
}
