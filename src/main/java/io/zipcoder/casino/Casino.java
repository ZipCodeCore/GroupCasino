package io.zipcoder.casino;


import io.zipcoder.casino.CardGame.BlackJack.Blackjack;
import io.zipcoder.casino.CardGame.GoFish;
import io.zipcoder.casino.DiceGame.Craps;
import io.zipcoder.casino.DiceGame.Yahtzee;
import io.zipcoder.casino.utilities.Console;

public class Casino {
    private static Player player;
    private static Game game;

    public Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Casino.player = player;
    }

    public static void setGame(Game game) {
        Casino.game = game;
    }


    public static void main(String[] args) {
        Casino.run();
    }




    public static void run(){
            Console console = Console.getInstance();
            boolean running = true;

            console.println("                                                           \n" +
                    "⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁ ⚂ ⚃ ⚄ ⚅ ⚀ ⚁\n" +
                    "⚅ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ⚂\n" +
                    "⚄ ♦                                                                     ♠ ⚃\n" +
                    "⚃ ♥  ♠---.             .--♥        ♦        .--♠                        ♣ ⚄\n" +
                    "⚂ ♣     /   ♣         :            |       :               ♣            ♥ ⚅\n" +
                    "⚁ ♠    /    .  ♦,-.   |    .-.  .-.| .-.   |    .-.♦ .--♥  .  .--. .-.  ♦ ⚀\n" +
                    "⚀ ♦   /     |  |   )  :   (   )(   |(.-'   :   (   ) `--.  |  |  |(   ) ♠ ⚁\n" +
                    "⚅ ♥  '---♥-' `-|`-'    `--♥`-'  `-'`♠`--♦   `--♣`-'`-♣--'-' `-♠  `♥`-'  ♣ ⚂\n" +
                    "⚄ ♣            |                                                        ♥ ⚃\n" +
                    "⚃ ♠            ♥                                                        ♦ ⚄\n" +
                    "⚂ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♥ ♦ ♠ ♣ ♠ ⚅\n" +
                    "⚁ ⚀ ⚅ ⚄ ⚃ ⚂ ⚁ ⚀ ⚅ ⚄ ⚃ ⚂ ⚁ ⚀ ⚅ ⚄ ⚃ ⚂ ⚁ ⚀ ⚅ ⚄ ⚃ ⚂ ⚁ ⚀ ⚅ ⚄ ⚃ ⚂ ⚁ ⚀ ⚅ ⚄ ⚃ ⚂ ⚁ ⚀\n");

            String name = console.getStringInput("Welcome to the Zip Code Casino!  What is your name?");
            Double wallet = console.getDoubleInput("\nThanks for playing, %s!  How much money will you be gambling?", name);
            Casino.setPlayer(new Player(name, wallet));

            while (running) {
                console.println("\nWhat game would you like to play, %s?", name);
                String gameToPlay = console.getStringInput("We have Blackjack, Craps, Yahtzee, and Go Fish!");

                if (gameToPlay.toLowerCase().equals("yahtzee")) {
                    Casino.setGame(new Yahtzee(player));
                    Casino.game.play();
                } else if (gameToPlay.toLowerCase().equals("craps")) {
                    Casino.setGame(new Craps());
                    Casino.game.play();
                } else if (gameToPlay.toLowerCase().equals("blackjack")) {
                    Casino.setGame(new Blackjack());
                    Casino.game.play();
                } else if (gameToPlay.toLowerCase().equals("go fish")) {
                    Casino.setGame(new GoFish());
                    Casino.game.play();
                } else {
                    console.println("Invalid Game!  Try again!");
                }
            }


    }

}
