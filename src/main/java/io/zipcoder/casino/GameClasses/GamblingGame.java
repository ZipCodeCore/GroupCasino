package io.zipcoder.casino.GameClasses;

public interface GamblingGame {
    Integer betsOnTable = null;

    public Integer placeWager();

    public Integer addWinnings();

    public Integer subtractLoses();

    public Boolean checkPlayerBalances();

}
