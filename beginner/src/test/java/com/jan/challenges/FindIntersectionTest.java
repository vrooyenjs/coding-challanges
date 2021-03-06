package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindIntersectionTest {
    IChallange findIntersection = new FindIntersection();

    @Test
    void testFindIntersection_valid_test1(){
        assertEquals ("1,4,13", findIntersection.execute(new String[]{"1, 3, 4, 7, 13", "1, 2, 4, 13, 15"}));
    }

    @Test
    void testFindIntersection_valid_test2(){
        assertEquals ("1,9,10", findIntersection.execute(new String[]{"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}));
    }

    @Test
    void testExecute(){
        assertEquals ("1,9,10", findIntersection.execute(new String[]{"1, 3, 9, 10, 17, 18", "1, 4, 9, 10"}));
    }
}
