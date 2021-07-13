package com.github.zipcodewilmington.casino.games.slots;


import java.util.ArrayList;
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


    public void spinSlots(){

        for (int a = 0; a < 3; a++) {
            this.slots[a][0] = ramdomSlotItem();
            this.slots[a][1] = ramdomSlotItem();
            this.slots[a][2] = ramdomSlotItem();
        }
    }

    public static String ramdomSlotItem(){
        int input = (int) ((Math.random() * (7 - 1)) + 1);
        String result;
        switch(input){
            case 1:
                result = slotItems[0];
                break;
            case 2:
                result = slotItems[1];
                break;
            case 3:
                result = slotItems[2];
                break;
            case 4:
                result = slotItems[3];
                break;
            case 5:
                result = slotItems[4];
                break;
            case 6:
                result = slotItems[5];
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + input);
        }
        return result;
    }




}
