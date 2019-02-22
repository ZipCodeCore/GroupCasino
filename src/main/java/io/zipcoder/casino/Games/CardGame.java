package io.zipcoder.casino.Games;

import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Models.Card;
import io.zipcoder.casino.Models.CardDeck;
import io.zipcoder.casino.Players.Player;

public abstract class CardGame implements Game {

    private Player player;
    private CardDeck gameDeck;

    public void shuffleDeck(){

    }

    public void collectCards(){

    }

    public Player getPlayer(){
        return null;
    }

    public void setPlayer(Player player){

    }

    public CardDeck getDeck(){
        return null;
    }

    public abstract Card deal();

}
