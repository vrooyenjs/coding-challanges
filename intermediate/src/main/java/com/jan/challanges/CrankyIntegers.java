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
        return getCrankySum((long) obj);
    }

    private long getCrankySum(long higherNumber) {
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
                }
            }
            taskList.removeAll(completedList);

            log.debug("Current list size: {}", taskList.size());
            completedList.clear();
        } while (taskList.size() > 0);

        return crankySum;
    }
}

@Slf4j
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
class CrankyIntegerBlock implements Callable<Long> {
    private final long blockStart;
    private final long blockEnd;

    @Override
    public Long call() throws Exception {
        long currentNumber = getBlockStart();
        long crankySum = 0L;
        while (currentNumber < getBlockEnd()) {
            log.debug("Running block{} and currentNumber{}", getBlockStart(), currentNumber);

            if (currentNumber >= 10L) {
                if (isCranky(currentNumber)) {
                    crankySum += currentNumber;
                }
            }
            currentNumber++;
        }
        return crankySum;
    }


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
                if (secondHalf > 0L) {
                    if ((firstHalf * secondHalf) == reversedNumber) {
                        log.debug("** number({}) | reversedNumber({}) | numberOfDigits({}) | digitAtIndex({}) | firstHalf({}) | secondHalf({})", number, reversedNumber, numberOfDigits, digitAtIndex, firstHalf, secondHalf);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

class CrankyHelper {

    private static final int RETURN_DIGIT_AT = 0;
    private static final int RETURN_LEFT_OVER = 1;

    // Get the number in reverse.
    protected static long getReversedNumber(long value) {
        long reversedValue = 0L;
        while (value != 0) {
            reversedValue = reversedValue * 10;
            reversedValue = reversedValue + value % 10;
            value = value / 10;
        }
        return reversedValue;
    }

    // Find the digit at the given index.
    protected static long findDigitAt(long number, int digitIndex) {
        return getSecondHalfOrDigitAt(RETURN_DIGIT_AT, number, digitIndex);
    }

    // Determines how many digits are in the number
    protected static int findNumberOfDigits(long number) {
        return (int) (Math.log10(number) + 1);
    }


    // Builds the 'first half' of digits
    protected static long getFirstHalf(long firstHalf, int digitAtIndex) {
        return (digitAtIndex + (firstHalf * 10));
    }

    protected static long getSecondHalf(long number, int digitIndex) {
        return getSecondHalfOrDigitAt(RETURN_LEFT_OVER, number, digitIndex);
    }

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