package com.jan.challenges;

import com.jan.interfaces.IChallange;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Have the function LongestWord(sen) take the sen parameter being passed
 * and return the largest word in the string. If there are two or more
 * words that are the same length, return the first word from the string with
 * that length. Ignore punctuation and assume sen will not be empty.
 * <p>
 * Examples
 * Input: "fun&!! time"
 * Output: time
 * Input: "I love dogs"
 * Output: love
 */
public class LongestWord implements IChallange {

    private static final Pattern WORD_PATTERN = Pattern.compile("[a-zA-Z]+");

    @Override
    public Object execute(Object obj) {
        return findLongestWord(String.valueOf(obj));
    }

    private String findLongestWord(String sentence) {
        Matcher matcher = WORD_PATTERN.matcher(sentence);
        String longestWord = "";

        while (matcher.find()){
            String word = matcher.group();

            if (word.length() > longestWord.length()){
                longestWord = word;
            }
        }

        return longestWord;
    }

}
