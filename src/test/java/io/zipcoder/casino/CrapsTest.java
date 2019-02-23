package io.zipcoder.casino;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrapsTest {

    @Before
            @Test
            public void promptNewBetsTest(){
     //Given
        String expectedPromptNewBets =
     //When
        String actualPromptNewBets = Craps.promptNewBets();
        //Then
        Assert.assertEquals(expectedPromptNewBets, actualPromptNewBets);
    }

    @Test
    public void listBetsTest(){
        //Given
        String expectedBets = "You make the following bets: 1) Lay Bet or 2) Place Bet.";
        //When
        String actualBets = Craps.listBets();
        //Then
        Assert.assertEquals(expectedBets, actualBets);
    }
}
