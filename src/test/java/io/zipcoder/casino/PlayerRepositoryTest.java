package io.zipcoder.casino;

import io.zipcoder.casino.PlayerCreation.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PlayerRepositoryTest {

    @Test
    public void findPlayerTest1() {
        PlayerRepository repository = new PlayerRepository();
        Player sabin = new Player("Terra", 500);
        repository.addPlayer(sabin);
        Player actual = repository.findPlayer("Terra");

        assertEquals(actual.getBalance(), sabin.getBalance());
    }

    @Test
    public void findPlayerTest2() {
        PlayerRepository repository = new PlayerRepository();
        Player sabin = new Player("Sabin", null);
        repository.addPlayer(sabin);
        Player actual = repository.findPlayer("Sabin");

        assertEquals(actual.getName(), sabin.getName());
    }

    @Test
    public void addPlayerTest1() {
        PlayerRepository repository = new PlayerRepository();
        Player cyan = new Player("Cyan", null);


        Assert.assertTrue(repository.addPlayer(cyan));
    }

    @Test
    public void addPlayerTest2() {
        PlayerRepository repository = new PlayerRepository();
        Player cyan = new Player("Cyan", null);


        Assert.assertTrue(repository.addPlayer(cyan));
    }

    @Test
    public void constructorTest(){
        PlayerRepository repository = new PlayerRepository();
        Player cyan = new Player("Cyan", null);
        repository.addPlayer(cyan);


        Assert.assertFalse(repository.addPlayer(cyan));
    }
}