package io.zipcoder.casino;
import io.zipcoder.casino.games.*;
import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

public class Handler {
void run() {
    String input = "";
    Integer intergerInput = 0;

    //Console console = new Console();
    Player player = new Player();

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
}
