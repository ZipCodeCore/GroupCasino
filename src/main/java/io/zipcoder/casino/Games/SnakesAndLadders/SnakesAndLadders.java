package io.zipcoder.casino.Games.SnakesAndLadders;

import io.zipcoder.casino.CasinoArt;
import io.zipcoder.casino.GamePieces.SnakesLaddersPiece;
import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.Console;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

import java.util.HashMap;


public class SnakesAndLadders implements Game {
    private Console console = new Console(System.in, System.out);
    private Dice dice = new Dice();
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private SnakesLaddersPiece playerPiece = new SnakesLaddersPiece();
    private SnakesLaddersPiece aiPiece = new SnakesLaddersPiece();
    private Player currentPlayer;
    private boolean running = true;
    private boolean currentGame = true;

    public void runSnakesAndLadders(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
        approachTable(currentPlayer);
    }

    public void setUpGame(){
        running = true;
        currentGame = true;
        playerPiece.setCurrentPosition(0);
        aiPiece.setCurrentPosition(0);
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
        console.getStringInput(SnakesAndLaddersLanguage.DICEROLL.getSnakeLanguage());
        playerPosition = playerDiceRoll();
        playerSnakesAndLadders(playerPosition);
        if(playerPosition >= 100){
            return "Player";
        }

        return "no winner yet";
    }

    public String aiTurn(Integer aiPosition){
        aiPosition = aiDiceRoll();
        aiSnakesAndLadders(aiPosition);
        if (aiPosition >= 100){
            return "Ai";
        }
        return "no winner yet";
    }


    public Integer playerDiceRoll(){
        Integer roll = dice.rollDice(1);
        playerPiece.setCurrentPosition(playerPiece.getCurrentPosition() + roll);
        Integer currentPosition = playerPiece.getCurrentPosition();
        console.println(dice.diceArt(roll));
        console.println("You've rolled a %d. Your current position is now %d.", roll, currentPosition);
        return currentPosition;
    }

    public Integer aiDiceRoll(){
        Integer roll = dice.rollDice(1);
        aiPiece.setCurrentPosition(aiPiece.getCurrentPosition() + roll);
        Integer currentPosition = aiPiece.getCurrentPosition();
        console.println(dice.diceArt(roll));
        console.println("I've rolled a %d. My current position is now %d.", roll, currentPosition);
        return currentPosition;
    }

    public Integer snakesAndLaddersCheckerViaMap(Integer position){
        Integer newPosition = 0;
        HashMap<Integer, Integer> snakesMap = new HashMap<>();
        HashMap<Integer, Integer> laddersMap = new HashMap<>();

            snakesMap.put(16,6);
            snakesMap.put(46,26);
            snakesMap.put(49,11);
            snakesMap.put(56,53);
            snakesMap.put(62,19);
            snakesMap.put(64,60);
            snakesMap.put(87,24);
            snakesMap.put(93,73);
            snakesMap.put(95,75);
            snakesMap.put(98,78);

            laddersMap.put(1,38);
            laddersMap.put(4,14);
            laddersMap.put(9,31);
            laddersMap.put(21,42);
            laddersMap.put(28,84);
            laddersMap.put(36,44);
            laddersMap.put(51,67);
            laddersMap.put(71,91);
            laddersMap.put(80,99);

            if(laddersMap.containsKey(position)){
                newPosition = laddersMap.get(position);
            } else if (snakesMap.containsKey(position)){
                newPosition = snakesMap.get(position);
            } else {
                newPosition = position;
            }
            return newPosition;
        }

    public Integer playerSnakesAndLadders(Integer position) {
        Integer newPosition = snakesAndLaddersCheckerViaMap(position);
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

    public Integer aiSnakesAndLadders(Integer position){
        Integer newPosition = snakesAndLaddersCheckerViaMap(position);
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




    public void showRules(){
        console.println(SnakesAndLaddersLanguage.RULES.getSnakeLanguage());
    }


    @Override
    public void approachTable(Player currentPlayer) {
        Console.clearScreen();
        console.println(CasinoArt.SNAKESANDLADDERS.getCasinoArt());
        while(running) {
            console.println(SnakesAndLaddersLanguage.APPROACHTABLE.getSnakeLanguage());
            Integer playerInput = console.getIntegerInput(":");
            switch (playerInput) {
                case 1:
                    runGame(currentPlayer);
                    running = false;
                    break;
                case 2:
                    showRules();
                    break;
                case 3:
                    running = false;
                    break;
            }
        }
    }


    @Override
    public void runGame(Player currentPlayer) {
        setUpGame();
        while (running) {
            console.println("Welcome to Snakes and Ladders, %s!", currentPlayer.getName());
            console.println("In this house, the player always goes first! Step on up!");
            String winner = startNewGame();
            if (winner.equals("Player")) {
                console.println(SnakesAndLaddersLanguage.PLAYERWINS.getSnakeLanguage());
                LocalDateTime now = LocalDateTime.now();
                currentPlayer.addHistory("You won at Snakes and Ladders. ** " + dateTimeFormatter.format(now) + "!");
            } else if (winner.equals("Ai")) {
                console.println(SnakesAndLaddersLanguage.AIWINS.getSnakeLanguage());
                LocalDateTime now = LocalDateTime.now();
                currentPlayer.addHistory("You lost at Snakes and Ladders. ** " + dateTimeFormatter.format(now));
            }
            exitGame(currentPlayer);
        }

    }

    @Override
    public void exitGame(Player currentPlayer) {
        console.println(SnakesAndLaddersLanguage.EXITMENU.getSnakeLanguage());
        Integer playerInput = console.getIntegerInput(":");
        switch (playerInput){
            case 1:
                runGame(currentPlayer);
                break;
            case 2:
                running = false;
                break;
        }
    }
}
