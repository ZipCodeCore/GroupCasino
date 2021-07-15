package NumberGuessGame;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class NumberGuessTest {
    @Test
    public void numberRandomizerTest(){
        //given
        Random random = new Random();
        int randomNumberFromOneToOneHundred = random.nextInt(100) + 1;

        //when
        int guessedNumber = randomNumberFromOneToOneHundred;
        //then
        Assert.assertTrue(guessedNumber >= 1 && guessedNumber <= 100);
    }

    @Test
    public void winnerTest(){
        //given

        //when

        //then
    }
    @Test
    public void loserTest(){
        //given

        //when

        //then
    }
}
