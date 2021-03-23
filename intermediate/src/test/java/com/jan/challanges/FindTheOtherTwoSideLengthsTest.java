package com.jan.challanges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class FindTheOtherTwoSideLengthsTest {

    IChallange findTheOtherTwoSideLengths = new FindTheOtherTwoSideLengths();

    @Test
    void testExecute (){
        assertArrayEquals (new double[]{2.0, 1.73}, (double[])findTheOtherTwoSideLengths.execute(1.0));

        assertArrayEquals (new double[]{24.0, 20.78}, (double[])findTheOtherTwoSideLengths.execute(12.0));

        assertArrayEquals (new double[]{4.0, 3.46}, (double[])findTheOtherTwoSideLengths.execute(2.0));

        assertArrayEquals (new double[]{6.0, 5.2}, (double[])findTheOtherTwoSideLengths.execute(3.0));
    }
}
