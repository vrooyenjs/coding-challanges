package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * Have a function that take in a long of milliseconds and converts it into a string of format:
 * <p>
 * <p>
 * a week(s), b day(s), c hour(s), d minute(s), e second(s), f millisecond(s)
 * <p>
 * with the plural 's' only present if the value is more than one.
 */
@Slf4j
@Component
@NoArgsConstructor
public class ConvertMillisecondToPrettyTime implements IChallange {
    private static final String SINGLE_ENTRY = "%d %s%s";
    private static final String OUTPUT_FORMAT = "%s, %s, %s, %s, %s, %s";

    @Override
    public Object execute(Object obj) {
        long ms = (Long) obj;
        return convertToPrettyTime(ms);
    }

    private String convertToPrettyTime(long ms) {

        long weeks = 0L;
        long days = 0L;
        long hours = 0L;
        long minutes = 0L;
        long seconds = 0L;
        long milliseconds = ms;

        while (milliseconds >=  TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS)) {
            // Start with the biggest increment of weeks
            if (milliseconds >= TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS)) {
                weeks++;
                milliseconds -= TimeUnit.MILLISECONDS.convert(7, TimeUnit.DAYS);

            } else if (milliseconds >= TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS)) {
                days++;
                milliseconds -= TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS);

            } else if (milliseconds >= TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)) {
                hours++;
                milliseconds -= TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS);

            }else if (milliseconds >= TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES)) {
                minutes++;
                milliseconds -= TimeUnit.MILLISECONDS.convert(1, TimeUnit.MINUTES);

            }else if (milliseconds >= TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS)) {
                seconds++;
                milliseconds -= TimeUnit.MILLISECONDS.convert(1, TimeUnit.SECONDS);
            }
        }

        return String.format(OUTPUT_FORMAT, getSuffix(weeks, "week"),
                getSuffix(days, "day"),
                getSuffix(hours, "hour"),
                getSuffix(minutes, "minute"),
                getSuffix(seconds, "second"),
                getSuffix(milliseconds, "millisecond"));

    }


    private String getSuffix (long amount, String singular){
        if (amount > 1){
            return String.format(SINGLE_ENTRY, amount, singular, "s");
        }
        return String.format(SINGLE_ENTRY, amount, singular, "");
    }
}
