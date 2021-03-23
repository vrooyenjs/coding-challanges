package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConvertMillisecondToPrettyTimeTest {
    IChallange convertMillisecondToPrettyTime = new ConvertMillisecondToPrettyTime();

    @Test
    void testExecute_invalid1() {
        assertEquals("0 week, 0 day, 0 hour, 0 minute, 0 second, -100 millisecond", convertMillisecondToPrettyTime.execute(-100L));
    }

    @Test
    void testExecute_valid1() {
        assertEquals("1 week, 0 day, 0 hour, 0 minute, 0 second, 0 millisecond", convertMillisecondToPrettyTime.execute(TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS)));
    }

    @Test
    void testExecute_valid2() {
        assertEquals("0 week, 1 day, 0 hour, 0 minute, 0 second, 0 millisecond", convertMillisecondToPrettyTime.execute(TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)));
    }

    @Test
    void testExecute_valid3() {
        assertEquals("0 week, 0 day, 1 hour, 0 minute, 0 second, 0 millisecond", convertMillisecondToPrettyTime.execute(TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)));
    }

    @Test
    void testExecute_valid4() {
        assertEquals("0 week, 0 day, 0 hour, 1 minute, 0 second, 0 millisecond", convertMillisecondToPrettyTime.execute(TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES)));
    }

    @Test
    void testExecute_valid5() {
        assertEquals("0 week, 0 day, 0 hour, 0 minute, 1 second, 0 millisecond", convertMillisecondToPrettyTime.execute(TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS)));
    }

    @Test
    void testExecute_valid6() {
        assertEquals("0 week, 0 day, 0 hour, 0 minute, 0 second, 1 millisecond", convertMillisecondToPrettyTime.execute(TimeUnit.MILLISECONDS.convert(1, TimeUnit.MILLISECONDS)));
    }

    @Test
    void testExecute_valid7() {
        long ms = TimeUnit.MILLISECONDS.convert(3486, TimeUnit.DAYS)+
                TimeUnit.MILLISECONDS.convert(97, TimeUnit.HOURS)+
                TimeUnit.MILLISECONDS.convert(38, TimeUnit.MINUTES)+
                TimeUnit.MILLISECONDS.convert(55, TimeUnit.SECONDS)+
                TimeUnit.MILLISECONDS.convert(957, TimeUnit.MILLISECONDS);
        assertEquals("498 weeks, 4 days, 1 hour, 38 minutes, 55 seconds, 957 milliseconds", convertMillisecondToPrettyTime.execute(ms));

        ms = 549846549681654L;
        assertEquals("909137 weeks, 5 days, 16 hours, 41 minutes, 21 seconds, 654 milliseconds", convertMillisecondToPrettyTime.execute(ms));
    }
}
