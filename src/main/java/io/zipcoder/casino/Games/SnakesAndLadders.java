package io.zipcoder.casino.Games;

import io.zipcoder.casino.GamePieces.SnakesLaddersPiece;
import io.zipcoder.casino.GamePieces.Dice;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.time.LocalDateTime;

import java.util.HashMap;


public class SnakesAndLadders implements Game {
    private Console console = new Console(System.in, System.out);
    private Dice dice = new Dice();
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
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
        String winner = "";
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
        console.getStringInput("Press Enter to roll the dice.");
        playerPosition = playerDiceRoll();
        playerSnakesAndLadders(playerPosition);
        if(playerPosition >= 100){
            return "Player";
        }

        return "no winner yet";
    }

    public String aiTurn(Integer aiPosition){
        console.getStringInput("Now it's my turn! Press enter.");
        aiPosition = aiDiceRoll();
        aiSnakesAndLadder(aiPosition);
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

    public Integer SnakesAndLaddersCheckerViaMap(Integer position){
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
        Integer newPosition = SnakesAndLaddersCheckerViaMap(position);
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
        Integer newPosition = SnakesAndLaddersCheckerViaMap(position);
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
        console.println("Snakes and Ladders finds its origins in Ancient India, where it\n" +
                "was first created under the name Moksha Patam.\n" +
                "It was used to teach children values, rewarding proper behavior with\n" +
                "a boost in point value, via climbing a ladder, or punishing a player\n" +
                "in point value for bad behavior, via sliding down the back of a snake.\n\n" +
                "Commercially known in the West as Chutes and Ladders, the game has been published by Milton Bradley\n" +
                "since the 1940's, and players compete by rolling dice and\n" +
                "and racing to the value of 100 points, the final spot on the board.\n" +
                "But beware! Certain spots on the board will send you down the backs of the Snakes!\n" +
                "Likewise, certain spots on the board will push you closer to your goal.\n" +
                "Roll the dice and see who gets there first!\n\n");
    }


    @Override
    public void approachTable(Player currentPlayer) {
        console.println("You approach the Snakes and Ladders table. What would you like to do?");
        console.println("(1) - Play the game");
        console.println("(2) - Read the rules");
        console.println("(3) - Return to the game menu");
        Integer playerInput = console.getIntegerInput(":");
        while(running) {
            switch (playerInput) {
                case 1:
                    runGame(currentPlayer);
                    running = false;
                    break;
                case 2:
                    showRules();
                    approachTable(currentPlayer);
                    running = false;
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
                console.println("Congratulations! You won!");
                LocalDateTime now = LocalDateTime.now();
                currentPlayer.addHistory("You won at Snakes and Ladders. ** " + dtf.format(now) + "!");
            } else if (winner.equals("Ai")) {
                console.println("Oh, Too bad! I won! Better lucky next time!");
                LocalDateTime now = LocalDateTime.now();
                currentPlayer.addHistory("You lost at Snakes and Ladders. ** " + dtf.format(now));
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
                runGame(currentPlayer);
                break;
            case 2:
                running = false;
                break;
        }
    }
}
