package io.zipcoder.casino.games;


import java.security.PublicKey;

abstract class Games {
    Integer odds;

    abstract boolean getResults();

    public void display(String output) {
        System.out.println(output);
    }


}
