package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create a function that takes an integer and outputs an n x n square solely consisting of the integer n.
 * Examples
 * <p>
 * squarePatch(3) ➞ [
 * [3, 3, 3],
 * [3, 3, 3],
 * [3, 3, 3]
 * ]
 * <p>
 * squarePatch(5) ➞ [
 * [5, 5, 5, 5, 5],
 * [5, 5, 5, 5, 5],
 * [5, 5, 5, 5, 5],
 * [5, 5, 5, 5, 5],
 * [5, 5, 5, 5, 5]
 * ]
 * <p>
 * squarePatch(1) ➞ [
 * [1]
 * ]
 * <p>
 * squarePatch(0) ➞ []
 * <p>
 * Notes
 * <p>
 * n >= 0.
 * If n = 0, return an empty array.
 */
@Slf4j
@Component
@NoArgsConstructor
public class PerfectSquarePatch implements IChallange {
    @Override
    public Object execute(Object obj) {
        return squarePatch((int) obj);
    }

    private int[][] squarePatch(int n) {
        if (n <= 0) {
            return new int[][]{};
        }

        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                arr[i][k] = n;
            }
        }
        return arr;
    }
}
