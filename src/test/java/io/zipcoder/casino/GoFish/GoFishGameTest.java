package io.zipcoder.casino.GoFish;


import io.zipcoder.casino.Menus.GoFishMenu;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoFishGameTest {
    private GoFishMenu goFishMenu;
    private GoFishGame goFishGame;
    private Player player;
    private GoFishPlayer goFishPlayer;
    private GoFishNPC opponent;
    private GoFishNPC goFishNPC;


    @Before
    public void before(){
        player = new Player("Bamboo", "Rod", 25, 15);
        goFishGame = new GoFishGame(player);
        goFishMenu = new GoFishMenu(goFishGame);
        goFishPlayer = goFishGame.getPlayer();
        opponent = goFishGame.getOpponent();
    }

    @Test
    public void getNameTest(){
        Assert.assertEquals("Go Fish", goFishGame.getName());
    }




}
