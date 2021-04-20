package com.jan.challanges;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
class SuperCrankyIntegersOldTest {
    IChallange superCrankyIntegers = new SuperCrankyIntegersOld();

    //        @Test
    void testExecute_for_graph() throws IOException {

        BufferedWriter writer = Files.newBufferedWriter(Paths.get("metrics.csv"));
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("Number", "TimeTaken"));


        for (long i = 1000000L; i < 100000000L + 1000000L; i += 1000000L) {
            long start = System.currentTimeMillis();
            superCrankyIntegers.execute(i);
            long finish = (System.currentTimeMillis() - start);

            log.info("Finished file: {}", i);
            csvPrinter.printRecord(String.valueOf(i), String.valueOf(finish));
        }
        csvPrinter.flush();
    }

    //    @Test
    void incrementalCacheBuilding() {
        for (long i = 0L; i < 100000000L + SuperCrankyIntegersOld.BLOCK_DIVISION_SEGMENT_SIZE; i += SuperCrankyIntegersOld.BLOCK_DIVISION_SEGMENT_SIZE) {
            long start = System.currentTimeMillis();
            superCrankyIntegers.execute(i);
            long finish = (System.currentTimeMillis() - start);

            log.info("Finished file: {} in {}ms", i, finish);
        }
    }

    //    @Test
    void testExecute_100l() {
        assertEquals(0L, (long) superCrankyIntegers.execute(100L));
    }

    //    @Test
    void testExecute_1000l() {
        assertEquals(1858L, (long) superCrankyIntegers.execute(1000L));
    }

    //    @Test
    void testExecute_10000l() {
        assertEquals(1858L, (long) superCrankyIntegers.execute(10000L));
    }

    //    @Test
    void testExecute_100000l() {
        assertEquals(1858L, (long) superCrankyIntegers.execute(100000L));
    }

    @Test
    void testExecute_1000000l() {
        assertEquals(1778723L, (long) superCrankyIntegers.execute(1000000L));
    }

    //    @Test
    void testExecute_10000000l() {
        assertEquals(5303474L, (long) superCrankyIntegers.execute(10000000L));
    }


    //    @Test
    void testExecute_100000000l() {
        assertEquals(139852339L, (long) superCrankyIntegers.execute(100000000L));
    }


    //    @Test
    void testExecute_1000000000l() {
        assertEquals(598515851L, (long) superCrankyIntegers.execute(1000000000L));
    }


    //    @Test
    void testExecute_10000000000l() {
        assertEquals(20304631882L, (long) superCrankyIntegers.execute(10000000000L));
    }

    //        @Test
    void testExecute_100000000000000l() {
        assertEquals(1778723L, (long) superCrankyIntegers.execute(100000000000000L));
    }
}
