package io.zipcoder.casino.Craps;

import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Menus.CrapsMenu;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrapsGameTest  {

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
    public void getFirstNameTest(){
        String expected = "Zapp";
        String actual = player.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastNameTest(){
        String expected = "Brannigan";
        String actual = player.getLastName();
        Assert.assertEquals(expected, actual);
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
    //tests whether lose on first works on 2
    public void loseOnFirstTest4() {
        setThePointRoll = 8;
        Assert.assertFalse(crapsGame.loseOnFirst(setThePointRoll));
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

    @Test
    public void tossPointRollTest() {
        Integer expected = 8;
        Integer actual = crapsGame.tossPointRoll(5,  3);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void winningMessageFirstRollTest() {
    String expected = "\n(( You rolled a null on the first roll! ))\n\nCongratulations!!\n\nYou are a winner!!!\n-------------------------------------------------\n\n";
    String actual = crapsGame.winningMessageFirstRoll();
    Assert.assertEquals(expected, actual);

    }

    @Test
    public void losingMessageFirstRoll() {
        String expected = "\n(( You rolled a null and have lost on the first roll! ))\n\nThis is unfortunate.....\n\n:(\n-------------------------------------------------\n\n";
        String actual = crapsGame.losingMessageFirstRoll();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void losingMessageOutOfRolls() {

        String expected = "(( You are out of rolls. ))\nYou seem to have lost.\nThis is unfortunate.....\n:(\n-------------------------------------------------\n\n";
        String actual = crapsGame.losingMessageOutOfRolls();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tossCurrentRoll() {
        Integer expected = 12;
        Integer actual = crapsGame.tossPointRoll(7,  5);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void winOnSubsequentMessage() {
        String expected = "Hooray! You rolled a null, and you have won!!  It took you 0 rolls to win.";
        String actual = crapsGame.winOnSubsequentMessage();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void loseOnSubsequentMessage() {
        String expected = "It appears that the odds were not in your favor today. Better luck next time.....\n-------------------------------------------------\n\n";
        String actual = crapsGame.loseOnSubsequentMessage();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayCurrentRoll() {
        crapsGame.setDie1Current(3);
        Integer die1Current= crapsGame.getDie1Current();
        crapsGame.setDie2Current(5);
        Integer die2Current= crapsGame.getDie2Current();
        String expected = (DiceGame.diceToASCII(die1Current, die2Current) + String.format(("\n(( You have rolled a 8 for this roll. ))\n")));
    String actual = crapsGame.displayCurrentRoll(8);
    Assert.assertEquals(expected, actual);
    }

    @Test
    public void tossCurrentRoll2() {
        Integer expected = 12;
        Integer actual = crapsGame.tossCurrentRoll(7,  5);
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void displayPointRoll() {
        crapsGame.setDie1Point(4);
        Integer die1Point= crapsGame.getDie1Point();
        crapsGame.setDie2Point(6);
        Integer die2Point= crapsGame.getDie2Point();
        String expected = "\n-------------------------------------------------" + "SET THE POINT ROLL:\n" + DiceGame.diceToASCII(die1Point, die2Point) + "\n-------------------------------------------------";
        String actual = crapsGame.displayPointRoll();
                Assert.assertEquals(expected, actual);
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