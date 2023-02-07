package com.hackerrank.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

public class LetterSeriesTests {
    @Test
    void test() {
        int result = deretHuruf(List.of("+ A 6", "+ B 8", "+ C 4", "- B 8", "+ D 6", "+ E 4", "- A 6", "+ F 5", "+ G 4",
                "- F 5", "+ H 4", "+ I 4", "+ J 2"));
        System.out.println(result);
        assertEquals(0, result);
    }

    public static int deretHuruf(List<String> deret) {
        // Write your code here
        StringBuilder results = new StringBuilder();
        String result = "";
        for (String s : deret) {
            // System.out.println(s);
            if (s.contains("+")) {
                String numberOnly = s.replaceAll("[^0-9]", "");
                for (int i = 0; i < Integer.parseInt(numberOnly); i++) {
                    results.append(s.charAt(2));
                    // System.out.println(results);
                }
            } else if (s.contains("-")) {
                String alphaOnly = s.replaceAll("[^A-Z]", "");
                int numberOnly = Integer.parseInt(s.replaceAll("[^0-9]", ""));
                int firstIndex = results.indexOf(alphaOnly);
                int lastIndex = results.lastIndexOf(alphaOnly);
                // System.out.println("number: " + numberOnly);
                // System.out.println("count: " + (lastIndex - firstIndex + 1));
                for (int i = 0; i < numberOnly; i++) {
                    results.deleteCharAt(results.indexOf(alphaOnly));
                }
                if (numberOnly > (lastIndex - firstIndex + 1)) {
                    results.insert(firstIndex, "-");
                }
            }
        }
        result = results.toString();
        return result.length();
    }
}
