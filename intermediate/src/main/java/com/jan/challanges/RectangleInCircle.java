package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create a function that takes three numbers — the width and height of a rectangle, and the radius of a circle and returns true if the rectangle can fit inside the circle, false if it can't.
 * Examples
 * <p>
 * rectangleInCircle(8, 6, 5) ➞ true
 * <p>
 * rectangleInCircle(5, 9, 5) ➞ false
 * <p>
 * rectangleInCircle(4, 7, 4) ➞ false
 */
@Slf4j
@Component
@NoArgsConstructor
public class RectangleInCircle implements IChallange {
    @Override
    public Object execute(Object obj) {
        int[] arr = (int[]) obj;
        return rectangleInCircle(arr[0], arr[1], arr[2]);
    }

    private boolean rectangleInCircle(double rectangleWidth, double rectangleHeight, double circleRadius) {
        double hypotenuse = Math.sqrt(Math.pow(rectangleHeight, 2) + Math.pow(rectangleWidth, 2));
        log.info("Circle Radius: {} | Hypotenuse: {}", circleRadius, hypotenuse);
        return (circleRadius * 2) >= hypotenuse;
    }
}
