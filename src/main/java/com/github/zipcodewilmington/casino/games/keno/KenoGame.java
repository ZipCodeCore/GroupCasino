package com.github.zipcodewilmington.casino.games.keno;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by leon on 7/21/2020.
 */
public class KenoGame {

    private ArrayList<Integer> numbers = new ArrayList<>();  //list that holds numbers to guess from
    private ArrayList<Integer> winNumbers = new ArrayList<>();  //list that holds the winning numbers




    Scanner sc = new Scanner(System.in);

    public ArrayList<Integer> setKenoGame(){
        //create the array of answers to guess from

        for(int i = 1; i <= 80; i++){
            numbers.add(i);
        }
        return numbers;
    }
    //generate winning numbers to play
    public ArrayList<Integer> generateNumbers(){

        while (winNumbers.size() < 20){
            int winNum = (int)(Math.random() * 80 + 1);
            if (winNumbers.indexOf(winNum) == -1){
                winNumbers.add(winNum);
            }
        }
        return winNumbers;
    }
     public int[] userInput(){
        boolean player = true;
        boolean invalidNumber = true;
        int playerNumbers[] = new int[20];
        int numberEntered;

        for (int i = 0; i < playerNumbers.length; i++){
            playerNumbers[i] = 0;
        }
        int i = 0;
        while (player && i < 20){
            numberEntered = sc.nextInt();

            if(numberEntered > 1 && numberEntered < 80){
                if(isUnique(numberEntered,playerNumbers)){
                    invalidNumber = false;
                    playerNumbers[i] = numberEntered;
                }else {
                    invalidNumber = true;
                }
            }

        }


         return playerNumbers;
     }

    //check whether the number is unique or not
    public boolean isUnique(int number,int[] array){
        for (int i = 0; i < array.length; i++){
            if (number ==array[i]){
                return false;
            }
        }
        return true;
    }

    // generate the numbers for the computer. numbers are generated randomly
    public int[] getComputerNum(){
        int[] computerNum = new int[20];
        Random r = new Random();
        int randomNumber = 0;

        for (int i = 0; i < computerNum.length; i++){
            randomNumber = r.nextInt(80) + 1;
            if(isUnique(randomNumber,computerNum)){
                computerNum[i] = randomNumber;
            }else {
                i++;
            }
        }
        return computerNum;

    }

}