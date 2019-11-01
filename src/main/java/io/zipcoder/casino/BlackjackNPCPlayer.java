package io.zipcoder.casino;

public class BlackjackNPCPlayer {

    private int threshold;
    private boolean isDealer;
    private Player player;

    public BlackjackNPCPlayer(Player player, int threshold, boolean isDealer) {
        this.player = player;
        this.threshold = threshold;
        this.isDealer = isDealer;
    }

    public int getThreshold() {
        return threshold;
    }

    public boolean isDealer() {
        return isDealer;
    }

    public Player getPlayer() {
        return player;
    }


}
