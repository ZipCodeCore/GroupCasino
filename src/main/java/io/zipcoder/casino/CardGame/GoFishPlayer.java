package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

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

    private ArrayList<Card> cardsToGive;
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
//    public void draw() {
//
//
//    }

    // Provided that the player has the face requested the player gives all the cards to the opponent.
    public void giveCard(ArrayList<Card> cards) {


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
    public ArrayList<Card> checkHandForFace(Hand playersHand, Enum faceInHand) {

        return cardsToGive;

    }

    // Method adds the Array list of cards in the parameters to the hand and returns all the cards in that hand
    public ArrayList<Card> addCardsToHand(ArrayList<Card> cardsToAdd, Hand playersHand) {

        return newHand;


    }


}
