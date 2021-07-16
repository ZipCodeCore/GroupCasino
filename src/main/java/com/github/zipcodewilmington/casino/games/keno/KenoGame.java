package com.github.zipcodewilmington.casino.games.keno;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class KenoGame implements GameInterface {




    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public int getNumberOfPlayers() {
        return 0;
    }

    @Override
    public boolean playerWins() {
        return false;
    }

    @Override
    public boolean playerLoses() {
        return false;
    }

    @Override
    public void clearGame() {

    }

    @Override
    public void run() {
        guessNumbers();
        if(getCatch(userInput(),getComputerNum()) > 0)
        {
            System.out.println("You Win");
        }


    }


        //create the array of answers to guess from
        //will create numbers from 1 to 80
        public ArrayList<Integer> guessNumbers() {
            System.out.println("Welcome to Keno Game");
            System.out.println("***       *** ***      ***");
            ArrayList<Integer> nums = new ArrayList<>(); //list that holds numbers to guess from
            for (int i = 1; i <= 80; i++) {
                nums.add(i);
            }
            return nums;
        }

        //will be all of the numbers that the user entered this function initially sets all the numbers in the array to 0
        //
        public int[] userInput() {
            boolean player = true;
            boolean invalidNumber = true;
            int playerNumbers[] = new int[5];
            int numberEntered;
            Scanner sc = new Scanner(System.in);

            for (int i = 0; i < playerNumbers.length; i++) {
                System.out.println("Enter" + i +  "Number");
                while (player && i < 20) {
                numberEntered = sc.nextInt();
                if (numberEntered > 1 && numberEntered < 80) {
                    if (isUnique(numberEntered, playerNumbers)) {
                        invalidNumber = false;
                        playerNumbers[i] = numberEntered;
                        } else {
                            invalidNumber = true;
                        }
                    }
                }
            }
            return playerNumbers;
        }

        //check whether the number is unique or not
        public boolean isUnique ( int number, int[] array){
            for (int i = 0; i < array.length; i++) {
                if (number == array[i]) {
                    return false;
                }
            }
            return true;

        }

        // generate the numbers for the computer. numbers are generated randomly
        public int[] getComputerNum () {
            int[] computerNum = new int[20];
            Random r = new Random();
            int randomNumber = 0;

            for (int i = 0; i < computerNum.length; i++) {
                randomNumber = r.nextInt(80) + 1;
                if (isUnique(randomNumber, computerNum)) {
                    computerNum[i] = randomNumber;
                } else {
                    i++;
                }
            }
            return computerNum;
        }

        //return the catch which is how many of user's number matched to the computer's
        public int getCatch(int[] playerNumber, int[] computerNumber){

            int kenoCatch = 0;
            for (int i = 0; i < playerNumber.length; i++) {
                for (int j = 0; j < computerNumber.length; j++) {
                    if (playerNumber[i] == computerNumber[j]) {
                        kenoCatch++;
                    }
                }
            }
            return kenoCatch;

    }
}
