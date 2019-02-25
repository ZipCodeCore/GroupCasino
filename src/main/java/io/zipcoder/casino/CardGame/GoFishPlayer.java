package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;
import io.zipcoder.casino.CardGame.Cards.Face;
import io.zipcoder.casino.Player;

import javax.swing.*;
import java.util.ArrayList;

import static io.zipcoder.casino.CardGame.Cards.Face.*;

public class GoFishPlayer {
    private Hand hand;
    private String name;
    private Player player;

    // Four of a kind counter
    private int counter4;

    //Array list to store player's 4 of a kind stacks
    private ArrayList<Card> player4OfAKind;


    //Array to store the faces of the 4 of a kind stacks
    private ArrayList<Card> dealer4OfAKind;

    private Deck deck;

    private ArrayList<Card> firstHand; // Player's/Dealer's Initial Hand
    private ArrayList<Card> remainingDeck;

    private ArrayList<Card> cardsToReturn;
    private  ArrayList<Card> newHand;

    // Constructor

    public GoFishPlayer(Player player) {

        this.name = player.getName();


    }


    //A player is requesting  a particular Face of Card from the opponent.
    //Once the particular face enum is requested, check opponents hand for that face if true return all the cards in opponents hands having the same face to the requesting player's hand.
    public void requestCard(Enum requestFace) {


    }

    // The player draws the card from the middle deck.
    // Draw method in the Hand that can be used by Go Fish Player.
    //Draws only one card from the deck. If the deck is empty then .......we still need to figure out.
//    public void draw() {
//
//
//    }

    // Provided that the player has the face requested the player gives all the cards to the opponent.
    public void removeCardFromHand(ArrayList<Card> cards) {


    }

    // Provided that a player has a particular face 4 times the player can lay stack of 4 of a kind.
    public void layFourOfAKindCards(Enum face4, Hand playersHand) {


    }

    // The method to allocate the first hand to each of the players and setting aside the the remaining to the middle deck. 7 cards for each of the two players.
    // The deal method will be created in the Deck class and the go fish player/dealer will call the deal method passing 7 as a parameter.
    // And get back the array list of the 7 cards that will be set to the players/dealers hand.
//    public ArrayList allocateFirstHand(Deck deck) {
//
//        return firstHand;
//    }

    // The method returns the remaining middle deck. full deck -
    // (player's hand + dealer's hand + all four of a kind stacks)
    // Might not need it. It can be taken care by the Deck class.
//    public ArrayList getRemainingDeck() {
//
//
//        return remainingDeck;
//    }

    // Checks the players hand for the face passed through the parameters  and return the array list of cards with the same face and return null if the face do not exist in the player's Hand
    public ArrayList<Card> cardsToReturn(Hand playersHand, Enum faceInHand) {

        return cardsToReturn;

    }

    // Method adds the Array list of cards in the parameters to the hand and returns all the cards in that hand
    public ArrayList<Card> addCardsToHands(ArrayList<Card> cardsToAdd){ //Hand playersHand) {

        hand.addCardsToHand(cardsToAdd);

         return hand.showMyCards();


    }

    // Checks the player/dealers' hand for 4 of a kind cards and returns a boolean
    public int checkForFourOKind (GoFishPlayer player , Hand hand){

        //int len = hand.getSize; // the getSize might be defined in the Hand Class.

        boolean bool = false;

        int fourOfaKindCounter =0;

        ArrayList <Card>  cardsInHand = player.hand.showMyCards();

        int aceCounter =0, jackCounter=0, kingCounter=0,queenCounter=0, twoCounter=0, threeCounter=0, fourCounter=0, fiveCounter=0, sixCounter=0, sevenCounter=0,eightCounter=0, nineCounter=0, tenCounter = 0;


        for (Card card: cardsInHand) {

            Face face = card.getFace();

            switch (face) {

                case ACE:

                    aceCounter++;
                    break;

                case JACK:
                    jackCounter++;
                    break;

                case KING:
                    kingCounter++;
                    break;

                case QUEEN:
                    queenCounter++;
                    break;

                case TWO:
                    twoCounter++;
                    break;

                case THREE:
                    threeCounter++;
                    break;

                case FOUR:
                    fourCounter++;
                    break;

                case FIVE:
                    fiveCounter++;
                    break;

                case SIX:
                    sixCounter++;
                    break;

                case SEVEN:
                    sevenCounter++;
                    break;

                case EIGHT:
                    eightCounter++;
                    break;

                case NINE:
                    nineCounter++;
                    break;

                case TEN:
                    tenCounter++;
                    break;

            }

            if (aceCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

            else if (kingCounter == 4) {

                bool = true;
                fourOfaKindCounter++;
            }
            else if (queenCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

            else if (jackCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

            else if (twoCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

            else if (threeCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

            else if (fourCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

            else if (fiveCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

            else if (sixCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

            else if (sevenCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

            else if (eightCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

            else if (nineCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }


            else if (tenCounter==4) {

                bool = true;
                fourOfaKindCounter++;
            }

        }

        return fourOfaKindCounter;



    }


    // The show method shows the hand of a particular player/dealer
//    System.out.println('\u2665');// hearts
//    System.out.println('\u2666');//Diamond
//    System.out.println('\u2660'); //Spade
//    System.out.println('\u2663'); // club

    public void showHand() {

        hand.showMyCards(); //getHand method needs to be defined



    }


}
