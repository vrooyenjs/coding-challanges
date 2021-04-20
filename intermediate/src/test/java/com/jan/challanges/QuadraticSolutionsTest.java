package com.jan.challanges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QuadraticSolutionsTest  {

    IChallange quadraticSolutions = new QuadraticSolutions();

    @Test
    void testExecute (){
        assertEquals (2, quadraticSolutions.execute(new int[]{1, 0 , -1}));

        assertEquals (1, quadraticSolutions.execute(new int[]{1, 0 , 0}));

        assertEquals (0, quadraticSolutions.execute(new int[]{1, 0 , 1}));
    }
}
