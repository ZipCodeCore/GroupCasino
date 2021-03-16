package io.zipcoder.casino;

public class GoFishDisplay extends Display{

    public void goFishRules(){
        currentDisplaySP("Two players will be dealt 5 cards each.\nThe object of the game is to have the most pairs when the deck is empty." +
                "\nA player creates pairs by asking the other player if they have a specific card in their hand." +
                "\nYou must be holding the card the card you request." +
                "\n");
    }

    public void goFish(){
        currentDisplaySP("GO FISH!");
    }

    public void cardFound(){
        currentDisplaySP("That card is in their hand.");
    }

    public void cardNotFound(){
        currentDisplaySP("Nope. They are not holding that card.");
    }

    //only necessary for multiple player games
    public void whoWillYouAsk(){
        currentDisplaySP("Who will you ask?");
    }

    public void cardYouWillAskFor(){}

    public void opponentAskedFor(){}

    public void createdAPair() {}



}
