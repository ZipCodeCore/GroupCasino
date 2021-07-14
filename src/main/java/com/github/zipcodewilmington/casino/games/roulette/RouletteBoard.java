package com.github.zipcodewilmington.casino.games.roulette;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RouletteBoard {
    public int ball;
    List<Integer> boardBlack;
    List<Integer> boardRed;
    Integer[] red;
    Integer[] black;

    public RouletteBoard(){
        Integer[] red ={1,3,5,7,9,12,14,16,18,19,21,23,25,27,30,32,34,36};
        Integer[]black = {2,4,6,8,10,11,13,15,17,20,22,24,26,28,29,31,33,35};
        ball= (int)(Math.random()*36+1);
    }
    public void blackAndRedArrays(){
            List<Integer> boardBlack = Arrays.asList(black);
            List<Integer> boardRed = Arrays.asList(red);
    }




}
