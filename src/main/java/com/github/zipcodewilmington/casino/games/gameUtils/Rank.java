package com.github.zipcodewilmington.casino.games.gameUtils;

public enum Rank {
    Two(2),
    Three(3),
    Four(4),
    Five(5),
    Six(6),
    Seven(7),
    Eight(8),
    Nine(9),
    Ten(10),
    Jack(11),
    Queen(12),
    King(13),
    Ace(1, 11);

    private final Integer primaryValue;
    private final Integer secondaryValue;

    Rank(Integer value){
        this.primaryValue = value;
        this.secondaryValue = value;
    }

    Rank(Integer primaryValue, Integer secondaryValue) {
        this.primaryValue = primaryValue;
        this.secondaryValue = secondaryValue;
    }

    public Integer getPrimaryValue(){
        return  primaryValue;
    }

    public Integer getSecondaryValue(){
        return secondaryValue;
    }
}
//each item is public static final