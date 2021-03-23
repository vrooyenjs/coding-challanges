package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * A quadratic equation a x² + b x + c = 0 has either 0, 1, or 2 distinct solutions for real values of x. Given a, b and c, you should return the number of solutions to the equation.
 * Examples
 * <p>
 * solutions(1, 0, -1) ➞ 2
 * // x² - 1 = 0 has two solutions (x = 1 and x = -1).
 * <p>
 * solutions(1, 0, 0) ➞ 1
 * // x² = 0 has one solution (x = 0).
 * <p>
 * solutions(1, 0, 1) ➞ 0
 * // x² + 1 = 0 has no real solutions.
 */
@Slf4j
@Component
@NoArgsConstructor
public class QuadraticSolutions implements IChallange {
    @Override
    public Object execute(Object obj) {
        int[] arr = (int[]) obj;
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        return solutions (a, b, c);
    }

    int solutions(int a, int b, int c) {
        // https://www.khanacademy.org/math/algebra-2018/quadratics/solving-quadratics-using-the-quadratic-formula/a/discriminant-review
        double discriminant = Math.pow(b, 2) - (4 * a * c);

        // A negative discriminant indicates that neither of the solutions are real numbers.
        if (discriminant < 0){
            return 0;
        }

        // A discriminant of zero indicates that the quadratic has a repeated real number solution.
        else if (discriminant == 0){
            return 1;
        }

        // A positive discriminant indicates that the quadratic has two distinct real number solutions.
        else {
            return 2;
        }
    }
}
