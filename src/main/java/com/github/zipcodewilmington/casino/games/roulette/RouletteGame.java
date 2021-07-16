
package com.github.zipcodewilmington.casino.games.roulette;
import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.PlayerInterface;


import com.github.zipcodewilmington.casino.objects.RouletteBet;
import com.github.zipcodewilmington.casino.objects.Wheel;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;


public class RouletteGame implements GambleableGame {
    String gameName;
    Wheel wheel;
    RoulettePlayer player;
    RouletteBet bet;

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
        console.getStringInput("Inside or Outside");
        String betSelectionInput = getBetSelection().toUpperCase();
        if (betSelectionInput.equals("Inside")) {
            selectStreetorSingle();
            placeInsideBet();

        }


    }

    public int spinWheel(){
        int winningNumber = wheel.getSpinValue();
        return winningNumber;
    }



    public String getBetSelection(){
        return console.getStringInput(new StringBuilder()
                .toString());
    }

    public String selectStreetorSingle(){
        return console.getStringInput("Street or Single");
    }

    public int placeInsideBet(){
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

    public float calculateWinnings(RouletteBet bet){
       return 0;
    }


    @Override
    public void clearGame() {

    }
}
