package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.CardGame.BlackJack;
import com.github.zipcodewilmington.casino.games.CardGame.CasinoWar;
import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import com.github.zipcodewilmington.casino.games.keno.KenoPlayer;

public class MainApplication {
    public static void main(String[] args) {
        //new CasinoWar().playCasinoWarHands();
        //new BlackJack().playBlackjack();
        new KenoPlayer(new CasinoAccount(),new KenoGame()).play();
    }
}
