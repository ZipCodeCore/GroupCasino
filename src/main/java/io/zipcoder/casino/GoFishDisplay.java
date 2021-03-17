package io.zipcoder.casino;

public class GoFishDisplay extends Display{

    public void goFishRules(){
        setPrintCurrentDisplay("Two players will be dealt 5 cards each.\nThe object of the game is to have the most pairs when the deck is empty." +
                "\nA player creates pairs by asking the other player if they have a specific card rank in their hand." +
                "\nYou must be holding the card the card you request." +
                "\n");
    }

    public void goFish(){
        setPrintCurrentDisplay("GO FISH!");
    }

    public void cardFound(){
        setPrintCurrentDisplay("That card is in their hand.");
    }

    public void cardNotFound(){
        setPrintCurrentDisplay("Nope. They are not holding that card.");
    }

    //only necessary for multiple player games
    public void whoWillYouAsk(){
        setPrintCurrentDisplay("Who will you ask?");
    }

    public void cardYouWillAskFor(){setPrintCurrentDisplay("What card will you ask for?");}

    public void opponentAskedFor(){setPrintCurrentDisplay("You opponent asked for a");}

    public void createdAPair() {setPrintCurrentDisplay("Your opponent has a " +  ". A pair of " +  "'s have been added to your score.");}

    public void printNotInYourHand() {setPrintCurrentDisplay("Ooops! That rank isn't in your hand. Ask for one that is!");}

}
