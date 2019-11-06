package io.zipcoder.casino.RR;


import io.zipcoder.casino.DiceGame;
import io.zipcoder.casino.RR.RRGame;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
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

            @Test
            public void selectTargetNum() {
            }

            @Test
            public void evaluateResult() {
            }
}
