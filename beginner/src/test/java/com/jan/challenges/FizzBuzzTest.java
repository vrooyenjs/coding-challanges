package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class FizzBuzzTest {

    IChallange fizzBuzz = new FizzBuzz();

    @Test
    void testExecute() {
        assertEquals("Fizz", fizzBuzz.execute(3));
        assertEquals("4", fizzBuzz.execute(4));
        assertEquals("Buzz", fizzBuzz.execute(5));
        assertEquals("FizzBuzz", fizzBuzz.execute(15));
    }
}
