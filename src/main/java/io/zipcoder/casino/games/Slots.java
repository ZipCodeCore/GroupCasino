package io.zipcoder.casino.games;

public class Slots extends Games {
    Integer numOfLines;

    public Slots(){}

    @Override
    boolean getResults() {
        return false;
    }

    @Override
    public void display(String output) {
        super.display(output);
    }
}
