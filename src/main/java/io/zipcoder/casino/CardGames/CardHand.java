package io.zipcoder.casino.CardGames;

import java.util.ArrayList;

public class CardHand {

    ArrayList<Card> userHand = new ArrayList<Card>();


    public CardHand(ArrayList<Card> dealtCards){

        userHand.addAll(dealtCards);
    }


    public String displayHand(){
        //Collections.sort(userHand); TODO - do this later
       return userHand.toString();
    }

    public boolean lookForCard(String wantedCard){

        for(Card card : userHand) {
            if (card.toString().contains(wantedCard))
                return true;
        }

        return false;
    }

    public ArrayList<Card> removeCardsFromHand(String cardToRemove){

        ArrayList<Card> tradingCards = new ArrayList<Card>();


        for(Card card : userHand) {
            if (card.toString().contains(cardToRemove)) {
                Card temp = card;
                userHand.remove(card);
                tradingCards.add(temp);
            }

        }

        return tradingCards;

    }

    public void tradeCards(ArrayList cardsToTrade){
        userHand.addAll(cardsToTrade);
    }

    public void getCardFromDeck(Card cardToAdd){

        userHand.add(cardToAdd);
    }

    public boolean evaluateHand(){
        int counter = 0;

        for(Card checkCard : userHand){
            counter = 0;
            for (Card card : userHand){
                if(checkCard.getRank() == card.getRank()){
                    counter++;
                }
            }

            if(counter == 2){
                return true;
            }


        }

        return false;
    }


}
