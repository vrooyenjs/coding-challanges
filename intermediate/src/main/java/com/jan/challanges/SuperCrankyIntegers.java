package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
    private ExecutorService executor;

    private static final long SEGMENT_SIZE = 10000000L;
    private static final long SEGMENT_BLOCKS = 1000000L;


    @Override
    public Object execute(Object obj) {
        try {
            return crankyInteger((long) obj);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }

        return 0L;
    }

    private void initCache(long num) {
        /*
         * Init cache
         */
        long start = System.currentTimeMillis();
        log.info("Starting cache load...");
        for (long i = 0; i < num; i++) {
            getLongFromCache(String.valueOf(i));
        }
        log.info("Starting cache load of {} entries in {} ms", num, (System.currentTimeMillis() - start));
    }

    private long crankyInteger(long num) throws ExecutionException, InterruptedException {
//        initCache(num);


        executor = Executors.newFixedThreadPool(6);
        long crankySum = 0L;
        List<Future<Long>> taskList = new LinkedList<>();

        /*
         * The segments are partitioned by either the number of partitions or
         * standard block size....whichever one is larger.
         */
        long segmentSize = 0L;
        if (num / SEGMENT_BLOCKS > SEGMENT_SIZE) {
            segmentSize = num / SEGMENT_BLOCKS;
        } else {
            segmentSize = SEGMENT_SIZE;
        }

        long blockStart = 0L;
        long blockSize = 0L;
        while (blockStart < num) {

            // If the full segment goes over the num, we trim it down
            if (blockStart + segmentSize > num) {
                blockSize = num - blockStart;
            } else {
                blockSize = segmentSize;
            }
//            log.info("Processing block: {}/{} -- size({})", blockStart, num, blockSize);

            taskList.add(scheduleBlock(blockStart, blockSize));
            blockStart += blockSize;
            crankySum += countCompleted(taskList);
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

    private Future<Long> scheduleBlock(long blockStart, long segmentSize) {
        return executor.submit(() -> {
            long value = 0L;
            for (long i = blockStart; i < blockStart + segmentSize; i++) {
                value += isCranky(i);
            }
            return value;
        });
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

    private long isCranky(long num) {
        String intValue = String.valueOf(num);
        long reversedValue = getLongFromCache(new StringBuilder(intValue).reverse().toString());

        for (int i = 1; i < intValue.length(); i++) {

            long firstPart = getLongFromCache(intValue.substring(0, i));
            long secondPart = getLongFromCache(intValue.substring(i));

            if ((firstPart * secondPart) == reversedValue) {
                return num;
            }
        }

        return 0;
    }

    private static final Map<String, Long> LONG_CACHE = new HashMap<>();

    private long getLongFromCache(String longAsString) {
        Long longValue = LONG_CACHE.get(longAsString);

        if (longValue == null) {
            longValue = Long.parseLong(longAsString);
            LONG_CACHE.put(longAsString, longValue);
        }
        return longValue;
    }


}

