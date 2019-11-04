package models.games;

import models.gamecomponents.DeckOfCards;
import models.people.dealers.Dealer;
import models.people.players.Player;

abstract class CardGame {
    DeckOfCards deckOfCards;
    Dealer dealer;
    Player player;

    public CardGame() {
    }

    public CardGame(DeckOfCards deckOfCards, Dealer dealer, Player player) {
        this.deckOfCards = deckOfCards;
        this.dealer = dealer;
        this.player = player;
    }

    public void startGame() {

    }

    public Boolean determineWin() {
        return null;
    }

    public void quitGame() {

    }

    public void getMenu() {

    }

}
