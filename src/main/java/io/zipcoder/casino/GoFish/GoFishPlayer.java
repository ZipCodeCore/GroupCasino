package io.zipcoder.casino.GoFish;

import io.zipcoder.casino.Card;
import io.zipcoder.casino.CardSet;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;


import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class GoFishPlayer {

    private Player player;
    private Console console = new Console(System.in, System.out);

    public GoFishPlayer(Player player){
        this.player = player;

    }

    public Player getPlayer() {
        return player;
    }

    public String chooseCard(CardSet hand) {
        ArrayList<String> ranks = new ArrayList<String>();
        for (Card card : hand.getCards()) {
            ranks.add(card.getRank());
        }
        String input = "";
        while (true) {
            input = console.getCardRankInput("");
            if (ranks.contains(input)) {
                return input;
            }
        }
    }


}
