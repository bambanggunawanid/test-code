package com.hackerrank.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AnagramTests {
    @Test
    void testAnagramTrue() {
        String string1 = "cinema";
        String string2 = "iceman";

        boolean isAnagram = isAnagram(string1, string2);
        System.out.println(isAnagram);
        assertEquals(true, isAnagram);
    }

    @Test
    void testAnagramFalse() {
        String string1 = "cinemax";
        String string2 = "icemant";

        boolean isAnagram = isAnagram(string1, string2);
        System.out.println(isAnagram);
        assertEquals(false, isAnagram);
    }

    boolean isAnagram(String word1, String word2) {
        // cek apakah panjang string sama, jika tidak berarti bukan anagram
        if (word1.length() != word2.length()) {
            return false;
        }

        // ubah parameter string menjadi lowercase
        word1 = word1.toLowerCase();
        word2 = word2.toLowerCase();

        // buat array untuk menampung 26 jumlah huruf
        int[] letters = new int[26];

        // looping sebanyak panjang string
        for (int i = 0; i < word1.length(); i++) {
            // ubah huruf menjadi angka, misal a = 0, b = 1, c = 2, dst dengan mengurangi 97
            // ASCII a = 97
            System.out.println(i + ".word 1 = " + (word1.charAt(i) - 97));
            System.out.println(i + ".word 2 = " + (word2.charAt(i) - 97));

            // tambah jumlah huruf yang sama
            letters[word1.charAt(i) - 97]++;

            // kurangi jumlah huruf yang sama
            letters[word2.charAt(i) - 97]--;
        }

        for (int i : letters) {
            System.out.println("letters: " + i);
            // jika jumlah huruf yang sama tidak sama dengan 0, maka bukan anagram
            if (i != 0) {
                return false;
            }
        }

        // jika jumlah huruf yang sama sama dengan 0, maka anagram
        return true;
    }
}
