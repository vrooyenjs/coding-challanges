package com.jan.challanges;

import com.jan.interfaces.IChallange;

/**
 * Write a function that changes every letter to the next letter:
 * <p>
 * "a" becomes "b"
 * "b" becomes "c"
 * "d" becomes "e"
 * and so on ...
 * <p>
 * Examples
 * <p>
 * move("hello") ➞ "ifmmp"
 * <p>
 * move("bye") ➞ "czf"
 * <p>
 * move("welcome") ➞ "xfmdpnf"
 * <p>
 * Note: This is circular in nature. i.e. z becomes a
 */
public class ChangeEveryLetterToTheNextLetter implements IChallange {
    @Override
    public Object execute(Object obj) {
        return move((String) obj);
    }

    private String move(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()){
            if ((int)c < (int)'z') {
                stringBuilder.append((char) (((int) c) + 1));
            }else{
                stringBuilder.append('a');
            }
        }
        return stringBuilder.toString();
    }
}
