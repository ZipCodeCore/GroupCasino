package com.github.zipcodewilmington.casino.games.plinko;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PlinkoGame implements GameInterface,PlayerInterface {
    private Map<Integer,Integer> moneyGenerator=new HashMap<Integer, Integer>();
    public int initialPosition;
    private double betAmount;
    public int randomNumber;

    public PlinkoGame(int initialPosition){
        this.initialPosition=initialPosition;
    }

    public String playPlinko(int initialPosition){
        if(initialPosition<10 && initialPosition>0){
            int max=9;
            int min=1;
            Random rand = new Random();
            int randomNumber=rand.nextInt(max - min + 1) + min;
            return String.valueOf(randomNumber);
        }
        else
            return "Invalid Entry";
    }

    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {
        if (initialPosition < 10 && initialPosition > 0) {
            int max = 9;
            int min = 1;
            Random rand = new Random();
            randomNumber = rand.nextInt(max - min + 1) + min;
            System.out.println("Now your position is: " + randomNumber);
        }
        else
        {
            System.out.println("Invalid Entry");
        }
    }

    @Override
    public Integer calculateWinnings(Integer multiplier, Integer betAmount) {
        moneyGenerator.put(1,200);
        moneyGenerator.put(2,0);
        moneyGenerator.put(3,3000);
        moneyGenerator.put(4,30);
        moneyGenerator.put(5,0);
        moneyGenerator.put(6,0);
        moneyGenerator.put(7,1);
        moneyGenerator.put(8,750);
        moneyGenerator.put(9,0);
        Integer moneyWon=0;
        for (Integer pos:moneyGenerator.keySet())
        {
            if(pos.equals(randomNumber)){
                moneyWon=moneyGenerator.get(pos);
            }
        }
        return moneyWon;
    }


    @Override
    public void subtractBetFromBalance(Integer betAmount) {

    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Integer winnings) {

    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}

