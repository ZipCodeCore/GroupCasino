package io.zipcoder.casino.GamePieces;

import java.util.HashMap;
import java.util.Map;

public enum CardValue {

    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(10),
    QUEEN(10),
    KING(10),
    ACE(11);

    private final int value;
    private CardValue (int value){
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    private static final Map<Integer, CardValue> intToTypeMap = new HashMap<Integer, CardValue>();
    static {
        for (CardValue type : CardValue.values()) {
            intToTypeMap.put(type.value, type);
        }
    }
    public static CardValue fromInt(int i) {
        return intToTypeMap.get(i);
    }
}
