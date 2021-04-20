package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WarOfNumbersTest {

    IChallange warOfNumbers = new WarOfNumbers();

    @Test
    void testExecute (){
        assertEquals(2, warOfNumbers.execute(new int[]{2, 8, 7, 5}));
        assertEquals(27, warOfNumbers.execute(new int[]{12, 90, 75}));
        assertEquals(168, warOfNumbers.execute(new int[]{5, 9, 45, 6, 2, 7, 34, 8, 6, 90, 5, 243}));
    }
}
