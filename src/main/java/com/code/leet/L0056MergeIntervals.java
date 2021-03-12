package com.code.leet;

import com.sun.deploy.util.StringUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * Created by hejiaxu on 2021/1/14
 */
public class L0056MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(intervals);
        Arrays.stream(merge).map(s -> StringUtils.join(Arrays.stream(s).mapToObj(String::valueOf).collect(Collectors.toList()), ",")
        ).forEach(System.out::println);
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        ArrayList<int[]> r = new ArrayList<>();
        r.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] last = r.get(r.size() - 1);
            if (intervals[i][0] > last[1]) {
                r.add(intervals[i]);
            } else if (intervals[i][1] > last[1]) {
                last[1] = intervals[i][1];
            }
        }
        return r.toArray(new int[0][0]);
    }
}
