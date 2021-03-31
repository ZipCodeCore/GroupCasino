package io.zipcoder.casino;

public class GoFishDisplay extends Display{

    // GAME START MESSAGING
    public void printGoFishRules(){
        setPrintCurrentDisplay("GO FISH RULES:\n"+
                "Two players will be dealt 5 cards each to begin.\n"+
                "The object of the game is to have the most pairs.\n"+
                "A player creates a pair by asking the other player if they have cards of a specific rank in their hand.\n" +
                "If the other player is holding cards of the requested rank, they must hand them over.\n"+
                "You can only request card ranks that you already have in your hand.\n" +
                "Game play continues until the deck is empty.\n"+
                "Humans play first!\n");
    }

    // TURN SEPARATORS
    public void printTurnSeparator(int deckSize, String currentPlayer) {
        setPrintCurrentDisplay("\n=================================================================================="+
                "\nCARDS REMAINING IN DECK: " + deckSize+
                "\nCURRENT PLAYER: " + currentPlayer);
    }

    // FOR PRINTING PLAYER'S CARDS
    public void printPlayersHand(String playersHand) {
        setPrintCurrentDisplay("\nCARDS IN YOUR HAND:\n"+
                playersHand);
    }

    // ASKING FOR CARDS
    public void printWhatRankYouWillAskFor(){
        setPrintCurrentDisplay("\nWhat card rank will you ask for?");
    }

    public void printInvalidRankRequested() {
        setPrintCurrentDisplay("You must request a card rank that is already in your hand.");
    }

    public void printComputerAskedFor(String rankRequested){
        setPrintCurrentDisplay("\nComputer Requested Rank: " + rankRequested);
    }

    // TAKING CARDS
    public void printPlayerTookCard(){
        setPrintCurrentDisplay("That card rank is in the computer's hand! It will now be given to you!\n"+
                "You get to play another turn!");
    }

    public void printComputerTookCard() {
        setPrintCurrentDisplay("You have the requested rank in your hand! The computer has taken it from you!\n"+
                "The computer gets to play another turn!");
    }

    // GO FISH
    public void printComputerSaysGoFish(String cardDrawnRank){
        setPrintCurrentDisplay("\nTHE COMPUTER SAYS: GO FISH!\nRank Drawn: " + cardDrawnRank + ".");
    }

    public void printTellComputerGoFish() {
        setPrintCurrentDisplay("\nYOU TOLD THE COMPUTER TO GO FISH!\nThe Computer has drawn a card from the deck.");
    }

    public void printAnotherTurn() {
        setPrintCurrentDisplay("\nCard drawn from deck is same rank as that requested. Current player gets another turn.");
    }

    // PAIRS
    public void printNumPairsPlayer(String rankRemoved, int numPairsPlayer) {
        setPrintCurrentDisplay("\nYay! You made a pair of rank " + rankRemoved + "!\nCurrent Number of Pairs You Have: " + numPairsPlayer);
    }

    public void printNumPairsComputer(String rankRemoved, int numPairsComputer) {
        setPrintCurrentDisplay("\nThe Computer made a pair of rank " + rankRemoved + "!\nCurrent Number of Pairs Computer Has: " + numPairsComputer);
    }

    public void printRanOutOfCards() {
        setPrintCurrentDisplay("\nEmpty hand - one card drawn from deck.");
    }


    // FINAL GAME RESULTS
    public void printGameOver() {
        setPrintCurrentDisplay("\nGAME OVER");
    }
    public void printPlayerWinner() {
        setPrintCurrentDisplay("\nCongratulations, you WIN!!!");
    }

    public void printComputerWinner() {
        setPrintCurrentDisplay("\nSorry, the computer BEAT you!");
    }

    public void printTiedGame() {
        setPrintCurrentDisplay("\nYou TIED with the computer!");
    }

}
