package models.games;

import models.Lobby;
import models.gamecomponents.DeckOfCards;
import models.people.dealers.Dealer;
import models.people.players.Player;
import services.Console;
import services.PlayerRepo;

abstract class CardGame {
    DeckOfCards deckOfCards;
    Dealer dealer;
    Player player;
    PlayerRepo playerRepo;
    // made a new object called console cause Console class had getIntegerInput which was static
    Console console = new Console(System.in, System.out);

    public CardGame() {
    }

    public CardGame(DeckOfCards deckOfCards, Dealer dealer, Player player, PlayerRepo playerRepo) {
        this.deckOfCards = deckOfCards;
        this.dealer = dealer;
        this.player = player;
        this.playerRepo = playerRepo;
    }


    public Boolean determineWin() {
        return null;
    }

    public void quitGame() {
        Lobby lobby = new Lobby(playerRepo);
        lobby.selectGameMenu();
    }





}
