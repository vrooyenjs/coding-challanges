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
        assertEquals(0L, (long) crankyIntegers.execute(100L));
    }


    //    @Test
    void testExecute_10_2() {
        // ~ 1.45 ms
        log.info("***************************************** Starting test");
        assertEquals(0L, (long) crankyIntegers.execute(100L));
    }

    //    @Test
    void testExecute_10_3() {
        // < 1.5 ms
        log.info("***************************************** Starting test");
        assertEquals(1858L, (long) crankyIntegers.execute(1000L));
    }

    //    @Test
    void testExecute_10_4() {
        // ~ 5 ms
        log.info("***************************************** Starting test");
        assertEquals(1858L, (long) crankyIntegers.execute(10000L));
    }

    //    @Test
    void testExecute_10_5() {
        // ~11 ms
        log.info("***************************************** Starting test");
        assertEquals(1858L, (long) crankyIntegers.execute(100000L));
    }

    //    @Test
    void testExecute_10_6() {
        // ~90 ms
        log.info("***************************************** Starting test");
        assertEquals(1778723L, (long) crankyIntegers.execute(1000000L));
    }

    @Test
    void testExecute_10_7() {
        // ~ 940 ms
        log.info("***************************************** Starting test");
        assertEquals(5303474L, (long) crankyIntegers.execute(10000000L));
    }

    //    @Test
    void testExecute_10_8() {
        // ~13 000 ms
        log.info("***************************************** Starting test");
        assertEquals(139852339L, (long) crankyIntegers.execute(100000000L));
    }

    //    @Test
    void testExecute_10_9() {
        log.info("***************************************** Starting test");
        assertEquals(598515851L, (long) crankyIntegers.execute(1000000000L));
    }

    //    @Test
    void testExecute_10_10() {
        // ~30 minutes
        log.info("***************************************** Starting test");
        assertEquals(20304631882L, (long) crankyIntegers.execute(10000000000L));
    }


    //    @Test
    void testExecute_10_11() {
        log.info("***************************************** Starting test");
        assertEquals(20304631882L, (long) crankyIntegers.execute(100000000000L));
    }
}