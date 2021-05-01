package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Write a function that reverses a string. Make your function recursive.
 * Examples
 * <p>
 * reverse("hello") ➞ "olleh"
 * <p>
 * reverse("world") ➞ "dlrow"
 * <p>
 * reverse("a") ➞ "a"
 * <p>
 * reverse("") ➞ ""
 * <p>
 * Notes
 * <p>
 * For non-base cases, your function must call itself at least once.
 * Check the Resources tab for info on recursion.
 */
@Slf4j
@Component
@NoArgsConstructor
public class RecursiveReverseString implements IChallange {
    @Override
    public Object execute(Object obj) {
        return reverse((String) obj);
    }

    private String reverse(String str) {
        if (str.equals("")) {
            return "";
        }

        return str.charAt(str.length() - 1) + reverse(str.substring(0, str.length() - 1));
    }
}
