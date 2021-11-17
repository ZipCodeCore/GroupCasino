package com.github.zipcodewilmington;


import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;

import java.util.Arrays;
import java.util.Random;

public class MainApplication {
    public static void main(String[] args) {
      // new Casino().run();
     //new RouletteGame().run();

       // System.out.println(Arrays.toString(new RouletteGame().getRed()) );
      new RouletteGame().pickNumberChoice();

    }
}
