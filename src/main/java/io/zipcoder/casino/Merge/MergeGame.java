package io.zipcoder.casino.Merge;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import java.util.Arrays;

public class MergeGame {

    private Console console = new Console(System.in, System.out);
    private Player player;
    private int[] arrayToSort;

    public MergeGame(Player player) {
        this.player = player;
        this.arrayToSort = new int[20];
    }

    public int[] getArrayToSort() {
        return arrayToSort;
    }

    public void setArrayToSort(int[] arrayToSort) {
        this.arrayToSort = arrayToSort;
    }

    public int[] merge(int[] arrayIn, int start, int mid, int stop) {
        int i = start;
        int j = mid;
        int pos = start;
        int[] copy = Arrays.copyOf(arrayIn, arrayIn.length);
        while (i < mid || j < stop + 1 ) {
            if (arrayIn[i] <= arrayIn[j]) {
                copy[pos++] = arrayIn[i++];
                copy[pos++] = arrayIn[j++];
            } else {
                copy[pos++] = arrayIn[j++];
                copy[pos++] = arrayIn[i++];
            }
        }
        return copy;
    }
}
