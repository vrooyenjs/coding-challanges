package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CrankyIntegersTest {

    IChallange crankyIntegers;

    @Test
    void testExecute_100() {
        log.info("***************************************** Starting test");
        crankyIntegers = new CrankyIntegers();
        assertEquals(0L, (long) crankyIntegers.execute(100L));

    }

    @Test
    void testExecute_1000l() {
        log.info("***************************************** Starting test");
        crankyIntegers = new CrankyIntegers();
        assertEquals(1858L, (long) crankyIntegers.execute(1000L));
    }

    @Test
    void testExecute_10000l() {
        log.info("***************************************** Starting test");
        crankyIntegers = new CrankyIntegers();
        assertEquals(1858L, (long) crankyIntegers.execute(10000L));
    }

    @Test
    void testExecute_100000l() {
        log.info("***************************************** Starting test");
        crankyIntegers = new CrankyIntegers();
        assertEquals(1858L, (long) crankyIntegers.execute(100000L));
    }

    @Test
    void testExecute_1000000l() {
        log.info("***************************************** Starting test");
        crankyIntegers = new CrankyIntegers();
        assertEquals(1778723L, (long) crankyIntegers.execute(1000000L));
    }

    @Test
    void testExecute_10000000l() {
        log.info("***************************************** Starting test");
        crankyIntegers = new CrankyIntegers();
        assertEquals(5303474L, (long) crankyIntegers.execute(10000000L));
    }

}