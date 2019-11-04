package io.zipcoder.casino.casino;

import io.zipcoder.casino.casino.games.dicegames.MacaoPlayer;
import org.junit.Assert;
import org.junit.Test;

public class MacaoPlayerTest {

    @Test
    public void constructorTest1() {
        // Given the expected roll and cumulative roll are both zero
        int expectedRoll = 0;
        int expectedCumuRoll = 0;

        // When we construct a new macaoPlayer with the default constuctor
        MacaoPlayer macaoPlayer = new MacaoPlayer();

        // When we retrieve the roll & cumulative roll from the macaoPlayer instance
        int actualRoll = macaoPlayer.getRoll();
        int actualCumuRoll = macaoPlayer.getCumulativeRoll();

        // Then we expect the given data to match the retrieved data
        Assert.assertEquals(expectedRoll, actualRoll);
        Assert.assertEquals(expectedCumuRoll, actualCumuRoll);
    }

    @Test
    public void constructorTest2() {
        // Given a profile exists with name Ashley and gambling status false
        Profile expectedProfile = new Profile("Ashley", false);

        // Given the expected roll and cumulative roll are both zero
        int expectedRoll = 0;
        int expectedCumuRoll = 0;

        // When we construct a new macaoPlayer with the given profile
        MacaoPlayer macaoPlayer = new MacaoPlayer(expectedProfile);

        // When we retrieve the profile, roll, and cumulative roll from the player instance
        Profile actualProfile = macaoPlayer.getProfile();
        int actualRoll = macaoPlayer.getRoll();
        int actualCumuRoll = macaoPlayer.getCumulativeRoll();

        // Then we expect the given data to match the retrieved data
        Assert.assertEquals(expectedProfile, actualProfile);
        Assert.assertEquals(expectedRoll, actualRoll);
        Assert.assertEquals(expectedCumuRoll, actualCumuRoll);
    }

    @Test
    public void getProfileTest() {
        // Given a player exists with a given profile
        Profile expected = new Profile ("Abby", true);
        MacaoPlayer player = new MacaoPlayer(expected);

        // When we call the get profile method & store it in a variable
        Profile actual = player.getProfile();

        // Then we expected the given and retrieved profiles to match
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRollTest() {
        // Given a player exists with a current roll of 5
        MacaoPlayer player = new MacaoPlayer();
        int expected = 5;
        player.setRoll(expected);

        // When we call the get roll method
        int actual = player.getRoll();

        // Then we expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCumulativeRollTest1() {
        // Given a player exists with a cumulative roll of 8
        MacaoPlayer player = new MacaoPlayer();
        int expected = 8;
        player.setCumulativeRoll(expected);

        // When we call the get cumulative roll method
        int actual = player.getCumulativeRoll();

        // Then we expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getCumulativeRollTest2() {
        // Given a player exists with a cumulative roll of 8
        MacaoPlayer player = new MacaoPlayer();
        int roll1 = 6;
        int roll2 = 4;
        int expected = roll1 + roll2;
        player.setRoll(roll1);
        player.setRoll(roll2);

        // When we call the get cumulative roll method
        int actual = player.getCumulativeRoll();

        // Then we expect the given data to match the retrieved data
        Assert.assertEquals(expected, actual);
    }
}
