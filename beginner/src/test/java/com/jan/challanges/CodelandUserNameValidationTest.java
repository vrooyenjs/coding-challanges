package com.jan.challanges;

import com.jan.challenges.CodelandUserNameValidation;
import com.jan.interfaces.IChallange;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodelandUserNameValidationTest {

    public static final String[] VALID_SELECTION = {"test", "Test1", "ValidUserName123", "U_ser_Na_me1"};
    public static final String[] INVALID_SELECTION = {"tes", "Test#", "Vali[]UserName123", "U_ser_Na_me!", "TestInvalid_"};


    @Test
    public void testCodelandUsernameValidation_not_enough_chars() {
        IChallange CodelandUserNameValidation = new CodelandUserNameValidation();

        for (int i = 0; i < 4; i++) {
            assertFalse((boolean) CodelandUserNameValidation.execute(RandomStringUtils.randomAlphabetic(i)));
        }
    }

    @Test
    public void testCodelandUsernameValidation_valid_selection() {
        IChallange CodelandUserNameValidation = new CodelandUserNameValidation();

        for (String username : VALID_SELECTION) {
            assertTrue((boolean) CodelandUserNameValidation.execute(username));
        }
    }

    @Test
    public void testCodelandUsernameValidation_invalid_selection() {
        IChallange CodelandUserNameValidation = new CodelandUserNameValidation();

        for (String username : INVALID_SELECTION) {
            assertFalse((boolean) CodelandUserNameValidation.execute(username));
        }
    }

    @Test
    public void testCodelandUsernameValidation_enough_chars() {
        IChallange CodelandUserNameValidation = new CodelandUserNameValidation();

        for (int i = 4; i < 25; i++) {
            assertTrue((boolean) CodelandUserNameValidation.execute(RandomStringUtils.randomAlphabetic(i)));
        }
    }

    @Test
    public void testCodelandUsernameValidation_too_many_chars() {
        IChallange CodelandUserNameValidation = new CodelandUserNameValidation();

        for (int i = 26; i < 50; i++) {
            assertFalse((boolean) CodelandUserNameValidation.execute(RandomStringUtils.randomAlphabetic(i)));
        }
    }
}
