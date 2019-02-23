package io.zipcoder.casino.Cards;

public enum Rank {

    ACE(1,11),

    TWO(2,2),

    THREE(3,3),

    FOUR(4,4),

    FIVE(5,5),

    SIX(6,6),

    SEVEN(7,7),

    EIGHT(8,8),

    NINE(9,9),

    TEN(10,10),

    JACK(10,10),

    QUEEN(10,10),

    KING(10,10);

    private int value;
    private int secondValue;

    private Rank(int value, int secondValue) {
        this.value = value;
        this.secondValue = secondValue;
    }

    public int returnPrimaryRankValue() {
        return this.value;
    }

    public int returnSecondaryRankValue() {
        return this.secondValue;
    }
}
