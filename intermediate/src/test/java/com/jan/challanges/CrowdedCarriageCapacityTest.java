package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrowdedCarriageCapacityTest {
    IChallange crowdedCarriageCapacity = new CrowdedCarriageCapacity();

    @Test
    void testExecute (){
        assertEquals(3, crowdedCarriageCapacity.execute(new Object[]{20, new int[]{3, 5, 4, 2}}));

        assertEquals(0, crowdedCarriageCapacity.execute(new Object[]{1000, new int[]{50, 20, 80, 90, 100, 60, 30, 50, 80, 60}}));

        assertEquals(-1, crowdedCarriageCapacity.execute(new Object[]{200, new int[]{35, 23, 40, 21, 38}}));
    }
}
