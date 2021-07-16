
package com.github.zipcodewilmington.casino.games.roulette;
import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.PlayerInterface;


import com.github.zipcodewilmington.casino.objects.RouletteBet;
import com.github.zipcodewilmington.casino.objects.Wheel;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RouletteGame implements GambleableGame {

    public static void main(String[] args) {
        RouletteGame game = new RouletteGame();
        game.run();
    }

    String gameName;
    Wheel wheel;
    RoulettePlayer player;
    RouletteBet bet;
    int streetBet;
    int singleBet;
    int columnBet;
    int evenBet;
    int oddBet;
    int winningNum;

    private final IOConsole console = new IOConsole(AnsiColor.YELLOW);


    public RouletteGame(String gameName, RoulettePlayer player) {
        this.gameName = gameName;
        this.player = player;

    }

    public RouletteGame(){
        this.gameName = "Rowena's Roulette";
        this.player = new RoulettePlayer();
    }


    @Override
    public void run() {
        console.println("Welcome to %s !", gameName);
        console.println("Place your bet!");
        console.getStringInput("Select Inside or Outside");
        String betSelectionInput = getBetSelection().toUpperCase();
        if (betSelectionInput.equals("INSIDE")) {
            String insideBet = selectStreetorSingle().toUpperCase();
            if (insideBet.equals("STREET")) {
                selectStreetNumber();
                spinWheel();
                Integer[] check = bet.winningStreetArray(streetBet); //check array
                console.println(getWinningString(check));
            } else {
                selectSingleNumber();
                spinWheel();


            }
        }
        if (betSelectionInput.equals("OUTSIDE")){
            String outsideBet = getOutBetSelection().toString();
            placeBet();
        }





    }

    public void spinWheel(){
        console.println("Spinning...");
        int winningNumber = wheel.getSpinValue();
         this.winningNum= winningNumber;
    }



    public String getBetSelection(){
        return console.getStringInput(new StringBuilder()
                .toString());
    }
    public String getOutBetSelection(){
        return console.getStringInput(new StringBuilder()
            .toString());
    }

    public String selectStreetorSingle(){
        return console.getStringInput("Street or Single");
    }

    public void selectStreetNumber(){
        this.streetBet = console.getIntegerInput("Pick Your Number");

    }

    public void selectSingleNumber(){
        this.singleBet = console.getIntegerInput("Pick Your Number");
    }

    public int placeBet(){
        String input = console.getStringInput("How much?");
        return Integer.parseInt(input);

    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }



    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public boolean playerWins() {

        //return (userInput == wheel.getSpinValue());
        return false;

    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    public int evaluateInsideBet(int bet){
        return 0;


    }

    public String getWinningString(Integer[] win){
        List<Integer> winArray = new ArrayList<Integer>(Arrays.asList(win));
        if (winArray.contains(winningNum)){
       return "Winner, Winner! Chicken Dinner!" ;
        }
      return "Bang, bang. You're done.";
    }




    @Override
    public void clearGame() {

    }
}
