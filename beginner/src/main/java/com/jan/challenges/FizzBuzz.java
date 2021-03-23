package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create a function that takes a number as an argument and returns "Fizz", "Buzz" or "FizzBuzz".
 * <p>
 * If the number is a multiple of 3 the output should be "Fizz".
 * If the number given is a multiple of 5, the output should be "Buzz".
 * If the number given is a multiple of both 3 and 5, the output should be "FizzBuzz".
 * If the number is not a multiple of either 3 or 5, the number should be output on its own as shown in the examples below.
 * The output should always be a string even if it is not a multiple of 3 or 5.
 * <p>
 * Examples
 *
 * fizzBuzz(3) ➞ "Fizz"
 *
 * fizzBuzz(5) ➞ "Buzz"
 *
 * fizzBuzz(15) ➞ "FizzBuzz"
 *
 * fizzBuzz(4) ➞ "4"
 */
@Slf4j
@Component
@NoArgsConstructor
public class FizzBuzz implements IChallange {
    private static final String BUZZ = "Buzz";
    private static final String FIZZ = "Fizz";
    @Override
    public Object execute(Object obj) {
        return fizzBuzz((int) obj);
    }

    String fizzBuzz(int num) {
        boolean isFizz = (num % 3 == 0);
        boolean isBuzz = (num % 5 == 0);

        // If the number given is a multiple of both 3 and 5, the output should be "FizzBuzz".
        if (isFizz && isBuzz){
            return FIZZ + BUZZ;
        }

        // If the number is a multiple of 3 the output should be "Fizz".
        else if (isFizz){
            return FIZZ;
        }

        // If the number given is a multiple of 5, the output should be "Buzz".
        else if (isBuzz){
            return BUZZ;
        }

        // If the number is not a multiple of either 3 or 5, the number should be output on its own
        else{
            return String.valueOf(num);
        }
    }
}
