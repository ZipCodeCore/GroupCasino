package io.zipcoder.casino.Menus;

import io.zipcoder.casino.GameObject;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Services.GameRepo;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class GameMenuTest {


    @Test
    public void mapSizeTest() {
        Player player = new Player("June", "Cleaver", 35, 0.00);
        GameRepo gameRepo = new GameRepo(player);

        GameMenu gameMenu = new GameMenu(gameRepo);
        HashMap<Integer,GameObject> map = gameMenu.getGameMap();

        Assert.assertEquals(GameRepo.NUM_ADULT_GAMES+GameRepo.NUM_KID_GAMES, map.size());

    }

    @Test
    public void mapSizeTest2() {
        Player player = new Player("Beaver", "Cleaver", 13, 0.00);
        GameRepo gameRepo = new GameRepo(player);

        GameMenu gameMenu = new GameMenu(gameRepo);
        HashMap<Integer,GameObject> map = gameMenu.getGameMap();

        Assert.assertEquals(GameRepo.NUM_ADULT_GAMES+GameRepo.NUM_KID_GAMES, map.size());
    }

    @Test
    public void handleChoices() {
    }
}