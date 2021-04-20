package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Create a function that takes a string and returns true or false, depending on whether the characters are in order or not.
 * Examples
 * <p>
 * isInOrder("abc") ➞ true
 * <p>
 * isInOrder("edabit") ➞ false
 * <p>
 * isInOrder("123") ➞ true
 * <p>
 * isInOrder("xyzz") ➞ true
 * <p>
 * Notes
 * <p>
 * You don't have to handle empty strings.
 */
public class IsTheStringInOrderTest {

    IChallange isTheStringInOrder = new IsTheStringInOrder();

    @Test
    void testExecute() {
        assertTrue((boolean)isTheStringInOrder.execute("a"));
        assertTrue((boolean)isTheStringInOrder.execute("abc"));
        assertTrue((boolean)isTheStringInOrder.execute("xyz"));
        assertTrue((boolean)isTheStringInOrder.execute("xxyyzz"));
        assertTrue((boolean)isTheStringInOrder.execute("123"));
        assertTrue((boolean)isTheStringInOrder.execute("23"));

        assertFalse((boolean)isTheStringInOrder.execute("edabit"));
        assertFalse((boolean)isTheStringInOrder.execute("cba"));
        assertFalse((boolean)isTheStringInOrder.execute("zyx"));
        assertFalse((boolean)isTheStringInOrder.execute("321"));
        assertFalse((boolean)isTheStringInOrder.execute("21"));

    }


}
