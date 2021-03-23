package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create a function which returns the number of true values there are in an array.
 * Examples
 *
 * countTrue([true, false, false, true, false]) ➞ 2
 *
 * countTrue([false, false, false, false]) ➞ 0
 *
 * countTrue([]) ➞ 0
 *
 * Notes
 *
 *     Return 0 if given an empty array.
 *     All array items are of the type bool (true or false).
 */
@Slf4j
@Component
@NoArgsConstructor
public class HowMuchIsTrue implements IChallange {
    @Override
    public Object execute(Object obj) {
        boolean[] arr = (boolean[]) obj;
        return countTrue(arr);
    }

    private int countTrue(boolean [] arr){
        int trueCount = 0;
        for (boolean bool : arr){
            if(bool){
                trueCount++;
            }
        }
        return trueCount;
    }
}
