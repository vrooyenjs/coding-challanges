package com.jan.challanges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * A quadratic equation a x² + b x + c = 0 has either 0, 1, or 2 distinct solutions for real values of x. Given a, b and c, you should return the number of solutions to the equation.
 * Examples
 *
 * solutions(1, 0, -1) ➞ 2
 * // x² - 1 = 0 has two solutions (x = 1 and x = -1).
 *
 * solutions(1, 0, 0) ➞ 1
 * // x² = 0 has one solution (x = 0).
 *
 * solutions(1, 0, 1) ➞ 0
 * // x² + 1 = 0 has no real solutions.
 */
public class QuadraticSolutionsTest  {

    IChallange quadraticSolutions = new QuadraticSolutions();

    @Test
    void testExecute (){
        assertEquals (2, quadraticSolutions.execute(new int[]{1, 0 , -1}));

        assertEquals (1, quadraticSolutions.execute(new int[]{1, 0 , 0}));

        assertEquals (0, quadraticSolutions.execute(new int[]{1, 0 , 1}));
    }
}
