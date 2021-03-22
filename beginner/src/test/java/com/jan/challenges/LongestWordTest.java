package com.jan.challenges;

import com.jan.interfaces.IChallange;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestWordTest {

    IChallange longestWord = new LongestWord();

    @Test
    void testExecute_valid1 (){
        assertEquals ("time", String.valueOf(longestWord.execute("fun&!! time")));
    }

    @Test
    void testExecute_valid2(){
        assertEquals ("love", String.valueOf(longestWord.execute("I love dogs")));
    }


    @Test
    void testExecute_valid3(){
        assertEquals ("expression", String.valueOf(longestWord.execute("your regular expression here")));
    }


    @Test
    void testExecute_empty_string(){
        assertEquals ("", String.valueOf(longestWord.execute("")));
    }

    @Test
    void testExecute_no_words(){
        assertEquals ("", String.valueOf(longestWord.execute("*( ^%&*(#$%^ ^@!#$%^@43576 3567 8")));
    }
}
