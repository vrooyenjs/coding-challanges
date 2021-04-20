package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RectangleInCircleTest {
    IChallange rectangleInCircle = new RectangleInCircle();


    @Test
    void testExecute() {
        assertTrue((boolean) rectangleInCircle.execute(new int[]{8, 6, 5}));
        assertTrue((boolean) rectangleInCircle.execute(new int[]{8, 8, 15}));

        assertFalse((boolean) rectangleInCircle.execute(new int[]{5, 9, 5}));
        assertFalse((boolean) rectangleInCircle.execute(new int[]{4, 7, 4}));
    }
}
