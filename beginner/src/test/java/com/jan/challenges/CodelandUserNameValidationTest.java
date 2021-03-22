package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CodelandUserNameValidationTest {

    public static final String[] VALID_SELECTION = {"test", "Test1", "ValidUserName123", "U_ser_Na_me1"};
    public static final String[] INVALID_SELECTION = {"tes", "Test#", "Vali[]UserName123", "U_ser_Na_me!", "TestInvalid_"};

    IChallange CodelandUserNameValidation = new CodelandUserNameValidation();

    @Test
    void testCodelandUsernameValidation_not_enough_chars() {
        for (int i = 0; i < 4; i++) {
            assertFalse((boolean) CodelandUserNameValidation.execute(RandomStringUtils.randomAlphabetic(i)));
        }
    }

    @Test
    void testCodelandUsernameValidation_valid_selection() {
        for (String username : VALID_SELECTION) {
            assertTrue((boolean) CodelandUserNameValidation.execute(username));
        }
    }

    @Test
    void testCodelandUsernameValidation_invalid_selection() {
        for (String username : INVALID_SELECTION) {
            assertFalse((boolean) CodelandUserNameValidation.execute(username));
        }
    }

    @Test
    void testCodelandUsernameValidation_enough_chars() {
        for (int i = 4; i < 25; i++) {
            assertTrue((boolean) CodelandUserNameValidation.execute(RandomStringUtils.randomAlphabetic(i)));
        }
    }

    @Test
    void testCodelandUsernameValidation_too_many_chars() {
        for (int i = 26; i < 50; i++) {
            assertFalse((boolean) CodelandUserNameValidation.execute(RandomStringUtils.randomAlphabetic(i)));
        }
    }
}
