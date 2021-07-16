package com.github.zipcodewilmington.casino.player;


//import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.card.Deck;
import com.github.zipcodewilmington.casino.card.Hand;
import com.github.zipcodewilmington.casino.games.Blackjack;

public class BlackJackPlayer extends Player implements PlayerInterface {

   private Hand hand = new Hand();

    private Deck deck = new Deck();
    private Blackjack blackjack = new Blackjack();
    private Casino casino = new Casino();
    private Player player;
    CasinoAccount casinoAccount;
    private int bet;

    public BlackJackPlayer(Player player, CasinoAccount casinoAccount) {
        this.player = player;
        this.casinoAccount = casinoAccount;
    }

    public BlackJackPlayer() {

   }

    public Player getPlayer() {
        return this.player;
    }

    public void getWinnings() {
        player.setPlayerBalance(casinoAccount.getPlayerBalance() + (bet));
    }


    @Override
    public CasinoAccount getArcadeAccount() {
        return casinoAccount;
    }

    public void setArcadeAccount() {
        this.casinoAccount = casinoAccount;
    }

//    @Override
//    public <SomeReturnType> SomeReturnType play() {
//        return null;
//    }
}


