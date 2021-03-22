package com.jan.challenges;

import com.jan.interfaces.IChallange;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.*;

/**
 * Have the function FindIntersection(strArr) read the array of
 * strings stored in strArr which will contain 2 elements: the
 * first element will represent a list of comma-separated numbers
 * sorted in ascending order, the second element will represent a
 * second list of comma-separated numbers (also sorted).
 * <p>
 * Your goal is to return a comma-separated string containing the
 * numbers that occur in elements of strArr in sorted order.
 * <p>
 * If there is no intersection, return the string false.
 * <p>
 * <p>
 * Examples
 * Input: ["1, 3, 4, 7, 13", "1, 2, 4, 13, 15"]
 * Output: 1,4,13
 * <p>
 * Input: ["1, 3, 9, 10, 17, 18", "1, 4, 9, 10"]
 * Output: 1,9,10
 */
@Slf4j
@Component
@NoArgsConstructor
public class FindIntersection implements IChallange {
    @Override
    public Object execute(Object obj) {
        String[] arr = (String[]) obj;
        return findIntersection(arr);
    }

    protected String findIntersection(String[] arr) {
        // Split both elements into their own arrays and remove all white spaces.
        String[] index_1 = arr[0].split(",");
        trimStringsInArray(index_1);

        String[] index_2 = arr[1].split(",");
        trimStringsInArray(index_2);

        // If we conver the first list to a hash set, we can search for collisions (O(n)) instead of going through both arrays O(n^2)
        Set<String> set_1 = new HashSet<String>(Arrays.asList(index_1));

        List<String> result = new LinkedList<>();

        // We now compare the two arrays to find intersections
        for (int k = 0; k < index_2.length; k++) {
            if (set_1.contains(index_2[k])) {
                result.add(index_2[k]);
            }
        }

        return (result.isEmpty() ? "false" : String.join(",", result));
    }

    private void trimStringsInArray(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (StringUtils.containsWhitespace(arr[i])) {
                arr[i] = StringUtils.trimAllWhitespace(arr[i]);
            }
        }
    }
}
