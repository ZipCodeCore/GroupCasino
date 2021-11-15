package com.github.zipcodewilmington.casino.games.gameUtils;

public enum Suit {
    HEARTS("♥"),
    DIAMONDS("◆"),
    CLUBS("♧"),
    SPADES("♠");

   private final String graphic;

    Suit(String graphic) {
        this.graphic = graphic;
    }

    public String getGraphic() {
        return graphic;
    }
}
