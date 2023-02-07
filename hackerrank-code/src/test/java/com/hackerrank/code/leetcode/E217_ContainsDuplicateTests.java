package com.hackerrank.code.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class E217_ContainsDuplicateTests {
    @Test
    void test() {
        int[] nums = { 1, 2, 3, 4, 5, 6, 1 };
        boolean result = containsDuplicate(nums);
        assertEquals(true, result);
        System.out.println(result);
    }

    boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], 1);
            }
        }
        return false;
    }

}
