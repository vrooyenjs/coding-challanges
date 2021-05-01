package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Create a function which simulates the game "rock, paper, scissors". The function takes the input of both players (rock, paper or scissors), first parameter from first player, second from second player. The function returns the result as such:
 * <p>
 * "Player 1 wins"
 * "Player 2 wins"
 * "TIE" (if both inputs are the same)
 * <p>
 * The rules of rock, paper, scissors, if not known:
 * <p>
 * Both players have to say either "rock", "paper" or "scissors" at the same time.
 * Rock beats scissors, paper beats rock, scissors beat paper.
 * <p>
 * Examples
 * <p>
 * rps("rock", "paper") ➞ "Player 2 wins"
 * <p>
 * rps("paper", "rock") ➞ "Player 1 wins"
 * <p>
 * rps("paper", "scissors") ➞ "Player 2 wins"
 * <p>
 * rps("scissors", "scissors") ➞ "TIE"
 * <p>
 * rps("scissors", "paper") ➞ "Player 1 wins"
 */
@Slf4j
@Component
@NoArgsConstructor
public class RockPaperScissors implements IChallange {

    public static final int ROCK = 0;
    public static final int PAPER = 1;
    public static final int SCISSORS = 3;

    @Override
    public Object execute(Object obj) {
        int[] arr = (int[]) obj;
        return rps(arr[0], arr[1]);
    }

    private int rps(int playerOneChoice, int playerTwoChoice) {
        if (playerOneChoice < 0 || playerOneChoice > 3 || playerTwoChoice < 0 || playerTwoChoice > 3) {
            return -1;
        }

        switch (playerOneChoice) {
            case ROCK:
                switch (playerTwoChoice) {
                    case ROCK:
                        return -1;
                    case PAPER:
                        return 2;
                    case SCISSORS:
                        return 1;
                }

            case PAPER:
                switch (playerTwoChoice) {
                    case ROCK:
                        return 1;
                    case PAPER:
                        return -1;
                    case SCISSORS:
                        return 2;
                }
            case SCISSORS:
                switch (playerTwoChoice) {
                    case ROCK:
                        return 2;
                    case PAPER:
                        return 1;
                    case SCISSORS:
                        return -1;
                }

            default:
                return -1;
        }
    }
}
