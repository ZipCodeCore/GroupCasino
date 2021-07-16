package com.github.zipcodewilmington.casino.games.CardGame;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.List;

public class BlackJackPlayer implements PlayerInterface {
private ArrayList<BlackJackPlayer> players= new ArrayList<BlackJackPlayer>();
    Integer balance;
    private BlackJack currentGame;
    private CasinoAccount casinoRobinAccount;
     String ID;
     String pwd;

public BlackJackPlayer(){
}

//public BlackJackPlayer(final List<String>players){
//    players.addAll(players);
//}
//    public void add(BlackJackPlayer player)
//    {
//        players.add(player);
//    }
//public void add(PlayerInterface...players){
//    for(PlayerInterface player: players){
//        this.players.get(player.getArcadeAccount());
//    }
//}

//    private BlackJack currentGame;
//    private CasinoAccount casinoAccount;
//    protected String ID;
//    protected String pwd;
//    protected

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

        public BlackJackPlayer(BlackJackPlayer user) {
            this.blackJackPlayer = user;
        }

        public Boolean reduceBalance(Integer wagerAmount) {
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

