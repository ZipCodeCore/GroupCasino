package models;

import models.games.BlackjackGame;
import models.games.CrapsGame;
import models.games.GoFishGame;
import models.games.KlondikeGame;
import models.people.dealers.Dealer;
import models.people.players.Player;
import services.Console;

public class Lobby {
    Console console = new Console(System.in, System.out);
    Player player;


    public Player checkIn() {
        String name = console.getStringInput("Hello, What is your name?");
        Integer age = console.getIntegerInput("How old are you?");
        Double money = console.getDoubleInput("How much money are you putting on the line today?");
        player = new Player(name, age, money);

        return player;
    }

    public void selectGameMenu() {
        Integer input = console.getIntegerInput(
                "\nHere are the available games:\n\n" +
                        "1. BlackJack\n" +
                        "2. Go Fish\n" +
                        "3. Klondike\n" +
                        "4. Craps\n" +
                        "5. Exit the Casino\n");

        menuActions(input);
    }

    private void menuActions(Integer input) {
        switch (input) {
            case 1:
                BlackjackGame blackjackGame = new BlackjackGame();
                blackjackGame.getMenu();
                break;

            case 2:
                Dealer dealer = new Dealer();
                GoFishGame goFishGame = new GoFishGame(player, dealer);
                goFishGame.getMenu();
                break;

            case 3:
                KlondikeGame klondikeGame = new KlondikeGame();
                klondikeGame.getMenu();
                break;

            case 4:
                CrapsGame crapsGame = new CrapsGame();
                crapsGame.getMenu();
                break;

            case 5:
                console.print("Bye!");
                System.exit(0);
                break;

            default:
                console.print("\nInvalid selection. Please try again.");
                selectGameMenu();
                break;
        }
    }

    public void leaveCasino() {

    }



}
