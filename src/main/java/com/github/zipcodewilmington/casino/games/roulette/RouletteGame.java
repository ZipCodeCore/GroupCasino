<<<<<<< HEAD
 package com.github.zipcodewilmington.casino.games.roulette;


=======
package com.github.zipcodewilmington.casino.games.roulette;
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
import com.github.zipcodewilmington.casino.GambleableGame;
import com.github.zipcodewilmington.casino.PlayerInterface;
import java.util.List;
<<<<<<< HEAD

public class RouletteGame implements GambleableGame {
    List<RoulettePlayer> activePlayers;


    @Override
    public void add(PlayerInterface player) {

import com.github.zipcodewilmington.casino.*;
=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
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
<<<<<<< HEAD


=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
        wheel.getSpinValue();


    }

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public boolean playerWins() {
<<<<<<< HEAD

        return false;

=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
        Scanner scanner = new Scanner(System.in);
        //return (userInput == wheel.getSpinValue());
        return false;

<<<<<<< HEAD

=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
    }

    @Override
    public boolean playerLoses() {
        return false;
    }


<<<<<<< HEAD

=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
    public float calculateWinnings(RouletteBet bet){
       return 0;
    }


    @Override
    public void clearGame() {

    }
<<<<<<< HEAD





=======
>>>>>>> 37ece5a5914c44edd1e5995214cab2a1876cb55e
}


