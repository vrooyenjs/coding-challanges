package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Have the function QuestionsMarks(str) take the str string parameter,
 * which will contain single digit numbers, letters, and question marks,
 * and check if there are exactly 3 question marks between every pair of
 * two numbers that add up to 10.
 * <p>
 * If so, then your program should return the string true, otherwise it should return the string false.
 * <p>
 * If there aren't any two numbers that add up to 10 in the string,
 * then your program should return false as well.
 * <p>
 * For example: if str is "arrb6???4xxbl5???eee5" then your program should return true
 * because there are exactly 3 question marks between 6 and 4, and 3
 * question marks between 5 and 5 at the end of the string.
 * <p>
 * Examples
 * Input: "aa6?9"
 * Output: false
 * <p>
 * Input: "acc?7??sss?3rr1??????5"
 * Output: true
 */
@Slf4j
@Component
@NoArgsConstructor
public class QuestionsMarks implements IChallange {
    @Override
    public Object execute(Object obj) {
        return questionsMarks(String.valueOf(obj));
    }

    protected boolean questionsMarks(String str) {
        boolean validString = false;

        int firstDigit = -1;
        int secondDigit = -1;
        int questionMarkCount = 0;


        for (char c : str.toCharArray()) {
            log.debug("Checking char: " + c);
            if (firstDigit > 0 && c == '?') {
                log.debug("questionMarkCount++");
                questionMarkCount++;
            }

            // We found a digit!
            if (Character.isDigit(c)) {

                // It's the first in the pair
                if (firstDigit < 0) {
                    firstDigit = Character.getNumericValue(c);
                    log.debug("Setting digit 1 to: " + firstDigit);
                }

                // It's the second of the first pair...
                else if (secondDigit < 0) {
                    secondDigit = Character.getNumericValue(c);
                    log.debug("Setting digit 2 to: " + secondDigit);

                    log.debug("SUM: " + (firstDigit + secondDigit));

                    /*
                     * No that we have the second digit...if the sum is equal to 10
                     */
                    if (firstDigit + secondDigit == 10) {
                        /*
                         * Then we check how many question marks were found since the first digit...
                         */
                        if (questionMarkCount == 3) {
                            log.info("Found a valid case!");
                            // Setting this will ensure that if we find at least one valid case, we will return true.
                            validString = true;
                        } else {
                            log.info("Fail immediate");
                            // If it is anything but 3, we fail immediately.
                            return false;
                        }

                        /*
                         * Now we make the first digit equald to the second one, resetting the search.
                         */
                        questionMarkCount = 0;
                        firstDigit = secondDigit;
                        secondDigit = -1;
                        log.debug("Setting digit 1 to: " + firstDigit);
                        log.debug("Setting digit 2 to: " + secondDigit);
                    }
                }
            }

        }

        return validString;
    }
}
