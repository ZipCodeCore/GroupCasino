package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.CasinoAccountManager;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.keno.KenoGame;
import com.github.zipcodewilmington.casino.games.keno.KenoPlayer;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessGame;
import com.github.zipcodewilmington.casino.games.numberguess.NumberGuessPlayer;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

/**
 * Created by leon on 7/21/2020.
 */
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        printSign1();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                Integer numberOfPlayers = console.getIntegerInput("How many players?");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {
                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    if (gameSelectionInput.equals("SLOTS")) {
                        play(new SlotsGame(), new SlotsPlayer());
                    } else if (gameSelectionInput.equals("NUMBERGUESS")) {
                        play(new NumberGuessGame(), new NumberGuessPlayer());
                    } else if (gameSelectionInput.equals("KENO")) {
                        KenoGame kenoGame = new KenoGame();
                        play(kenoGame, new KenoPlayer(casinoAccount, kenoGame));
                    } else {
                        // TODO - implement better exception handling
                        String errorMessage = "[ %s ] is an invalid game selection";
                        throw new RuntimeException(String.format(errorMessage, gameSelectionInput));
                    }
                } else {
                    // TODO - implement better exception handling
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, getUsernameAndPassword().getPassword(), getUsernameAndPassword().getUsername()));
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                console.println("Welcome to the account-creation screen.");
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                Integer accountAge = console.getIntegerInput("Enter your account age");
                Double accountBalance = console.getDoubleInput("Enter your account balance");
                CasinoAccount newAccount = casinoAccountManager.createAccount(accountName, accountPassword, accountAge, accountBalance);
                casinoAccountManager.registerAccount(newAccount);
            }
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t1. create account  2. select game ")
                .toString());
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
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

    private CasinoAccount getUsernameAndPassword() {
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        String accountName = console.getStringInput("Enter your account name:");
        String accountPassword = console.getStringInput("Enter your account password:");
        CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
        return casinoAccount;
    }

    private void printSign() {
        IOConsole sign = new IOConsole(AnsiColor.CYAN);
        StringBuilder builder = new StringBuilder();
        builder.append("♡ ♡ ♡ ♡ ♡               ♡          ♡                  ♡        ♡                             ♡ ♡ ♡ ♡ ♡    ♡    ♡                     ♡\n");
        builder.append("♡       ♡               ♡                               ♡    ♡                               ♡       ♡    ♡                          ♡\n");
        builder.append("♡ ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡    ♡    ♡ ♡ ♡ ♡           ♡♡    ♡ ♡ ♡ ♡    ♡     ♡           ♡ ♡ ♡ ♡      ♡    ♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡\n");
        builder.append("♡     ♡      ♡     ♡    ♡     ♡    ♡    ♡     ♡           ♡♡    ♡     ♡    ♡     ♡           ♡       ♡    ♡    ♡    ♡     ♡    ♡     ♡\n");
        builder.append("♡       ♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡    ♡    ♡     ♡           ♡♡    ♡ ♡ ♡ ♡    ♡ ♡ ♡ ♡           ♡ ♡ ♡ ♡ ♡    ♡    ♡    ♡     ♡    ♡ ♡ ♡ ♡\n");
        sign.println(builder.toString());
    }

    private void printSign1() {
        IOConsole sign = new IOConsole(AnsiColor.CYAN);
        StringBuilder builder = new StringBuilder();
        builder.append("♠ ♠ ♠ ♠ ♠               ♠          ♠                  ♠        ♠                             ♠ ♠ ♠ ♠ ♠    ♠    ♠                     ♠\n");
        builder.append("♠       ♠               ♠                               ♠    ♠                               ♠       ♠    ♠                          ♠\n");
        builder.append("♠ ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠    ♠ ♠ ♠ ♠           ♠♠    ♠ ♠ ♠ ♠    ♠     ♠           ♠ ♠ ♠ ♠      ♠    ♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠\n");
        builder.append("♠     ♠      ♠     ♠    ♠     ♠    ♠    ♠     ♠           ♠♠    ♠     ♠    ♠     ♠           ♠       ♠    ♠    ♠    ♠     ♠    ♠     ♠\n");
        builder.append("♠       ♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠    ♠    ♠     ♠           ♠♠    ♠ ♠ ♠ ♠    ♠ ♠ ♠ ♠           ♠ ♠ ♠ ♠ ♠    ♠    ♠    ♠     ♠    ♠ ♠ ♠ ♠\n");
        sign.println(builder.toString());
    }
}
