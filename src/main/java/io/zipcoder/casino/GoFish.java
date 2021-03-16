package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.List;

public class GoFish extends CardGame {
    private List<Card> oswald= new ArrayList<>();
    private List<Card> dealer= new ArrayList<>();

    public void playGame() {
    }

    public Boolean checkWinner() {
        return null;
    }

    public Integer cardsInHand(List<Card> player){
        return player.size();
    }


    public String showCard(List<Card> player, int indexOfCard) {
        String name=player.get(indexOfCard).getCardName();
        String suit=player.get(indexOfCard).getCardSuit();
        return name+" of "+suit;
    }
}
