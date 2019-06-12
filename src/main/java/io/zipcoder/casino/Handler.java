package io.zipcoder.casino;
import io.zipcoder.casino.games.*;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;
//
public class Handler {
    Player player;
    Integer intergerInput;

void run() {
    createPlayer();
    pickGame();



    switch (intergerInput) {
        case 0 :
            Blackjack blackjack = new Blackjack();
            break;
        case 1 :
            GoFish goFish = new GoFish();
            break;
        case 2:
            Roulette roulette = new Roulette();
            break;
        case 3:
            Craps craps = new Craps();
            break;
        case 4:
            Slots slots = new Slots();
            break;
        default:
            System.out.println("you blew it");
    }

}

    public void pickGame() {
    Integer i;
        //console get game
         this.intergerInput = 0;
    }

    public void createPlayer () {
        //console input
        String name = "";
        Double account = 0.0;
        player = new Player(name, account);
    }
}
