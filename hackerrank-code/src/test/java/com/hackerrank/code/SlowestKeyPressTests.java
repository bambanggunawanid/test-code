package com.hackerrank.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class SlowestKeyPressTests {

    /*
     * Complete the 'slowestKey' function below.
     *
     * The function is expected to return a CHARACTER.
     * The function accepts 2D_INTEGER_ARRAY keyTimes as parameter.
     */
    @Test
    void runRest() {
        char result = slowestKey(List.of(List.of(0, 2), List.of(1, 5), List.of(0, 9), List.of(2, 15)));
        assertEquals('c', result);
        System.out.println(result);
    }

    public static char slowestKey(List<List<Integer>> keyTimes) {
        System.out.println(keyTimes);
        // Write your code here

        // save the max press time
        int maxPress = 0;

        // save the character
        char character = ' ';

        // loop
        for (int i = 0; i < keyTimes.size(); i++) {
            // get the press time
            int press = keyTimes.get(i).get(1);

            // if the press time is greater than the max press time
            if (i > 0) {
                // subtract the previous press time
                press -= keyTimes.get(i - 1).get(1);
            }

            // if the press time is greater than the max press time
            if (press > maxPress) {
                // save the max press time
                maxPress = press;

                // save the character
                character = (char) (keyTimes.get(i).get(0) + 97);
            }
        }
        return character;

    }

}
