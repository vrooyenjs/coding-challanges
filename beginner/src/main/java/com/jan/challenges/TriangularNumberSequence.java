package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * This Triangular Number Sequence is generated from a pattern of dots that form a triangle. The first 5 numbers of the sequence, or dots, are:
 *
 * 1, 3, 6, 10, 15
 *
 * This means that the first triangle has just one dot, the second one has three dots, the third one has 6 dots and so on.
 *
 * Write a function that gives the number of dots with its corresponding triangle number of the sequence.
 * Examples
 *
 * triangle(1) ➞ 1
 *
 * triangle(6) ➞ 21
 *
 * triangle(215) ➞ 23220
 * @see "https://en.wikipedia.org/wiki/Triangular_number"
 */
@Slf4j
@Component
@NoArgsConstructor
public class TriangularNumberSequence implements IChallange {

    @Override
    public Object execute(Object obj) {
        return triangle ((int)obj);
    }

    private int triangle (int n){
        return ((n+1) * n) / 2;
    }
}
