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

    public void runChutesAndLadders(Player currentPlayer){
        setUpGame();
        while(running){
            console.println("Welcome to Chutes and Ladders!");
            console.println("In this house, the player always goes first! Step on up!");
            startNewGame();

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
        while (currentGame){
            Integer playerPosition = playerTurn();
            Integer aiPosition = aiTurn();
            playerTurn();
            aiTurn();
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

    public Integer chutes(Integer position) {
        Integer newPosition = 0;
        switch (position) {
            case 16:
                newPosition = 6;
                console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
                return newPosition;
            break;
            case 47:
                newPosition = 26;
                console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
                return newPosition;
            break;
            case 49:
                newPosition = 11;
                console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
                return newPosition;
            break;
            case 56:
                newPosition = 53;
                console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
                return newPosition;
            break;
            case 62:
                newPosition = 19;
                console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
                return newPosition;
            break;
            case 64:
                newPosition = 60;
                console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
                return newPosition;
            break;
            case 87:
                newPosition = 24;
                console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
                return newPosition;
            break;
            case 93:
                newPosition = 73;
                console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
                return newPosition;
            break;
            case 95:
                newPosition = 75;
                console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
                return newPosition;
            break;
            case 98:
                newPosition = 78;
                console.println("Uh-oh! You've hit a chute! You're back at %d", newPosition);
                return newPosition;
            break;
            default:
                return position;
        }
    }

    public void playerLadders(Integer position){

    }

    public String checkWinner(){

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
