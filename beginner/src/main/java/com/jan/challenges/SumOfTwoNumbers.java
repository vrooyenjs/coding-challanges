package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create a method that takes two integers as arguments and return their sum.
 */
@Slf4j
@Component
@NoArgsConstructor
public class SumOfTwoNumbers implements IChallange {
    @Override
    public Object execute(Object obj) {
        int[] arr = (int[]) obj;
        return findSum(arr[0], arr[1]);
    }

    private int findSum(int a, int b) {
        return a + b;
    }
}
