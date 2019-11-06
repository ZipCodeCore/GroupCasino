package io.zipcoder.casino.RR;


import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

public class RRGameTest{

//import static org.junit.Assert.*;


    @Test
    public void roll() {}

    @Test
    public void testRoll2() {
        int expected = DiceGame.roll(2, 8);
        Assert.assertTrue((expected >=1 && expected <=16));
            }
      @Test
      public void player(){
      }
    @Test
    public void getFirstName() {
        // Given
        Player testPlayer = new Player("Grace", "Bunde", 23, 500.00);
        String expected = "Grace";

        // Then
        String actual = testPlayer.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastName() {
        // Given
        Player testPlayer = new Player("Grace", "Bunde", 23, 500.00);
        String expected = "Bunde";

        // Then
        String actual = testPlayer.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAge() {
        // Given
        Player testPlayer = new Player("Grace", "Bunde", 23, 500.00);
        Integer expected = 23;

        // Then
        Integer actual = testPlayer.getAge();
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getBalance() {
        // Given
        Player testPlayer = new Player("Grace", "Bunde", 23, 500.00);
        Double expected = 500.00;

        // Then
        Double actual = testPlayer.getBalance();
        Assert.assertEquals(expected, actual);
    }


    @Test
              public void getWager() {
            }

             @Test
             public void payOut() {
             }

             @Test
             public void startPlay() {
            }

            @Test
             public void endChoice() {
             }

            @Test
            public void roundOfPlay() {



                }


            @org.junit.jupiter.api.Test
            public void selectTargetNum() {
            }

            @Test
            public void evaluateResult() {
            }

}
