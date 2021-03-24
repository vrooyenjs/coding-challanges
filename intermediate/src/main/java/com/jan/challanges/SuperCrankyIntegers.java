package com.jan.challanges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
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
 * The sum of all cranky integers smaller than 106 is 1778723. What is the sum of all cranky integers smaller than 10^14?
 */
@Slf4j
@Component
@NoArgsConstructor
public class SuperCrankyIntegers implements IChallange {

    private final ExecutorService executor = Executors.newScheduledThreadPool(4);

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
        long crankySum = 0;

        List<Future<Long>> taskList = new LinkedList<>();

        long start = System.currentTimeMillis();
        long startTimer = System.currentTimeMillis();

        for (long i = 10; i < num; i++) {
            crankySum += countCompleted(taskList);

            if (System.currentTimeMillis() - startTimer > 1000) {
                long processed = COUNT.get();
                long timeSinceStart = System.currentTimeMillis() - start;

                log.info("Processed: {} --> {} tps", processed, (processed / TimeUnit.SECONDS.convert(timeSinceStart, TimeUnit.MILLISECONDS)));

                startTimer = System.currentTimeMillis();
            }

            taskList.add(calculate(i));
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

    private static AtomicLong COUNT = new AtomicLong();

    private Future<Long> calculate(long input) {
        return executor.submit(() -> {
            long value = isCranky(input);
            COUNT.getAndIncrement();
            return value;
        });
    }

    private long isCranky(long num) {
        String intValue = String.valueOf(num);
        long reversedValue = reversedNumber(num);

        // first digit is always part of the first part
        // and the last digit is never part of the first part.
        for (int i = 1; i < intValue.length(); i++) {
            long firstPart = Long.parseLong(intValue.substring(0, i));
            long secondPart = Long.parseLong(intValue.substring(i));


            if ((firstPart * secondPart) == reversedValue) {
                return num;
            }
        }

        return 0;
    }

    private long reversedNumber(long num) {
        long reversed = 0;
        for (; num != 0; num /= 10) {
            long digit = num % 10;
            reversed = reversed * 10 + digit;
        }
        return reversed;
    }
}
