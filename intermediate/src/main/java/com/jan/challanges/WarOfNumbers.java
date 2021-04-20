package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * There's a great war between the even and odd numbers. Many numbers already lost their life in this war and it's your task to end this. You have to determine which group sums larger: the even, or the odd. The larger group wins.
 * <p>
 * Create a function that takes an array of integers, sums the even and odd numbers separately, then returns the difference between sum of even and odd numbers.
 * Examples
 * <p>
 * warOfNumbers([2, 8, 7, 5]) ➞ 2
 * // 2 + 8 = 10
 * // 7 + 5 = 12
 * // 12 is larger than 10
 * // So we return 12 - 10 = 2
 * <p>
 * warOfNumbers([12, 90, 75]) ➞ 27
 * <p>
 * warOfNumbers([5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243]) ➞ 168
 * <p>
 * Notes
 * <p>
 * The given array contains only positive integers.
 */
@Slf4j
@Component
@NoArgsConstructor
public class WarOfNumbers implements IChallange {
    @Override
    public Object execute(Object obj) {
        int[] arr = (int[]) obj;
        return warOfNumbers(arr);
    }

    private int warOfNumbers(int[] numbers) {
        int sumOfEven = 0;
        int sumOfOdd = 0;

        for (int i : numbers){
            if (i % 2 == 0){
                sumOfEven += i;
            }else{
                sumOfOdd += i;
            }
        }

        return Math.abs(sumOfEven - sumOfOdd);
    }
}
