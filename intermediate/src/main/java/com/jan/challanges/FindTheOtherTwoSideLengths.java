package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Given the shortest side of a 30° by 60° by 90° triangle you have to find out the other 2 sides, (return the longest side, medium-length side).
 * Examples
 * <p>
 * otherSides(1) ➞ [2.0, 1.73]
 * <p>
 * otherSides(12) ➞ [24.0, 20.78]
 * <p>
 * otherSides(2) ➞ [4.0, 3.46]
 * <p>
 * otherSides(3) ➞ [6.0, 5.2]
 * <p>
 * Notes
 * <p>
 * 30° by 60° by 90° triangles always follow this rule, let's say the shortest side length is x units, the hypotenuse would be 2x units and the other side would be x * root3 units.
 * The results in the Tests are rounded up to 2 decimal places.
 * Return the result as an array.
 */
@Slf4j
@Component
@NoArgsConstructor
public class FindTheOtherTwoSideLengths implements IChallange {

    @Override
    public Object execute(Object obj) {
        return otherSides((double) obj);
    }

    private double[] otherSides(double shortSide) {
        return new double[]{findLongSide(shortSide), findMediumSide(shortSide)};
    }

    private double findLongSide(double shortSide) {
        return BigDecimal.valueOf(2 * shortSide)
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }

    private double findMediumSide(double shortSide) {
        return BigDecimal.valueOf(shortSide * Math.sqrt(3))
                .setScale(2, RoundingMode.HALF_UP)
                .doubleValue();
    }
}
