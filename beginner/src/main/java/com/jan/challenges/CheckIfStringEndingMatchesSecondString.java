package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * Create a function that takes two strings and returns true if the first string ends with the second string; otherwise return false.
 * Examples
 * <p>
 * checkEnding("abc", "bc") ➞ true
 * <p>
 * checkEnding("abc", "d") ➞ false
 * <p>
 * checkEnding("samurai", "zi") ➞ false
 * <p>
 * checkEnding("feminine", "nine") ➞ true
 * <p>
 * checkEnding("convention", "tio") ➞ false
 * <p>
 * Notes
 * <p>
 * All test cases are valid one word strings.
 */
@Slf4j
@Component
@NoArgsConstructor
public class CheckIfStringEndingMatchesSecondString implements IChallange {

    @Override
    public Object execute(Object obj) {
        String[] arr = (String[]) obj;

        return checkEndingMethodTwo(arr[0], arr[1]);
    }


    // My own function to perform this check.
    boolean checkEndingMethodTwo(String word, String ending) {
        // If either strings are null or empty, then fail immediately.
        if (word == null || ending == null || ending.length() == 0 || word.length() == 0) {
            return false;
        }

        // Start at the end and check each char moving backwards
        for (int i = 1; i <= ending.length(); i++) {

            /*
             * If any of the characters in the sequence do not match, stop iterating and return false.
             */
            if (word.charAt(word.length() - i) != ending.charAt(ending.length() - i)) {
                return false;
            }

        }

        // It's safe to assume that all characters have matched.
        return true;
    }
}
