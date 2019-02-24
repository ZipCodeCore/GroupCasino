package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.Player;

public class GoFish extends CardGame {
    private GoFishPlayer goFishPlayer;
    private GoFishPlayer dealer;
    private int playersFourOfAKind;
    private int dealersFourOfAKind;

    // Player's hand
    public Hand playersHand;

    // Dealer's hand
    public Hand dealersHand;


    public GoFish(Player player) {

        this.goFishPlayer = new GoFishPlayer(player);


        //this.dealer = new GoFishPlayer( new Player("dealer", 0.0)); // Cara is adding the Player Constructor.


    }
    //While ((player.hand is empty || Dealer.hand is empty) && deck is Empty)
    // The two go Fish players are passed to the play method.
    //Deal cards- Deck.deal (7) -> returns array list of cards.

    //Player's turn
    //Display hand  call show method.
    //Call IO console  to take input from the player which card they want to request.
    //Request for card
    // Boolean check Hand (player/Dealer, enum face)

    //If (checkHand) {
    // ArrayList <Cards> cardsToReturn = new ArrayList();
    //for (Card c: dealer/player.hand) {
    // if (c.getFace == Enum face){
    // cardsToReturn.add(c);
    //dealer/player hand.remove(c) }

    //Dealers's turn
    // get dealers' hand size
    // random index between 

    //Else  -> Go Fish -> player.draw from the deck
    //If the face of draw equals the face requested then // Request for Card  and continue


    public void play() {


    }

    // The show method shows the hand of a particular player/dealer
//    System.out.println('\u2665');// hearts
//    System.out.println('\u2666');//Diamond
//    System.out.println('\u2660'); //Spade
//    System.out.println('\u2663'); // club

    public void showHand(GoFishPlayer player) {


    }

    public void walkAway() {

    }


}
