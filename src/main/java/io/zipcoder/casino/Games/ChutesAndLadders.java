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
    ChutesLaddersPiece piece = new ChutesLaddersPiece();
    ChutesLaddersPiece playerPiece = new ChutesLaddersPiece();
    ChutesLaddersPiece aiPiece = new ChutesLaddersPiece();
    private Player currentPlayer;
    private boolean running = true;
    private boolean currentGame = true;

    public void runChutesAndLadders(Player currentPlayer) {
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

    public Integer[] createBoard(){
        Integer[] board = new Integer[101];
        for(int i = 0; i < board.length; i++){
            board[i] = i;
        }
        return board;
    }

    public String startNewGame(){
        String winner = "";
        while (currentGame) {
            Integer playerPosition = playerTurn();
            playerChutesAndLadders(playerPosition);
            Integer aiPosition = aiTurn();
            aiChutesAndLadder(aiPosition);


            if(playerPosition >= 100){
                winner = "Player";
                break;
            } else if (aiPosition >= 100){
                winner = "Ai";
                break;
            }
        }
        return winner;
    }


    public Integer playerTurn(){
        Integer roll = dice.rollDice(1);
        Integer currentPosition = playerPiece.getCurrentPosition() + roll;
        console.println("You've rolled a %d. Your current position is now %d.", roll, currentPosition);
        return currentPosition;
    }

    public Integer aiTurn(){
        Integer roll = dice.rollDice(1);
        Integer currentPosition = aiPiece.getCurrentPosition() + roll;
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
            return newPosition;
        } else if (position < newPosition){
            console.println("Hooray! You've hit a ladder! You're now at %d.", newPosition);
            return newPosition;
        }
        return position;
    }

    public Integer aiChutesAndLadder(Integer position){
        Integer newPosition = chutesAndLaddersChecker(position);
        if (position > newPosition) {
            console.println("Uh-oh! I've hit a chute! You're back at %d", newPosition);
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
