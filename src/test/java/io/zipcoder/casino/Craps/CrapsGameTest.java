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
    private Double wager;
    private Integer setThePointRoll;
    private Integer currentRoll;
    private Integer numRolls;

    @Before
    public void setUp() throws Exception{
        //starting balance was $200, minus the wager of $50
        wager = 50.00;  //note that for purposes of this test, this wager is taken out before the balance below
        player = new Player("Zapp","Brannigan", 46,150);  //reflects balance after wager
        crapsGame = new CrapsGame(10.0, 50.0, player);
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

    @Test
    //tests calculateWinnings - whether winning on set the point roll pays out correctly
    public void PayOnSetThePointTest1(){
        setThePointRoll = 7;
        numRolls = 0;
        Assert.assertEquals(100.00, crapsGame.calculateWinnings(wager, setThePointRoll, numRolls), 0.001);
        Assert.assertEquals(250.00, player.getBalance(),0.001);
    }

    @Test
    //tests calculateWinnings - whether winning on 4 or 10 on the first roll pays out correctly
    public void Pay4or10firstTest(){
        setThePointRoll = 4;
        numRolls = 1;
        Assert.assertEquals(300.00, crapsGame.calculateWinnings(wager,setThePointRoll,numRolls), 0.001);
        Assert.assertEquals(450.00, player.getBalance(),0.001);
    }

    @Test
    //tests calculateWinnings - whether winning on 4 or 10 on the second roll pays out correctly
    public void Pay4or10secondTest(){
        setThePointRoll = 4;
        numRolls = 2;
        Assert.assertEquals(250.00, crapsGame.calculateWinnings(wager,setThePointRoll,numRolls), 0.001);
        Assert.assertEquals(400.00, player.getBalance(),0.001);
    }

    @Test
    //tests calculateWinnings - whether winning on 4 or 10 on the third roll pays out correctly
    public void Pay4or10thirdTest(){
        setThePointRoll = 4;
        numRolls = 3;
        Assert.assertEquals(200.00, crapsGame.calculateWinnings(wager,setThePointRoll,numRolls), 0.001);
        Assert.assertEquals(350.00, player.getBalance(),0.001);
    }

    @Test
    //tests calculateWinnings - whether winning on 5 or 9 on the first roll pays out correctly
    public void Pay5or9firstTest(){
        setThePointRoll = 5;
        numRolls = 1;
        Assert.assertEquals(250.00, crapsGame.calculateWinnings(wager,setThePointRoll,numRolls), 0.001);
        Assert.assertEquals(400.00, player.getBalance(),0.001);
    }

    @Test
    //tests calculateWinnings - whether winning on 5 or 9 on the second roll pays out correctly
    public void Pay5or9secondTest(){
        setThePointRoll = 5;
        numRolls = 2;
        Assert.assertEquals(200.00, crapsGame.calculateWinnings(wager,setThePointRoll,numRolls), 0.001);
        Assert.assertEquals(350.00, player.getBalance(),0.001);
    }

    @Test
    //tests calculateWinnings - whether winning on 5 or 9 on the third roll pays out correctly
    public void Pay5or9thirdTest(){
        setThePointRoll = 5;
        numRolls = 3;
        Assert.assertEquals(150.00, crapsGame.calculateWinnings(wager,setThePointRoll,numRolls), 0.001);
        Assert.assertEquals(300.00, player.getBalance(),0.001);
    }

    @Test
    //tests calculateWinnings - whether winning on 6 or 8 on the first roll pays out correctly
    public void Pay6or8firstTest(){
        setThePointRoll = 6;
        numRolls = 1;
        Assert.assertEquals(200.00, crapsGame.calculateWinnings(wager,setThePointRoll,numRolls), 0.001);
        Assert.assertEquals(350.00, player.getBalance(),0.001);
    }

    @Test
    //tests calculateWinnings - whether winning on 6 or 8 on the second roll pays out correctly
    public void Pay6or8secondTest(){
        setThePointRoll = 6;
        numRolls = 2;
        Assert.assertEquals(150.00, crapsGame.calculateWinnings(wager,setThePointRoll,numRolls), 0.001);
        Assert.assertEquals(300.00, player.getBalance(),0.001);
    }

    @Test
    //tests calculateWinnings - whether winning on 6 or 8 on the third roll pays out correctly
    public void Pay6or8thirdTest(){
        setThePointRoll = 6;
        numRolls = 3;
        Assert.assertEquals(100.00, crapsGame.calculateWinnings(wager,setThePointRoll,numRolls), 0.001);
        Assert.assertEquals(250.00, player.getBalance(),0.001);
    }

    @Test
    // tests calculateWinnings - whether losing on set the point roll deducts your balance correctly
    public void BalanceDeductsOnSetThePointTest1() {
        setThePointRoll = 3;
        numRolls = 0;
        Assert.assertEquals(0.00, crapsGame.calculateWinnings(wager, setThePointRoll, numRolls), 0.001);
        Assert.assertEquals(150.00, player.getBalance(), 0.001);
    }

    //WRITE TEST OF ROUND OF PLAY FOR HOW DIFFERENT TYPES OF LOSSES EFFECT YOUR BALANCE

    /*-------------------I DON'T KNOW HOW TO TEST THESE-----------------------
    @Test
    // tests whether losing on set the point roll correctly computes balance
    public void BalanceAfterLoseOnSetThePointRollTest(){
        setThePointRoll = 3;
        numRolls = 0;
        crapsGame.roundOfPlay();
        Assert.assertEquals(150.00, player.getBalance(),0.001);
    }

    @Test
    // tests whether losing on subsequent roll currectly computes balance
    public void BalanceAfterLosingOnSubsequentRollTest(){

    }

    @Test
    //tests whether losing due to running out of rolls correctly computes balance
    public void BalanceAfterRunningOutOfRollsTest(){

    }
*/

}