package com.github.zipcodewilmington.casino.games.keno;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by leon on 7/21/2020.
 */
public class KenoGame {

    private ArrayList<Integer> numbers = new ArrayList<>();  //list that holds numbers to guess from
    private ArrayList<Integer> winNumbers = new ArrayList<>();  //list that holds the winning numbers

    public KenoGame(){
        this.numbers =numbers;
        this.winNumbers = winNumbers;
    }

    public KenoGame() {

    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public void setNumbers(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public ArrayList<Integer> getWinNumbers() {
        return winNumbers;
    }

    public void setWinNumbers(ArrayList<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    void getKenoGame(){

    }

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