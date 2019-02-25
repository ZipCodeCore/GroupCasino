package io.zipcoder.casino.CardGame;

import io.zipcoder.casino.CardGame.Cards.Card;
import io.zipcoder.casino.CardGame.Cards.Deck;
import io.zipcoder.casino.CardGame.Cards.Face;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import javax.swing.*;
import java.util.ArrayList;

import static io.zipcoder.casino.CardGame.Cards.Face.*;

public class GoFishPlayer {
    private Hand hand;
    private String name;
    private Player player;

    // Four of a kind counter
    private int counter4 = 0;


    private Deck deck;


    //private ArrayList<Card> cardsToReturn;

    // Constructor

    public GoFishPlayer(Player player) {

        this.name = player.getName();
        this.player = player;
        this.hand = new Hand(new ArrayList<Card>());


    }

    public int getCounter4() {
        return counter4;
    }

    public Hand getHand() {
        return hand;
    }

    public Player getPlayer() {
        return player;
    }

    public String getName() {
        return name;
    }

    // method return boolean to check whether the opponent has the requested face
    public boolean isCardsToReturn(Face faceRequested) {

        boolean bool = false;

        for (Card card : hand.showMyCards()) {

            if (card.getFace().equals(faceRequested)) {


                bool = true;
            }
        }

        return bool;

    }


    //A player is requesting  a particular Face of Card from the opponent.
    //Once the particular face enum is requested, check opponents hand for that face if true return all the cards in opponents hands having the same face to the requesting player's hand.
    public void requestCard(GoFishPlayer otherPlayer, Face face) {

        ArrayList<Card> cardsInHand = otherPlayer.hand.showMyCards();

        ArrayList<Card> cardsToRemove = new ArrayList<Card>();


        for (Card card : cardsInHand) {

            if (card.getFace().equals(face)) {

                cardsToRemove.add(card);
            }

        }

        otherPlayer.getHand().removeCardsFromHand(cardsToRemove);
        hand.addCardsToHand(cardsToRemove);

    }


    // Provided that a player has a particular face 4 times the player can lay stack of 4 of a kind.
    public void layDown4OfAKind(Face face4) {

        ArrayList<Card> fourOfAKind = new ArrayList<>();
        for (Card c : hand.showMyCards()) {
            if (c.getFace().equals(face4)) {
                fourOfAKind.add(c);
            }
        }

        hand.removeCardsFromHand(fourOfAKind);
        counter4++;


    }


    public Integer[] getCardCountInHand() {
        Integer[] counter = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};


        for (Card card : hand.showMyCards()) {

            Face face = card.getFace();

            switch (face) {

                case ACE:

                    counter[0]++;
                    break;

                case TWO:
                    counter[1]++;
                    break;

                case THREE:
                    counter[2]++;
                    break;

                case FOUR:
                    counter[3]++;
                    break;

                case FIVE:
                    counter[4]++;
                    break;

                case SIX:
                    counter[5]++;
                    break;

                case SEVEN:
                    counter[6]++;
                    break;

                case EIGHT:
                    counter[7]++;
                    break;

                case NINE:
                    counter[8]++;
                    break;

                case TEN:
                    counter[9]++;
                    break;

                case JACK:
                    counter[10]++;
                    break;

                case QUEEN:
                    counter[11]++;
                    break;

                case KING:
                    counter[12]++;
                    break;
            }
        }
        return counter;
    }

    public void fourOfAKindFinder() {

        Integer[] cardCounter = getCardCountInHand();

        for (int i = 0; i < 13; i++) {
            if (cardCounter[i] == 4) {
                if (i == 0) {
                    layDown4OfAKind(Face.ACE);
                }
                if (i == 1) {
                    layDown4OfAKind(Face.TWO);
                }
                if (i == 2) {
                    layDown4OfAKind(Face.THREE);
                }
                if (i == 3) {
                    layDown4OfAKind(Face.FOUR);
                }
                if (i == 4) {
                    layDown4OfAKind(Face.FIVE);
                }
                if (i == 5) {
                    layDown4OfAKind(Face.SIX);
                }
                if (i == 6) {
                    layDown4OfAKind(Face.SEVEN);
                }
                if (i == 7) {
                    layDown4OfAKind(Face.EIGHT);
                }
                if (i == 8) {
                    layDown4OfAKind(Face.NINE);
                }
                if (i == 9) {
                    layDown4OfAKind(Face.TEN);
                }
                if (i == 10) {
                    layDown4OfAKind(Face.JACK);
                }
                if (i == 11) {
                    layDown4OfAKind(Face.QUEEN);
                }
                if (i == 12) {
                    layDown4OfAKind(Face.KING);
                }
            }
        }
    }


    // The show method shows the hand of a particular player/dealer
//    System.out.println('\u2665');// hearts
//    System.out.println('\u2666');//Diamond
//    System.out.println('\u2660'); //Spade
//    System.out.println('\u2663'); // club

    // Kyle is working on re-writing the ToString method to print

//    public void showHand() {
//
//        hand.showMyCards(); //showMyCards method needs to be defined in the Hand Class.
//
//        Console console = Console.getInstance();
//
//       console.print(hand.toString());
//
//
//
//
//
//    }


}
