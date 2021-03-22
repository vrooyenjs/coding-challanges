package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

/**
 * Have the function CodelandUsernameValidation(str) take the str parameter being passed and determine if the string is a valid username according to the following rules:
 * <p>
 * 1. The username is between 4 and 25 characters.
 * 2. It must start with a letter.
 * 3. It can only contain letters, numbers, and the underscore character.
 * 4. It cannot end with an underscore character.
 * <p>
 * If the username is valid then your program should return the string true, otherwise return the string false.
 *
 * Input: "aa_"
 * Output: false
 *
 * Input: "u__hello_world123"
 * Output: true
 */
@Slf4j
@Component
@NoArgsConstructor
public class CodelandUserNameValidation implements IChallange {

    /**
     * ^ - Anchor for the 'beginning' of the string
     * [a-zA-Z] - indicates one and only one a-z or A-Z char
     * \w{2,23} - Indicates any string of length 2 to 23 with any word character (a-z, A-Z, 0-9, _)
     * [a-zA-Z0-9] - Indicates one and only one character of a-z, A-Z or 0-9.
     * $ - Anchor for the end of the string
     *
     */
    private static final Pattern PATTERN = Pattern.compile("^[a-zA-Z]\\w{2,23}[a-zA-Z0-9]$");

    @Override
    public Object execute(Object obj) {
        return codelandUsernameValidation(String.valueOf(obj));
    }

    protected boolean codelandUsernameValidation(String str) {
        return PATTERN.matcher(str).find();
    }
}
