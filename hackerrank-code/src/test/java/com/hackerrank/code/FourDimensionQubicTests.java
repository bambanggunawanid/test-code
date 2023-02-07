package com.hackerrank.code;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

// import org.junit.jupiter.api.Test;

public class FourDimensionQubicTests {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
     * class should be named Solution.
     */

    /*
     *
     * 9 9 9 9 9 9 9 9 9 9 9 9
     * 9 9 9 9 9 9 9 9 9 9 9 9
     * 9 9 9 9 9 9 9 9 9 9 9 9
     * 9 9 9 9 9 9 9 9 9 9 9 9
     * 
     * 9 9 9 9
     * 9 9 9 9
     * 9 9 9 9
     * 9 9 9 9
     * 
     * 9 9 9 9
     * 9 9 9 9
     * 9 9 9 9
     * 9 9 9 9 9
     */

    @Test
    void testFourDimensional() {
        System.out.println("Hello World!");
        String input = "4\n" + "4\n" + "1 2 3 4\n" + "4 5 6 7\n" + "7 8 9 10\n" + "10 11 12 13";
        try (Scanner in = new Scanner(input)) {
            // Scanner in = new Scanner(System.in);
            int res;

            int _n;
            _n = Integer.parseInt(in.nextLine().trim());

            int _m;
            _m = Integer.parseInt(in.nextLine().trim());

            int[][] _a = new int[_n][_m];
            for (int _a_i = 0; _a_i < _n; _a_i++) {
                for (int _a_j = 0; _a_j < _m; _a_j++) {
                    _a[_a_i][_a_j] = in.nextInt();
                }
            }
            System.out.println(Arrays.deepToString(_a));

            if (in.hasNextLine()) {
                in.nextLine();
            }

            res = solve(_n, _m, _a);
            System.out.println(res);
            assertEquals(_n, _m);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    static int solve(int n, int m, int[][] a) {
        int result = 0;
        int[][][] cube = new int[n][n][n];
        int[][][][] qubic = new int[n][n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    cube[i][j][k] = a[i][j] + a[i][k] + a[j][k];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        qubic[i][j][k][l] = cube[i][j][k] + cube[i][j][l] + cube[i][k][l] + cube[j][k][l];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (qubic[i][j][k][l] > result) {
                            result = qubic[i][j][k][l];
                        }
                    }
                }
            }
        }

        return result;
    }

}
