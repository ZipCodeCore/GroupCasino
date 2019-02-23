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


    public GoFish(Player player){

        this.goFishPlayer =  new GoFishPlayer(player);


        //this.dealer = new GoFishPlayer( new Player("dealer", 0.0)); // Cara is adding the Player Constructor.


    }

   // The two go Fish players are passed to the
    public void play() {






    }

    public void walkAway() {

    }


}
