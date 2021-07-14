package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class KenoPlayer implements PlayerInterface {

    CasinoAccount casinoAccount;
    KenoGame gameCurrentlyPlaying;

    public KenoPlayer(CasinoAccount casinoAccount, KenoGame gameCurrentlyPlaying) {
        this.casinoAccount = casinoAccount;
        this.gameCurrentlyPlaying = gameCurrentlyPlaying;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return casinoAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        gameCurrentlyPlaying.getChosenNumbers();
        gameCurrentlyPlaying.checkHowManyMatch();
        gameCurrentlyPlaying.outcomeOfGame(gameCurrentlyPlaying.getBet());
        return (SomeReturnType) gameCurrentlyPlaying.prizeMoney;
    }

    public static void main(String[] args) {
        CasinoAccount casinoAccount = new CasinoAccount("Zach", "Kitto", 22, 100.0);
        KenoGame kenoGame = new KenoGame();
        KenoPlayer kenoPlayer = new KenoPlayer(casinoAccount, kenoGame);
        kenoPlayer.play();
    }
}
