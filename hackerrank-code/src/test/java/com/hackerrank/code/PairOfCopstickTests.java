package com.hackerrank.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

public class PairOfCopstickTests {
    /*
     * Complete the 'hitung' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY P as parameter.
     */

    /*
     * 10 | 20 31 21 31 50 21 21 31 41 21
     * Baris pertama adalah jumlah tongkat = 10
     * Pasangan chop[1] dan chop[4] = 31
     * Pasangan chop[2] dan chop[9] = 31
     * Pasangan chop[3] dan chop[7] = 21
     * 
     * Jumlah pasang tongkat adalah 3
     * 
     * Algortihm => Next array hitung jumlah angka yang
     * sama by containsKey kemudian bagi 2.
     */

    @Test
    void testPairChopstick() {
        List<Integer> copsticks = new ArrayList<>();
        copsticks.add(20);
        copsticks.add(31);
        copsticks.add(21);
        copsticks.add(31);
        copsticks.add(50);
        copsticks.add(21);
        copsticks.add(21);
        copsticks.add(31);
        copsticks.add(41);
        copsticks.add(21);

        int countPair = hitung(copsticks);
        System.out.println(countPair);

        assertEquals(3, countPair);
    }

    static int hitung(List<Integer> P) {
        // Write your code here
        System.out.println(P);
        // The first element of the list is the number of chopsticks
        int n = P.size();

        // Create an array to store the length of each chopstick based on n
        int[] lengths = new int[n];

        // Read the length of each chopstick and store it in the array
        for (int i = 0; i < n; i++) {
            System.out.println(P.get(i));
            lengths[i] = P.get(i);
        }

        // Create a HashMap to store the counts of each length
        HashMap<Integer, Integer> counts = new HashMap<>();

        // Count the number of occurrences of each length
        for (int length : lengths) {
            // If the length is already in the HashMap, increment the count
            if (counts.containsKey(length)) {
                counts.put(length, counts.get(length) + 1);
            } else {
                // If the length is not in the HashMap, just give it a count of 1
                counts.put(length, 1);
            }
        }
        System.out.println(counts);

        // Initialize the number of pairs to 0
        int pairs = 0;

        // Loop through the HashMap
        for (int length : counts.keySet()) {
            // Pairs is just simple division of the count by 2
            pairs += counts.get(length) / 2;
        }

        // return the number of pairs
        return pairs;
    }
}
