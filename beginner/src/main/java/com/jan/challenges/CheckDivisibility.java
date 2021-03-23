package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create a function that returns true if an integer is evenly divisible by another integer, and false otherwise.
 * isDivisible(dividend, divisor)
 * <p>
 * Examples:
 * divisibleByFive(5, 5) ➞ true
 * divisibleByFive(-55, 5) ➞ true
 * divisibleByFive(37, 5) ➞ false
 */
@Slf4j
@Component
@NoArgsConstructor
public class CheckDivisibility implements IChallange {

    @Override
    public Object execute(Object obj) {
        int[] arr = (int[]) obj;
        return isDivisible(arr[0], arr[1]);
    }

    private boolean isDivisible(int dividend, int divisor) {
        if (divisor == 0){
            return false;
        }
        log.info("is {} / {} ? --> {}", dividend, divisor, (dividend % divisor));
        return (dividend % divisor) == 0;
    }
}
