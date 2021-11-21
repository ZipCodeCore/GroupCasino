package com.github.zipcodewilmington.casino.games.cardGames;


import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.Collections;

public class War implements GameInterface {

    createDeck deck = new createDeck();
    private Double balance;
    private Double wager;
    private PlayerInterface warPlayer;
    private Double player2Bet;
    private IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);
    private int numberOfPlayers;
    private String player1Name;
    private int player1Score;
    private int player2Score;
    Cards player1Card = deck.cardsStack.pop();
    Cards player2Card = deck.cardsStack.pop();
    private Rank player1CardRank;
    private Rank player2CardRank;
    private String choice;


    public War(CasinoAccount casinoAccount) {
        warPlayer = new WarPlayer(casinoAccount);
        balance = warPlayer.getArcadeAccount().getBalance();
    }

    // this method states the rules of the game
    public String warRules() {

        return ("Welcome to the game of War.\n\nEach player will get dealt a " +
                "card. Whoever has the higher \nvalue card wins that round, and gets awarded " +
                "one point. In \nthe event of a tie, no points will be rewarded and both " +
                "\nplayers will play again. The winner is the first player to \nscore ten points.\n");

    }

    // this method determines how many players will play
    // if 1 player, then player 2 is "computer".
//    public void howManyPlayers() {
//
////        IOConsole consoleAuto = new IOConsole(AnsiColor.AUTO);
//
//
//        int userInput;
//
//        do {
//            consoleAuto.println("How many players will be playing?");
//            userInput = consoleAuto.getIntegerInput("Please select 1 or 2 players.");
//            numberOfPlayers = userInput;
//            // sets the input to numberOfPlayers
//            // defines how many players there will be to be used in following
//
//            if (numberOfPlayers != 1 && numberOfPlayers != 2) {
//                numberOfPlayers = 0;
//                consoleAuto.println("That's not a valid amount.");
//            }
//        }
//        while (numberOfPlayers == 0);
//
//    }


    // this method takes in and set players names
    public String enterNames(String player1) {

        player1Name = player1;

        return player1Name;
    }

    // this method creates a new deck and shuffles
    public createDeck shuffle(createDeck deck) {
        Collections.shuffle(deck.cardsStack);

        return deck;
    }

    public Double placeWager(Double balance, String choice) {


        consoleAuto.println(player1Name + ", your current balance is " + balance);
        Double amountWagered = Double.parseDouble(choice); // converting choice to a Double called amountWagered

            if (amountWagered > balance) {
                amountWagered = consoleAuto.getDoubleInput("You do not have enough money for that wager. Please place wager again.");
            } else if (amountWagered < 0) {
                amountWagered = consoleAuto.getDoubleInput("Sorry, but that is not a valid amount to wager. Please enter a wager more than zero.");
            } else if (amountWagered == 0) {
                amountWagered = consoleAuto.getDoubleInput("C'mon, that's no fun. Please enter a valid wager amount.");
            } else if (amountWagered <= balance) {
                wager = amountWagered; // setting amountWagered to global var wager in order to use in other methods
            }

        return amountWagered;
    }


    public String dealCards(String deal) {

        consoleAuto.println("Let's flip over our cards.");
        consoleAuto.println("\n" + player1Name + " draws a " + player1Card); // print player1card
        consoleAuto.println("Computer draws a " + player2Card); // print player2card

        return "";
    }

    // this method determines winner of each individual round
    public String determineRoundWinner(Cards player1Card, Cards player2Card, Double wager) {

        String result = "";
        player1CardRank = player1Card.getRank();
        player2CardRank = player2Card.getRank();
        Integer player1Value = player1CardRank.getFirstValue();
        Integer player2Value = player2CardRank.getFirstValue();
        this.wager = wager;

        if (player1Value > player2Value) {

            result = "\n" + player1Name + " has won this round!";
            consoleAuto.println(result);
            player1Score++;
//            System.out.println(player1Score);
            balance = balance + wager;
            consoleAuto.println("\n" + player1Name + " now has a balance of " + balance);
            consoleAuto.println("\n" + player1Name + " now has won " + player1Score + " rounds.\n");

        } else if (player1Value < player2Value) {
            // if 2 is higher than 1, 2 wins, and one point added to score for player 2

            result = "\nComputer has won this round!";
            consoleAuto.println(result);
            player2Score++;
            balance = balance - wager;
            consoleAuto.println("\n" + player1Name + " now has a balance of " + balance);
            consoleAuto.println("\nComputer now has won " + player2Score + " rounds.\n");

        } else if (player1Value == player2Value) {
            // this is a tie. neither players gets a point

            result = "\nIt was a tie.\n";
            consoleAuto.println(result);
            player1Card = deck.cardsStack.pop();
            player2Card = deck.cardsStack.pop();
        }
        return result;

    }

    // this method declares a winner for whoever reached 10 points first
    public String determineGameWinner(int player1Score, int player2Score) {
        String result = "";
        if (player1Score >= 10) {
            consoleAuto.println("\n" + player1Name + " has won the game!\n");
            result = "\n" + player1Name + " has won the game!\n";
            player1Score = 0;
            player2Score = 0;
        } else if (player2Score >= 10) {
            consoleAuto.println("\nComputer has won the game!\n");
            result = "\nComputer has won the game!\n";
            player2Score = 0;
            player1Score = 0;
        }
        return result;
    }

//    public void keepPlaying() {
//        consoleAuto.println("Would you like to play again?");
//        String answer = consoleAuto.getStringInput("Please type in YES or NO.");
//
//        if (answer.equalsIgnoreCase("YES")) {
//            System.out.println(" ");
//            runGame();
//        } else if (answer.equalsIgnoreCase("NO")) {
//            System.out.println(" ");
//            // todo quit game return to main menu
//        } else {
//            do {
//                consoleAuto.println("Would you like to play again?");
//                answer = consoleAuto.getStringInput("Please type in YES or NO.");
//            }
//            while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));
//        }
////        return;
//    }


    @Override
    public void add(PlayerInterface player) {
        this.warPlayer = player;
    }

    @Override
    public void remove(PlayerInterface player) {
        this.warPlayer = null;
    }

    @Override
    public void run() {
        // where you have game running

        balance = warPlayer.getArcadeAccount().getBalance();

        War war = new War(warPlayer.getArcadeAccount());
        consoleAuto.println("\n" +
                "                                                                                                \n" +
                "                                                                                                \n" +
                "WWWWWWWW                           WWWWWWWW               AAA               RRRRRRRRRRRRRRRRR   \n" +
                "W::::::W                           W::::::W              A:::A              R::::::::::::::::R  \n" +
                "W::::::W                           W::::::W             A:::::A             R::::::RRRRRR:::::R \n" +
                "W::::::W                           W::::::W            A:::::::A            RR:::::R     R:::::R\n" +
                " W:::::W           WWWWW           W:::::W            A:::::::::A             R::::R     R:::::R\n" +
                "  W:::::W         W:::::W         W:::::W            A:::::A:::::A            R::::R     R:::::R\n" +
                "   W:::::W       W:::::::W       W:::::W            A:::::A A:::::A           R::::RRRRRR:::::R \n" +
                "    W:::::W     W:::::::::W     W:::::W            A:::::A   A:::::A          R:::::::::::::RR  \n" +
                "     W:::::W   W:::::W:::::W   W:::::W            A:::::A     A:::::A         R::::RRRRRR:::::R \n" +
                "      W:::::W W:::::W W:::::W W:::::W            A:::::AAAAAAAAA:::::A        R::::R     R:::::R\n" +
                "       W:::::W:::::W   W:::::W:::::W            A:::::::::::::::::::::A       R::::R     R:::::R\n" +
                "        W:::::::::W     W:::::::::W            A:::::AAAAAAAAAAAAA:::::A      R::::R     R:::::R\n" +
                "         W:::::::W       W:::::::W            A:::::A             A:::::A   RR:::::R     R:::::R\n" +
                "          W:::::W         W:::::W            A:::::A               A:::::A  R::::::R     R:::::R\n" +
                "           W:::W           W:::W            A:::::A                 A:::::A R::::::R     R:::::R\n" +
                "            WWW             WWW            AAAAAAA                   AAAAAAARRRRRRRR     RRRRRRR\n");

        System.out.println(war.warRules());
//        war.howManyPlayers();
        this.choice = consoleAuto.getStringInput("Player, please enter your name:");
        war.enterNames(choice);


        do {
            war.shuffle(deck);
            this.choice = consoleAuto.getStringInput("Please enter your wager amount.");
            war.placeWager(5000.0, choice);
            war.dealCards("");
            war.dealCards("");

            war.determineRoundWinner(player1Card, player2Card, wager);
            war.determineGameWinner(player1Score, player2Score);
            String keepPlaying = "";
            keepPlaying = consoleAuto.getStringInput("Would you like to play again? Please press any key to continue, or type [no] to quit.");
            if (keepPlaying.equalsIgnoreCase("no")) {
                break;
            }
        } while (true);

    }
} // class War closing bracket