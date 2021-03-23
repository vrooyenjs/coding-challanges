package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HowManyVowelsTest {

    IChallange howManyVowels = new HowManyVowels();

    @Test
    void testExecute() {
        assertEquals(5, howManyVowels.execute("Celebration"));
        assertEquals(1, howManyVowels.execute("Palm"));
        assertEquals(4, howManyVowels.execute("Prediction"));
        assertEquals(0, howManyVowels.execute("b"));
        assertEquals(0, howManyVowels.execute(""));
    }

}
