package io.zipcoder.casino.blackjack;

import io.zipcoder.casino.Player;

// implements Game
public class BlackJackGame {
    //declare a field of type Player named dealer
    //declare a field of type Player named player
    //declare a field of type Deck named deck
    //declare a field of type double named playerBet
    //declare a field of type BlackJackConsole named console

    //create a constructor that takes in a
    // CardPlayer, Deck, and BlackJackConsole
    // set the fields to the params

    // create a constructor that takes in a
    // CardPlayer and a BlackJackConsole
    // set the fields to the params
    // Create a new Deck and set it to the deck field


    //create a method named play with no return type or parameter
    public void play(){
        //deal cards
        //show player their cards
        // ask them how much they want to bet
        // store the result in the playerBet
        //call takeTurn(player)
        //call takeTurn(dealer)
        //check if the player win by calling
        //BlackJackRule.getResult and give it
        // the player hand and the dealer hand
        // if the result return "win"
        // then addMoney to the player with
        // the playerBet amount
        // if result return "lose" then
        // ask the player to pay the playerBet amount
        // print dealer hand
        // print the player hand
        // call console.printResult with
        // the result and playerBet

    }

    //create a method named deal with no return type
    public void deal(Deck deck, CardPlayer... players){

    }

    //create a method named takeTurn that takes in
    //player and return nothing
    // the method will:
        //in a while loop
        // ask if they want to draw
        // if they say no, exit the loop
        // else add a card to the player hand
        // call BlackJackRule to checks if
        // it's busted?
        // if it's busted, exit the loop

}
