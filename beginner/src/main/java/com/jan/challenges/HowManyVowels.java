package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create a function that takes a string and returns the number (count) of vowels contained within it.
 * Examples
 *
 * countVowels("Celebration") ➞ 5
 *
 * countVowels("Palm") ➞ 1
 *
 * countVowels("Prediction") ➞ 4
 */
@Slf4j
@Component
@NoArgsConstructor
public class HowManyVowels implements IChallange {

    private static final Pattern PATTERN = Pattern.compile("a+|e+|i+|o+|u+");

    @Override
    public Object execute(Object obj) {
        return countVowels((String)obj);
    }

    private int countVowels(String sentence){
        Matcher matcher = PATTERN.matcher(sentence);

        int count = 0;
        while (matcher.find()){
            count ++;
        }
        return count;
    }
}
