package com.jan.challanges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ChangeEveryLetterToTheNextLetterTest {
    IChallange changeEveryLetterToTheNextLetter = new ChangeEveryLetterToTheNextLetter();

    @Test
    void testExecute() {
        assertEquals("ifmmp", changeEveryLetterToTheNextLetter.execute("hello"));
        assertEquals("czf", changeEveryLetterToTheNextLetter.execute("bye"));
        assertEquals("xfmdpnf", changeEveryLetterToTheNextLetter.execute("welcome"));
        assertEquals("yza", changeEveryLetterToTheNextLetter.execute("xyz"));
    }
}
