package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class CheckDivisibilityTest{
    IChallange checkDivisibility = new CheckDivisibility();

    @Test
    public void testExecute_valid1(){
        assertTrue ((boolean)checkDivisibility.execute(new int[]{5, 5}));
        assertTrue ((boolean)checkDivisibility.execute(new int[]{10, 5}));
    }

    @Test
    public void testExecute_valid2(){
        assertFalse ((boolean)checkDivisibility.execute(new int[]{33, 2}));
        assertFalse ((boolean)checkDivisibility.execute(new int[]{9, 8}));
        assertFalse ((boolean)checkDivisibility.execute(new int[]{0, 0}));
    }
}

