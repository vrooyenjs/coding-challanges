package com.jan.challanges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursiveReverseStringTest {
    IChallange recursiveReverseString = new RecursiveReverseString();

    @Test
    void testExecute() {
        assertEquals("olleh", recursiveReverseString.execute("hello"));
        assertEquals("dlrow", recursiveReverseString.execute("world"));
        assertEquals("a", recursiveReverseString.execute("a"));
        assertEquals("", recursiveReverseString.execute(""));
    }
}
