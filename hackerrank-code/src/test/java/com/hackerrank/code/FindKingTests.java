package com.hackerrank.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class FindKingTests {

    /*
     * Complete the 'findTheKing' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER N
     * 2. 2D_INTEGER_ARRAY peta
     */

    /*
     * 9 9 9
     * 9 5 9
     * 9 9 9
     * -> The king always in center of 9
     * 
     * 5 9 2 9 9
     * 1 2 4 9 5
     * 9 3 8 9 9
     * 1 7 8 9 9
     * -> even in corner the king should completely surrounded by 9
     */

    @Test
    void testFindKing() {
        List<List<Integer>> peta = new ArrayList<>();

        // int N = 3;
        // peta.add(Arrays.asList(9, 9, 9));
        // peta.add(Arrays.asList(9, 5, 9));
        // peta.add(Arrays.asList(9, 9, 9));
        // assert equals 5

        // int N = 5;
        // peta.add(Arrays.asList(9, 2, 1, 5, 8));
        // peta.add(Arrays.asList(7, 3, 0, 9, 9));
        // peta.add(Arrays.asList(2, 1, 5, 9, 1));
        // peta.add(Arrays.asList(3, 4, 6, 9, 9));
        // peta.add(Arrays.asList(0, 9, 1, 3, 8));
        // assert equals 1

        int N = 9;
        peta.add(Arrays.asList(0, 9, 1, 3, 8, 2, 5, 1, 5));
        peta.add(Arrays.asList(9, 2, 1, 5, 8, 3, 0, 9, 1));
        peta.add(Arrays.asList(7, 3, 0, 4, 9, 9, 9, 1, 0));
        peta.add(Arrays.asList(2, 1, 5, 3, 9, 3, 9, 7, 3));
        peta.add(Arrays.asList(3, 4, 6, 9, 9, 9, 9, 4, 4));
        peta.add(Arrays.asList(2, 3, 8, 3, 2, 1, 0, 0, 6));
        peta.add(Arrays.asList(9, 4, 2, 6, 7, 9, 3, 5, 1));
        peta.add(Arrays.asList(2, 0, 0, 9, 1, 2, 4, 7, 8));
        peta.add(Arrays.asList(7, 9, 2, 8, 5, 3, 8, 6, 6));
        // assert equals 3

        System.out.println(findTheKing(N, peta));
        int king = findTheKing(N, peta);

        assertEquals(3, king);
    }

    int findTheKing(int N, List<List<Integer>> peta) {
        // Write your code here
        // First convert the 2D list into a 2D array
        int[][] square = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                square[i][j] = peta.get(i).get(j);
            }
        }

        // Print the 2D array to check if it's correct
        // System.out.println(Arrays.deepToString(square));

        // Now we can start the algorithm
        int king = 0;

        // Loop through the 2D array
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                // If the current element is a 9, then skip it
                if (square[i][j] == 9) {
                    continue;
                }

                // Check if the current element is a king
                if (isKingCompletelySurrounded(square, i, j)) {
                    // If the current element is a king, then put it in the king variable
                    // System.out.println("masuk");
                    // System.out.println("i: " + i + ", j: " + j + ", square[i][j]: " +
                    // square[i][j]);
                    king = square[i][j];
                    // System.out.println("king: " + king);
                }
            }
        }

        // Return the king
        return king;
    }

    static boolean isKingCompletelySurrounded(int[][] square, int row, int col) {
        int n = square.length;
        System.out.println("row: " + row);
        System.out.println("col: " + col);
        // Check for the top-left, top-right, bottom-left, and bottom-right corners
        if ((row == 0 || row == n - 1) && (col == 0 || col == n - 1)) {
            // Top-left corner
            if (row == 0 && col == 0) {
                if (square[row][col + 1] != 9 || square[row + 1][col] != 9 || square[row + 1][col + 1] != 9) {
                    return false;
                }
            }
            // Top-right corner
            else if (row == 0 && col == n - 1) {
                if (square[row][col - 1] != 9 || square[row + 1][col] != 9 || square[row + 1][col - 1] != 9) {
                    return false;
                }
            }
            // Bottom-left corner
            else if (row == n - 1 && col == 0) {
                if (square[row][col + 1] != 9 || square[row - 1][col] != 9 || square[row - 1][col + 1] != 9) {
                    return false;
                }
            }
            // Bottom-right corner
            else {
                if (square[row][col - 1] != 9 || square[row - 1][col] != 9 || square[row - 1][col - 1] != 9) {
                    return false;
                }
            }
        }
        // Check for the top and bottom edges
        else if (row == 0 || row == n - 1) {
            // Top edge
            if (row == 0) {
                if (square[row][col - 1] != 9 || square[row][col + 1] != 9 || square[row + 1][col - 1] != 9
                        || square[row + 1][col] != 9 || square[row + 1][col + 1] != 9) {
                    return false;
                }
            }
            // Bottom edge
            else {
                if (square[row][col - 1] != 9 || square[row][col + 1] != 9 || square[row - 1][col - 1] != 9
                        || square[row - 1][col] != 9 || square[row - 1][col + 1] != 9) {
                    return false;
                }
            }
        }
        // Check for the left and right edges
        else if (col == 0 || col == n - 1) {
            // Left edge
            if (col == 0) {
                if (square[row - 1][col] != 9 || square[row + 1][col] != 9 || square[row - 1][col + 1] != 9
                        || square[row][col + 1] != 9 || square[row + 1][col + 1] != 9) {
                    return false;
                }
            }
            // Right edge
            else {
                if (square[row - 1][col] != 9 || square[row + 1][col] != 9 || square[row - 1][col - 1] != 9
                        || square[row][col - 1] != 9 || square[row + 1][col - 1] != 9) {
                    return false;
                }
            }
        }
        // Check for the middle
        else {
            if (square[row - 1][col - 1] != 9 || square[row - 1][col] != 9 || square[row - 1][col + 1] != 9
                    || square[row][col - 1] != 9 || square[row][col + 1] != 9 || square[row + 1][col - 1] != 9
                    || square[row + 1][col] != 9 || square[row + 1][col + 1] != 9) {
                return false;
            }
        }
        // If the king is completely surrounded by 9s, then return true
        return true;
    }

}
