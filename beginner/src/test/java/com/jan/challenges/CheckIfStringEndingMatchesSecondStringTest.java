package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CheckIfStringEndingMatchesSecondStringTest {
    IChallange checkIfStringEndingMatchesSecondString = new CheckIfStringEndingMatchesSecondString();

    @Test
    void testExecute_valid_tests() {
        assertTrue((boolean) checkIfStringEndingMatchesSecondString.execute(new String[]{"testing", "ing"}));

        assertTrue((boolean) checkIfStringEndingMatchesSecondString.execute(new String[]{"feminine", "inine"}));
    }


    @Test
    void testExecute_invalid_tests() {
        assertFalse((boolean) checkIfStringEndingMatchesSecondString.execute(new String[]{"abc", "d"}));

        assertFalse((boolean) checkIfStringEndingMatchesSecondString.execute(new String[]{"samurai", "rzi"}));
    }
}
