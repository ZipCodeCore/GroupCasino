package io.zipcoder.casino.Games.Slots;

import io.zipcoder.casino.utilities.CasinoArt;
import io.zipcoder.casino.GamePieces.SlotMachine;
import io.zipcoder.casino.Games.GamblingGame;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.Menus.Casino;
import io.zipcoder.casino.PlayerCreation.Player;
import io.zipcoder.casino.utilities.Console;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Slots implements Game, GamblingGame {

    Console console = new Console(System.in, System.out);
    Casino casino = new Casino();
    private Integer[][] slots;
    SlotMachine slotMachine = new SlotMachine();
    Player currentPlayer;
    private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    private CasinoArt art = new CasinoArt();
    private Boolean running = true;
    private Boolean currentGame  = true;
    private Integer pot;
    private Integer placeBet;
    private Integer winnings;


    @Override
    public void approachTable(Player currentPLayer) {
        Console.clearScreen();
        console.println(art.getCasinoArt(CasinoArt.Art.SLOTS));
        console.println("You approach the Slot Machine. What would you like to do?");
        console.println("(1) - Play the game");
        console.println("(2) - Return to the game menu");
        Integer playerInput = console.getIntegerInput(":");
        while (playerInput < 1 || playerInput >2) {
            console.println("Please pick option 1 or 2 dumbass");
            playerInput = console.getIntegerInput(":");
        }
        while (running) {
            switch (playerInput) {
                case 1:
                    runGame(currentPlayer);
                    running = false;
                    break;
                case 2:
                    running = false;
                    break;
            }
        }
    }

    public void runSlots(Player currentPlayer){
        this.currentPlayer = currentPlayer;
        approachTable(currentPlayer);
    }

    public void runGame(Player currentPlayer){
        while (running){
            placeBet(currentPlayer);
            pullLever();
            if(isWinner()){
                returnWinnings(currentPlayer);
            } else {
                youLose(currentPlayer);
            }
            exitGame(currentPlayer);
        }
    }

    public void exitGame(Player currentPlayer){
        console.println("Would you like to play again?");
        console.println("(1) - Yes");
        console.println("(2) - No");
        Integer playerInput = console.getIntegerInput(":");
        while (playerInput < 1 || playerInput >2) {
            console.println("Please pick option 1 or 2 dumbass");
            playerInput = console.getIntegerInput(":");
        }

        switch (playerInput) {
            case 1:
                runGame(currentPlayer);
                break;
            case 2:
                //casino.goToGameMenu();
                running = false;
                break;
        }

    }
    public void placeBet(Player currentPlayer){
        console.println("How much would you like to bet?");
        pot = console.getIntegerInput(":");
    }

    @Override
    public void returnWinnings(Player currentPlayer, Integer bet) {

    }

    public void pullLever(){
        slots = new Integer[3][3];
        slots = slotMachine.createMachine();
        for(int i = 0; i < slots.length; i++){
            for(int j = 0; j <slots.length; j++){
                console.print("[");
                console.print(slots[i][j].toString());
                console.print("]");
            }
            console.newln();
        }
    }

    public Boolean isWinner(){
        if(checkDiagonal() || checkHorizontal() || checkVertical()){
            return true;
        } return false;
    }

    public Boolean checkHorizontal(){
        for(int i = 0; i <= 2; i++) {
            if (slots[i][0].equals(slots[i][1]) && slots[i][1].equals(slots[i][2]))
            return true;
        } return false;
    }

    public Boolean checkVertical(){
        for(int i = 0; i <= 2; i++) {
            if (slots[0][i].equals(slots[1][i]) && slots[1][i].equals(slots[2][i]))
                return true;
        } return false;
    }

    public Boolean checkDiagonal(){
       if((slots[0][0].equals(slots[1][1]) && slots[1][1].equals(slots[2][2])) || (slots[2][0].equals(slots[1][1]) && slots[1][1].equals(slots[0][2]))) {
           return true;
       }return false;
    }

    public void returnWinnings(Player currentPlayer){
            winnings = pot * 50;
            console.println("Congrats KWEEN! You won: $"+ winnings);
            currentPlayer.changeBalance(winnings);
            console.println("Your current balance is: $" + currentPlayer.getBalance());
            LocalDateTime now = LocalDateTime.now();
            String addHistory = String.format("You won $%d.00 at Slots! ** ", winnings);
            currentPlayer.addHistory(addHistory + dtf.format(now));
    }

    public boolean youLose(Player currentPlayer) {
        console.println("Better luck next time!");
        winnings = pot * -1;
        currentPlayer.changeBalance(winnings);
        console.println("Your current balance is: $" + currentPlayer.getBalance());
        LocalDateTime now = LocalDateTime.now();
        String addHistory = String.format("You lost $%d.00 at Slots! ** ", winnings);
        currentPlayer.addHistory(addHistory + dtf.format(now));

        return true;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public void setCurrentGame(Boolean currentGame) {
        this.currentGame = currentGame;
    }

    public void setPot(Integer pot) {
        this.pot = pot;
    }

    public void setPlaceBet(Integer placeBet) {
        this.placeBet = placeBet;
    }

    public void setWinnings(Integer winnings) {
        this.winnings = winnings;
    }
}
