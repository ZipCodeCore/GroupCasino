package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.CardGame.BlackJack;
import com.github.zipcodewilmington.casino.games.CardGame.CasinoWar;

public class MainApplication {
    public static void main(String[] args) {
        //new CasinoWar().playCasinoWarHands();
        new BlackJack().playBlackjack();
    }
}
