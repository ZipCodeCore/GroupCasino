package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by Nathan on 7/12/21
 */
public class SlotsGame implements GameInterface {
    private static String[] slotItems = {"Peach", "Cherry", "Diamond", "Plum", "Seven", "Nine"};
    private String[][] slots = new String[3][3];



    @Override
    public void add(PlayerInterface player) {

    }

    @Override
    public void remove(PlayerInterface player) {

    }

    @Override
    public void run() {

    }

    @Override
    public Double calculateWinnings(Double betAmount) {
        return null;
    }

    @Override
    public void subtractBetFromBalance(Double betAmount) {

    }

    @Override
    public void addMoneyToBalance(PlayerInterface Player, Double winnings) {

    }
}
