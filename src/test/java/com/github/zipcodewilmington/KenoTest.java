package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.Player;
import com.github.zipcodewilmington.casino.games.keno.Keno;
import org.junit.Test;

public class KenoTest {
    @Test
    public void testRun(){
        Player player=new Player("Dipinti",3000);
        Keno keno=new Keno();
        int[] playerNums={80,23,31,14,54,36,72,18,91,1,11,12,13,14,44};
        keno.setPlayerNumbers(playerNums);
        keno.run();
        Integer winnings=keno.calculateWinnings(keno.getMultiplier(),3000);
        System.out.println(winnings);
    }
}
