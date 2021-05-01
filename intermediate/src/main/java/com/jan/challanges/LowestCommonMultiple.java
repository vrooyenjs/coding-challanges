package com.jan.challanges;

import com.jan.interfaces.IChallange;

/**
 * Create a function that takes two numbers as arguments and return the LCM of the two numbers.
 * Examples
 * <p>
 * lcm(3, 5) ➞ 15
 * <p>
 * lcm(14, 28) ➞ 28
 * <p>
 * lcm(4, 6) ➞ 12
 */
public class LowestCommonMultiple implements IChallange {
    @Override
    public Object execute(Object obj) {
        int[] arr = (int[]) obj;
        return lcm(arr[0], arr[1]);
    }

    int lcm(int a, int b) {
        // If the two numbers match, they are already on the LCM.
        if (a == b) {
            return a;
        }

        // We sort it to make sure the 'lowest' number is always in 'a'.
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }

        // We multiply 'b' by i until i is a or until a can be modulus'd into the multiple of b*i
        for (int i = 1; i < a; i++) {
            int multiple = b * i;
            if (multiple % a == 0) {
                return multiple;
            }
        }
        return a * b;
    }
}
