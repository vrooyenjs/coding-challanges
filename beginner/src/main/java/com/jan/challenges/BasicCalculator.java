package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create a function that takes two numbers and a mathematical operator + - / * and will perform a calculation with the given numbers.
 * Examples
 * <p>
 * calculator(2, '+', 2) ➞ 4
 * <p>
 * calculator(2, '*', 2) ➞ 4
 * <p>
 * calculator(4, '/', 2) ➞ 2
 * <p>
 * Notes
 * <p>
 * If the input tries to divide by 0, return 0.
 */
@Slf4j
@Component
@NoArgsConstructor
public class BasicCalculator implements IChallange {

    @Override
    public Object execute(Object obj) {
        Object[] arr = (Object[]) obj;
        return calculator((double) arr[0], (String) arr[1], (double) arr[2]);
    }

    double calculator(double firstTerm, String operation, double secondTerm) {
        switch (operation) {
            case "+":
                return firstTerm + secondTerm;

            case "-":
                return firstTerm - secondTerm;

            case "*":
                return firstTerm * secondTerm;

            case "/":
                if (secondTerm == 0) return 0;
                return firstTerm / secondTerm;

            default:
                return 0;
        }
    }
}
