package com.hackerrank.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class FizzBuzzTests {

    @Test
    void test() {
        assertEquals("FizzBuzz", fizzBuzz(15));
        assertEquals("Buzz", fizzBuzz(10));
        assertEquals("Fizz", fizzBuzz(9));
        assertEquals("1", fizzBuzz(1));

        for (int i = 0; i < 100; i++) {
            System.out.println(fizzBuzz(i));
        }
    }

    String fizzBuzz(int n) {
        String output = "";
        if (n % 3 == 0 && n % 5 == 0) {
            output = "FizzBuzz";
        } else if (n % 3 == 0) {
            output = "Fizz";
        } else if (n % 5 == 0) {
            output = "Buzz";
        } else {
            output = String.valueOf(n);
        }
        return output;
    }
}
