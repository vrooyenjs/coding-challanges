package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 *
 */
@Slf4j
@Component
@NoArgsConstructor
public class UnitOfLengthConversion implements IChallange {

    public static final int FROM_MILLIMETER = 0;
    public static final int FROM_CENTIMETER = 1;
    public static final int FROM_METER = 2;
    public static final int FROM_KILOMETER = 3;
    public static final int FROM_INCH = 4;
    public static final int FROM_FOOT = 5;
    public static final int FROM_MILE= 6;

    public static final int TO_MILLIMETER = 0;
    public static final int TO_CENTIMETER = 1;
    public static final int TO_METER = 2;
    public static final int TO_KILOMETER = 3;
    public static final int TO_INCH = 4;
    public static final int TO_FEET = 5;
    public static final int TO_MILE = 6;

    /**
     * Static conversion table
     */
    private static final double[][] CONVERSION_LOOKUP = new double[][]
            {
                    // TO_MILLIMETER, TO_CENTIMETER, TO_METER, TO_KILOMETER, TO_INCH, TO_FEET, TO_MILE
                    {1.0, 0.1, 0.001, 0.000001, 0.03937007874, 0.003280839895, 0.0000006213711922}, // FROM_MILLIMETER
                    {10, 1, 0.01, 0.00001, 0.3937007874, 0.03280839895, 0.000006213711922}, // FROM_CENTIMETER
                    {1000, 100, 1, 0.001, 39.370078740, 0.3280839895, 0.0006213711922},  // FROM_METER
                    {1000000, 100000, 1000, 1.0, 39370.078740, 3280.839895, 0.6213711922},  // FROM_KILOMETER
                    {25.4, 2.54, 0.0254, 0.0000254, 1.0, 0.0833333, 0.0000157828283},  // FROM_INCH
                    {304.8, 30.48, 0.3048, 0.0003048, 12, 1.0, 0.000189394},  // FROM_FOOT
                    {1609340.0, 160934.0, 1609.34, 1.60934, 63360, 5280, 1.0}  // FROM_MILE
            };


    @Override
    public Object execute(Object obj) {
        Object[] arr = (Object[]) obj;
        int convertFrom = (int) arr[0];
        int convertTo = (int) arr[1];
        double input = (double) arr[2];

        return convert(convertFrom, convertTo, input);
    }

    private double convert(int convertFrom, int convertTo, double input) {
        return CONVERSION_LOOKUP[convertFrom][convertTo] * input;
    }
}
