package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class RecursiveArraySumTest {
    IChallange recursiveArraySum = new RecursiveArraySum();

    @Test
    void testExecute() {
        assertEquals(10, recursiveArraySum.execute(new int[]{1, 2, 3, 4}));
        assertEquals(3, recursiveArraySum.execute(new int[]{1, 2}));
        assertEquals(1, recursiveArraySum.execute(new int[]{1}));
        assertEquals(0, recursiveArraySum.execute(new int[]{}));
    }
}
