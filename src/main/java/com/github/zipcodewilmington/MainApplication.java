package com.github.zipcodewilmington;


import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;

import java.util.Arrays;

public class MainApplication {
    public static void main(String[] args) {

      //  new Casino().run();
    new RouletteGame().run();
//        RouletteGame rouletteGame = new RouletteGame();
//        rouletteGame.setBalance(1000.0);
//        System.out.println(rouletteGame.blackChoice(24,100.0));
      //  System.out.println(Arrays.toString(new RouletteGame().getRed()));
    }
}
