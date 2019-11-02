package io.zipcoder.casino.Services;

import io.zipcoder.casino.Blackjack.BlackjackGame;
import io.zipcoder.casino.Craps.CrapsGame;
import io.zipcoder.casino.GoFish.GoFishGame;
import io.zipcoder.casino.GameObject;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.RR.RRGame;
;
import java.util.HashMap;

public class GameRepo {

    public static final int NUM_ADULT_GAMES = 3;
    public static final int NUM_KID_GAMES = 1;
    private HashMap<Integer, GameObject> gamesMap;

    public GameRepo(Player player) {
        int counter = 1;
        this.gamesMap = new HashMap<Integer, GameObject>();
        this.gamesMap.put(counter,new GoFishGame(player));
        counter++;
        if (player.getAge() >= 21) {
            this.gamesMap.put(counter,new BlackjackGame(0.0, 0.0, 1,player));
            counter++;
            this.gamesMap.put(counter,new CrapsGame(player));
            counter++;
            this.gamesMap.put(counter,new RRGame());
            counter++;
        }

    }

    public HashMap<Integer, GameObject> getGamesMap() {
        return this.gamesMap;
    }

}
