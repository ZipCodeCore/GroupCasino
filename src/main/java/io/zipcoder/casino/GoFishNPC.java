package io.zipcoder.casino;

public class GoFishNPC {
    private CardSet hand;
    private Player player;

    public GoFishNPC (Player player){
        this.player = player;
    }

    public Player getPlayer(){
        return player;
    }

    public CardSet getHand() {
        return hand;
    }
}
