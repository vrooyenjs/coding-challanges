package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SumOfTwoNumbersTest {
    IChallange sumOfTwoNumbers = new SumOfTwoNumbers();

    @Test
    void testExecute_valid1() {
        assertEquals(3, sumOfTwoNumbers.execute(new int[]{1, 2}));
    }

    @Test
    void testExecute_valid2() {
        assertEquals(-9, sumOfTwoNumbers.execute(new int[]{-3, -6}));
    }


    @Test
    void testExecute_valid3() {

        assertEquals(10, sumOfTwoNumbers.execute(new int[]{7, 3}));
    }

}
