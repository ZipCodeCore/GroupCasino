package models.people.players;

import models.gamecomponents.Card;
import models.hands.GoFishHand;

public class GoFishPlayer extends Player {
    Player goFishPlayer;
    GoFishHand hand = new GoFishHand();

    public GoFishPlayer(Player player) {
        this.goFishPlayer = player;
    }

    public Integer askForCard(){
        return null;
    }

    public Card drawCard() {
        return null;
    }

    public Card giveCard() {
        return null;
    }

}
