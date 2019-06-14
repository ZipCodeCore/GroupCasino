package io.zipcoder.casino.games;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.player.SlotsPlayer;

import java.lang.reflect.Array;

public class Slots extends Games implements GamblerGameInterface {
    Integer numOfLines;
    SlotsPlayer slotsPlayer = new SlotsPlayer();
    private Double currentBet;

    public Player player;

    Integer random = 0;
    String[] characters = new String[]{"cherry ", "orange ", "bell   ", "bars   ", "apple  ", "seven  "};

    String[][] toSave = new String[3][3];



    public Slots() {
    }

    public Slots(Player player) {
        this.player = player;
    }

//    public static void main(String[] args) {
//        Slots bestSlot = new Slots();
//
//        int max = bestSlot.characters.length;
//        int min = 1;
//        int range = max - min + 1;
//
//
//
//        // generate random numbers within 1 to 6
//        for (int i = 0; i <= 2; i++) {
//            for (int j = 0; j <= 2; j++) {
//                int rand = (int) (Math.random() * range);
//                System.out.print(bestSlot.characters[rand]);
//                bestSlot.toSave[i][j] = bestSlot.characters[rand];
//
//            }
//
//            System.out.println();
//        }
//
//        for (int i = 0; i <bestSlot.characters.length ; i++) {
//            bestSlot.checkIfWin(bestSlot.characters[i]);
//        }
//
//
//    }
//
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
//                }
//
//            }
//
//            if (countHor == 3) {
//                System.out.println("You won  "+ fruit);
//            } else {
//                countHor = 0;
//
//            }
//
//
//        }
//        if (countDiag1 == 3) {
//
//            System.out.println("You won "+fruit);
//        }
//        if (countDiag2 == 3) {
//
//            System.out.println("You won "+fruit);
//        }
//
//
//        System.out.println();
//       // System.out.println("one more time?!");
//       return 9;
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
        return null;
    }

    public void withdraw(Double num) {

    }

    public void deposit(Double num) {

    }

    public void updateAccount(Double num) {

    }
}
