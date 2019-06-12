package io.zipcoder.casino.games;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.Deck;
import io.zipcoder.casino.player.GoFishPlayer;
import io.zipcoder.casino.player.GoFishPlayerNPC;

public class GoFish extends Games {
    GoFishPlayer player1 = new GoFishPlayer();
    GoFishPlayerNPC player2 = new GoFishPlayerNPC();
    Deck deck = new Deck();
    private Integer player1Score;
    private Integer player2Score;

    public GoFish() {
        super();
        this.player1Score = 0;
        this.player2Score = 0;
    }


    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        super.display(output);
    }

    public Card check (Integer query) {
        return null;
    };

    public Card goFish () {
        return null;
    };
}
