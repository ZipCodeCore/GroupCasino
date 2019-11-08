package io.zipcoder.casino.RR;


import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RRGameTest{

//import static org.junit.Assert.*;


    private RRGame testGame;
    private Player dave;
    private Player testPlayer;
    private Integer computersRoll;
    private Integer userDieNum;
    private RRGame  testGame2;

    @Before
    public void setUp () {
            dave = new Player("David", "Trombello", 37, 500);
            testGame = new RRGame(dave);
            testPlayer = new Player("Grace", "Bunde", 23, 500.00);
            testGame2 = new RRGame(testPlayer);
        }

    @Test
    public void computerRollTest() {
        for (int i = 0; i < 1000; i++) {
            Integer expected = testGame.computerRoll();
            Assert.assertTrue((expected >= 1 && expected <= 6));

        }
    }


    @Test
    public void getFirstName() {
        // Given

        String expected = "Grace";

        // Then
        String actual = testPlayer.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastName() {
        // Given

        String expected = "Trombello";

        // Then
        String actual = dave.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAge() {
        // Given

        Integer expected = 23;

        // Then
        Integer actual = testPlayer.getAge();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getBalance() {
        // Given
        dave.setBalance(500.00);
        Double expected = 500.00;

        // Then
        Double actual = dave.getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void houseDisplayRollTest () {
        testGame.setComputersRoll(5);
        Integer computersRoll = testGame.getComputersRoll();
        String expected = "------------------------------------------------------\n\n** The House rolled 5 **\n" + DiceGame.diceToASCII(computersRoll);
        String actual = testGame.houseRollDisplay(computersRoll);
        Assert.assertEquals(expected , actual);
    }

    @Test
    public void userRollDisplay() {
        testGame.setUserDieNum(6);
        Integer userDieNum = testGame.getUserDieNum();
        String expected = "------------------------------------------------------\n** You rolled 6 **\n\n" + DiceGame.diceToASCII(userDieNum);
        String actual = testGame.userRollDisplay(userDieNum);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void displayUserBalance() {
        dave.setBalance(535.00);
        String expected = "Your Current Balance Is 535.00";
        String actual = testGame.displayUserBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayWinnerBalance() {
        testPlayer.setBalance(825);
        String expected = "\n\nYou Won!!! Your Balance Is Now $825.00\n";
        String actual = testGame2.displayWinnerBalance();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getName() {
        String expected = "Russian Dice Roulette";
        String actual = testGame.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printElFin() {
        String expected = "   ,ggggggg,             ,gggggggggggggg                  \n" +
                " ,dP\"\"\"\"\"\"Y8b ,dPYb,    dP\"\"\"\"\"\"88\"\"\"\"\"\"                  \n" +
                " d8'    a  Y8 IP'`Yb    Yb,_    88                        \n" +
                " 88     \"Y8P' I8  8I     `\"\"    88      gg                \n" +
                " `8baaaa      I8  8'         ggg88gggg  \"\"                \n" +
                ",d8P\"\"\"\"      I8 dP             88   8  gg    ,ggg,,ggg,  \n" +
                "d8\"           I8dP              88      88   ,8\" \"8P\" \"8, \n" +
                "Y8,           I8P         gg,   88      88   I8   8I   8I \n" +
                "`Yba,,_____, ,d8b,_        \"Yb,,8P    _,88,_,dP   8I   Yb,\n" +
                "  `\"Y8888888 8P'\"Y88         \"Y8P'    8P\"\"Y88P'   8I   `Y8\n\n\n\n";
        String actual = testGame.printElFin();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printPistol() {
        String expected = "                                  \n\n\n" +
                "   )                               /=>\n" +
                "  (  +____________________/\\/\\___ / /|\n" +
                "   .''._____________'._____      / /|/\\\n" +
                "  : () :              :\\ ----\\|    \\ )\n" +
                "   '..'______________.'0|----|      \\\n" +
                "                    0_0/____/        \\\n" +
                "                        |----    /----\\\n" +
                "                       || -\\\\ --|      \\\n" +
                "                       ||   || ||\\      \\\n" +
                "                        \\\\____// '|      \\\n" +
                "      Bang!                     .'/       |\n" +
                "                               .:/        |\n" +
                "                               :/_________|";
                String actual = testGame.printPistol();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printLosingMessage() {
        String expected = "\nYou Lost!!!";
        String actual = testGame.printLosingMessage();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printDealersLosingMessage() {
        String expected = "[DEALER]: Don't you know how Russian Roulette works?\n\n";
        String actual = testGame.printDealersLosingMessage();
        Assert.assertEquals(expected,actual);
    }
}
