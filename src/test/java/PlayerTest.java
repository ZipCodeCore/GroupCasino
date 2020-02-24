import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
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
        // Given
        Player testPlayer = new Player("John", "Doe", 52, 327.0);
        String expected = "John";

        // Then
        String actual = testPlayer.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getLastName() {
        // Given
        Player testPlayer = new Player("John", "Doe", 52, 327.0);
        String expected = "Doe";

        // Then
        String actual = testPlayer.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getAge() {
        // Given
        Player testPlayer = new Player("John", "Doe", 52, 327.0);
        Integer expected = 52;

        // Then
        Integer actual = testPlayer.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getBalance() {
        // Given
        Player testPlayer = new Player("John", "Doe", 52, 327.0);
        Double expected = 327.0;

        // Then
        Double actual = testPlayer.getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWinnings() {
        // Given
        Player testPlayer = new Player("John", "Doe", 52, 327.0);
        testPlayer.setWinnings(650.0);
        Double expected = 650.0;

        // Then
        Double actual = testPlayer.getWinnings();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setFirstName() {
        // Given
        Player testPlayer = new Player("John", "Doe", 52, 327.0);
        String expected = "Robert";

        // When
        testPlayer.setFirstName(expected);

        // Then
        String  actual = testPlayer.getFirstName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setLastName() {
        // Given
        Player testPlayer = new Player("John", "Doe", 52, 327.0);
        String expected = "DelPriore";

        // When
        testPlayer.setLastName(expected);

        // Then
        String  actual = testPlayer.getLastName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setAge() {
        // Given
        Player testPlayer = new Player("John", "Doe", 52, 327.0);
        Integer expected = 45;

        // When
        testPlayer.setAge(expected);

        // Then
        Integer actual = testPlayer.getAge();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setBalance() {
        // Given
        Player testPlayer = new Player("John", "Doe", 52, 327.0);
        Double expected = 435.0;

        // When
        testPlayer.setBalance(expected);

        // Then
        Double actual = testPlayer.getBalance();
        Assert.assertEquals(expected, actual);
    }

}
