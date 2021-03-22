package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Have the function FirstFactorial(num) take the num parameter
 * being passed and return the factorial of it. For example:
 * if num = 4, then your program should return (4 * 3 * 2 * 1) = 24.
 * For the test cases, the range will be between 1 and 18 and the input will always be an integer.
 *
 * Examples
 * Input: 4
 * Output: 24
 *
 * Input: 8
 * Output: 40320
 */
@Slf4j
@Component
@NoArgsConstructor
public class FirstFactorial implements IChallange {
    @Override
    public Object execute(Object obj) {
        return findFirstFactorial ((Integer) obj);
    }

    private int findFirstFactorial (int num){
        if (num >= 1){
            return num * findFirstFactorial( num - 1);
        }else{
            return 1;
        }
    }
}
