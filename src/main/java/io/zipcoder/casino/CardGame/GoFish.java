package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;
import io.zipcoder.casino.CardGame.Cards.Face;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.ArrayList;
import java.util.Random;

public class GoFish extends CardGame {
    private GoFishPlayer goFishPlayer;
    private GoFishPlayer dealer;
    private int playersScoreCounter;
    private int dealersScoreCounter;

    private Deck deck;

//    // Player's hand
//    public Hand playersHand;
//
//    // Dealer's hand
//    public Hand dealersHand;


    public GoFish(Player player) {

        this.goFishPlayer = new GoFishPlayer(player);

        this.dealer = new GoFishPlayer(new Player("dealer", 0.0));

        this.deck = new Deck(1);

        this.deck.shuffle();


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


    public void play() {

        // GoFishPlayer goFishPlayer;
        //GoFishPlayer dealer;

        String faceRequested = "";

        goFishPlayer.getHand().addCardsToHand(deck.deal(7));

        goFishPlayer.fourOfAKindFinder();

        playersScoreCounter = goFishPlayer.getCounter4();

        dealer.getHand().addCardsToHand(deck.deal(7));

        dealer.fourOfAKindFinder();

        dealersScoreCounter = dealer.getCounter4();

        Console console = Console.getInstance();

        while (!((goFishPlayer.getHand().getSize() == 0 || dealer.getHand().getSize() == 0) && deck.deckSize() == 0)) { // the getter size method is included in the Hand class

            //Players Turn
            // goFishPlayer.getHand().toString();

            boolean playersTurn = true;

            while (playersTurn) {
                Face face1;

                console.println(goFishPlayer.getHand().toString());
                // console.println("Please enter the face of the card you want to request");
                faceRequested = console.getStringInput("Please enter the face of the card you want to request");
                face1 = Face.valueOf(faceRequested);

                boolean bool1 = dealer.isCardsToReturn(face1);

                if (bool1) {

                    goFishPlayer.requestCard(dealer, face1);

                    goFishPlayer.fourOfAKindFinder();

                    playersScoreCounter = goFishPlayer.getCounter4();
                } else {

                    console.println("Go Fish, Draw a Card from the Deck");
                    goFishPlayer.getHand().drawCard(deck);

                    goFishPlayer.fourOfAKindFinder();

                    playersScoreCounter = goFishPlayer.getCounter4();

                    if (getLastCard(goFishPlayer).getFace().equals(face1)) {

                        console.println("The Card you drew is the face you requested so go again");
                        //console.getStringInput("Please enter the face of the card you want to request", faceRequested);


                    } else {

                        playersTurn = false;
                    }


                }

            }
            boolean dealersTurn = true;

            //Dealer's turn

            while (dealersTurn) {

                Face face2;

                int len = dealer.getHand().getSize();

                Random random = new Random();
                Integer indexOfCard = random.nextInt(len - 1);

                Card cardToRequest = dealer.getHand().showMyCards().get(indexOfCard);

                face2 = cardToRequest.getFace();

                console.println("The dealer requested the face " + face2.getFaceValue());

                boolean bool2 = dealer.isCardsToReturn(face2);

                if (bool2) {

                    console.println("You have the face card(s) the dealer requested. The cards will be added to the dealer's hand");

                    dealer.requestCard(goFishPlayer, face2);

                    dealer.fourOfAKindFinder();

                    dealersScoreCounter = dealer.getCounter4();
                } else {

                    console.println("Go Fish, Dealer will Draw a Card from the Deck");
                    dealer.getHand().drawCard(deck);

                    dealer.fourOfAKindFinder();

                    dealersScoreCounter = dealer.getCounter4();

                    if (getLastCard(dealer).getFace().equals(face2)) {

                        console.println("The Dealer drew the face they requested so gets to go again");
                        //console.getStringInput("Please enter the face of the card you want to request", faceRequested);


                    } else {

                        dealersTurn = false;
                    }


                }
            }
        }


        if (dealersScoreCounter > playersScoreCounter) {

            console.println("You Loose, Better Luck Next Time");
        } else {

            console.println("Congratulations! You Win");
        }


    }


    public Card getLastCard(GoFishPlayer player) {

        ArrayList<Card> cards = player.getHand().showMyCards();

        Card cardLast = player.getHand().showMyCards().get(cards.size() - 1);


        return cardLast;
    }


    public void walkAway() {

    }


}
