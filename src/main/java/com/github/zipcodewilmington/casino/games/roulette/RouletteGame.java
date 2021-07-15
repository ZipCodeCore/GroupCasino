package com.github.zipcodewilmington.casino.games.roulette;
import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.PlayerInterface;
import java.util.List;
import com.github.zipcodewilmington.casino.objects.RouletteBet;
import com.github.zipcodewilmington.casino.objects.Wheel;
import java.util.Scanner;

public class RouletteGame implements GambleableGame {
    String gameName;
    Wheel wheel;
    List<PlayerInterface> activePlayers;
    RoulettePlayer player;

    public RouletteGame(String gameName, List<PlayerInterface> activePlayers, RoulettePlayer player) {
        this.gameName = gameName;
        this.activePlayers = activePlayers;
        this.player = player;
    }

    @Override
    public void add(PlayerInterface player) {
        activePlayers.add(this.player);


    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        wheel.getSpinValue();


    }

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public boolean playerWins() {
        Scanner scanner = new Scanner(System.in);
        //return (userInput == wheel.getSpinValue());
        return false;

    }

    @Override
    public boolean playerLoses() {
        return false;
    }


    public float calculateWinnings(RouletteBet bet){
       return 0;
    }


    @Override
    public void clearGame() {

    }
}
