package io.zipcoder.casino.CardGame.BlackJack;

public enum BlackjackActions {

    HIT(1),
    STAND(2),
    DOUBLEDOWN(3),
    SPLIT(4),
    WALKAWAY(5);

    int actionValue;

    BlackjackActions (int actionValue) {
        this.actionValue = actionValue;
    }


    public int getActionValue() {
        return actionValue;
    }


}

