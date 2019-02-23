package io.zipcoder.casino.Cards.Games;

import io.zipcoder.casino.Cards.Card;
import io.zipcoder.casino.Cards.Deck;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.utilities.Displayer;

import java.util.List;

public class GoFish extends Game {
    private GoFishPlayer dealer = new GoFishPlayer();
    private GoFishPlayer user = new GoFishPlayer();
    private Deck deck = new Deck();
    private boolean isOver = false;
    private Displayer console = new Displayer();

    public int playGame() {
        dealStartingHands();
        console.displayCards(user.getHand());
        evaluate();
        while (!isOver) {
            dealerTurn();
            console.displayCards(dealer.getHand());
            evaluate();
            userTurn();
            evaluate();
        }
        return -5;
    }

    private void dealerTurn() {
        tryForUserCard();
        playPairs();
    }

    private void playPairs() {
        if (dealer.hasPairs()) {
            List<Card> pairs = dealer.getPairs();
            console.announcePlayingCards();
            console.displayCards(pairs);
        }
    }

    private void tryForUserCard() {
        String askedFor = dealer.getRandomCard().getRank().toString();
        boolean hasCard = console.askForCard(askedFor);
        if (user.handContains(askedFor)) {
            if (!hasCard) { console.accuse();}
            takeCards(askedFor);
        } else if (!user.handContains(askedFor) && hasCard) {
            console.accuse();
            goFish(dealer);
        } else {
            goFish(dealer);
        }
    }

    private void takeCards(String askedFor) {
        List<Card> takenCards = user.getCards(askedFor);
        console.takeUserCard();
        console.displayCards(takenCards);
        dealer.addToHand(takenCards);
    }

    private void dealStartingHands() {
        dealer.setHand(deck.drawMultipleCards(5));
        user.setHand(deck.drawMultipleCards(5));
    }

    private void userTurn() {
        console.displayCards(user.getHand());
        String answer = console.goFishTurn();
        boolean hasCard = dealer.handContains(answer);
        dealerResponse(hasCard, answer);
        if(user.hasPairs()) {
            pairTurn();
        }
    }

    private void dealerResponse(boolean hasCard, String answer) {
        if (hasCard) {
            List<Card> givenCards = dealer.getCards(answer);
            user.addToHand(givenCards);
            console.announceCardGiven(answer, givenCards.size());
        } else {
            Card card = deck.drawCard();
            user.addToHand(card);
            console.announceGoFish(answer, card);
        }
    }

    private void pairTurn() {
        boolean playingPair = console.playPair();
        if(playingPair) {
            console.displayCards(user.getHand());
            String playPairs = console.getPairToPlay();
            List<Card> playedPairs = user.getCards(playPairs);
            if(playedPairs.size() == 0) {
                console.notAPair();
                pairTurn();
            } else if (user.hasPairs()) {
                pairTurn();
            }
        }
    }

    public void goFish(GoFishPlayer player) {
        Card card = deck.drawCard();
        player.addToHand(card);
    }

    private void evaluate() {
        if(user.handSize() == 0) {
            console.congradulate();
            isOver = true;
        } else if (dealer.handSize() ==0) {
            console.goodGame();
            isOver = true;
        }
    }


}
