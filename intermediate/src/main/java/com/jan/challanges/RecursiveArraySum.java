package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Write a function that finds the sum of an array. Make your function recursive.
 * Examples
 * <p>
 * sum([1, 2, 3, 4]) ➞ 10
 * <p>
 * sum([1, 2]) ➞ 3
 * <p>
 * sum([1]) ➞ 1
 * <p>
 * sum([]) ➞ 0
 * <p>
 * Notes
 * <p>
 * Return 0 for an empty array.
 * Check the Resources tab for info on recursion.
 */
@Slf4j
@Component
@NoArgsConstructor
public class RecursiveArraySum implements IChallange {
    @Override
    public Object execute(Object obj) {
        int[] arr = (int[]) obj;
        return sum(arr);
    }

    private int sum(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }else{
            int sum = arr[0] + sum(Arrays.copyOfRange(arr, 1, arr.length));
            log.info("{} + {} = {}", arr[0], sum(Arrays.copyOfRange(arr, 1, arr.length)), sum);
            return sum;
        }
    }
}
