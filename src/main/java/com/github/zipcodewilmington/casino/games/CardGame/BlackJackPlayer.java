package com.github.zipcodewilmington.casino.games.CardGame;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class BlackJackPlayer implements PlayerInterface {

    private BlackJack currentGame;
    private CasinoAccount casinoAccount;
    protected String ID;
    protected String pwd;
    protected Integer balance;

    public BlackJackPlayer(String ID, String password){
        this.ID = ID;
        this.pwd = password;
        this.balance = 0;
    }

    public String getID() {
        return ID;
    }

    public void addAmount(Integer balance) {
        this.balance += balance;
    }

        private BlackJackPlayer blackJackPlayer;

        public BlackJackPlayer(BlackJackPlayer user) {
            this.blackJackPlayer = user;
        }

        public Boolean placeWager(Integer wagerAmount) {
            if (blackJackPlayer.balance < wagerAmount) { return false; }
            else if ( wagerAmount < 0 ) { return false;}
            else {
                blackJackPlayer.balance -= wagerAmount;
                //this.pot += wagerAmount;
                return true;
            }
        }

        public Integer getBalance(){return blackJackPlayer.balance;}

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> void play() {

    }
        public BlackJackPlayer(CasinoAccount casinoAccount,BlackJack currentGame){
        this.casinoAccount=casinoAccount;
        this.currentGame=currentGame;
    }
}
//    IOConsole console = new IOConsole();
//    CasinoAccount casinoAccount;
//    BlackJack currentGame;
//
//    public Integer getPlayerAmount() {
//        return playerAmount;
//    }
//
//    public void setPlayerAmount(Integer playerAmount) {
//        this.playerAmount = playerAmount;
//    }
//
//    Integer playerAmount;
//
//
//    public BlackJackPlayer(CasinoAccount casinoAccount,BlackJack currentGame){
//        this.casinoAccount=casinoAccount;
//        this.currentGame=currentGame;
//    }
//
//
//
//
//
//    @Override
//    public CasinoAccount getArcadeAccount() {
//        return null;
//    }
//
//    @Override
//    public <SomeReturnType> void play() {
//
//
//    }
