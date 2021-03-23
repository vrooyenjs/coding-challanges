package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangularNumberSequenceTest {

    IChallange triangularNumberSequence = new TriangularNumberSequence();

    @Test
    void testExecute (){
        assertEquals (1, triangularNumberSequence.execute(1));
        assertEquals (21, triangularNumberSequence.execute(6));
        assertEquals (23220, triangularNumberSequence.execute(215));
    }
}
