package io.zipcoder.casino.Craps;

import io.zipcoder.casino.Menus.CrapsMenu;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsGameTest {

    private CrapsMenu crapsMenu;
    private CrapsGame crapsGame;
    private Player player;
    private Integer setThePointRoll;
    private Integer currentRoll;

    @Before
    public void setUp() throws Exception{
        player = new Player("Zapp","Brannigan", 46,200);
        crapsGame = new CrapsGame(0.0, 0.0, player);
        crapsMenu = new CrapsMenu(crapsGame);
    }

    @Test
    //tests whether win on first works on 7
    public void winOnFirstTest(){
        setThePointRoll = 7;
        Assert.assertTrue(crapsGame.winOnFirst(setThePointRoll));

    }

    @Test
    //tests whether win on first works on 8
    public void winOnFirstTest3(){
        setThePointRoll = 8;
        Assert.assertFalse(crapsGame.winOnFirst(setThePointRoll));

    }

    @Test
    //tests whether win on first works on 11
    public void winOnFirstTest2(){
        setThePointRoll = 11;
        Assert.assertTrue(crapsGame.winOnFirst(setThePointRoll));

    }

    @Test
    //tests whether lose on first works on 2
    public void loseOnFirstTest(){
        setThePointRoll = 2;
        Assert.assertTrue(crapsGame.loseOnFirst(setThePointRoll));

    }

    @Test
    //tests whether lose on first works on 3
    public void loseOnFirstTest2(){
        setThePointRoll = 3;
        Assert.assertTrue(crapsGame.loseOnFirst(setThePointRoll));

    }

    @Test
    //tests whether lose on first works on 12
    public void loseOnFirstTest3(){
        setThePointRoll = 12;
        Assert.assertTrue(crapsGame.loseOnFirst(setThePointRoll));

    }

    @Test
    //tests whether win on subsequent works if they win
    public void winOnSubsequentTest(){
        setThePointRoll = 8;
        currentRoll = 8;
        Assert.assertTrue(crapsGame.winOnSubsequent(currentRoll, setThePointRoll));
    }

    @Test
    //tests whether win on subsequent works if they win
    public void winOnSubsequentTest2(){
        setThePointRoll = 8;
        currentRoll = 5;
        Assert.assertFalse(crapsGame.winOnSubsequent(currentRoll, setThePointRoll));
    }

    @Test
    //tests whether win on subsequent works if they win
    public void LoseOnSubsequentTest(){
        currentRoll = 7;
        Assert.assertTrue(crapsGame.loseOnSubsequent(currentRoll));
    }

    @Test
    //tests whether win on subsequent works if they win
    public void LoseOnSubsequentTest2(){
        currentRoll = 5;
        Assert.assertFalse(crapsGame.loseOnSubsequent(currentRoll));
    }

}