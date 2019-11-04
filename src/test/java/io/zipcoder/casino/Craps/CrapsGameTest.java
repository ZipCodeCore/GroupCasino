package io.zipcoder.casino.Craps;

import io.zipcoder.casino.Menus.CrapsMenu;
import io.zipcoder.casino.Player;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsGameTest {

    private CrapsMenu crapsMenu;
    private CrapsGame crapsGame;
    private Player player;

    @Before
    public void setUp() throws Exception{
        player = new Player("Zapp","Brannigan", 46,200);
        crapsGame = new CrapsGame(0.0, 0.0, player);
        crapsMenu = new CrapsMenu(crapsGame);
    }

    @Test
    //tests whether win on first works
    public void winOnFirstTest(){

    }

}