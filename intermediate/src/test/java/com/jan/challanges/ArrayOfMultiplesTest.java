package com.jan.challanges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayOfMultiplesTest {

    IChallange arrayOfMultiples = new ArrayOfMultiples();

    @Test
    void testExecute (){
        assertArrayEquals (new int[]{7, 14, 21, 28, 35}, (int[]) arrayOfMultiples.execute(new int[]{7, 5}));
        assertArrayEquals (new int[]{12, 24, 36, 48, 60, 72, 84, 96, 108, 120}, (int[]) arrayOfMultiples.execute(new int[]{12, 10}));
        assertArrayEquals (new int[]{17, 34, 51, 68, 85, 102}, (int[]) arrayOfMultiples.execute(new int[]{17, 6}));
    }
}
