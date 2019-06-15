package io.zipcoder.casino.games;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.SlotsPlayer;
import io.zipcoder.casino.utilities.Console;

import java.lang.reflect.Array;
import java.util.Random;

public class Slots extends Games implements GamblerGameInterface {
    Integer numOfLines;
    SlotsPlayer slotsPlayer;
    private Double currentBet;
    public Console console;


    public Player player;

    Integer random = 0;
    String[] characters = new String[]{"cherry ", "orange ", "bell   ", "bars   ", "apple  ", "seven  "};
    //   String[] characters = new String[]{"cherry ", "cherry ", "cherry ", "cherry ", "cherry ", "cherry "};
    String[][] toSave = new String[3][3];


    public Slots() {
    }

    public Slots(SlotsPlayer player, Console console) {
        this.slotsPlayer = player;
        this.console = console;
    }

    public static void main(String[] args) {


// public void runGame() {
//       display("Welcome to the slots " +slotsPlayer.player.getName() + "! \n");
        Slots bestSlot = new Slots();

        int max = bestSlot.characters.length;
        int min = 1;
        int range = max - min + 1;


        // generate random numbers within 1 to 6
    // Random rnd = new Random();
        // rnd.setSeed(2L);
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                int rand = (int) (Math.random() * range);
                System.out.print(bestSlot.characters[rand]);
                bestSlot.toSave[i][j] = bestSlot.characters[rand];

            }

            System.out.println();
        }

//
//      for (int i = 0; i < bestSlot.characters.length; i++) {
//           bestSlot.checkIfWin(bestSlot.characters[i]);
//      }
//     endGame();
          bestSlot.CheckWins();
    }

    public void CheckWins() {
        int countPaylines = 0;
        int bet = 5;

        if (bet >= 1) {
            if (toSave[1][0] == toSave[1][1] && toSave[1][1] == toSave[1][2]) {
                System.out.println();
                System.out.println("you won horizontal middle");
                countPaylines++;
            }
        }
        if (bet >= 3) {
            if (toSave[0][0] == toSave[0][1] && toSave[0][1] == toSave[0][2]) {
                System.out.println();
                System.out.println("you won horizontal top");
                countPaylines++;
            }
            if (toSave[2][0] == toSave[2][1] && toSave[2][1] == toSave[2][2]) {
                System.out.println();
                System.out.println("you won horizontal bottom");
                countPaylines++;
            }
        }
        if (bet >= 5) {
            if (toSave[2][0] == toSave[1][1] && toSave[1][1] == toSave[0][2]) {
                System.out.println();
                System.out.println("you won diagonally right");
                countPaylines++;
            }
            if (toSave[0][0] == toSave[1][1] && toSave[1][1] == toSave[2][2]) {
                System.out.println();
                System.out.println("you won diagonally left ");
                countPaylines++;
            }

        }

//        bestSlots.
    }


//    public Integer checkIfWin(String fruit) {
//        int countDiag1 = 0;
//        int countDiag2 = 0;
//        int countHor = 0;
//        for (int i = 0; i < toSave.length; i++) {
//            for (int j = 0; j < toSave.length; j++) {
//
//                if (i == j && toSave[i][j] == fruit) {
//                    countDiag1 += 1;
//                }
//                if (i + j == 2 && toSave[i][j] == fruit) {
//                    countDiag2 += 1;
//                }
//                if (toSave[i][j] == fruit) {
//                    countHor += 1;
//
//
//                }
//
//                if (countHor == 3) {
//                    System.out.println("You won " + fruit + "horizontally");
////                calcPayment();
////                System.out.print(calcPayment(currentBet, getOdds()));
//
//                } else {
//                    countHor = 0;
//
//                }
//
//
//            }
//            if (countDiag1 == 3) {
//
//                System.out.println("You won " + fruit + "diagonally ");
////            calcPayment();
////            System.out.print();
//
//            }
//            if (countDiag2 == 3) {
//
//                System.out.println("You won " + fruit + "diagonally");
////            calcPayment();
////            System.out.print(calcPayment());
//
//            }
//
//
//            System.out.println();
//            // System.out.println("one more time?!");
//
//
//        }
//        return 9;
//    }


    @Override
    void nextTurn() {
    }

    @Override
    void endGame() {

    }

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        super.display(output);
    }

    public Integer calcPayment(Integer bet, Integer odds) {
        return null;
    }

    public void updateAccount(Integer num) {

    }

    public Double getCurrentBet() {
        return currentBet;
    }

    public void setCurrentBet(Double currentBet) {
        this.currentBet = currentBet;
    }

    public Double calcPayment(Double bet, Double odds) {
        return bet * odds;
    }

    public void withdraw(Double num) {

    }

    public void deposit(Double num) {

    }

    public void updateAccount(Double num) {

    }
}
