package com.github.zipcodewilmington.casino.games.slots;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Slots {
    private static final String[] slotItems = {"Peach", "Cherry", "Diamond", "Plum", "Seven", "Nine"};
    private String[][] slots = new String[3][3];
    private List<String[]> slotsList = new ArrayList<>();

    public Slots(){
        this.slots = new String[][] {
                {"Peach", "Cherry", "Diamond"},
                {"Diamond", "Plum", "Nine"},
                {"Seven", "Peach", "Diamond"}};
    }

    public String[][] getSlots() {
        return slots;
    }

    public void setSlots(String[][] slots) {
        this.slots = slots;
    }

    public void spinSlots(){
        String[][] newSlot = new String[3][3];
        for (int a = 0; a < 3; a++) {
            newSlot[a][0] = ramdomSlotItem();
            newSlot[a][1] = ramdomSlotItem();
            newSlot[a][2] = ramdomSlotItem();
        }
        setSlots(newSlot);
    }

    public static String ramdomSlotItem(){
        int input = (int) ((Math.random() * (7 - 1)) + 1);
        String result;
        result = slotItems[input -1];
        return result;
    }

    public static void findWinnings(){
        //HashMap<int, Boolean>;

    }




}
