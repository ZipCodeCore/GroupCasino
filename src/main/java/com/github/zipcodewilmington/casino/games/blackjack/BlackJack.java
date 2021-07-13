package com.github.zipcodewilmington.casino.games.blackjack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.models.Card;

import java.util.*;

public class BlackJack implements GameInterface, PlayerInterface {
    Card card = new Card();
    List<Integer> playersHand;
    List<Integer> dealersHand;
    Deque<Integer> deckOfCards = new LinkedList<>(generateNewDeck(52));

    public BlackJack () {
        this.playersHand = new ArrayList<>();
        this.dealersHand = new ArrayList<>();
    }

    public List<Integer> generateNewDeck (Integer numberOfCards) {
        card.createDeck(numberOfCards);
        card.polishDeck();
        card.shuffleDeck();
        return card.getCardPool();
    }

    public List<Integer> givePlayerCard () {
        Integer valueOfCard = deckOfCards.pop();
        this.playersHand.add(valueOfCard);
        return this.playersHand;
    }

    public Integer playersCurrentValue () {
        Integer sum = 0;
        for (int i = 0; i < this.playersHand.size(); i++) {
           sum += this.playersHand.get(i);
        }
        return sum;
    }

    public void ahhWork () {}

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
