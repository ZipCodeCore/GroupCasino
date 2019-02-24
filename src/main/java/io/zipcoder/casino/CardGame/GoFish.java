package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.Player;

public class GoFish extends CardGame {
    private GoFishPlayer goFishPlayer;
    private GoFishPlayer dealer;
    private int playersFourOfAKind;
    private int dealersFourOfAKind;

//    // Player's hand
//    public Hand playersHand;
//
//    // Dealer's hand
//    public Hand dealersHand;


    public GoFish(Player player) {

        this.goFishPlayer = new GoFishPlayer(player);

        this.dealer = new GoFishPlayer( new Player("dealer", 0.0));


    }
    //While (!((player.hand is empty || Dealer.hand is empty) && deck is Empty))
    // The two go Fish players are passed to the play method.
    //Deal cards- Deck.deal (7) -> returns array list of cards.

    //Player's turn
    //Display hand  call show method. = showHand Method
    //Call IO console  to take input from the player which card they want to request.
    //Request for card
    // Boolean check Hand (player/Dealer, enum face)

    //If (checkHand) { // ***
    // ArrayList <Cards> cardsToReturn = new ArrayList(); // get all the cards with the requested face
    //for (Card c: dealer/player.hand) { // add all the cards to the player's hand
    // if (c.getFace == Enum face){
    // cardsToReturn.add(c);
    //dealer/player hand.remove(c) } } // also remove those cards from the dealers hand
    //Boolean checkForFourOfAKind (Players/Dealers hand)
    // If (check for four of a kind) {
    // increment  playersFourOfAKind; or  dealersFourOfAKind; counter
    // remove the cards (4 of a kind ) from players hand.
    // Else continue to Dealer's turn.
    // }

    //Dealers's turn
    // get dealers' hand size
    // random index  and return the face of the card. The requested card

   // IO console: Display message t the player that the Dealer requested the "face".

    // Check player's hand to see if it contains the requested card face enum.
    // Boolean check Hand (player/Dealer, enum face)

    // IO Console : if true then display message to the player saying that all the suits of the requested face will be added to the dealers hand.


    //If (checkHand) {
    // ArrayList <Cards> cardsToReturn = new ArrayList();
    //for (Card c: dealer/player.hand) {
    // if (c.getFace == Enum face){
    // cardsToReturn.add(c);
    //dealer/player hand.remove(c) }
    //Boolean checkForFourOfAKind (Players/Dealers hand)
    // If (check for four of a kind) {
    // increment  playersFourOfAKind; or  dealersFourOfAKind; counter
    // remove the cards (4 of a kind ) from dealers hand.


    //Else --> Go fish --> dealer.draw from the deck // Need to check if deck.size > 0, else deck is empty.
    //Add card to the dealer's hand
    //Check for four of a kind




    //Else  -> Go Fish -> player.draw from the deck // else for the first If (checkHand) ***
    //Add the card to the Player's Hand.
    //If the face of draw equals the face requested then // Request for Card  and continue
    //Else Dealer's turn


    //if playersFourOfAKind  >  dealersFourOfAKind
    //Player wins
    //else Dealer wins



    public void play () {

        GoFishPlayer goFishPlayer;
        GoFishPlayer dealer;


    }



    public void walkAway() {

    }


}
