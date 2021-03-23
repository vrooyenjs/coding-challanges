package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Create a function which returns the number of true values there are in an array.
 * Examples
 * <p>
 * countTrue([true, false, false, true, false]) ➞ 2
 * <p>
 * countTrue([false, false, false, false]) ➞ 0
 * <p>
 * countTrue([]) ➞ 0
 * <p>
 * Notes
 * <p>
 * Return 0 if given an empty array.
 * All array items are of the type bool (true or false).
 */
public class HowMuchIsTrueTest {

    IChallange howMuchIsTrue = new HowMuchIsTrue();

    @Test
    void testExecute_with_values() {
        assertEquals(5, howMuchIsTrue.execute(new boolean[]{true, false, true, true, false, true, false, true}));


        assertEquals(3, howMuchIsTrue.execute(new boolean[]{true, false, true, false, false, true}));
    }


    @Test
    void testExecute_without_values() {
        assertEquals(0, howMuchIsTrue.execute(new boolean[]{false}));


        assertEquals(0, howMuchIsTrue.execute(new boolean[]{}));
    }
}
