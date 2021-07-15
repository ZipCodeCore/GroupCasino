package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.CardGame.BlackJack;
import com.github.zipcodewilmington.casino.games.CardGame.CasinoWar;
import com.github.zipcodewilmington.casino.games.CrapsGame.CrapsGame;
import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import com.github.zipcodewilmington.casino.games.keno.KenoPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.roulette.RouletteGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.*;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole consoleBlue = new IOConsole(AnsiColor.BLUE);
    private final IOConsole consoleCyan = new IOConsole(AnsiColor.CYAN);
    private final IOConsole consoleRed = new IOConsole(AnsiColor.RED);


    @Override
    public void run() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        Integer arcadeDashBoardInput;
        printSign1();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if (2 == arcadeDashBoardInput) {
                String accountName = consoleBlue.getStringInput("Enter your account name:");
                String accountPassword = consoleBlue.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                String gameSelectionInput = getGameSelectionInput().toUpperCase();

                switch (gameSelectionInput) {
                    case "KENO":
                        if (casinoAccount.getAge() < 18) {
                            consoleRed.println("You are not old enough to play this game!");
                        }
                        else {
                            KenoGame kenoGame = new KenoGame();
                            play(kenoGame, new KenoPlayer(casinoAccount, kenoGame));
                        }
                        break;

                    case "SLOTS":
                        if (casinoAccount.getAge() < 18) {
                            consoleRed.println("You are not old enough to play this game!");

                        }
                        else {
                            SlotsGame slotsGame = new SlotsGame();
                            play(slotsGame, new SlotsPlayer());
                        }
                        break;

                    case "BLACKJACK":
                        if (casinoAccount.getAge() < 18) {
                            consoleRed.println("You are not old enough to play this game!");
                        }
                        else {
                            BlackJack blackJack = new BlackJack();
                            //play(blackJack, new BlackJackPlayer());
                        }
                        break;

                    case "NUMBERGUESS":
                        NumberGuessGame numberGuessGame = new NumberGuessGame();
                        play(numberGuessGame, new NumberGuessPlayer());
                        break;

                    case "WAR":
                        CasinoWar war = new CasinoWar();
                        play(war, new CasinoWar());
                        break;

                    case "ROULETTE":
                        if (casinoAccount.getAge() < 18) {
                            consoleRed.println("You are not old enough to play this game!");
                        }
                        else {
                            RouletteGame rouletteGame = new RouletteGame();
                            //play(rouletteGame, new RoulettePlayer());
                        }
                        break;

                    case "CRAPS":
                        if (casinoAccount.getAge() < 18) {
                            consoleRed.println("You are not old enough to play this game!");
                        }
                        else {
                            CrapsGame crapsGame = new CrapsGame();
                            //play(crapsGame, new CrapsPlayer());
                        }
                        break;

                    default:
                        consoleRed.println("[ %s ] is an invalid game selection", gameSelectionInput);
                    }
                } else {
                    // TODO - implement better exception handling
                    consoleRed.println("No account found with name of [ %s ] and password of [ %s ]", accountName, accountPassword);
                }
            } else if (1 == arcadeDashBoardInput) {
                consoleBlue.println("Welcome to the account-creation screen.");
                String accountName = consoleBlue.getStringInput("Enter your account name:");
                String accountPassword = consoleBlue.getStringInput("Enter your account password:");
                Integer accountAge = consoleBlue.getIntegerInput("Enter your account age");
                Integer accountBalance = consoleBlue.getIntegerInput("Enter your account balance");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword, accountAge, accountBalance);
                casinoAccountManager.registerAccount(newAccount);
            }
        } while (3 != arcadeDashBoardInput);
    }

    private Integer getArcadeDashboardInput() {
        return consoleBlue.getIntegerInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t1. create account  2. select game  3. logout")
                .toString());
    }

    private String getGameSelectionInput() {
        return consoleBlue.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ SLOTS ], [ NUMBERGUESS ], [ KENO ], [ ROULETTE ]," +
                        "[ BLACKJACK ], [ WAR ], [ CRAPS ]")
                .toString());
    }

    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface)gameObject;
        PlayerInterface player = (PlayerInterface)playerObject;
        game.add(player);
        game.run();
    }

    private void printSign() {
        StringBuilder builder = new StringBuilder();
        builder.append("♡ ♡ ♡ ♡ ♡               ♡          ♡                  ♡        ♡                             ♡ ♡ ♡ ♡ ♡    ♡    ♡                     ♡\n");
        builder.append("♡       ♡               ♡                               ♡    ♡                               ♡       ♡    ♡                          ♡\n");
        builder.append("♡ ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡    ♡    ♡ ♡ ♡ ♡           ♡♡    ♡ ♡ ♡ ♡    ♡     ♡           ♡ ♡ ♡ ♡      ♡    ♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡\n");
        builder.append("♡     ♡      ♡     ♡    ♡     ♡    ♡    ♡     ♡           ♡♡    ♡     ♡    ♡     ♡           ♡       ♡    ♡    ♡    ♡     ♡    ♡     ♡\n");
        builder.append("♡       ♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡    ♡    ♡     ♡           ♡♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡           ♡ ♡ ♡ ♡ ♡    ♡    ♡    ♡     ♡    ♡ ♡ ♡ ♡\n");
        consoleCyan.println(builder.toString());
    }

    private void printSign1() {
        StringBuilder builder = new StringBuilder();
        builder.append("♠ ♠ ♠ ♠ ♠               ♠          ♠                  ♠        ♠                             ♠ ♠ ♠ ♠ ♠    ♠    ♠                     ♠\n");
        builder.append("♠       ♠               ♠                               ♠    ♠                               ♠       ♠    ♠                          ♠\n");
        builder.append("♠ ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠    ♠ ♠ ♠ ♠           ♠♠    ♠ ♠ ♠ ♠    ♠     ♠           ♠ ♠ ♠ ♠      ♠    ♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠\n");
        builder.append("♠     ♠      ♠     ♠    ♠     ♠    ♠    ♠     ♠           ♠♠    ♠     ♠    ♠     ♠           ♠       ♠    ♠    ♠    ♠     ♠    ♠     ♠\n");
        builder.append("♠       ♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠    ♠     ♠           ♠♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠           ♠ ♠ ♠ ♠ ♠    ♠    ♠    ♠     ♠    ♠ ♠ ♠ ♠\n");
        consoleCyan.println(builder.toString());
    }
}
