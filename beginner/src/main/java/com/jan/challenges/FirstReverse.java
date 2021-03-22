package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Have the function FirstReverse(str) take the str
 * parameter being passed and return the string in reversed order.
 *
 * For example: if the input string is "Hello World and Coders" then
 * your program should return the string sredoC dna dlroW olleH.
 */
@Slf4j
@Component
@NoArgsConstructor
public class FirstReverse implements IChallange {
    @Override
    public Object execute(Object obj) {
        return findFirstReverse (String.valueOf(obj));
    }

    private String findFirstReverse(String str){
        char [] reversed = new char[str.length()];

        int index = 0;
        for (int i = str.length() - 1 ; i >= 0 ; i --){
            char c = str.charAt(i);
            reversed[index] = c;
            index ++;
        }
        return new String (reversed);
    }
}
