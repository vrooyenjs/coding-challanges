package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuestionsMarksTest {

    IChallange questionsMarks = new QuestionsMarks();

    @Test
    void testQuestionsMarks_valid() {
        assertTrue((Boolean) questionsMarks.execute("acc?7??sss?3rr1??????5"));
    }

    @Test
    void testQuestionsMarks_invalid() {
        assertFalse((Boolean) questionsMarks.execute("aa6?9"));
    }
}
