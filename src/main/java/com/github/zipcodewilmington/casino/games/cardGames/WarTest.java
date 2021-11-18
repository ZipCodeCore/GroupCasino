//package com.github.zipcodewilmington.casino.games.cardGames;
//
//import com.github.zipcodewilmington.utils.AnsiColor;
//import com.github.zipcodewilmington.utils.IOConsole;
//
//import javax.smartcardio.Card;
//
//public class WarTest {
//    public static void main(String[] args) {
//
//
//
//
//        // create new deck
//        // shuffle deck
////        callDeck(); todo
//
//        consoleAuto.println("Welcome to the game of War.\n\nEach player will get dealt a " +
//                "card. Whoever has the higher value card wins that round, and gets awarded " +
//                "one point. The winner is the first player to score ten points.");
//
//        // perform this gameplay loop while neither player has yet scored ten points.
//        while (player1Score < 10 && player2Score < 10) {
//            // introduction to game and rules
//            consoleAuto.println("\nLet's get started.");
//            // create new deck method
//            // shuffle deck method
//
//
//            // players get assigned cards
////            player1Card = deck.getNextCard(); // player1 gets next card
////            player2Card = deck.getNextCard(); // player2 gets next card
//
//            // displaying results
//            consoleAuto.println("Results:");
//            consoleRed.println("Player 1: " + player1Card);
//            consoleGreen.println("Player 2: " + player2Card);
//
//            // if 1 is higher than 2, 1 wins, and add 1 to player1 score
//            if (player1Card > player2Card) {
//                consoleAuto.println("\nPlayer 1 has won this round.\n");
//                player1Score++;
//                consoleAuto.println("Player 1 now has " + player1Score + " points.");
//            } else if (player2Card > player1Card) {
//                // if 2 is higher than 1, 2 wins, and one point added to score for player 2
//                consoleAuto.println("\nPlayer 2 has won this round.\n");
//                player2Score++;
//                consoleAuto.println("Player 2 now has " + player2Score + " points.");
//            } else if (player1Card == player2Card) {
//                // this is a tie. neither players gets a point
//                consoleAuto.println("\nIt was a tie. Let's deal again.\n");
//            }
//
//
//        }
//
//        while (player1Score >= 10) {
//            consoleAuto.println("Congratulations to Player 1!");
//        }
//        while (player2Score >= 10) {
//            consoleAuto.println("Congratulations to Player 2!");
//        }
//
//
//    } // psv main bracket
//} // class bracket
