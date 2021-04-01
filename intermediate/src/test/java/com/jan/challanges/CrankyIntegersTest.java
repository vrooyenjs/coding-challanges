package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CrankyIntegersTest {

    private static CrankyIntegers crankyIntegers;

    @BeforeAll
    static void beforeTests() {
        crankyIntegers = new CrankyIntegers();
    }

    @Test
    void testExecute_10_7_load() {
        log.info("***************************************** Starting test");
        long before = System.currentTimeMillis();
        int iterations = 20;
        long highNumber = 10000000L;
        for (int i = 0 ; i < iterations ; i++){
            assertEquals(5303474L, (long) crankyIntegers.execute(highNumber));
        }
        double timeTaken = (System.currentTimeMillis() - before);
        float timePerCalc = (float) (timeTaken / (iterations * highNumber));
        log.info("Completed iteration({}) of batch({}) in: {} -- ~(({} * {}) / {}) ms per calc",
                iterations,
                highNumber,
                timeTaken,
                iterations,
                highNumber,
                timeTaken);
        // 1.0076E-4
        // 0.00010076
    }

//    @Test
    void testExecute_10_2() {
        log.info("***************************************** Starting test");
        assertEquals(0L, (long) crankyIntegers.execute(100L));
    }

//    @Test
    void testExecute_10_3() {
        log.info("***************************************** Starting test");
        assertEquals(1858L, (long) crankyIntegers.execute(1000L));
    }

//    @Test
    void testExecute_10_4() {
        log.info("***************************************** Starting test");
        assertEquals(1858L, (long) crankyIntegers.execute(10000L));
    }

//    @Test
    void testExecute_10_5() {
        log.info("***************************************** Starting test");
        assertEquals(1858L, (long) crankyIntegers.execute(100000L));
    }

//    @Test
    void testExecute_10_6() {
        log.info("***************************************** Starting test");
        assertEquals(1778723L, (long) crankyIntegers.execute(1000000L));
    }

//    @Test
    void testExecute_10_7() {
        log.info("***************************************** Starting test");
        assertEquals(5303474L, (long) crankyIntegers.execute(10000000L));
    }

//    @Test
    void testExecute_10_8() {
        log.info("***************************************** Starting test");
        assertEquals(139852339L, (long) crankyIntegers.execute(100000000L));
    }


//    @Test
    void testExecute_10_9() {
        log.info("***************************************** Starting test");
        assertEquals(598515851L, (long) crankyIntegers.execute(1000000000L));
    }
}