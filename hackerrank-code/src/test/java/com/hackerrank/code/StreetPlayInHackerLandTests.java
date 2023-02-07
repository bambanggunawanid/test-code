package com.hackerrank.code;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class StreetPlayInHackerLandTests {
    @Test
    void testStreetPlayInHackerLand() {
        int n = 5;
        int m = 3;
        List<List<Integer>> lights = List.of(List.of(1, 1, 3), List.of(2, 2, 4), List.of(3, 3, 5));
        int whiteLightLenght = getWhiteLightLenght2(n, m, lights);
        System.out.println(whiteLightLenght);
    }

    @Test
    void testStreetPlayInHackerLand2() {
        int n = 5;
        int m = 4;
        List<List<Integer>> lights = List.of(List.of(1, 1, 5), List.of(1, 2, 4), List.of(2, 2, 4), List.of(3, 2, 4));
        int whiteLightLenght = getWhiteLightLenght2(n, m, lights);
        System.out.println(whiteLightLenght);
    }

    @Test
    void testStreetPlayInHackerLand3() {
        int n = 5;
        int m = 3;
        List<List<Integer>> lights = List.of(List.of(1, 1, 5), List.of(2, 2, 5), List.of(3, 3, 5));
        int whiteLightLenght = getWhiteLightLenght2(n, m, lights);
        System.out.println(whiteLightLenght);
    }

    public static int getWhiteLightLenght(int n, int m, List<List<Integer>> lights) {
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
            System.out.println(lightsArray[i]);
            if (lightsArray[i] == n) {
                whiteLightLenght++;
            }
        }

        return whiteLightLenght;
    }

    public static int getWhiteLightLenght2(int n, int m, List<List<Integer>> lights) {
        // Write your code here
        // deklarasi panjang lampu putih
        int whiteLightLenght = 0;

        // buat array untuk menyimpan panjang lampu
        int[] lightsArray = new int[n];

        // looping untuk setiap lampu
        for (int i = 0; i < m; i++) {
            // ambil nilai start, end, dan light
            int start = lights.get(i).get(0);
            int end = lights.get(i).get(1);
            int light = lights.get(i).get(2);

            System.out.println("start: " + start);
            System.out.println("end: " + end);
            System.out.println("light: " + light);

            // looping untuk setiap lampu
            for (int j = start; j <= end; j++) {
                // jika panjang lampu lebih kecil dari light, maka ganti dengan nilai light
                lightsArray[j - 1] = light;
            }
        }

        System.out.println(Arrays.toString(lightsArray));
        // looping untuk setiap panjang lampu
        for (int i = 0; i < n; i++) {
            // jika panjang lampu sama dengan n, maka tambahkan panjang lampu putih
            if (lightsArray[i] == n) {
                whiteLightLenght++;
            }
        }

        return whiteLightLenght;
    }
}
