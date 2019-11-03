package io.zipcoder.casino.Services;

import io.zipcoder.casino.GameObject;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class GameRepoTest {

    @Test
    public void constructorTestAdult() {
        Player player = new Player("June", "Cleaver", 35, 0.00);
        GameRepo gameRepo = new GameRepo(player);

        HashMap<Integer, GameObject> map = gameRepo.getGamesMap();

        Assert.assertEquals(GameRepo.NUM_ADULT_GAMES + GameRepo.NUM_KID_GAMES + 1, map.size());

    }

    @Test
    public void constructorTestUnder21() {
        Player player = new Player("Beaver", "Cleaver", 13, 0.00);
        GameRepo gameRepo = new GameRepo(player);

        HashMap<Integer, GameObject> map = gameRepo.getGamesMap();

        Assert.assertEquals(GameRepo.NUM_KID_GAMES + 1, map.size());
    }

}