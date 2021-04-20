package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
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
public class SuperCrankyIntegersOld implements IChallange {

    // Controls into how many segments the initial blocks are split
    public static final long BLOCK_DIVISION_SEGMENT_SIZE = 1000000L;

    // How often the task list needs to be scanned and completed items counted and removed to keep memory down.
    private static final long TASK_LIST_CLEANUP_THRESHOLD = 1000000L;

    // How many parallel tasks can run at one time.
    private static final int THREAD_COUNT = 16;

    // Task list
    private final List<Future<Long>> taskList = new ArrayList<>((int) TASK_LIST_CLEANUP_THRESHOLD);

    // Thread executor service
    private final ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

    // Use file cache?
    private static final boolean USE_CACHE = false;


    @Override
    public Object execute(Object obj) {
        try {
            return crankyInteger((long) obj);
        } catch (ExecutionException | InterruptedException e) {
            log.error("Exception occurred, due to: {}", ExceptionUtils.getRootCauseMessage(e), e);
            // Restore interrupted state...
            Thread.currentThread().interrupt();
        }
        return 0L;
    }

    private long crankyInteger(long num) throws ExecutionException, InterruptedException {
        long crankySum = 0L;
        long blockStart = 0L;
        while (blockStart < num) {

            // get the next block size
            long blockSize = getBlockSize(num, blockStart);

            scheduleTask(blockStart, blockSize);
            blockStart += blockSize;

            crankySum += countCompleted();


        }

        int completedTasks = 0;
        while (completedTasks < taskList.size()) {
            completedTasks = 0;
            for (Future<Long> task : taskList) {
                if (task.isDone()) {
                    completedTasks++;
                }
            }
        }

        for (Future<Long> task : taskList) {
            crankySum += task.get();
        }

        return crankySum;
    }

    private void scheduleTask(long blockStart, long blockSize) {
        CrankyCallable crankyCallable = new CrankyCallable(blockStart, blockSize);
        taskList.add(executor.submit(crankyCallable));
    }

    private long getBlockSize(long num, long blockStart) {
        // If the full segment goes over the num, we trim it down
        if (blockStart + SuperCrankyIntegersOld.BLOCK_DIVISION_SEGMENT_SIZE > num) {
            return num - blockStart;
        } else {
            return SuperCrankyIntegersOld.BLOCK_DIVISION_SEGMENT_SIZE;
        }
    }


    private long countCompleted() throws ExecutionException, InterruptedException {
        if (taskList.size() < TASK_LIST_CLEANUP_THRESHOLD) {
            return 0L;
        }

        List<Future<Long>> completedList = new LinkedList<>();
        long sum = 0L;

        for (Future<Long> task : taskList) {
            if (task.isDone()) {
                sum += task.get();
                completedList.add(task);
            }
        }
        taskList.removeAll(completedList);
        return sum;
    }
}

/**
 *
 */
@Slf4j
@Getter
@Setter
class CrankyCallable implements Callable<Long> {
    private static Long[] digitlookup;
    private CrankyBlock crankyBlock;

    private long blockStart;
    private long segmentSize;

    public CrankyCallable(long blockStart, long segmentSize) {
        this.setBlockStart(blockStart);
        this.setSegmentSize(segmentSize);

        crankyBlock = new CrankyBlock(blockStart, segmentSize, (blockStart + segmentSize));

        if (digitlookup == null) {
            initiateCache();
        }
    }

    public synchronized void initiateCache() {
        if (digitlookup != null) {
            return;

        }
        /*
         ** Preload 0-9 longs FOR ULTIMATE SPEEEEED
         */
        digitlookup = new Long[10];
        for (int i = 0; i < 10; i++) {
            digitlookup[i] = (long) i;
        }
    }


    @Override
    public Long call() {
        long value = 0L;
        for (long i = blockStart; i < blockStart + segmentSize; i++) {
            // We work our way to the end of the current block...
            if (i < crankyBlock.getBiggestCrankyNumberInBlock() || i < 10) {
                continue;
            }

            value += isCrankyBlock(i);
        }

        return value;
    }


    private int[] digitsToProcess;

    private void populateDigitArray(long num) {
        char[] charArr = String.valueOf(num).toCharArray();
        digitsToProcess = new int[charArr.length];
        int index = 0;
        for (char c : charArr) {
            digitsToProcess[index++] = ((int) c) - 48;
        }
    }

    private long isCrankyBlock(long num) {
        long reversedValue = getReversedNumber(num);
        populateDigitArray(num);

        long firstHalf = 0L;
        long secondHalf;
        long digitToProcess;
        long subtractor = 0L;

        int reverseIndex = digitsToProcess.length - 1;
        for (int i = 0; i < digitsToProcess.length; i++) {

            // Get the i'th digit.
            digitToProcess = digitsToProcess[i];


            // Get the value to subtract from num to get b
            subtractor += (long) (digitToProcess * Math.pow(10, reverseIndex--));

            // get firstHalf
            firstHalf = findFirstHalf(firstHalf, digitToProcess, i);
            // get secondHalf
            secondHalf = getSecondHalf(num, subtractor);
            if (firstHalf == 0 || secondHalf == 0) {
                continue;
            }

            if (crankyCheck(firstHalf, secondHalf, reversedValue)) {
                crankyBlock.addCrankyNumber(num);
                log.info("Cranky number ({})", num);
                return num;
            }
        }
        return 0;
    }

    private boolean crankyCheck(long firstHalf, long secondHalf, long reversedValue) {
        return (getMultiplication(firstHalf, secondHalf) == reversedValue);
    }

    private long getMultiplication(long firstHalf, long secondHalf) {
        return firstHalf * secondHalf;
    }


    private long findFirstHalf(long firstHalf, long digitToProcess, long i) {
        if (firstHalf == 0L) {
            return (long) (digitToProcess * Math.pow(10, i));
        } else {
            return (long) (firstHalf * Math.pow(10, 1)) + digitToProcess;
        }
    }

    private long getSecondHalf(long num, long subtractor) {
        return num - subtractor;
    }

    /**
     * @param value long value that will be reversed
     * @return the reversed value that was input as a parameter
     */
    private long getReversedNumber(long value) {
        long reversedValue = 0L;
        while (value != 0) {
            reversedValue = reversedValue * 10;
            reversedValue = reversedValue + value % 10;
            value = value / 10;
        }
        return reversedValue;
    }


    @Override
    public boolean equals(Object obj) {
        /*
         * If the object is compared with itself then return true
         */
        if (obj == this) {
            return true;
        }

        /*
         * Check if o is an instance of Complex or not
         * "null instanceof [type]" also returns false
         */
        if (!(obj instanceof Callable)) {
            return false;
        }

        CrankyCallable c = (CrankyCallable) obj;
        return c.getBlockStart() == this.getBlockStart() && c.getSegmentSize() == this.getSegmentSize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockStart, segmentSize);
    }
}

@Getter
@RequiredArgsConstructor()
class CrankyBlock implements Serializable {
    private static final long serialVersionUID = 290129995745497085L;

    @NonNull
    private final long blockStart;

    @NonNull
    private final long segmentSize;

    @NonNull
    private final long blockEnd;

    private long crankyBlockSum;

    private long biggestCrankyNumberInBlock;

    @NonNull
    private final List<Long> crankyNumbersFound = new ArrayList<>();

    public String getFileName() {
        return "./cache/" + getBlockStart() + "__" + getBlockEnd() + ".block";
    }

    public boolean hasCrankyNumbersInBlock() {
        return !crankyNumbersFound.isEmpty();
    }

    public void addCrankyNumber(long num) {
        crankyBlockSum += num;
        if (num > biggestCrankyNumberInBlock) {
            biggestCrankyNumberInBlock = num;
        }
        if (!crankyNumbersFound.contains(num)) {
            crankyNumbersFound.add(num);
        }
    }

    public long getCrankyIntegerSum(long num) {
        long sum = 0L;
        for (long l : crankyNumbersFound) {
            if (l < num) {
                sum += l;
            } else {
                break;
            }
        }
        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CrankyBlock that = (CrankyBlock) o;
        return blockStart == that.blockStart;
    }

    @Override
    public int hashCode() {
        return Objects.hash(blockStart, segmentSize, crankyNumbersFound);
    }

    @Override
    public String toString() {
        return "CrankyBlock{" +
                "blockStart=" + blockStart +
                ", segmentSize=" + segmentSize +
                ", blockEnd=" + blockEnd +
                ", crankyNumbersFound=" + crankyNumbersFound +
                '}';
    }
}
