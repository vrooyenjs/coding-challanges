package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;


/**
 * The integer 351 has the property that 3 x 51 = 153, the digit-reverse of 351.
 * <p>
 * The same is true for 425322, since 42 x 5322 = 223524, and also for 57982563, since 579825 x 63 = 36528975.
 * <p>
 * <p>
 * Positive integers larger than 9 which have this property when written in decimal are called cranky.
 * <p>
 * <p>
 * The sum of all cranky integers smaller than 10^6 is 1778723. What is the sum of all cranky integers smaller than 10^14?
 */
@Slf4j
@Component
@NoArgsConstructor
public class CrankyIntegers implements IChallange {


    // How many parallel tasks can run at one time.
    private static final int THREAD_COUNT = 16;

    // Thread executor service
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);


    @Override
    public Object execute(Object obj) {
        try {
            return getCrankySum((long) obj);
        } catch (ExecutionException | InterruptedException e) {
            // Restore interrupted state...
            Thread.currentThread().interrupt();
            return 0L;
        }
    }

    /**
     * Function used to break up the given integer number into blocks per CPU thread
     * and given to an ExecutorService to process each block on a logical CPU core.
     *
     * @param higherNumber Integer to process up to.
     * @return The sum of all cranky integers found up until and excluding the higherNumber value.
     */
    private long getCrankySum(long higherNumber) throws ExecutionException, InterruptedException {
        List<Future<Long>> taskList = new LinkedList<>();

        long blockInterval = (long) Math.ceil((double) higherNumber / THREAD_COUNT);

        log.info("Starting segmentation on interval size({}), using thread count ({})", blockInterval, THREAD_COUNT);

        long blockStart = 0L;
        long blockEnd = blockStart + blockInterval;
        while (blockStart < higherNumber) {
            log.info("Submitting blockStart({}) | blockEnd({}) | higherNumber({})", blockStart, blockEnd, higherNumber);
            taskList.add(executor.submit(new CrankyIntegerBlock(blockStart, blockEnd)));

            blockStart += blockInterval;
            blockEnd = blockStart + blockInterval;
            if (blockEnd > higherNumber) {
                blockEnd = higherNumber;
            }
        }
        long crankySum = 0L;

        List<Future<Long>> completedList = new ArrayList<>(taskList.size());
        do {
            for (Future<Long> task : taskList) {
                try {
                    if (task.isDone()) {
                        crankySum += task.get();
                        log.debug("Current sum after task completed: {}", crankySum);
                        completedList.add(task);
                    }
                } catch (InterruptedException | ExecutionException e) {
                    log.error("An error occurred while getting the future task completed value, {}", ExceptionUtils.getRootCauseMessage(e), e);
                    throw e;
                }
            }
            taskList.removeAll(completedList);

            log.debug("Current list size: {}", taskList.size());
            completedList.clear();
        } while (!taskList.isEmpty());

        return crankySum;
    }
}

/**
 * Callable processor class that will determine the sum of cranky integers
 * in any given block of integers.
 */
@Slf4j
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
class CrankyIntegerBlock implements Callable<Long> {
    private final long blockStart;
    private final long blockEnd;

    @Override
    public Long call() {
        long currentNumber = getBlockStart();
        long crankySum = 0L;

        // Iterate over the block of integers and test each integer for crankiness.
        while (currentNumber < getBlockEnd()) {
            log.debug("Running block{} and currentNumber{}", getBlockStart(), currentNumber);

            if (currentNumber >= 10L && isCranky(currentNumber)) {
                crankySum += currentNumber;
            }

            currentNumber++;
        }
        return crankySum;
    }


    /**
     * Function used to process any given integer and determine if it can be
     * classified as a cranky integer or not.
     *
     * @param number Integer to determine if it is a cranky integer or not.
     * @return True if found to be a cranky number, false otherwise
     */
    private boolean isCranky(long number) {

        long reversedNumber = CrankyHelper.getReversedNumber(number);
        int numberOfDigits = CrankyHelper.findNumberOfDigits(number);
        long firstHalf = 0L;

        log.debug("number({}) | reversedNumber({}) | numberOfDigits({})", number, reversedNumber, numberOfDigits);
        for (int i = 0; i < numberOfDigits; i++) {
            int digitAtIndex = (int) CrankyHelper.findDigitAt(number, i + 1);
            firstHalf = CrankyHelper.getFirstHalf(firstHalf, digitAtIndex);
            if (firstHalf > 0L && firstHalf != number) {
                long secondHalf = CrankyHelper.getSecondHalf(number, i + 1);
                if (secondHalf > 0L && (firstHalf * secondHalf) == reversedNumber) {
                    log.debug("** number({}) | reversedNumber({}) | numberOfDigits({}) | digitAtIndex({}) | firstHalf({}) | secondHalf({})", number, reversedNumber, numberOfDigits, digitAtIndex, firstHalf, secondHalf);
                    return true;
                }
            }
        }
        return false;
    }
}

/**
 * Helper class to perform mathematics based integer operations
 */
class CrankyHelper {
    private CrankyHelper(){
        // No public constructor needed.
    }

    private static final int RETURN_DIGIT_AT = 0;
    private static final int RETURN_LEFT_OVER = 1;

    /**
     * Function determines what the inputted number is in reverse.
     *
     * @param value Long value that will be reversed.
     * @return Reversed value of the inputted value.
     */
    protected static long getReversedNumber(long value) {
        long reversedValue = 0L;
        while (value != 0) {
            reversedValue = reversedValue * 10;
            reversedValue = reversedValue + value % 10;
            value = value / 10;
        }
        return reversedValue;
    }

    /**
     * Find the digit at the given index.
     *
     * @param number     Input long value that will be used to search on.
     * @param digitIndex Moving from left to right, the digit at index 'digitIndex' will be found
     * @return Digit at index 'digitIndex' in number 'number' will be returned.
     */
    protected static long findDigitAt(long number, int digitIndex) {
        return getSecondHalfOrDigitAt(RETURN_DIGIT_AT, number, digitIndex);
    }

    /**
     * Determines how many digits are in the number
     *
     * @param number Input number
     * @return The number of digits present in the inputted number parameter.
     */
    protected static int findNumberOfDigits(long number) {
        return (int) (Math.log10(number) + 1);
    }


    /**
     * Builds the 'first half' of digits
     *
     * @param firstHalf    The value of the current firstHalf
     * @param digitAtIndex What digit to 'append' onto the current firstHalf
     * @return Increases the current first half by a power of ten and appends the new digit.
     */
    protected static long getFirstHalf(long firstHalf, int digitAtIndex) {
        return (digitAtIndex + (firstHalf * 10));
    }

    /**
     * Iterates of the number until cutting off at the desired digitIndex
     *
     * @param number     Number to cut up
     * @param digitIndex Digit index to chop the number in half
     * @return TThe second half of the number once it's been chopped into two.
     */
    protected static long getSecondHalf(long number, int digitIndex) {
        return getSecondHalfOrDigitAt(RETURN_LEFT_OVER, number, digitIndex);
    }

    /**
     * Function getSecondHalf and findDigitAt use the same functionality, but return different types.
     *
     * @param returnType   Return the digitAt or return the second half of the number?
     * @param number       Inputted number to process with
     * @param digitAtIndex What index to stop processing at
     * @return Either the digit found at the index or the second half of the number once the index has been reached.
     */
    private static long getSecondHalfOrDigitAt(int returnType, long number, int digitAtIndex) {
        long digitAt = -1L;
        long leftOver = number;

        // We need a moving index to track where we are at each iteration
        int currentIndex = 1;

        // Find the number of digits to process
        int numberOfDigits = findNumberOfDigits(number);

        // Loop until we find the correct number at index
        while (currentIndex <= digitAtIndex) {
            int powerOfTen = numberOfDigits - currentIndex;
            int divisorAndModulus = (int) Math.pow(10, powerOfTen);
            digitAt = leftOver / divisorAndModulus;
            leftOver = leftOver % divisorAndModulus;
            currentIndex++;
        }
        if (returnType == RETURN_DIGIT_AT) {
            return digitAt;
        } else {
            return leftOver;
        }
    }
}