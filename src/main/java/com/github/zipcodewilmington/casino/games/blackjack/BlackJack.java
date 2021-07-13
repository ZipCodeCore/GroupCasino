package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.models.Card;

import java.util.*;

public class BlackJack implements GameInterface, PlayerInterface {
    List<Integer> playersHand;
    List<Integer> dealersHand;
    Deque<Integer> deckOfCards;
    Double betAmount; // Equal to user input

    public BlackJack () {
        this.playersHand = new ArrayList<>();
        this.dealersHand = new ArrayList<>();
        this.deckOfCards = new ArrayDeque<>(generateNewDeck());
    }

    public List<Integer> generateNewDeck () {
        Card card = new Card();
        return card.getCardPool();
    }

    public List<Integer> givePlayerCard () {
        Integer valueOfCard = deckOfCards.pop();
        this.playersHand.add(valueOfCard);
        return this.playersHand;
    }

    public List<Integer> giveDealerCard () {
        Integer valueOfCard = deckOfCards.pop();
        this.dealersHand.add(valueOfCard);
        return this.dealersHand;
    }

    public Integer playersCurrentValue () {
        givePlayerCard();
        Integer sum = 0;
        for (int i = 0; i < this.playersHand.size(); i++) {
           sum += this.playersHand.get(i);
        }
        return sum;
    }

    public Integer dealersCurrentValue () {
        giveDealerCard();
        Integer sum = 0;
        for (int i = 0; i < this.dealersHand.size(); i++) {
            sum += this.dealersHand.get(i);
        }
        return sum;
    }

    public void playerBroke21 () {
       
    }

    public List<Integer> getPlayersHand() {
        return playersHand;
    }

    public void setPlayersHand(List<Integer> playersHand) {
        this.playersHand = playersHand;
    }

    public List<Integer> getDealersHand() {
        return dealersHand;
    }

    public void setDealersHand(List<Integer> dealersHand) {
        this.dealersHand = dealersHand;
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }

    @Override
    public Double calculateWinnings(Double multiplier, Double betAmount) {
        return null;
    }

    @Override
    public void subtractBetFromBalance(Double betAmount) {

    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Double winnings) {

    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}
