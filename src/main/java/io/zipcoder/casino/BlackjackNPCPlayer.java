package io.zipcoder.casino;

public class BlackjackNPCPlayer extends Player {

    private int threshold;
    private boolean isDealer;

    public BlackjackNPCPlayer(String firstName, String lastName, int age, double balance, double chipsInHand, int threshold, boolean isDealer) {
        super(firstName, lastName, age, balance, chipsInHand);
        this.threshold = threshold;
        this.isDealer = isDealer;
    }

    public int getThreshold() {
        return threshold;
    }

}
