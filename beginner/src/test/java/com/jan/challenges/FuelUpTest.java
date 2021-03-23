package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class FuelUpTest {
    IChallange fuelUp = new FuelUp();

    @Test
    void testExecute_less_than_minimum_tank () {
        // Have a 'minimum' tank that needs 100 units of fuel for the distance
        assertEquals(0.0, fuelUp.execute(new double[]{10.0, 100.0}));
        // Have a 'half minimum' tank that needs 100 units of fuel for the distance
        assertEquals(50.0, fuelUp.execute(new double[]{10.0, 50.0}));
        // Have a 'empty' tank that needs 100 units of fuel for the distance
        assertEquals(100.0, fuelUp.execute(new double[]{10.0, 0.0}));
        // We have more than enough fuel for the trip.
        assertEquals(0.0, fuelUp.execute(new double[]{8.0, 500.0}));
    }

    @Test
    void testExecute_more_than_minimum_tank() {
        assertEquals(250.0, fuelUp.execute(new double[]{25.0, 0.0}));
        assertEquals(240.0, fuelUp.execute(new double[]{25.0, 10.0}));
        assertEquals(815.0, fuelUp.execute(new double[]{89.0, 75.0}));
    }

    @Test
    void testExecute_negative_distance() {
        assertEquals(100.0, fuelUp.execute(new double[]{-1.0, 0.0}));
    }

    @Test
    void testExecute_valid_multi_tests() {
        // test values for less than 100 units of fuel
        for (double i = 0; i <= 10; i += 0.5) {
            assertEquals(100.0, fuelUp.execute(new double[]{i, 0.0}));
        }

        for (double k = 100.0; k >= 0; k -= 0.5) {
            assertEquals((100.0 - k), fuelUp.execute(new double[]{10.0, k}));
        }

        for (double i = 0; i <= 10; i += 0.5) {
            for (double k = 100.0; k >= 0; k -= 0.5) {
                assertEquals((100.0 - k), fuelUp.execute(new double[]{i, k}));
            }
       }
    }

}
