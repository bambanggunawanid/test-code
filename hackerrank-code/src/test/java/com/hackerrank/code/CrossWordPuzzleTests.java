package com.hackerrank.code;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

class CrossWordPuzzleTests {

    /*
     * Complete the 'isiTTS' function below.
     *
     * The function accepts following parameters:
     * 1. STRING_ARRAY kotak
     * 2. STRING kata
     */

    @Test
    void testTTS() {
        String[] kotak = {
                "++++++++++",
                "+++++-++++",
                "++-++-+++-",
                "+-------+-",
                "++-++-+++-",
                "++-++-+++-",
                "+++++-+++-",
                "+++++-+++-",
                "++++------",
                "++++++++++"
        };
        String[] kotakResult = {
                "++++++++++",
                "+++++s++++",
                "++b++u+++l",
                "+jakarta+a",
                "++l++a+++m",
                "++i++b+++p",
                "+++++a+++u",
                "+++++y+++n",
                "++++malang",
                "++++++++++"
        };
        String word = "jakarta,bali,lampung,surabaya,malang";
        String[] output = isiTTS(kotak, word);
        for (int i = 0; i < output.length; i++) {
            System.out.println(output[i]);
        }
        assertArrayEquals(kotakResult, output);
    }

    public static String[] isiTTS(String[] kotak, String kata) {
        // Split the words into a list
        String[] words = kata.split(",");
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);

        System.out.println(wordList);

        // Loop through each row and column of the grid
        for (int i = 0; i < kotak.length; i++) {
            for (int j = 0; j < kotak[i].length(); j++) {
                // Check if there is a "-" character at this position
                if (kotak[i].charAt(j) == '-') {
                    // Loop through the words in reverse order, starting with the longest words
                    for (int k = wordList.size() - 1; k >= 0; k--) {
                        String word = wordList.get(k);
                        // Check if the word fits at this position
                        if (fitsAtPosition(kotak, i, j, word)) {
                            // If it fits, place the word into the grid
                            kotak = placeWord(kotak, i, j, word);
                            // Remove the word from the list so it isn't used again
                            wordList.remove(k);
                            // Break out of the inner loop since we have placed a word
                            break;
                        }
                        // System.out.println(Arrays.toString(kotak));
                    }
                }
            }
        }

        // Return the grid with all words placed
        return kotak;
    }

    public static boolean fitsAtPosition(String[] kotak, int i, int j, String word) {
        // Check if the word will fit within the bounds of the grid
        if (i + word.length() > kotak.length || j + word.length() > kotak[i].length()) {
            return false;
        }

        // Check if the characters in the grid at the positions where the word
        // will be placed are all "-" characters
        for (int k = 0; k < word.length(); k++) {
            if (kotak[i + k].charAt(j + k) == '-') {
                return true;
            }
        }

        // If both of the above checks pass, the word fits at this position
        return true;
    }

    public static String[] placeWord(String[] kotak, int i, int j, String word) {
        // Loop through each character in the word
        for (int k = 0; k < word.length(); k++) {
            // Place the character into the grid
            char[] chars = kotak[i + k].toCharArray();
            chars[j + k] = word.charAt(k);
            kotak[i + k] = new String(chars);
            // System.out.println(Arrays.toString(chars));
            System.out.println(word);
        }
        return kotak;
    }

}
