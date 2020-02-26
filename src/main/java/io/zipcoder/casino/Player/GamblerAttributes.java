package io.zipcoder.casino.Player;

public interface GamblerAttributes {
    boolean isAdult = true;
    Integer winnings = null;
    Integer losses = null;

    public Integer placeBet(Integer bet);
}
