package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

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
public class SuperCrankyIntegers implements IChallange {

    private static final long BLOCK_DIVISION_SEGMENT_SIZE = 10000L;
    private static final int THREAD_COUNT = 6;


    @Override
    public Object execute(Object obj) {
        try {
            return crankyInteger((long) obj);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return 0L;
    }


    private long crankyInteger(long num) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        long crankySum = 0L;
        List<Future<Long>> taskList = new LinkedList<>();

        /*
         * Determine Segments
         */
        long segmentSize = num;
        while (segmentSize > BLOCK_DIVISION_SEGMENT_SIZE) {
            segmentSize /= Math.floor(2);
        }
        // we now have the chuck size and we process blocks as per the chuck size.


        /*
         * The segments are partitioned by either the number of partitions or
         * standard block size....whichever one is larger.
         */
        long blockStart = 0L;
        long blockSize;
        while (blockStart < num) {

            // If the full segment goes over the num, we trim it down
            if (blockStart + segmentSize > num) {
                blockSize = num - blockStart;
            } else {
                blockSize = segmentSize;
            }

            taskList.add(executor.submit(new CrankyCallable(blockStart, blockSize)));
            blockStart += blockSize;

            // we maar wait for the task list to finish processing each mod 10 items
            if (taskList.size() > 0 && taskList.size() % segmentSize == 0) {
//                log.info("Processing block: {}/{} -- {}%", blockStart, num, ((double) blockStart / (double) num * 100.00));
                crankySum += countCompleted(taskList);
            }
        }
        executor.shutdown();

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


    private long countCompleted(List<Future<Long>> taskList) throws ExecutionException, InterruptedException {
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
@Getter
@Setter
class CrankyCallable implements Callable<Long> {


    private static Long[] DIGIT_LOOKUP;
    private long blockStart;
    private long segmentSize;


    public CrankyCallable(long blockStart, long segmentSize) {
        this.setBlockStart(blockStart);
        this.setSegmentSize(segmentSize);
        if (DIGIT_LOOKUP == null) {
            initiateCache();
        }
    }

    public synchronized void initiateCache() {
        if (DIGIT_LOOKUP != null) {
            return;

        }
        /*
         ** Preload 0-9 longs
         */
        DIGIT_LOOKUP = new Long[10];
        for (int i = 0; i < 10 ; i ++) {
            DIGIT_LOOKUP[i] = (long)i;
        }
    }


    @Override
    public Long call() {
        long value = 0L;
        for (long i = blockStart; i < blockStart + segmentSize; i++) {
            value += isCranky(i);
        }
        return value;
    }


    /**
     * @param num
     * @return
     */
    private long isCranky(long num) {
        long reversedValue = getReversedNumber(num);

        String numAsString = String.valueOf(num);

        long a = 0L;
        long b;

        long digitToProcess;
        long subtractor = 0L;

        int reverseIndex = numAsString.length() - 1;
        for (int i = 0; i < numAsString.length(); i++) {

            // Get the i'th digit.
//            digitToProcess = Long.parseLong(String.valueOf(numAsString.charAt(i)));
//            digitToProcess = DIGIT_LOOKUP.get(numAsString.charAt(i));
            char digit = numAsString.charAt(i);
            int index = Character.getNumericValue(digit);
            digitToProcess = DIGIT_LOOKUP[index];

            // Get the value to subtract from num to get b
            subtractor += (long) (digitToProcess * Math.pow(10, reverseIndex--));


            // get a
            if (a == 0L) {
                a = (long) (digitToProcess * Math.pow(10, i));
            } else {
                a = (long) (a * Math.pow(10, 1)) + digitToProcess;
            }

            // get b
            b = num - subtractor;

            long multiplication = a * b;
            if (multiplication == reversedValue) {
                return num;
            }
        }
        return 0;
    }

    /**
     * @param value
     * @return
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
