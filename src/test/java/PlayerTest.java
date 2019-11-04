import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

//Player constructor test
    @Test
    public void constructorTest (){
        // Given
        String expectedFirstName = "David";
        String expectedLastName = "Trombello";
        int expectedAge = 37;
        double expectedBalance = 450.0;
        double expectedInitialBalance =  450.0;
        double actualInitialBalance = expectedBalance;


        // When
        Player testPlayer = new Player (expectedFirstName, expectedLastName, expectedAge, expectedBalance);

        // Then
        String actualFirstName = testPlayer.getFirstName();
        String actualLastName = testPlayer.getLastName();
        int actualAge = testPlayer.getAge();
        double actualBalance = testPlayer.getBalance();


        //Assertions
        Assert.assertEquals(expectedFirstName, actualFirstName);
        Assert.assertEquals(expectedLastName, actualLastName);
        Assert.assertEquals(expectedAge, actualAge);
        Assert.assertEquals(expectedBalance, actualBalance, 0.0000001);
        Assert.assertEquals(expectedInitialBalance, actualInitialBalance, 0.0000001);
    }


    @Test
    public void getFirstName() {
    }

    @Test
    public void getLastName() {
    }

    @Test
    public void getAge() {
    }

    @Test
    public void getBalance() {
    }

    @Test
    public void setFirstName() {
    }

    @Test
    public void setLastName() {
    }

    @Test
    public void setAge() {
    }

    @Test
    public void setBalance() {
    }

    @Test
    public void deposit() {
    }


}
