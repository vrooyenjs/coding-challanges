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
class SuperCrankyIntegersTest {


    @Test
    void testExecute_100l()  {
        IChallange superCrankyIntegers = new SuperCrankyIntegers();
        assertEquals(0L, (long) superCrankyIntegers.execute(100L));
    }

    @Test
    void testExecute_1000l()  {
        IChallange superCrankyIntegers = new SuperCrankyIntegers();
        assertEquals(1858L, (long) superCrankyIntegers.execute(1000L));
    }

    @Test
    void testExecute_10000l()  {
        IChallange superCrankyIntegers = new SuperCrankyIntegers();
        assertEquals(1858L, (long) superCrankyIntegers.execute(10000L));
    }

    @Test
    void testExecute_100000l()  {
        IChallange superCrankyIntegers = new SuperCrankyIntegers();
        assertEquals(1858L, (long) superCrankyIntegers.execute(100000L));
    }

//    @Test
    void testExecute_1000000l()  {
        IChallange superCrankyIntegers = new SuperCrankyIntegers();
        assertEquals(1778723L, (long) superCrankyIntegers.execute(1000000L));
    }

//    @Test
    void testExecute_10000000l()  {
        IChallange superCrankyIntegers = new SuperCrankyIntegers();
        assertEquals(5303474L, (long) superCrankyIntegers.execute(10000000L));
    }


//    @Test
    void testExecute_100000000l()  {
        IChallange superCrankyIntegers = new SuperCrankyIntegers();
        assertEquals(139852339L, (long) superCrankyIntegers.execute(100000000L));
    }


//    @Test
    void testExecute_1000000000l()  {
        IChallange superCrankyIntegers = new SuperCrankyIntegers();
        assertEquals(598515851L, (long) superCrankyIntegers.execute(1000000000L));
    }

//    @Test
    void testExecute_100000000000000l() {
        IChallange superCrankyIntegers = new SuperCrankyIntegers();
        assertEquals(1778723L, (long) superCrankyIntegers.execute(100000000000000L));
    }
}
