package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RockPaperScissorsTest {

    IChallange rockPaperScissors = new RockPaperScissors();

    @Test
    void testExecute() {
        // Player one wins
        assertEquals(1, rockPaperScissors.execute(new int[]{RockPaperScissors.ROCK, RockPaperScissors.SCISSORS}));
        assertEquals(1, rockPaperScissors.execute(new int[]{RockPaperScissors.SCISSORS, RockPaperScissors.PAPER}));
        assertEquals(1, rockPaperScissors.execute(new int[]{RockPaperScissors.PAPER, RockPaperScissors.ROCK}));

        // Playoer two wins
        assertEquals(2, rockPaperScissors.execute(new int[]{RockPaperScissors.ROCK, RockPaperScissors.PAPER}));
        assertEquals(2, rockPaperScissors.execute(new int[]{RockPaperScissors.SCISSORS, RockPaperScissors.ROCK}));
        assertEquals(2, rockPaperScissors.execute(new int[]{RockPaperScissors.PAPER, RockPaperScissors.SCISSORS}));
    }
}
