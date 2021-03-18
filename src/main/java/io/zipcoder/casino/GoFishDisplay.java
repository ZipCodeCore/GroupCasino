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

    public void printCardNotFound(){
        setPrintCurrentDisplay("Nope. They are not holding that card.");
    }

    //only necessary for multiple player games
    public void whoWillYouAsk(){
        setPrintCurrentDisplay("Who will you ask?");
    }

    public void printWhatRankYouWillAskFor(){setPrintCurrentDisplay("What card will you ask for?");}

    public void printOponentAskedFor(){setPrintCurrentDisplay("You opponent asked for a");}

    public void printCreatedAPair() {setPrintCurrentDisplay("Your opponent has a " +  ". A pair of " +  "'s have been added to your score.");}

}
