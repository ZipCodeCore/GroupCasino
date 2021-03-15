package io.zipcoder.casino;

public class Card {
    //value from ace to king
    private String cardName;
    //Spade, Diamond, Heart, Clubs
    private String cardSuit;
    //value = name from 2-10. Jack queen and king are also ten, with ace being 1 or 11 in blackjack.
    private Integer cardValue;

    public Card(String name, String suit, Integer value){
        cardName=name;
        cardSuit=suit;
        cardValue=value;
    }

    private String getCardName(){
        return cardName;
    }

    private Integer getValue(){
        return cardValue;
    }

    private String getCardSuit(){
        return cardSuit;
    }
}
