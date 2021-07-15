package com.github.zipcodewilmington;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RouletteTest {
    @Test
    public void numberToColorValue() {
        Map<Integer, String> wheelValues = new HashMap<Integer, String>();
        for (Integer i = 1; i <= 36; i++) {
            if (i % 2 == 0) {
                wheelValues.put(i, "red");
            } else {
                wheelValues.put(i, "black");
            }
        }
        System.out.println(wheelValues);
    }
}
