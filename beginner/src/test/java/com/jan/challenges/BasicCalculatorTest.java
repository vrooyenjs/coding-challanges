package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicCalculatorTest {
    IChallange basicCalculator = new BasicCalculator();

    @Test
    void testExecute() {
        assertEquals(2.0, basicCalculator.execute(new Object[]{1.0, "+", 1.0}));
        assertEquals(14.2, basicCalculator.execute(new Object[]{5.0, "+", 9.2}));

        assertEquals(0.0, basicCalculator.execute(new Object[]{1.0, "-", 1.0}));
        assertEquals(12.5, basicCalculator.execute(new Object[]{19.0, "-", 6.5}));


        assertEquals(0.0, basicCalculator.execute(new Object[]{1.0, "*", 0.0}));
        assertEquals(1.0, basicCalculator.execute(new Object[]{1.0, "*", 1.0}));
        assertEquals(-1.0, basicCalculator.execute(new Object[]{1.0, "*", -1.0}));
        assertEquals(63.65, basicCalculator.execute(new Object[]{6.7, "*", 9.5}));

        assertEquals(1.0, basicCalculator.execute(new Object[]{1.0, "/", 1.0}));
        assertEquals(2.0, basicCalculator.execute(new Object[]{4.0, "/", 2.0}));
        assertEquals(0.0, basicCalculator.execute(new Object[]{1.0, "/", 0.0}));

    }
}
