package com.github.zipcodewilmington.casino.games.CardGame;

public class Card{
    FaceValueOfCard faceValueOfCard;
    Suit suit;
    public Card(){

    }
    public Card(FaceValueOfCard value, Suit suit){
        this.faceValueOfCard=value;
        this.suit=suit;
    }

    public FaceValueOfCard getFaceValueOfCard() {
        return faceValueOfCard;
    }

    public void setFaceValueOfCard(FaceValueOfCard faceValueOfCard) {
        this.faceValueOfCard = faceValueOfCard;
    }

    public Suit getSuit() {
        return suit;
    }
    public String getFaceValueAndSuit() {
        StringBuilder faceValuesb = new StringBuilder();
        faceValuesb.append(faceValueOfCard+"-"+suit);
        faceValuesb.append("\n");
        return faceValuesb.toString();
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }
}

