package com.hackerrank.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AloneNumberTests {

    /*
     * Complete the 'angkaSendiri' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER_ARRAY barisAngka as parameter.
     */

    @Test
    void testAloneNumber() {
        List<Long> arr = Arrays.asList(9L, 4L, 9L, 5L, 7L, 10L, 2L, 5L, 1L, 3L, 7L,
                8L, 10L, 6L, 3L, 0L, 1L, 2L, 8L, 6L, 11L);
        // List<Long> arr = Arrays.asList(7L, 5L, 3L, 10L, 5L, 10L, 2L, 6L, 8L, 7L, 6L,
        // 4L, 9L, 9L, 1L, 1L, 2L, 8L, 4L, 3L);
        // List<Long> arr = Arrays.asList(9L, 6L, 2L, 0L, 7L, 10L, 1L, 4L, 8L, 1L, 5L,
        // 10L, 3L, 4L, 9L, 6L, 5L, 2L, 8L, 3L, 7L);
        // List<Long> arr = Arrays.asList(7L, 5L, 3L, 10L, 5L, 10L, 2L, 6L, 8L, 7L, 6L,
        // 4L, 9L, 9L, 1L, 1L, 2L, 8L, 4L, 3L);

        Long aloneNumber = angkaSendiri(arr);

        // Long aloneNumber = angkaSendiriIndex(arr);

        System.out.println(aloneNumber);
        assertEquals(4, aloneNumber);
    }

    // work
    public static long angkaSendiri(List<Long> barisAngka) {
        // Write your code here
        // We can use copstick pair algorithm
        // Create a HashMap to store the counts of each length
        HashMap<Long, Integer> counts = new HashMap<>();

        // Count the number of occurrences of each length
        for (Long baris : barisAngka) {
            // If the length is already in the HashMap, increment the count
            if (counts.containsKey(baris)) {
                counts.put(baris, counts.get(baris) + 1);
            } else {
                // If the length is not in the HashMap, just give it a count of 0
                counts.put(baris, 0);
            }
        }
        System.out.println(counts);
        // compare the counts with barisAngka
        for (Long baris : barisAngka) {
            if (counts.get(baris) == 0) {
                return baris;
            }
        }

        // If we get to this point, then there is no lone number so we return 0
        return 0;
    }

    // !not work
    public static long angkaSendiriIndex(List<Long> barisAngka) {
        for (Long angka : barisAngka) {
            System.out.println("Angka: " + angka);
            System.out.println("Index: " + barisAngka.indexOf(angka));
            System.out.println("Last Index: " + barisAngka.lastIndexOf(angka));
            if (barisAngka.indexOf(angka) == barisAngka.lastIndexOf(angka)) {
                return angka;
            }
        }
        return 0;
    }
}
