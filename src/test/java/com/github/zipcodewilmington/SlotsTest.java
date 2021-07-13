package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.slots.Slots;
import org.junit.Assert;
import org.junit.Test;

public class SlotsTest {

    @Test
    public void slotConstructorTest(){
        //given
        String[][] expected =  {
            {"Peach", "Cherry", "Diamond"},
            {"Diamond", "Plum", "Nine"},
            {"Seven", "Peach", "Diamond"}};
        //when
        Slots slot = new Slots();
        String[][] retrieved =  slot.getSlots();
        //then
        Assert.assertEquals(expected, retrieved);
    }

    @Test
    public void randomItemTest(){
        //given
        String[] given = {"Peach", "Cherry", "Diamond"};
        String[] retrieved = {"Peach", "Cherry", "Diamond"};
        //when
        for (int i = 0; i < retrieved.length; i++) {
            retrieved[i] = Slots.ramdomSlotItem();
        }
        //then
        Assert.assertFalse(given.equals(retrieved));
    }

    @Test
    public void spinSlotsTest(){
        //given
        Slots slotMachine = new Slots();
        String[][] given =  slotMachine.getSlots();
        //when
        slotMachine.spinSlots();
        String[][] retrieved =  slotMachine.getSlots();
        //then
        Assert.assertFalse(given.equals(retrieved));
    }
}
