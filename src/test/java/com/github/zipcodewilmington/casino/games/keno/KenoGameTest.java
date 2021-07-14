package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.RandomNumberGenerator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

public class KenoGameTest {

    @Test
    public void addTest() {
        // Given
        CasinoAccount casinoAccount = new CasinoAccount("Zach", "Kitto", 22, 2000.0);
        KenoGame kenoGame = new KenoGame();
        PlayerInterface expectedPlayer = new KenoPlayer(casinoAccount, kenoGame);

        // When
        kenoGame.add(expectedPlayer);
        PlayerInterface actualPlayer = kenoGame.getPlayer(casinoAccount.getUsername());

        // Then
        Assert.assertEquals(expectedPlayer, actualPlayer);
    }

    @Test
    public void removeTest() {
        // Given
        CasinoAccount casinoAccount1 = new CasinoAccount("Zach", "Kitto", 22, 2000.0);
        CasinoAccount casinoAccount2 = new CasinoAccount("Mack", "Kitto", 22, 2000.0);
        KenoGame kenoGame = new KenoGame();
        PlayerInterface player1 = new KenoPlayer(casinoAccount1, kenoGame);
        PlayerInterface player2 = new KenoPlayer(casinoAccount2, kenoGame);
        Integer expectedAmountOfPlayers = 1;

        // When
        kenoGame.add(player1);
        kenoGame.add(player2);
        kenoGame.remove(player1);
        Integer actualAmountOfPlayers = kenoGame.getPlayers().size();

        // Then
        Assert.assertEquals(expectedAmountOfPlayers, actualAmountOfPlayers);
    }

    @Test
    public void runTest() {

    }
}
