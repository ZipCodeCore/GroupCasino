package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer implements PlayerInterface {
    CasinoAccount casinoAccount;
    SlotsGame gameCurrentlyPlaying;

    @Override
    public CasinoAccount getArcadeAccount() {
        return casinoAccount;
    }

    @Override
    public void play() {
        gameCurrentlyPlaying.run();
    }
}