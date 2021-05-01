package com.jan.challanges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LowestCommonMultipleTest {

    IChallange lowestCommonMultiple = new LowestCommonMultiple();

    @Test
    void testExecute() {
        assertEquals(4, lowestCommonMultiple.execute(new int[]{2, 4}));
        assertEquals(6, lowestCommonMultiple.execute(new int[]{2, 3}));
        assertEquals(15, lowestCommonMultiple.execute(new int[]{3, 5}));
        assertEquals(12, lowestCommonMultiple.execute(new int[]{4, 6}));
    }
}
