package com.github.zipcodewilmington.casino.games.CardGame;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.List;

public class BlackJackPlayer implements PlayerInterface {
private ArrayList<BlackJackPlayer> players= new ArrayList<BlackJackPlayer>();
    Integer balance;
    private BlackJack currentGame;
     CasinoAccount casinoRobinAccount;
     String ID;
     String pwd;

public BlackJackPlayer(){
}



    public BlackJackPlayer(String ID, String password,Integer balance){
        this.ID = ID;
        this.pwd = password;
        this.balance = balance;
    }

    public String getID() {
        return ID;
    }

    public void addAmount(Integer moneyToAdd) {
        this.balance += moneyToAdd;
    }

        private BlackJackPlayer blackJackPlayer;

        public BlackJackPlayer(CasinoAccount casinoRobinAccount, BlackJackPlayer user) {
            this.casinoRobinAccount=casinoRobinAccount;
            this.blackJackPlayer = user;
        }

        public Boolean reduceBalance(Integer wagerAmount) {
            if (blackJackPlayer.balance < wagerAmount) { return false; }
            else if ( wagerAmount < 0 ) { return false;}
            else {
                blackJackPlayer.balance -= wagerAmount;

                return true;
            }
        }

        public Integer getBalance(){return blackJackPlayer.balance;}

    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoRobinAccount;
    }
    public void setArcadeAccount(CasinoAccount casinoRobinAccount) {
        this.casinoRobinAccount = casinoRobinAccount;
    }
    @Override
    public <SomeReturnType> void play() {

    }
//        public BlackJackPlayer(CasinoAccount casinoAccount,BlackJack currentGame){
//        this.casinoAccount=casinoAccount;
//        this.currentGame=currentGame;
//    }
}

