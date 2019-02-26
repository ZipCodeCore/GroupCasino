package io.zipcoder.casino.DiceGame;

import io.zipcoder.casino.utilities.Console;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public enum CrapsActions {
    //PASS_LINE_ODDS((crapsObj, doubleVal) -> crapsObj.passLineOddsBet(doubleVal)),
    FIELD((crapsObj, doubleVal) -> crapsObj.fieldBet(doubleVal)),
    //HARDWAY((crapsObj, doubleVal) -> crapsObj.hardWayBet(doubleVal)),
    PLACE((crapsObj, doubleVal) -> crapsObj.placeLineBet(doubleVal)),
    //COME_LINE((crapsObj, doubleVal) -> crapsObj.comeLineBet(doubleVal)),
    //    ROLL((crapsObj, doubleVal) -> crapsObj.roll),
    //COME_ODDS((crapsObj, doubleVal) -> crapsObj.comeLineOddsBet(doubleVal)),
    PASS_LINE((crapsObj, doubleVal) -> crapsObj.passLineBet(doubleVal));

    private final BiConsumer<Craps, Double> consumer;

    CrapsActions(BiConsumer<Craps, Double> consumer) {
        this.consumer = consumer;
    }

    public void perform(Craps crapsObject, Double doubleValue) {
        consumer.accept(crapsObject, doubleValue);
    }

//    public static void main(String[] args) {
//        CrapsActions c = CrapsActions.valueOf(Console.getInstance().getStringInput("What is the craps action you would like to perform?"));
//        c.perform(null, null);
//    }

}

