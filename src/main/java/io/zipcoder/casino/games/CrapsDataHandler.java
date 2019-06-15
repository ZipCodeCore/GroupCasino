package io.zipcoder.casino.games;

import io.zipcoder.casino.player.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.HashMap;

public class CrapsDataHandler {
    private Console console;
    private Integer onNumber;
    private Double firstLineBet;
    private Double secondLineBet;
    private Double fieldBet;
    private Integer fieldBetType;
    private Double firstLineOdds = 2.0;
    private Double secondLineOdds = 2.0;
    private Integer currentRoll;
    private HashMap<Integer , Double> fieldOdds = new HashMap();


    public Double getfieldOdds(Integer key) {
        return  fieldOdds.get(key);
    }

    public CrapsDataHandler(){
        fieldOdds.put(2,10.0);
        fieldOdds.put(3,9.0);
        fieldOdds.put(4,8.0);
        fieldOdds.put(5,7.0);
        fieldOdds.put(6,6.0);
        fieldOdds.put(7,5.0);
        fieldOdds.put(8,6.0);
        fieldOdds.put(9,7.0);
        fieldOdds.put(10,8.0);
        fieldOdds.put(11,9.0);
        fieldOdds.put(12,10.0);
    }





    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    public Integer getOnNumber() {
        return onNumber;
    }

    public void setOnNumber(Integer onNumber) {
        this.onNumber = onNumber;
    }

    public Double getFirstLineBet() {
        return firstLineBet;
    }

    public void setFirstLineBet(Double firstLineBet) {
        this.firstLineBet = firstLineBet;
    }

    public Double getSecondLineBet() {
        return secondLineBet;
    }

    public void setSecondLineBet(Double secondLineBet) {
        this.secondLineBet = secondLineBet;
    }

    public Double getFieldBet() {
        return fieldBet;
    }

    public void setFieldBet(Double fieldBet) {
        this.fieldBet = fieldBet;
    }

    public Integer getFieldBetType() {
        return fieldBetType;
    }

    public void setFieldBetType(Integer fieldBetType) {
        this.fieldBetType = fieldBetType;
    }

    public Double getFirstLineOdds() {
        return firstLineOdds;
    }

    public void setFirstLineOdds(Double firstLineOdds) {
        this.firstLineOdds = firstLineOdds;
    }

    public Double getSecondLineOdds() {
        return secondLineOdds;
    }

    public void setSecondLineOdds(Double secondLineOdds) {
        this.secondLineOdds = secondLineOdds;
    }

    public Integer getCurrentRoll() {
        return currentRoll;
    }

    public void setCurrentRoll(Integer currentRoll) {
        this.currentRoll = currentRoll;
    }




}
