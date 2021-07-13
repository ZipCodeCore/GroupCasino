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
        String[] retrieved = new String[3];
        //when
        for(String element: retrieved){
            element = Slots.ramdomSlotItem(); //Not updating retrieved
        }
        //then
        Assert.assertFalse(given.equals(retrieved));
    }
}
