package com.jan.challanges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PerfectSquarePatchTest {
    IChallange perfectSquarePatch = new PerfectSquarePatch();

    @Test
    void testExecute() {
        assertArrayEquals(new int[][]{}, (int[][]) perfectSquarePatch.execute(0));

        assertArrayEquals(new int[][]{{1}}, (int[][]) perfectSquarePatch.execute(1));

        assertArrayEquals(new int[][]{{2, 2}, {2, 2}}, (int[][]) perfectSquarePatch.execute(2));

        assertArrayEquals(new int[][]{{3, 3, 3}, {3, 3, 3}, {3, 3, 3}}, (int[][]) perfectSquarePatch.execute(3));
    }
}
