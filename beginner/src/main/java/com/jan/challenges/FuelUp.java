package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * A vehicle needs 10 times the amount of fuel than the distance it travels. However, it must always carry a minimum of 100 fuel before setting off.
 * <p>
 * Create a function which calculates the amount of fuel it needs, given the distance.
 */
@Slf4j
@Component
@NoArgsConstructor
public class FuelUp implements IChallange {
    private static final double FUEL_MULTIPLIER = 10;
    private static final double ZERO_FUEL = 0.0;
    private static final double MINIMUM_FUEL = 100.0;

    @Override
    public Object execute(Object obj) {
        double[] arr = (double[]) obj;
        return fuelUp(arr[0], arr[1]);
    }

    private double fuelUp(double distance, double currentFuelLevel) {
        double fuelNeededForDistance = (distance * FUEL_MULTIPLIER);


        /*
         * Is the required amount of fuel less than the minimum requirement?
         */
        if (fuelNeededForDistance <= MINIMUM_FUEL) {

            /*
             * Do we have the minimum fuel amount?
             */
            if (currentFuelLevel <= MINIMUM_FUEL) {
                return MINIMUM_FUEL - currentFuelLevel;
            }

            /*
             * Otherwise we currently have more fuel than the minimum requirement
             */
            else {
                return ZERO_FUEL;
            }
        }

        /*
         * Otherwise, the fuel needed for the required distance is equal
         * to more than the minimum fuel amount.
         */
        else {

            /*
             * We subtract the current amount of fuel from what is required to find the total amount needed.
             */
            fuelNeededForDistance -= currentFuelLevel;
        }

        return fuelNeededForDistance;
    }
}
