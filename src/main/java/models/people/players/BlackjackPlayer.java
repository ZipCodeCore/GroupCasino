package models.people.players;

import Interfaces.GamblingPlayer;
import models.gamecomponents.Card;
import models.hands.BlackjackHand;

public class BlackjackPlayer implements GamblingPlayer {
    Player blackjackPlayer;
    BlackjackHand hand = new BlackjackHand();

    public BlackjackPlayer(Player player) {
        this.blackjackPlayer = player;
    }

    public Double placeBet() {
        return null;
    }

    public Card hit() {
        return null;

    }

    public Boolean stay() {
        return null;

    }


}
