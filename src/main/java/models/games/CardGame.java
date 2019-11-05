package models.games;

import models.Lobby;
import models.gamecomponents.DeckOfCards;
import models.people.dealers.Dealer;
import models.people.players.Player;
import services.Console;

abstract class CardGame {
    private DeckOfCards deckOfCards;
    private Dealer dealer;
    private Player player;
    // made a new object called console cause Console class had getIntegerInput which was static
    Console console = new Console(System.in, System.out);

    public CardGame() {
    }

    public CardGame(DeckOfCards deckOfCards, Dealer dealer, Player player) {
        this.deckOfCards = deckOfCards;
        this.dealer = dealer;
        this.player = player;
    }


    public Boolean determineWin() {
        return null;
    }

    public void quitGame() {
        Lobby lobby = new Lobby();
        lobby.selectGameMenu();
    }





}
