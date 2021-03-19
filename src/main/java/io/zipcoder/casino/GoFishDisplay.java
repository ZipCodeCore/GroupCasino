package io.zipcoder.casino;

public class GoFishDisplay extends Display{

    public void printGoFishRules(){
        setPrintCurrentDisplay("GO FISH RULES:\n"+
                "Two players will be dealt 5 cards each to begin.\n"+
                "The object of the game is to have the most books (set of 4 cards of the same rank).\n"+
                "A player creates a book by asking the other player if they have cards of a specific rank in their hand.\n" +
                "If the other player is holding cards of the requested rank, they must hand them over.\n"+
                "You can only request card ranks that you already have in your hand.\n" +
                "Game play continues until the deck is empty.\n");
    }

    public void printPlayerHandHeader() {setPrintCurrentDisplay("\nCARDS IN YOUR HAND:");}

    public void printFreeGame() {System.out.println("And don't worry - you won't be needing your money. This game is FREE!!!!\n");}

    public void printGoFish(){
        setPrintCurrentDisplay("\nYOUR OPPONENT SAYS: GO FISH!\nYou have now drawn a card from the deck.");
    }

    public void printTellComputerGoFish() {
        setPrintCurrentDisplay("\nYOU TOLD YOUR OPPONENT TO GO FISH!\nYour opponent has drawn a card from the deck.");
    }

    public void printOpponentHasCard(){
        setPrintCurrentDisplay("That card rank is in their hand! It will now be given to you!");
    }

    public void printRankNotInYourHand() {
        setPrintCurrentDisplay("You must request a card rank that is already in your hand.");
    }

    public void printCardNotFound(){
        setPrintCurrentDisplay("Nope. They are not holding any cards of that rank.");
    }

    public void printWhatRankYouWillAskFor(){setPrintCurrentDisplay("\nWhat card rank will you ask for?");}

    public void printOpponentAskedFor(){setPrintCurrentDisplay("Your opponent asked for a...");}

    public void printOpponentTookCard() {setPrintCurrentDisplay("Your opponent took a card from you!\n");}

    public void printHumansFirst() {setPrintCurrentDisplay("Humans play first!\n");
    }

    public void printMadePair() {setPrintCurrentDisplay("\nYou made a pair!");}

    public void printMadePairOpponent() {setPrintCurrentDisplay("\nYour opponent made a pair!");}

    public void printPairsHuman() {setPrintCurrentDisplay("\nCurrent Number of Pairs You Have: ");}

    public void printPairsComputer() {setPrintCurrentDisplay("\nCurrent Number of Pairs Opponent Has: ");}

}
