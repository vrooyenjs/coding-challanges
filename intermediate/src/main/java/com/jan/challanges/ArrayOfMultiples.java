package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create a function that takes two numbers as arguments (num, length) and returns an array of multiples of num until the array length reaches length.
 * Examples
 * <p>
 * arrayOfMultiples(7, 5) ➞ [7, 14, 21, 28, 35]
 * <p>
 * arrayOfMultiples(12, 10) ➞ [12, 24, 36, 48, 60, 72, 84, 96, 108, 120]
 * <p>
 * arrayOfMultiples(17, 6) ➞ [17, 34, 51, 68, 85, 102]
 */
@Slf4j
@Component
@NoArgsConstructor
public class ArrayOfMultiples implements IChallange {

    @Override
    public Object execute(Object obj) {
        int[] arr = (int[]) obj;
        return arrayOfMultiples(arr[0], arr[1]);
    }

    private int[] arrayOfMultiples(int multiple, int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (i + 1) * multiple;
        }
        return arr;
    }
}
