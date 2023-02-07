package com.hackerrank.code;

import java.util.Arrays;
import java.util.List;

public class GetWhiteLightLenghtTests {
    /*
     * The film and theater society of HackerLand is conducting a street play next
     * month.
     * The stage is n meters long and there are m lights above it. Each light is
     * either red, blue, or green.
     * When all three colors shine on some area, that area appears to have white
     * light.
     * Each light illumiates a range of the stage and is represented as three
     * attributes: color, left, right.
     * Color is 1, 2, or 3 to represented red, blue, and green. Left and right
     * represented illumination range's extent.
     * 
     * Find the total number of integer positions on the stage illuminated with
     * white light.
     */

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        // List<List<Integer>> lights = List.of(List.of(1, 1, 5), List.of(1, 2, 4),
        // List.of(2, 2, 4), List.of(3, 2, 4));
        List<List<Integer>> lights = List.of(List.of(1, 1, 3), List.of(2, 2, 4),
                List.of(3, 3, 5));
        int whiteLightLenght = getWhiteLightLenght(n, m, lights);
        System.out.println(whiteLightLenght);
    }

    static int getWhiteLightLenght(int n, int m, List<List<Integer>> lights) {
        // Write your code here
        int whiteLightLenght = 0;
        int[] lightsArray = new int[n];

        for (int i = 0; i < m; i++) {
            int start = lights.get(i).get(0);
            int end = lights.get(i).get(1);
            int light = lights.get(i).get(2);

            for (int j = start; j <= end; j++) {
                lightsArray[j - 1] = light;
            }
        }

        for (int i = 0; i < n; i++) {
            if (lightsArray[i] == n) {
                whiteLightLenght++;
            }
        }

        return whiteLightLenght;
    }
}