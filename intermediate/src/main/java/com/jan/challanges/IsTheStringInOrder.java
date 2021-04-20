package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * Create a function that takes a string and returns true or false, depending on whether the characters are in order or not.
 * Examples
 * <p>
 * isInOrder("abc") ➞ true
 * <p>
 * isInOrder("edabit") ➞ false
 * <p>
 * isInOrder("123") ➞ true
 * <p>
 * isInOrder("xyzz") ➞ true
 * <p>
 * Notes
 * <p>
 * You don't have to handle empty strings.
 */
@Slf4j
@Component
@NoArgsConstructor
public class IsTheStringInOrder implements IChallange {
    @Override
    public Object execute(Object obj) {
        return isInOrder((String) obj);
    }

    private boolean isInOrder(String str) {
        if (StringUtils.isBlank(str)) {
            return false;
        }
        char[] charArr = str.toCharArray();
        for (int i = 0; i < str.length() - 1; i++) {
            if ((int) charArr[i] > (int) charArr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
