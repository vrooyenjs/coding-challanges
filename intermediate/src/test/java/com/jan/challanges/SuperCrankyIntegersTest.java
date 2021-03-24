package com.jan.challanges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The integer 351 has the property that 3 x 51 = 153, the digit-reverse of 351. The same is true for 425322, since 42 x 5322 = 223524, and also for 57982563, since 579825 x 63 = 36528975.
 * <p>
 * Positive integers larger than 9 which have this property when written in decimal are called cranky.
 * <p>
 * The sum of all cranky integers smaller than 10^6 is 1778723. What is the sum of all cranky integers smaller than 10^14?
 */
public class SuperCrankyIntegersTest {

    IChallange superCrankyIntegers = new SuperCrankyIntegers();

    @Test
    void testExecute_1000000l() throws InterruptedException {
        assertEquals(1778723L, (long)superCrankyIntegers.execute(1000000L));
    }

    @Test
    void testExecute_100000000000000l() {
        assertEquals(1778723L, (long)superCrankyIntegers.execute(100000000000000L));
    }
}
