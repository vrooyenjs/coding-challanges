package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FirstFactorialTest {

    IChallange firstFactorial = new FirstFactorial();

    @Test
    void testExecute_valid_1(){
        assertEquals (24, firstFactorial.execute(4));
    }

    @Test
    void testExecute_valid_2(){
        assertEquals (40320, firstFactorial.execute(8));
    }

    @Test
    void testExecute_valid_3(){
        assertEquals (1, firstFactorial.execute(1));
    }

    @Test
    void testExecute_valid_4(){
        assertEquals (1, firstFactorial.execute(0));
    }
}
