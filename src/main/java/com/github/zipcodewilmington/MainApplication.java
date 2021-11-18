package com.github.zipcodewilmington;


import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.roulette.RoulettePlayer;

import javax.swing.*;
import java.util.Arrays;
import java.util.Random;

public class MainApplication {
    public static void main(String[] args) {
     //new Casino().run();
     //new RouletteGame().run();

       // System.out.println(Arrays.toString(new RouletteGame().getRed()) );
//     Double balance =  new RouletteGame().getBalance();
//        System.out.println(balance);

//   RouletteGame rouletteGame =    new RouletteGame();
//   rouletteGame.printBalance();
//   rouletteGame.setBalance(2000.);
//   rouletteGame.printBalance();


    new RouletteGame().run();
     //   new RouletteGame().evenChoice();

    }
}
